package com.example.credit.model;

import com.example.credit.model.templates.BaseEntity;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "credit_entity")
public class Credit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Long pinfl;
    private Long salary;

    public Credit(){}
    public Credit(Long id, String name, String lastName, Long pinfl, Long salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pinfl = pinfl;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPinfl() {
        return pinfl;
    }

    public void setPinfl(Long pinfl) {
        this.pinfl = pinfl;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
