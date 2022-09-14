package com.springboot05ems;

import com.springboot05ems.dao.DepartmentDao;
import com.springboot05ems.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class SpringBoot05EmsApplicationTests {

    @Test
    void contextLoads() {
        DepartmentDao departmentDao = new DepartmentDao();
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
    }

}
