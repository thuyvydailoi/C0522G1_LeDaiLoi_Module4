package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    private String age;
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$", message = "email phải đúng định dạng đã quy định")
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
