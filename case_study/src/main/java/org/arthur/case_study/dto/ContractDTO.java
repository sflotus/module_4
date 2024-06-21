package org.arthur.case_study.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.arthur.case_study.model.main_model.Customer;
import org.arthur.case_study.model.main_model.Employee;
import org.arthur.case_study.model.main_model.Facility;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractDTO implements Validator {

    private Long id;
    @NotBlank(message = "Please choose start date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    String startDate;
    @NotBlank(message = "Please choose end date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    String endDate;
    @Min(value = 1, message = "The deposit amount must be greater than 0")
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    public ContractDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ContractDTO contractDTO = (ContractDTO) target;
       if(contractDTO.startDate != null && contractDTO.endDate != null){
           try {
               Date dateStart = formatter.parse(contractDTO.startDate);
               Date dateEnd =formatter.parse(contractDTO.endDate);
               if(dateStart.after(dateEnd)){
                   errors.rejectValue("startDate","","The start date cannot be greater than the end date");
               }
           } catch (ParseException e) {
               errors.rejectValue("startDate","","Invalid date");
           }

       }
    }
}
