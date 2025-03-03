package com.db.zepto.db_api.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDateTime placedTime;
    @ManyToOne
    AppUser customer;
    @ManyToOne
    AppUser deliveryPartner;
    double totalAmount;
    @ManyToMany
    List<Product> products;
}
