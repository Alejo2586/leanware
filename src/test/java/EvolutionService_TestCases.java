import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import services.EvolutionService;
import services.EvolutionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EvolutionService_TestCases.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EvolutionService_TestCases {

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testGetEvolution() {
        String pokemonName = "pikachu";
        String mockResponse = "{\"chain\": {\"species\": {\"name\": \"pikachu\"}}}";

        // Mocking the API response
        Mockito.when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/"+pokemonName, String.class))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        // Creating the service instance
        EvolutionService evolutionService = new EvolutionServiceImpl(restTemplate);

        // Calling the method under test
        String result = evolutionService.getEvolution(pokemonName);

        // Asserting the result
        assertEquals(mockResponse, result);
    }
}
