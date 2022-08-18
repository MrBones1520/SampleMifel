package sample.mifel.entities.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sample.mifel.config.utils.ERole;

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
