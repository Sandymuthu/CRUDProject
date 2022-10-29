package com.cruddemo.cruddemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruddemo.cruddemo.model.Employeedetail;
import com.cruddemo.cruddemo.service.EmployeedetailService;



/*
    CRUD - Create , Retreive , Update , Delete
    POST  /api/v1/employee          Create new employee
    GET   /api/v1/employee          Retreive all employees
    GET   /api/v1/employee/:id      Retreive a employee by id
    PUT   /api/v1/employee          Update a employee 
    DELETE /api/v1/employee/:id     Delete a employee by id
 */
@RestController
@RequestMapping("api/v1/employee")
public class ApiController {
    
    @Autowired
    private EmployeedetailService employeedetailService;

    @GetMapping("/{id}")
    public ResponseEntity<Employeedetail> getEmployeeId(@PathVariable ("id") int id )
    {
        Optional<Employeedetail> employee=employeedetailService.retrieveOne(id);
        if(employee.isPresent())
        {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public List<Employeedetail> getAllEmployees()
    {
        return employeedetailService.retrieve();

    }

    @PostMapping
    public String saveEmployee(@RequestBody Employeedetail employeedetail)
    {
        Optional <Employeedetail> employee = employeedetailService.create(employeedetail);
        if(employee.isPresent())
        {
            return "The employee data has been saved successfully";
        }
        else
        {
            return " Employee already exists in the records";
        }
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employeedetail employeedetail)
    {
        Optional<Employeedetail> employee = employeedetailService.update(employeedetail);
        if(employee.isEmpty())
        {
            return "The Employee data does not exist in records";
        }
        else
        {
            return "The employee data has been updated successfully";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id)
    {
        return employeedetailService.delete(id);
    }
}
