package sample.mifel.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import sample.mifel.entities.Person;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PersonResponse extends BasicResponse{

    public static PersonResponse createInstance(){
        return new PersonResponse(200, "");
    }

    private Person result;

    private List<Person> results;

    private boolean valid = false;

    protected PersonResponse(int code, String message) {
        super(code, message);
    }

    public void calculateResult(Optional<List<Person>> optRest){
        this.valid = optRest.isPresent();
        this.result = optRest.isPresent() && optRest.get().size() == 1 ? optRest.get().get(0) : null;
        this.results = optRest.isPresent() && optRest.get().size() > 1 ? optRest.get() : null;
    }

    public void calculateResult(List<Person> personList){
        calculateResult(Optional.of(personList));
    }



}
