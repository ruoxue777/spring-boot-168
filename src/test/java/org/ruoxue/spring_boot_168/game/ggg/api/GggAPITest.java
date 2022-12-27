package org.ruoxue.spring_boot_168.game.ggg.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.game.ggg.service.GggService;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = GggAPI.class)
@SpringBootTest(classes = Application.class)
public class GggAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GggService gggService;

	@Test
	public void exist() throws Exception {
		Mockito.when(gggService.exist(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/ggg/user/exist")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"errorCode\":0,\"exist\":true}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
