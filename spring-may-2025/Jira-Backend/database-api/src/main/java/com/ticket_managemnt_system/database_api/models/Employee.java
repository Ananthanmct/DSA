package com.ticket_managemnt_system.database_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String firstName;
    String lastName;
    @Column(unique = true)
    String email;
    String password;
    @ManyToOne
    Organization organization;
    @OneToMany
    List<Role> roles;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
