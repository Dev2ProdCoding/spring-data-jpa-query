package com.dev2prod.springdatajpaquery.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String name;
    private Integer age;
    private Boolean active;
    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber=(long) (Math.random()*Math.pow(10,10));
    private String designation;
    private Double salary = Math.random()*100000;
}
