package com.example.Querydsl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

    @Id@GeneratedValue
    private Long id;

    private String name;
}
