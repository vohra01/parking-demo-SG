package com.jinternal.employee.services.impl;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.exception.ServiceException;
import com.jinternal.employee.repositories.EmployeeRepository;
import com.jinternal.employee.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.google.common.collect.Iterators.size;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final Integer totalParkingAvailable = 6;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ParkingServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        employee.orElseThrow(() -> new RuntimeException(String.format("Employee with id :%s not found", id)));

        return employee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) throws ServiceException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        if (!optionalEmployee.isPresent()) {
            throw new ServiceException("employee.not.found", Long.toString(employee.getId()));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public boolean removeEmployee(Employee employee) throws ServiceException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        if (!optionalEmployee.isPresent()) {
            throw new ServiceException("employee.not.found", Long.toString(employee.getId()));
        }
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public void removeEmployee(Long id) throws ServiceException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()) {
            throw new ServiceException("employee.not.found", Long.toString(id));
        }
        employeeRepository.delete(optionalEmployee.get());
    }

    @Override
    public void resetParking() {
        employeeRepository.deleteAll();
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public String spotMyCar(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        employee.orElseThrow(() -> new RuntimeException(String.format("Employee with id :%s not found", id)));

        return "Walk Straight!!! Your car is at pillar no " + id;
    }

    public Employee saveMyCar(Employee employee) {
        int size = size(employeeRepository.findAll().iterator());
        if (size >= totalParkingAvailable) {
            Optional<Employee> employee1 = Optional.empty();
            employee1.orElseThrow(() -> new RuntimeException(String.format("Employee is full, Sorry :%s ", employee.getFirstName())));
        }
        return employeeRepository.save(employee);
    }


}
