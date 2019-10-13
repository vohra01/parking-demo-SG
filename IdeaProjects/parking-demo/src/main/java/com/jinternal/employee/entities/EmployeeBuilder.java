package com.jinternal.employee.entities;

import com.jinternal.employee.enums.enums.Size;
import com.jinternal.employee.enums.enums.VehicleType;

import java.time.LocalDate;


public class EmployeeBuilder {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String department;
    private LocalDate dateOfBirth;

    private Size size;
    private boolean isForHandicap;

    // Vehicle Info

    private String licensePlate;
    private VehicleType type;
    private boolean hasHandicapParkingPermit;

    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder withDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public EmployeeBuilder withSize(Size size) {
        this.size = size;
        return this;
    }

    public EmployeeBuilder withType(VehicleType type) {
        this.type = type;
        return this;
    }

    public EmployeeBuilder withForHandicap(boolean isForHandicap) {
        this.isForHandicap = isForHandicap;
        return this;
    }

    public EmployeeBuilder withLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public EmployeeBuilder withHandicapParkingPermit(boolean hasHandicapParkingPermit) {
        this.hasHandicapParkingPermit = hasHandicapParkingPermit;
        return this;
    }

    public Employee build() {
        return new Employee(firstName, lastName, gender, department, dateOfBirth, size, isForHandicap, licensePlate, type);
    }

    public static EmployeeBuilder employee(){
        return new EmployeeBuilder();
    }
}
