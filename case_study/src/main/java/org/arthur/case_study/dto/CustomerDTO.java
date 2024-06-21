package org.arthur.case_study.dto;

import jakarta.validation.constraints.*;
import org.arthur.case_study.model.sub_model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class CustomerDTO implements Validator {
    private Long id;
    private CustomerType customerType;
    @NotNull(message = "Please input name")
    @Pattern(regexp = "^[\\p{L} ]{2,}(?: [\\p{L} ]{2,})*$", message = "Name is not contain number")
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "Please choose date of birth")
    private Date dateOfBirth;
    private boolean gender;
    @NotBlank(message = "Please input id card")
    @Size(min = 8, max = 12, message = "invalid Id Card")
    private String idCard;
    @NotNull(message = "Please input phone number")
    @Size(min = 10, max = 20, message = "Invalid phone number")
    private String phoneNumber;
//    @NotNull(message = "Please input email")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}", message = "Invalid email")
    private String email;
    @NotBlank(message = "please input address")
    private String address;

    public CustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        if(customerDTO.idCard.length()>=8 && customerDTO.idCard.length()<=12){
            if (customerDTO.idCard.length() != 8 && customerDTO.idCard.length() != 9 && customerDTO.idCard.length() != 12) {
                errors.rejectValue("idCard", "", "Invalid id card");
            }
        }
    }
}
