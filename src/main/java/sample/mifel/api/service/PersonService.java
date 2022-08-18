package sample.mifel.api.service;

import sample.mifel.api.request.PersonRequest;
import sample.mifel.api.response.PersonResponse;

public interface PersonService {

   PersonResponse getAllRecordsFilterByName(PersonRequest request);

   PersonResponse getAllRecords();

}
