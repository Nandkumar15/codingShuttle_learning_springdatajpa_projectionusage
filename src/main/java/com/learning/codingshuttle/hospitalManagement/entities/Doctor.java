package com.learning.codingshuttle.hospitalManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 108)
    private String name;

    @Column(length = 108)
    private String specilization;

    @Column(nullable = false,unique = true,length = 180)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments=new HashSet<>();

}
