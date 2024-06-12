package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department findById ====");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: Department: findAll ====");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n=== TEST 3: Department insert ====");
        department = new Department(null, "Food");
        departmentDao.insert(department);
        System.out.println("Id: " + department.getId());

        System.out.println("\n=== TEST 4: Department update ====");
        department = departmentDao.findById(6);
        department.setName("Instrumentos");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: Department delete ====");
        departmentDao.deleteById(8);
        System.out.println("Id deleted");

        DB.closeConnection();
    }
}
