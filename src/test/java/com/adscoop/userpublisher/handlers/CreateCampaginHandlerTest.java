package com.adscoop.userpublisher.handlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.Date;

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
public class CreateCampaginHandlerTest {

	@Mock
	private Session session;

	private CreateCampaginHandler handler;
	
	@Before
	public void setUp() {
		handler = new CreateCampaginHandler(new CampaginService(session));
	}
	
	@Test
	public void verifyThatAcampaginIsCreated() throws Exception {
		// given
		String jsonCampagin = new ObjectMapper().writeValueAsString(Campagin.builder()
				.build());

		// when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture
					.body(jsonCampagin, "application/json")
					.header(Const.Headers.TOKEN, "foo"));

		// then
		assertEquals("Campagins was not saved", Status.OK, result.getStatus());
		verify(session).save(any(Campagin.class));
	}
	
}
