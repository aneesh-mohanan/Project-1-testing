package com.ex.project1.Services;

import com.ex.project1.Project1Application;
import com.ex.project1.entities.Reimbursement;
import com.ex.project1.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ex.project1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    ManagerService managerService;

    String requestStatus;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReimbursementRepository reimbursementRepository;


    List<Reimbursement> reimbursementList = new ArrayList<>();

    final Logger logger = LoggerFactory.getLogger(Project1Application.class);

    public EmployeeServiceImpl() {
    }
/*
    public void setRepository(BankCustomerRepository bankCustomerRepository, BankAccountRepository bankAccountRepository, EmployeeRepository employeeRepository, ReimbursementRepository reimbursementRepository, TransactionRepository transactionRepository) {
        this.bankCustomerRepository = bankCustomerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.employeeRepository = employeeRepository;
        this.reimbursementRepository = reimbursementRepository;
        this.transactionRepository = transactionRepository;
    }
*/
    @Override
    public String requestForReimbursement(int employeeId, double amount, String reasonForReimbursement, String dateOfSpending) {
        logger.debug("Request started");
        if (employeeId == 0 || amount == 0 ||dateOfSpending == null) {
            throw new IllegalStateException("Employee id, transaction id and account number can't be null");
        }

        requestStatus = managerService.processReimbursement(employeeId, amount, reasonForReimbursement, dateOfSpending);
        return requestStatus;
    }

    @Override
    public List<Reimbursement> getAllReimbursements(int employeeId) {
        if( (reimbursementList = reimbursementRepository.findAllByEmployeeId(employeeId)) == null){
            throw new IllegalStateException();
        }
        return reimbursementList;
    }

}
