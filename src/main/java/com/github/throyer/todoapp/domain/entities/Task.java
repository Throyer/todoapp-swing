package com.github.throyer.todoapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import static jakarta.persistence.FetchType.LAZY;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import static java.util.Optional.ofNullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "task")
@Entity(name = "task")
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "finished")
    private Boolean finished;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
    
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private User user;

    public Task(String name, LocalDateTime expiresAt, User user) {
        this.name = name;
        this.expiresAt = expiresAt;
        this.user = user;
    }
    
    @Override
    public String toString() {
        return ofNullable(this.name).orElse("null");
    }
}
