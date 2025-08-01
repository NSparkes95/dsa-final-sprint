package com.theater.dsa_fs.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TreeSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String inputNumbers;

    @Lob
    @Column(nullable = false)
    private String treeJson;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() {return id; }
    public void setId(Long id) { this.id = id; }

    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }

    public String getTreeJson() { return treeJson; }
    public void setTreeJson(String treeJson) { this.treeJson = treeJson; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
