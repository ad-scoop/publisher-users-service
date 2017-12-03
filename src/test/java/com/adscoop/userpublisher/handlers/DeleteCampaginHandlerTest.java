package com.adscoop.userpublisher.handlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;

import ratpack.http.Status;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCampaginHandlerTest {

	@Mock
	private Session session;

	private DeleteCampaginHandler handler;
	
	@Before
	public void setUp() {
		handler = new DeleteCampaginHandler(new CampaginService(session));
	}
	
	@Test
	public void verifyThatACampaginIsDeleted() throws Exception {
		// given
		when(session.queryForObject(eq(Campagin.class), anyString(),anyMap())).thenReturn(Campagin.builder().build());

		// when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture
					.header(Const.Headers.TOKEN, "foo")
					.pathBinding(Collections.singletonMap("id", "100")));

		// then
		assertEquals("Campagins was not deleted", Status.OK, result.getStatus());
		verify(session).delete(any(Campagin.class));
	}
	
	@Test
	public void givenNoIdParamterWillRetrunError() throws Exception {
		// given when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture
				.header(Const.Headers.TOKEN, "foo")
				.uri("campagins/remove"));

		// then
		assertEquals("should return error", result.getStatus(), Status.of(412));
	}
	
}
