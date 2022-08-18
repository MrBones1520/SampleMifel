package sample.mifel.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CipherResponse extends BasicResponse{

    public static CipherResponse createInstance(){
        return new CipherResponse(200, "");
    }

    String publicKey;

    String cipherMessage;

    String originalMessage;

    protected CipherResponse(int code, String message) {
        super(code, message);
    }
}
