package com.jinternal.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.jinternal.employee.configuration.EmployeeConfiguration;
import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.entities.Gender;

import java.io.IOException;
import java.time.LocalDate;

import static com.jinternal.employee.entities.EmployeeBuilder.employee;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

public class EmployeeTestUtils {
    public static Employee anEmployee(String firstName, String lastName) {
        return employee()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withGender(Gender.MALE)
                .withDepartment("Some-department")
                .withDateOfBirth(now().minusYears(29))
                .build();
    }
    public static Employee anEmployee(Long id, String firstName, String lastName) {
        Employee employee = anEmployee(firstName,lastName);
        employee.setId(id);
        return employee;
    }

    public static String toJson(Object obj) throws IOException {
        ObjectMapper objectMapper = objectMapper();
        //objectMapper.registerModule(new MicroTypeModule());

        ObjectWriter writer = objectMapper.writer().withDefaultPrettyPrinter();
        return writer.writeValueAsString(obj);
    }

    public static ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(ofPattern(EmployeeConfiguration.DATE_FORMAT)));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(ofPattern(EmployeeConfiguration.DATE_FORMAT)));
        mapper.registerModule(module);
        return mapper;
    }
}
