package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class CustomerDto implements Validator {

    private int id;

    @NotBlank(message = "tên không được bỏ trống ")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$" ,message = "tên phải đúng định dạng")
    private String name;
    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private String dateOfBirth;
    private double gender;
    @NotBlank(message = "ID Card không được bỏ trống")
    @Pattern(regexp = "^\\d{9}$",message = "nhập đúng định dạng cmnd")
    @Column(unique = true)
    private String idCard;
    @NotBlank(message = "không được để trống số điện thoại")
    @Pattern(regexp = "[0-9]{10}",message = "nhập đúng định dạng số điện thoại ")
    @Column(unique = true)
    private String phoneNumber;
    @NotBlank(message = "khồn đươc bỏ trống email")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "yêu cầu nhập đúng định dạng email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "không được bỏ trống address")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getGender() {
        return gender;
    }

    public void setGender(double gender) {
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

    }
}
