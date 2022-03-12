package com.adilmx.spring_data_app.model;

import com.adilmx.spring_data_app.constants.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    AccountType type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE")
    Date dateCreation;
    @ManyToOne
    User user;
}
