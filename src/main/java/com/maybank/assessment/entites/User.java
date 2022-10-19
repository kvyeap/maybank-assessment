package com.maybank.assessment.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tb_user")
public class User extends BaseDomain {

    @Column(name = "name", nullable = false)
    private String name;

}
