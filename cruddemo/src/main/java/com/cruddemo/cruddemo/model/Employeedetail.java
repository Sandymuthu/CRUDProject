package com.cruddemo.cruddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employeedetail")

public class Employeedetail {
   @Id
   @Column(name="empid")
    private int empid;
    @Column(name="name")
    private String name;
    @Column(name="dob")
    private Date dob;
    @Column(name="bpay")
    private double bpay;
    @Column(name = "salary")
    private double salary;
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public Employeedetail(int empid, String name, Date dob, double bpay, double salary) {
        this.empid = empid;
        this.name = name;
        this.dob = dob;
        this.bpay = bpay;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employeedetail [empid=" + empid + ", name=" + name + ", dob=" + dob + ", bpay=" + bpay + ", salary="
                + salary + "]";
    }
    public Employeedetail() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public double getBpay() {
        return bpay;
    }
    public void setBpay(double bpay) {
        this.bpay = bpay;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
