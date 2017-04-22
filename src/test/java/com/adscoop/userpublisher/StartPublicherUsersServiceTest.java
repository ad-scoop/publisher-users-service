package com.adscoop.userpublisher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import com.adscoop.userpublisher.utils.RxRule;

import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;

public class StartPublicherUsersServiceTest {

	@Rule public RxRule rxRule = new RxRule();
	
	@Test
	public void verifyThatTheServiceIsUReturningErrorWhenTokenIsNotSet() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
			// given when then
			assertThat("Http requst status was wrong", service.getHttpClient().get("publisher/campagins").getStatus(),
					equalTo(Status.of(406)));
		}
	}

	@Test
	public void givenATokenWillReturnOk() throws Exception {
		try (MainClassApplicationUnderTest service = new MainClassApplicationUnderTest(
				StartPublicherUsersService.class)) {
		// given when then
		assertThat(
				"Http requst status was no ok", service.getHttpClient()
						.requestSpec(r -> r.getHeaders().add("token", "test")).get("publisher/campagins").getStatus(),
				equalTo(Status.OK));
		}
	}

}
