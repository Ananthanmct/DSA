package com.ticket_managemnt_system.database_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {
    UUID id;
    String commentDescription;
    @ManyToOne
    Task task;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
