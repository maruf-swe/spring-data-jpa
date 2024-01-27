package com.practice.springdatajpa.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {
    private String name ;
    private String guardianEmail;
    private String guardianMobile;
}
