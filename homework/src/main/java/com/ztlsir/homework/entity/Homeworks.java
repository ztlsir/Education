package com.ztlsir.homework.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Homeworks {
    public Homeworks() {
    }

    public Homeworks(String id, String jsonContent) {
        this.id = id;
        this.jsonContent = jsonContent;
    }

    @Id
    private String id;
    private String jsonContent;
}
