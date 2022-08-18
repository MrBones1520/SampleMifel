package sample.mifel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @Column(unique = true)
    String numberCard;

    @ManyToOne
    @JsonBackReference
    Person person;

    BigDecimal limitCredit;

    @OneToMany(mappedBy = "origin")
    Set<Transaction> transactionsOrigin;

    @OneToMany(mappedBy = "target")
    Set<Transaction> transactionsTarget;

}
