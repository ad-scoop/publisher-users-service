package com.adscoop.userpublisher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;
import rx.plugins.RxJavaPlugins;

public class StartPublicherUsersServiceTest {

	@Before
	public void setUp() throws Exception {
		Method method = RxJavaPlugins.class.getDeclaredMethod("reset");
		method.setAccessible(true);
		method.invoke(RxJavaPlugins.getInstance());
	}
	
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
