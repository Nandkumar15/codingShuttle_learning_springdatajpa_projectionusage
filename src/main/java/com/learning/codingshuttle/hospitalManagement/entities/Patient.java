package com.learning.codingshuttle.hospitalManagement.entities;

import com.learning.codingshuttle.hospitalManagement.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

    //by defualt enum returns EnumType.Ordinal = 0,1,2,3..
    // this is dangerous when enum order changes and data corruption risk
    //hence EnumType.STRING is used here which will store data in string data type itself.
    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDateTime createdAt;

    /// joinColumn should be on the owing side
    /// the unique=true is by default due to one to one mapping
    ///
    @OneToOne
    @JoinColumn(name = "patient_insurance")
    private Insurance insurance; //owning side one source of truth

    @OneToMany(mappedBy = "patient")   //inverse side
private Set<Appointment> appointments =new HashSet<>();

}
