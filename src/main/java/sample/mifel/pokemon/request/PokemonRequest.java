package sample.mifel.pokemon.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PokemonRequest {

    int id;

    @JsonProperty("base_experience")
    int baseExperience;

    int height;

    int weight;

    int order;

    @JsonProperty("is_default")
    boolean isDefault;

    @JsonProperty("location_area_encounters")
    String locationAreaEncounters;

    String name;

    Object species;

    Object sprites;

    List<Object> abilities;

    List<Object> forms;

    @JsonProperty("game_indices")
    List<Object> gameIndices;

    @JsonProperty("held_items")
    List<Object> heldItems;

    List<Object> moves;

    @JsonProperty("past_types")
    List<Object> pastTypes;

    List<Object> stats;

    List<Object> types;

}
