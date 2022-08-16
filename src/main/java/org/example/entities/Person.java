package org.example.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "person")
    Set<Account> accounts;



}
