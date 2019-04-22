package org.katheer.bean.validator;

import org.katheer.bean.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if(student.getName() == null || student.getName().equals("")) {
            errors.rejectValue("name", "error.name.required", "Name is " +
                    "required");
        }

        if(student.getRegNo() == null || student.getRegNo().equals("")) {
            errors.rejectValue("regNo", "error.regno.required", "Reg No is " +
                    "required");
        }

        if(student.getAge() <= 0 || student.getAge() >= 100) {
            errors.rejectValue("age", "error.age.invalid", "Age should be " +
                    "in-between 1 and 100");
        }

        if(student.getCgpa() < 0.0 || student.getCgpa() > 10.0) {
            errors.rejectValue("cgpa", "error.cgpa.invalid", "CGPA should be " +
                    "in-between 0.0 and 10.0");
        }

        if(student.getDept() == null || student.getDept().equals("")) {
            errors.rejectValue("dept", "error.dept.required", "Dept is " +
                    "required");
        }

        if(student.getSem() == null || student.getSem().equals("")) {
            errors.rejectValue("sem", "error.sem.required", "Sem is required");
        }
    }
}
