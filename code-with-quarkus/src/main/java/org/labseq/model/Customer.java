package org.labseq.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastemail;
    private Integer age;
    private String email;
}
