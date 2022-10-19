package com.maybank.assessment.controllers.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable {
    private String abbreviation;
    private String capital;
    private String currency;
    private String name;
    private String phone;
    private String population;
    private String id;
}