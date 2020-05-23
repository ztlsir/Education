package com.ztlsir.homework.homework.repository;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="Homeworks")
public class HomeworkPO {
    public HomeworkPO() {
    }

    public HomeworkPO(String id, String jsonContent) {
        this.id = id;
        this.jsonContent = jsonContent;
    }

    @Id
    private String id;
    private String jsonContent;
}
