package com.adscoop.userpublisher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.adscoop.userpublisher.entites.Banner;
import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.handlers.Const;
import com.adscoop.userpublisher.utils.RxRule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import org.mockito.Mock;
import org.neo4j.ogm.session.Session;
import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StartPublicherUsersServiceTest {

	@Rule public RxRule rxRule = new RxRule();

	@Mock
	Session session;
 	@Test
	public void AgivenATokenWillReturnCreateACampagin() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(request -> request
								.body(body -> body
										.type("application/json")
										.text(buildCampagin()))
								.getHeaders()
									.add(Const.Headers.TOKEN, "test")
							)
						.post("publisher/campagins/create")
						.getStatus(),
				equalTo(Status.OK));
		}
	}

	@Test
	public void BgivenATokenWillReturnCampagins() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(r -> r.getHeaders().add(Const.Headers.TOKEN, "test")).get("publisher/campagins").getStatus(),
				equalTo(Status.OK));
		}
	}

	@Test
	public void CgivenATokenWillReturnUpdateCampagin() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(request -> request
								.body(body -> body
										.type("application/json")
										.text(buildCampagin()))
								.getHeaders()
									.add(Const.Headers.TOKEN, "test")
							)
						.post("publisher/campagins/update")
						.getStatus(),
				equalTo(Status.OK));
		}
	}

	/**
	 *
	 * Test has to be rewritten since it can only run once
	 */
	@Ignore
	@Test
	public void DgivenATokenWillReturnDeleteACampagin() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		//	doReturn(Campagin.builder().build()).when(session.queryForObject(eq(Campagin.class), anyString(), anyMap()));
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(request -> request
								.getHeaders()
									.add(Const.Headers.TOKEN, "test")
							)
						.delete("publisher/campagins/remove/100")
						.getStatus(),
				equalTo(Status.OK));
		}
	}
	
	private String buildCampagin() throws JsonProcessingException {
		Campagin.builder().toString();
		Banner.builder().toString();
		Campagin campagin = Campagin.builder()
				.token("test")
				.clicks(200)
				.endDate(new Date().getTime())
				.name("name")
				.maxPricePrDay(200)
				.startDate(new Date().getTime())
				.webSiteIds(Lists.newArrayList(100L,200L,300L))
				.banners(Lists.newArrayList(Banner.builder()
						.clicks(200)
						.height(400)
						.picture("picutre")
						.width(200)
						.build()))
				.build();
		campagin.setId(100L);
		return new ObjectMapper().writeValueAsString(campagin);
	}
	
}
