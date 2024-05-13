package com.spring.calculator.validator;

import com.spring.calculator.model.User;
import com.spring.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User userFromDB = userService.getUserByUsername(user.getUsername());

        // Tells user that these fields are required
        if (user.getUsername().isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "User.NotEmpty.username");

        } else if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "User.size.username");

        } else if (userService.getUserByUsername(user.getUsername()) != null) { // Check if the username already exists
            errors.rejectValue("username", "User.duplicate.username");

        }


        if (user.getPassword().isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "User.NotEmpty.password");

        } else if (user.getPassword().length() < 3) {
            errors.rejectValue("password", "User.size.password");
        }


        if (user.getEmail().isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "User.NotEmpty.email");

        } else if (userService.getUserByEmail(user.getEmail()) != null) { // Check if the email already exists
            errors.rejectValue("email", "User.duplicate.email");

        } else if (user.getEmail() == null || user.getEmail().length() > 121) {
            errors.rejectValue("email", "User.size.email");
        }


        if (user.getPasswordConfirm().isEmpty()){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "User.NotEmpty.passwordConfirm");

        } else if (user.getPassword().length() < 3) {
            errors.rejectValue("passwordConfirm", "User.size.passwordConfirm");

        }
        else if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "User.diff.passwordConfirm");
        }

        // Check if the user exists
        if (userFromDB != null && !bCryptPasswordEncoder.matches(user.getPassword(), userFromDB.getPassword())) {
            errors.rejectValue("password", "User.exists.password");
        }

    }

    private boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,21}$");
    }
}
