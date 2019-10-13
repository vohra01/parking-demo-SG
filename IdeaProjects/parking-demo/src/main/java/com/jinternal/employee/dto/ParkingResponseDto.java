package com.jinternal.employee.dto;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.entities.EmployeeBuilder;
import com.jinternal.employee.entities.Gender;
import com.jinternal.employee.enums.enums.Size;
import com.jinternal.employee.enums.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
public class ParkingResponseDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String department;

    private LocalDate dateOfBirth;

    private boolean isForHandicap;

    private Size size;

    private String licensePlate;

    private VehicleType type;

    private boolean hasHandicapParkingPermit;

    public static Employee from(ParkingResponseDto employeeRequestDto) {

        return EmployeeBuilder
                .employee()
                .withFirstName(employeeRequestDto.firstName)
                .withLastName(employeeRequestDto.lastName)
                .withGender(Gender.valueOf(employeeRequestDto.gender))
                .withDepartment(employeeRequestDto.department)
                .withSize(employeeRequestDto.size)
                .withForHandicap(employeeRequestDto.isForHandicap)
                .withLicensePlate(employeeRequestDto.licensePlate)
                .withType(employeeRequestDto.type)
                .build();

    }

    public static ParkingResponseDto toResponse(Employee employee) {

        ParkingResponseDto employeeRequestDto = new ParkingResponseDto();
        employeeRequestDto.setId(employee.getId());
        employeeRequestDto.setFirstName(employee.getFirstName());
        employeeRequestDto.setLastName(employee.getLastName());
        employeeRequestDto.setDepartment(employee.getDepartment());
        employeeRequestDto.setDateOfBirth(employee.getDateOfBirth());
        employeeRequestDto.setGender(employee.getGender().toString());
        employeeRequestDto.setSize(employee.getSize());
        employeeRequestDto.setType(employee.getType());
        employeeRequestDto.setLicensePlate(employee.getLicensePlate());

        return employeeRequestDto;
    }

    public static List<ParkingResponseDto> toResponse(List<Employee> employee) {
        return employee
                .stream()
                .map(emp -> toResponse(emp))
                .collect(toList());

    }
}
