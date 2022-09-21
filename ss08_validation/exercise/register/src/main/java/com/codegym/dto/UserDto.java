package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

    @NotBlank
    @Size(max = 45, min = 5, message = "Số lượng ký tự tối thiếu là 5 và tối đa là 45")
    private String firstName;

    @NotBlank
    @Size(max = 45, min = 5, message = "Số lượng ký tự tối thiếu là 5 và tối đa là 45")
    private String lastName;

    @Pattern(regexp = "[8][4][0-9]{9}",message = "Số điện thoại có định dạng là 84*********  * là các chữ số từ 0-9")
    private String phoneNumber;

    @NotBlank
    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    private String age;

    @NotBlank
    @Email(message = "Email chưa đúng định dạng!")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
