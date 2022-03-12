package com.adilmx.spring_data_app.model;

import com.sun.org.glassfish.gmbal.DescriptorFields;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;
    @Column(name = "NAME")
    String name;
    @Column(name = "TEL")
    String tel;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    List<Account> accounts = new ArrayList<>();
    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}
