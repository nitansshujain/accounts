package com.microservice.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generate the primary key value
    @Column(name="customer_id") // no need here
    private Long customerId;

    private String name;

    private String email;

    @Column(name="mobile_number") // no need here as well
    private String mobileNumber;

}
