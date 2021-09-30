package com.example.fieldaware;

public class AddEng {
    String email_id,name,emp_id;

    public AddEng() {

    }

    public AddEng(String email_id, String name, String emp_id) {
        this.email_id = email_id;
        this.name = name;
        this.emp_id = emp_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
}
