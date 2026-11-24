package com.learning.codingshuttle.hospitalManagement.entities;

import com.learning.codingshuttle.hospitalManagement.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
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
    /// whenever there is change in the patient it will be reflected in the child that is Insurance
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_insurance")
    private Insurance insurance; //owning side one source of truth

    //by default one to many mapping has lazy fetch type , this can lead to n+1 select query problem.
    //@BatchSize(size = 3)
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Appointment> appointments =new HashSet<>();

}
