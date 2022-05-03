package com.ex.project1.controllers;

import com.ex.project1.Services.EmployeeService;
import com.ex.project1.Services.EmployeeServiceImpl;
import com.ex.project1.Services.ManagerService;
import com.ex.project1.Services.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    ManagerService managerService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "{employeeId}/{amount}/{reasonForReimbursement}/{dateOfSpending}")
    public  String requestForReimbursement(@PathVariable("employeeId") Integer employeeId, @PathVariable("amount") double amount, @PathVariable("reasonForReimbursement") String reasonForReimbursement, @PathVariable("dateOfSpending") String dateOfSpending){
        return (employeeService.requestForReimbursement(employeeId, amount, reasonForReimbursement, dateOfSpending));
    }

    @GetMapping("getAllReimbursements/{employeeId}")
    public ResponseEntity getAllReimbursements(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(employeeService.getAllReimbursements(employeeId));
    }
}
