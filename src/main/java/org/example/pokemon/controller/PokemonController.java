package org.example.pokemon.controller;

import org.example.pokemon.request.PokemonRequest;
import org.example.pokemon.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PokemonRequest allData(){
        return apiService.getRequest();
    }

    @GetMapping("/base")
    public Object baseInfo(){
        return "";
    }


}
