package com.portal.socgen;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.data.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindById_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex", "shawn", "M", Calendar.getInstance().getTime(), "e");
        employeeRepository.save(alex);

        // when
        Optional<Employee> found = employeeRepository.findById(1L);

        // then
        assertThat(found.get().getFirstName())
                .isEqualTo(alex.getFirstName());
    }

    @Test
    public void whenFindAll_thenReturnEmployees() {
        // given
        Employee alex = new Employee("alex", "shawn", "M", Calendar.getInstance().getTime(), "e");
        employeeRepository.save(alex);
        Employee alex2 = new Employee("alex2", "shawn2", "M", Calendar.getInstance().getTime(), "e");
        employeeRepository.save(alex);
        employeeRepository.save(alex2);

        // when
        List<Employee> found = employeeRepository.findAll();

        // then
        assertThat(found.size())
                .isEqualTo(2);
    }

    @Test
    public void whenSave_thenSaveAndReturnEmployees() {
        // given
        Employee alex = new Employee("alex", "shawn", "M", Calendar.getInstance().getTime(), "e");

        //when
        Employee savedEmployee = employeeRepository.save(alex);

        // then
        assertThat(savedEmployee.getFirstName())
                .isEqualTo(alex.getFirstName());
        assertThat(savedEmployee.getId())
                .isNotZero();
    }
}
