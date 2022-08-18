package sample.mifel.pokemon.service;

import lombok.Getter;
import sample.mifel.pokemon.request.PokemonRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class PokeApiService {

    @Value("${pokeapi.server}")
    String server;

    @Value("${pokeapi.ditto}")
    String pathDitto;

    final RestTemplate restTemplate = new RestTemplate();

    @Getter
    PokemonRequest request;

    @PostConstruct
    final void init(){
        this.request = restTemplate.getForObject(server + pathDitto, PokemonRequest.class);
    }



}
