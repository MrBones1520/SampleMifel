package org.example.entities.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.config.utils.ERole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    ERole name;

}
