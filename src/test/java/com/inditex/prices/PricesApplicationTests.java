package com.inditex.prices;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.dto.response.PriceResponseDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PricesApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
	
    private final Gson gson = new Gson();
	
	@Test
	public void firstRequest() throws URISyntaxException {
		
		//Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, 14, 10, 0)
			      .getTime());
 
		ImmutablePair<Double, Integer> result = execute(requestDTO);
         
        //Verify request succeed
        Assertions.assertEquals(35.5, result.getKey());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getValue());
	}
	
	@Test
	public void secondRequest() throws URISyntaxException {
		
		//Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, 14, 16, 0).getTime());
 
		ImmutablePair<Double, Integer> result = execute(requestDTO);
         
        //Verify request succeed
        Assertions.assertEquals(25.45, result.getKey());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getValue());
	}
	
	@Test
	public void thirdRequest() throws URISyntaxException {
		
		//Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, 14, 21, 0)
			      .getTime());
 
		ImmutablePair<Double, Integer> result = execute(requestDTO);
         
        //Verify request succeed
        Assertions.assertEquals(35.5, result.getKey());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getValue());
	}
	
	@Test
	public void fourthRequest() throws URISyntaxException {
		
		//Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, 15, 10, 0)
			      .getTime());
 
		ImmutablePair<Double, Integer> result = execute(requestDTO);
         
        //Verify request succeed
        Assertions.assertEquals(30.5, result.getKey());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getValue());
	}
	
	@Test
	public void fifthRequest() throws URISyntaxException {
		
		//Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, 16, 21, 0)
			      .getTime());
 
		ImmutablePair<Double, Integer> result = execute(requestDTO);
         
        //Verify request succeed
        Assertions.assertEquals(38.95, result.getKey());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getValue());
	}
	
	private ImmutablePair<Double, Integer> execute(PriceByBrandProductDateRequestDTO requestDTO) throws URISyntaxException {
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/getPrice";
        URI uri = new URI(baseUrl);
        
        HttpEntity<PriceByBrandProductDateRequestDTO> request = new HttpEntity<>(requestDTO);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        PriceResponseDTO priceResponseDTO = gson.fromJson(result.getBody(), PriceResponseDTO.class);
        
        return new ImmutablePair<Double, Integer>(priceResponseDTO.getPrice(), result.getStatusCode().value());
        
	}

}
