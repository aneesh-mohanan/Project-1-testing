package com.ex.project1.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Reimbursements")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    private int id;

    private double amountReimbursed;
    private Date dateAndTimeOfReimbursement;
    private String dateOfSpending;
    private int employeeId;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employeeId", updatable = false, insertable = false)
    private Employee employee;
}
