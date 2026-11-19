package com.learning.codingshuttle.hospitalManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 508)
    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false)   //owning side
    private  Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;


}
