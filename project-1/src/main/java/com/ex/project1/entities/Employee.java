package com.ex.project1.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "Employees")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId", columnDefinition = "AUTO_INCREMENT")
    private int employeeId;

    private String employeeName;
    private String employeePassword;
    private String employeeRole;
    private String emailId;
    private String isLoggedIn;
}
