package com.flairstech.flairstechdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class FlairstechdemoApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
    void testDBConnection() throws Exception {
		String URI = "http://localhost:12120/actuator/health";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = "UP";
	    String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).contains(expectedJson);
    }

}
