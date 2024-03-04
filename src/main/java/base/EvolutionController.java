package base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.EvolutionService;

@RestController
public class EvolutionController {
    private final EvolutionService evolutionService;

    public EvolutionController(EvolutionService evolutionService) {
        this.evolutionService = evolutionService;
    }

    @GetMapping("/evolution/{pokemonName}")
    public String getEvolution(@PathVariable String pokemonName) {
        return evolutionService.getEvolution(pokemonName);
    }
}
