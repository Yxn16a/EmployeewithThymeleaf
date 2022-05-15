package com.example.employeewiththymeleaf.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "Table_Employees")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String department;
}
