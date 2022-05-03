package com.ex.project1;

import com.ex.project1.Services.EmployeeService;
import com.ex.project1.Services.EmployeeServiceImpl;
import com.ex.project1.exceptions.IncorrectDetailsForReimbursementException;
import com.ex.project1.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


public class EmployeeServiceTests {



    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReimbursementRepository reimbursementRepository;


    EmployeeService employeeService;

    @BeforeEach
    public void initEachTest() {
        System.out.println("Initializing before test");

        /*
        employeeService.setRepository(bankCustomerRepository, bankAccountRepository,employeeRepository,reimbursementRepository, transactionRepository);
    */
    }

/*

    @Test
    void shouldThrowIllegalStateExceptionForNullDetailsForReimbursementRequest() {
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,0,0);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,0,100);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,10,0);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,2,100);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(100,2,0);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(100,0,100);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(100,2,0);
        });

        Assertions.assertEquals("Employee id, transaction id and account number can't be null", ex.getMessage(), "Method didn't throw with null values");

    }


    @Test
    void shouldThrowIncorrectDetailsForReimbursementRequest() {

        IncorrectDetailsForReimbursementException ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(500000,500000,50000);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(50000,50000,1);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(50000,1,50000);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(50000,1,1);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,50000,50000);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,50000,1);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

        ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,1,50000);
        });

        Assertions.assertEquals("Not valid EmployeeId, transaction id or account number", ex.getMessage(), "Method didn't throw with incorrect values exception");

    }*/
}
