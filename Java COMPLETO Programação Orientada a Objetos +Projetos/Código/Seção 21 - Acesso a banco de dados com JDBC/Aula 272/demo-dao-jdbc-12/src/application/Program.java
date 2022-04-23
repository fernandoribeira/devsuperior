package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller;

		System.out.println("----- Test 1: Seller findById -----");
		seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("----- Test 2: Seller findByDepartment -----");
		Department department = new Department(3, null);
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
		
		System.out.println("----- Test 4: Seller insert -----");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println();

		System.out.println("----- Test 5: Seller update -----");
		seller = sellerDao.findById(2);
		seller.setName("Bolacha1");
		seller.setEmail("bolacha@gmail.com1");
		seller.setBirthDate(new Date());
		seller.setBaseSalary(10001.0);
		seller.setDepartment(department);
		sellerDao.update(seller);
		System.out.println();
		
		System.out.println("----- Test 6: Seller delete -----");
		sellerDao.deleteById(28);
		System.out.println();
		
	}
}
