package sample.mifel.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CipherRequest {

    String publicKey;

    String originalMessage;

    String cipherMessage;

}
