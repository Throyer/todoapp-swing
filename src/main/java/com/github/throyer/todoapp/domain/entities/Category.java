package com.github.throyer.todoapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import static java.util.Optional.ofNullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "category")
@Entity(name = "category")
@EqualsAndHashCode(of = {"id"})
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return ofNullable(this.name).orElse("null");
    }
}
