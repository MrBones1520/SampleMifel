package org.example.api.service;

import org.example.api.request.PersonRequest;
import org.example.api.response.PersonResponse;

public interface PersonService {

   PersonResponse getAllRecordsFilterByName(PersonRequest request);

   PersonResponse getAllRecords();

}
