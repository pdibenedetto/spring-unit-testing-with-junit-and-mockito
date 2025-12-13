package com.in28minutes.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;// For Spring Boot 3
import org.springframework.test.web.servlet.client.RestTestClient; // Spring Boot 4

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class ItemControllerIT {

//	@Autowired
//	private TestRestTemplate restTemplate; // Spring Boot 3

	@Autowired
	private RestTestClient restTestClient;

	@Test
	public void contextLoads() throws JSONException {

		// String response = this.restTemplate.getForObject("/all-items-from-database", String.class); // For Spring Boot 3
		String response = new String(
				restTestClient.get()
						.uri("/all-items-from-database")
						.exchange()
						.returnResult()
						.getResponseBodyContent()
		);
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]",
				response, false);
	}

}
