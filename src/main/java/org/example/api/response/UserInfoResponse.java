package org.example.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    int id;
    String username;
    String email;
    List<String> roles;
}
