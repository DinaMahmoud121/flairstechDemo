package com.flairstech.flairstechdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.omg.CosNaming.NamingContextExtPackage.InvalidAddress;
import org.postgresql.translation.messages_bg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sun.xml.bind.marshaller.Messages;

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
	public void givenNotFound_whenGetSpecificException_thenNotFoundCode() throws Exception {
	    String exceptionParam = "BHR";

	    mockMvc.perform(get("/{countryCode}", exceptionParam))
	    	.andExpect(status().isOk())
	    	.andExpect(status().is2xxSuccessful());
	}
	
	@Test
    void givenADisabledIndicator_whenSendingRequest_thenReturns404() throws Exception {
		mockMvc.perform(get("/actuator/health"))
		.andExpect(status().isNotFound());
        
    }

}
