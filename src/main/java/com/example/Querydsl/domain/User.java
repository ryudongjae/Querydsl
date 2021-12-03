package com.example.Querydsl.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

    @Id@GeneratedValue
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Team team;
}
