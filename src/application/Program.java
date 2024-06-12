package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        sellers.forEach(System.out::println);

        System.out.println("\n=== TEST 3: Seller findAll ====");
        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);

        System.out.println("\n=== TEST 4: Seller insert ====");
        Seller joas = new Seller(null, "Gabriel", "jojo@gmail.com", new Date(), 2000, department);
        sellerDao.insert(joas);
        System.out.println("Inserted! New id = " + joas.getId());

        System.out.println("\n=== TEST 5: Seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Andre");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: Seller delete ====");
        System.out.print("Id: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Id deleted");

        DB.getConnection();
        sc.close();
    }
}
