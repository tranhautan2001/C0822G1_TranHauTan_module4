package com.example.dto;

import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5,max = 45 ,message = "tên có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String name;

    @NotBlank(message = "Số Điện thoại không được để trống")
    @Pattern(regexp = "^84\\d{9}$",message = "yêu cầu nhập đúng định dạng số điện thoại")
    private String phoneNumber;

    @NotBlank(message = "Tuổi không được để trống")
    @Min(value = 18,message = "yêu cầu nhập trên 18  tuổi")
    private String age;

    @NotBlank(message = "gmail không được để trống")
  /*  @Pattern(regexp = "[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}" ,message = "yêu cầu nhập đúng đinh dạng email")*/

    private String email;


    public UserDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
      UserDto userDto = (UserDto) target;
    }
}
