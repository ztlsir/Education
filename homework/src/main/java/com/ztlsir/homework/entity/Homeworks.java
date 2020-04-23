package com.ztlsir.homework.entity;

import lombok.Setter;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;

@Value
@Setter
@Entity
public class Homeworks {
    @Id
    private String id;
    private String jsonContent;
}
