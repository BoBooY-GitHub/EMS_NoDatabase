package com.springboot05ems.dao;

import com.springboot05ems.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BoBooY
 * @date 2022/9/4 19:57
 */
@Repository
public class DepartmentDao {
    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();   // 创建一个部门集合

        departments.put(101,new Department(101,"运营部"));
        departments.put(102,new Department(102,"策划部"));
        departments.put(103,new Department(103,"法务部"));
        departments.put(104,new Department(104,"开发部"));
        departments.put(105,new Department(105,"宣传部"));

    }

    //获取所有部门的信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    // 通过ID查询部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
