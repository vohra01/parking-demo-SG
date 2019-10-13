package com.jinternal.employee.services;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.repositories.EmployeeRepository;
import com.jinternal.employee.services.impl.ParkingServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.jinternal.employee.EmployeeTestUtils.anEmployee;
import static java.util.Optional.of;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    private ParkingService parkingService;

    @Mock
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        parkingService = new ParkingServiceImpl(employeeRepository);
    }

    @Test
    public void shouldSaveEmployee() {
        when(employeeRepository.save(Mockito.any())).thenReturn(anEmployee("Mradul","Pandey"));
        parkingService.saveEmployee(anEmployee("Mradul","Pandey"));
        Mockito.verify(employeeRepository).save(anEmployee("Mradul","Pandey"));

    }

    @Test
    public void shouldGetEmployeeId() {
        when(employeeRepository.findById(1L)).thenReturn(of(anEmployee(1L,"Mradul","Pandey")));
         Employee employee = parkingService.getEmployee(1L);

        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(employee.getFirstName()).isEqualTo("Mradul");
        Assertions.assertThat(employee.getLastName()).isEqualTo("Pandey");

    }
}
