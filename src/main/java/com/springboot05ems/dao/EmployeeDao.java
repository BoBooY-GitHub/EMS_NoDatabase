package com.springboot05ems.dao;

import com.springboot05ems.pojo.Department;
import com.springboot05ems.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BoBooY
 * @date 2022/9/4 20:25
 */
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;


    // 员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();   // 创建一个部门

        employees.put(1001, new Employee(1001, "BoBooY", "A1234567@qq.com", 1, new Department(1001, "运营部"), new Date()));
        employees.put(1002, new Employee(1002, "BoBooY", "B1234567@qq.com", 0, new Department(1002, "策划部"), new Date()));
        employees.put(1003, new Employee(1003, "BoBooY", "C1234567@qq.com", 1, new Department(1003, "法务部"), new Date()));
        employees.put(1004, new Employee(1004, "BoBooY", "D1234567@qq.com", 0, new Department(1004, "开发部"), new Date()));
        employees.put(1005, new Employee(1005, "BoBooY", "F1234567@qq.com", 1, new Department(1005, "宣传部"), new Date()));

    }

    // 增加员工/修改员工,主键自增
    private static Integer initid = 1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过ID查询员工
    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }


}
