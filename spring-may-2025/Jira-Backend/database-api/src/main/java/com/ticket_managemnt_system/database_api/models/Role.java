package com.ticket_managemnt_system.database_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(unique = true)
    String name;
    @ManyToOne
    Organization organization;
    @OneToMany
    List<Operation> operations;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
