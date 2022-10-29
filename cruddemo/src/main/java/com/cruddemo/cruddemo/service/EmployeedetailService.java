package com.cruddemo.cruddemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cruddemo.cruddemo.model.Employeedetail;
import com.cruddemo.cruddemo.repository.EmployeedetailRepository;

@Service
public class EmployeedetailService {
    @Autowired
    private EmployeedetailRepository employeedetailRepository;

    public List<Employeedetail> retrieve()
    {
        return employeedetailRepository.findAll();
    }

    public Optional<Employeedetail> retrieveOne(int empid)
    {
        return employeedetailRepository.findById(empid);
    }
    
    public Optional<Employeedetail> create(Employeedetail employeedetail)
    {
        if(employeedetailRepository.existsById(employeedetail.getEmpid()))
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(employeedetailRepository.save(employeedetail));
        }
    }

    public Optional<Employeedetail> update(Employeedetail employeedetail)
    {
        if(employeedetailRepository.existsById(employeedetail.getEmpid()))
        {
            return Optional.of(employeedetailRepository.save(employeedetail));
        }
        else
        {
            return Optional.empty();
        }
      
    }

    public String delete(int empid)
    {
        if(employeedetailRepository.existsById(empid))
        {
            employeedetailRepository.deleteById(empid);
            return empid + " deleted successfully";
        }
        else
        {
            return "The employee does not exists in the records";
        }
    }
}
