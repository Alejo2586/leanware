package services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
public class EvolutionServiceImpl implements EvolutionService {

    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/";

    private final RestTemplate restTemplate;

    public EvolutionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getEvolution(String pokemonName) {
        String apiUrl = API_BASE_URL + "evolution-chain/" + pokemonName;
        String evolutionChain = restTemplate.getForObject(apiUrl, String.class);
        // You can parse the response or process it further as needed
        return evolutionChain;
    }

}
