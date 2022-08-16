package org.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    enum TransactionType {
        LOAN, INCOME, EXPENSE, TRANSFER
    }

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "account_origin")
    @JsonBackReference
    Account origin;

    @ManyToOne
    @JoinColumn(name = "account_target")
    @JsonBackReference
    Account target;

    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    String description;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdOperation;

    @Temporal(TemporalType.TIMESTAMP)
    Date completeOperation;

}
