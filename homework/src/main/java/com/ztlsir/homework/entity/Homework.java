package com.ztlsir.homework.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="Homeworks")
public class Homework {
    public Homework() {
    }

    public Homework(String id, String jsonContent) {
        this.id = id;
        this.jsonContent = jsonContent;
    }

    @Id
    private String id;
    private String jsonContent;
}
