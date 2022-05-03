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

    @Column(name = "amountReimbursed")
    private double amountReimbursed;

    @Column(name = "dateAndTimeOfReimbursement")
    private Date dateAndTimeOfReimbursement;

    @Column(name = "dateOfSpending")
    private String dateOfSpending;

    @Column(name = "employeeId")
    private int employeeId;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employeeId", updatable = false, insertable = false)
    private Employee employee;
}
