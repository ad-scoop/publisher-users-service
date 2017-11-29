package com.adscoop.userpublisher.handlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.common.collect.Lists;

import ratpack.http.Status;
import ratpack.jackson.internal.DefaultJsonRender;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

@RunWith(MockitoJUnitRunner.class)
public class GetCampaginHandlerTest {

	@Mock
	private Session session;

	private GetCampaginHandler handler;

	@Before
	public void setUp() {
		handler = new GetCampaginHandler(new CampaginService(session));
	}

	@Test
	public void verifyThatDataIsReturnd() throws Exception {
		// given
		Campagin campagin = Campagin.builder().build();
		doReturn(Lists.newArrayList(campagin)).when(session).loadAll(eq(Campagin.class), any(Filter.class));

		// when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture.header(Const.Headers.TOKEN, "foo"));

		// then
		assertEquals("Campagins was not returnd", result.rendered(DefaultJsonRender.class).getObject(), Lists.newArrayList(campagin));
	}
	
	@Test
	public void givenNoTokenWillRetrunError() throws Exception {
		// given when
		HandlingResult result = RequestFixture.handle(handler,
				fixture -> fixture.uri("campagins"));

		// then
		assertEquals("should return error", result.getStatus(), Status.of(406));
	}
	
}
