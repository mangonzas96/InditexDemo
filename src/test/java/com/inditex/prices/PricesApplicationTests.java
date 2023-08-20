package com.inditex.prices;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inditex.prices.dto.request.PriceByBrandProductDateRequestDTO;
import com.inditex.prices.dto.response.PriceResponseDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PricesApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
	
    /**
     * Parameters:
     * 1. Integer - The day.
     * 2. Integer - The hour.
     * 3. Double  - The price that we expect.
     */
    private static Stream<Arguments> testPrice() {
        return Stream.of(
            Arguments.of(14, 10, 35.5),  //Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
            Arguments.of(14, 16, 25.45), //Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
            Arguments.of(14, 21, 35.5),  //Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
            Arguments.of(15, 10, 30.5),  //Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
            Arguments.of(16, 21, 38.95)  //Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "testPrice")
    @DisplayName(value = "Obtain the price in a concret day and hour")
	void check_price_in_date(Integer day, Integer hour, Double price) throws URISyntaxException, JsonMappingException, JsonProcessingException {
    	
		PriceByBrandProductDateRequestDTO requestDTO = new PriceByBrandProductDateRequestDTO(1, 35455, 
				new GregorianCalendar(2020, Calendar.JUNE, day, hour, 0)
			      .getTime());
 
		final String baseUrl = "http://localhost:" + randomServerPort + "/getPrice";
        URI uri = new URI(baseUrl);
        
        HttpEntity<PriceByBrandProductDateRequestDTO> request = new HttpEntity<>(requestDTO);
        ResponseEntity<PriceResponseDTO> result = this.restTemplate.postForEntity(uri, request, PriceResponseDTO.class);
         
        //Verify request succeed
        Assertions.assertEquals(price, result.getBody().getCost());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCode().value());
	}
    
}
