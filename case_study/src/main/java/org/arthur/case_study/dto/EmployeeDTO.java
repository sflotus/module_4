package org.arthur.case_study.dto;

import jakarta.validation.constraints.*;
import org.arthur.case_study.model.sub_model.employee.Division;
import org.arthur.case_study.model.sub_model.employee.EducationDegree;
import org.arthur.case_study.model.sub_model.employee.Position;
import org.arthur.case_study.model.sub_model.employee.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class EmployeeDTO implements Validator {
    private Long id;
    @NotBlank(message ="Please input name")
    @NotNull(message ="Please input name")
    @Pattern(regexp = "^[\\p{L} ]{2,}(?: [\\p{L} ]{2,})*$", message = "Name is not contain number")
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "Please choose date of birth")
    private Date dateOfBirth;
    @NotNull(message ="Please input id card")
    @Size(min = 8, max = 12, message = "invalid Id Card")
    private String idCard;
    @NotNull(message ="Please input salary")
    @Min(value = 0,message = "Salary must be greater than 0")
    private double salary;
    @NotNull(message ="Please input phone number")
    @Size(min = 10, max = 20, message = "Invalid phone number")
    private String phoneNumber;
    @NotNull(message = "Please input email")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}", message = "Invalid email")
    private String email;
    @NotNull(message = "please input address")
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        if(employeeDTO.idCard.length()>=8 && employeeDTO.idCard.length()<=12){
            if (employeeDTO.idCard.length() != 8 && employeeDTO.idCard.length() != 9 && employeeDTO.idCard.length() != 12) {
                errors.rejectValue("idCard", "", "Invalid id card");
            }
        }
    }
}
