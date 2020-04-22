package com.ztlsir.homework.entity;

import lombok.Setter;
import lombok.Value;

import javax.persistence.Id;

@Value
@Setter
public class Homeworks {
    @Id
    private String id;
    private String jsonContent;
}
