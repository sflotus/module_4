package org.arthur.case_study.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.arthur.case_study.model.sub_model.facility.FacilityType;
import org.arthur.case_study.model.sub_model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDTO implements Validator {
    private Long id;
    @NotBlank(message ="Please input name")
    @NotNull(message ="Please input name")
    private String name;
    @NotNull(message ="Please input area")
    @Min(value = 0,message = "Area must be greater than 0")
    private String area;
    @NotNull(message ="Please input cost")
    @Min(value = 0,message = "Cost must be greater than 0")
    private double cost;
    @NotNull(message ="Please input max people")
    @Min(value = 0,message = "Max people must be greater than 0")
    private String maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descOtherConvenience;
    @NotNull(message ="Please input  pool Area")
    @Min(value = 0,message = "Pool area people must be greater than 0")
    private double poolArea;
    @NotNull(message ="Please input number of floors")
    @Min(value = 0,message = "Number of floors  must be greater than 0")
    private String numberOfFloors;
    private String facilityFree;

    public FacilityDTO() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescOtherConvenience() {
        return descOtherConvenience;
    }

    public void setDescOtherConvenience(String descOtherConvenience) {
        this.descOtherConvenience = descOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }


    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        try{
            if(isInteger(Double.parseDouble(facilityDTO.area))){
                errors.rejectValue("area", "", "Please enter an integer.");
            }
        } catch (Exception e){
            errors.rejectValue("area", "", "Please enter an integer.");
        }
        try{
            if(isInteger(Double.parseDouble(facilityDTO.maxPeople))){
                errors.rejectValue("maxPeople", "", "Please enter an integer.");
            }
        } catch (Exception e){
            errors.rejectValue("maxPeople", "", "Please enter an integer.");
        }
        try{
            if(isInteger(Double.parseDouble(facilityDTO.numberOfFloors))){
                errors.rejectValue("numberOfFloors", "", "Please enter an integer.");
            }
        } catch (Exception e){
            errors.rejectValue("numberOfFloors", "", "Please enter an integer.");
        }

    }
    private boolean isInteger(double value){
        return value % 1 != 0;
    }
}
