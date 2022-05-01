package com.ex.project1.Services;

import com.ex.project1.Project1Application;
import com.ex.project1.entities.Employee;
import com.ex.project1.entities.Reimbursement;
import com.ex.project1.exceptions.InsuffientBalanceException;
import com.ex.project1.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ex.project1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{
    public ManagerServiceImpl() {
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReimbursementRepository reimbursementRepository;

    RestTemplate restTemplate = new RestTemplate();

    String response;
    List<Reimbursement> reimbursementList = new ArrayList<>();
    List<Reimbursement> allReimbursementsOfRequestedEmployee;
    Reimbursement newReimbursement = new Reimbursement();
    Date currentDateAndTime = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");

    final Logger logger = LoggerFactory.getLogger(Project1Application.class);

    @Override
    public String processReimbursement(int employeeId, double amount, String reasonForReimbursement, String dateOfSpending) {
        Employee requestedEmployee = employeeRepository.getById(employeeId);
        String emailId = requestedEmployee.getEmailId();
        if(amount >= 2000){
            response = "Reassigned";
            String message = "Your request for reimbursement of "+ amount + " has been reassigned";
            String emailingAppUrl = "http://localhost:8080/email/sendEmail/" + emailId + "/" + message;
            ResponseEntity<String> emailResponse = restTemplate.getForEntity(emailingAppUrl, String.class);
        }else if((allReimbursementsOfRequestedEmployee = reimbursementRepository.getByEmployeeId(employeeId)) != null ) {

            Reimbursement existingReimbursement = allReimbursementsOfRequestedEmployee.stream()
                    .filter(r -> (((r.getDateOfSpending()).equals(dateOfSpending)) && ((r.getAmountReimbursed()) == (amount))))
                    .findFirst().orElse(null);

            if (existingReimbursement != null) {
                response = "Declined";
                String message = "Your request for reimbursement of "+ amount + " has been declined";
                String emailingAppUrl = "http://localhost:8080/email/sendEmail/" + emailId + "/" + message;
                ResponseEntity<String> emailResponse = restTemplate.getForEntity(emailingAppUrl, String.class);
            } else{
                System.out.println("inside approval");
                System.out.println(currentDateAndTime);
                response = "Approved";
                String message = "Your request for reimbursement of "+ amount + " has been Approved";
                String emailingAppUrl = "http://localhost:8080/email/sendEmail/" + emailId + "/" + message;
                ResponseEntity<String> emailResponse = restTemplate.getForEntity(emailingAppUrl, String.class);
                newReimbursement.setAmountReimbursed(amount);
                newReimbursement.setDateAndTimeOfReimbursement(currentDateAndTime);
                newReimbursement.setDateOfSpending(dateOfSpending);
                newReimbursement.setEmployeeId(employeeId);
                reimbursementRepository.save(newReimbursement);
            }
        }
        return response;
    }


    @Override
    public List<Reimbursement> getAllReimbursements() {
        System.out.println("Entered");
        if( (reimbursementList = reimbursementRepository.findAll()) == null){
            throw new IllegalStateException();
        }
        return reimbursementList;
    }
}
