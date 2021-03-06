package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("----- Test 1: Seller findById -----");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("----- Test 2: Seller findByDepartment -----");
		Department department = new Department(2, null);
		List<Seller> listByDepartment = sellerDao.findByDepartment(department);
		for (Seller s : listByDepartment) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("----- Test 3: Seller findAll -----");
		List<Seller> listAll = sellerDao.findAll();
		for (Seller s : listAll) {
			System.out.println(s);
		}
		System.out.println();
		
	}
}
