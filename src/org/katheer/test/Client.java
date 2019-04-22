package org.katheer.test;

import org.katheer.bean.Student;
import org.katheer.bean.validator.StudentValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        /*
        Bean Validation:
        ----------------
        Validation is the process of checking correctness of data before
        using it in the application.

        Spring provided Validator interface for doing this. It works well in
        MVC application. But still we will do some POC with standalone
        application.
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("org" +
                "/katheer/resource/applicationContext.xml");
        Student student = (Student) context.getBean("student");
        StudentValidator validator = (StudentValidator) context.getBean(
                "validator");

        Map<String,String> errors = new HashMap<String, String>();
        MapBindingResult errorSet = new MapBindingResult(errors, "org.katheer" +
                ".bean.Student.");
        validator.validate(student, errorSet);

        List<ObjectError> allErrors = errorSet.getAllErrors();
        for(ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage());
        }
    }
}
