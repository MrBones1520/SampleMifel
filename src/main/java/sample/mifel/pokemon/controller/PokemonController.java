package sample.mifel.pokemon.controller;

import sample.mifel.pokemon.request.PokemonRequest;
import sample.mifel.pokemon.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon/ditto")
public class PokemonController {

    final PokeApiService apiService;

    @Autowired
    public PokemonController(PokeApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public PokemonRequest allData(){
        return apiService.getRequest();
    }


}
