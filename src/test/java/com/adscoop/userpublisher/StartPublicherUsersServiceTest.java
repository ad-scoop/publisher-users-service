package com.adscoop.userpublisher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.utils.RxRule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StartPublicherUsersServiceTest {

	@Rule public RxRule rxRule = new RxRule();
	
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
									.add("token", "test")
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
						.requestSpec(r -> r.getHeaders().add("token", "test")).get("publisher/campagins").getStatus(),
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
									.add("token", "test")
							)
						.post("publisher/campagins/update")
						.getStatus(),
				equalTo(Status.OK));
		}
	}
	
	@Test
	public void DgivenATokenWillReturnDeleteACampagin() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(request -> request
								.getHeaders()
									.add("token", "test")
							)
						.delete("publisher/campagins/remove?id=100")
						.getStatus(),
				equalTo(Status.OK));
		}
	}
	
	private String buildCampagin() throws JsonProcessingException {
		Campagin campagin = Campagin.builder()
				.token("test")
				.build();
		campagin.setId(100L);
		return new ObjectMapper().writeValueAsString(campagin);
	}
	
}
