package com.adscoop.userpublisher.handlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.fasterxml.jackson.databind.ObjectMapper;

import ratpack.http.Status;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCampaginHandlerTest {

	@Mock
	private Session session;

	private UpdateCampaginHandler handler;
	
	@Before
	public void setUp() {
		handler = new UpdateCampaginHandler(new CampaginService(session));
	}
	
	@Test
	public void verifyThatAcampaginIsCreated() throws Exception {
		// given
		String jsonCampagin = new ObjectMapper().writeValueAsString(Campagin.builder().build());

		// when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture
					.body(jsonCampagin, "application/json")
					.header("token", "foo")
					.uri("campagins/update"));

		// then
		assertEquals("Campagins was not updated", result.getStatus(), Status.OK);
		verify(session).save(any(Campagin.class));
	}


}
