package org.example.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PersonRequest {

    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo requiere algo de texto")
    String nombre;

}
