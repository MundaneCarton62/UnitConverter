package com.example.UnitConverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.UnitConverter.TemperatureUnit.CELSIUS;
import static com.example.UnitConverter.TemperatureUnit.FAHRENHEIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("unused")
public class UnitConverterApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void celsiusToFahrenheit(){
		UnitConverterService service = new UnitConverterService();
		assertEquals(32,service.convertTemperature(0,CELSIUS, FAHRENHEIT));
	}

	@Test
	void homeLoads() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}

}
