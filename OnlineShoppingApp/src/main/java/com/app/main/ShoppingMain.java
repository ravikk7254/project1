package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerCreateService;
import com.app.service.CustomerLoginService;
import com.app.service.impl.CustomerCreateServiceImpl;
import com.app.service.impl.CustomerLoginServiceImpl;

public class ShoppingMain {
	private static final boolean String = false;
	private static Logger log = Logger.getLogger(ShoppingMain.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		log.info("Welcome to Our Shopping app");
		log.info("=========================================");

		int choice = 0;

		do {

			log.info("Welcome to login page of our app..what do you wanna do??: ");
			log.info("\n1.) Login as Employee");
			log.info("2.) Register as a new Customer");
			log.info("3.) Login as Customer");
			log.info("4.) EXIT");

			log.info("\n Please!!!! Put your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.warn("Invalid entry...please add your choice between 1 to 4");
				continue;
			}
			
			switch (choice) {
			case 1:
				log.info("Processing");

				break;
			case 2:
				log.info("Enter customer details for creation :\n");
				CustomerCreateService customerCreateService = new CustomerCreateServiceImpl();
				CustomerCreateDAO customerCreateDAO = new CustomerCreateDAOImpl();

				Customer customer = new Customer();

				log.info("1.) Enter your email");

				String email = scanner.nextLine();

				try {
					if (customerCreateService.checkEmail(email)) {
						customer.setEmail(email);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("2.) Enter  your first name");

				String fname = scanner.nextLine();

				try {
					if (customerCreateService.checkFname(fname)) {
						customer.setFname(fname);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("3.) Enter your last name");

				String lname = scanner.nextLine();

				try {
					if (customerCreateService.checkLname(lname)) {
						customer.setLname(lname);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("4.) Enter your password");

				String password = scanner.nextLine();

				try {
					if (customerCreateService.checkPassword(password)) {
						customer.setPassword(password);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				try {
					int c = customerCreateDAO.createCustomer(customer);

					if (c == 1) {
						log.info("New Customer Registration Successfull");
					}

				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				break;

			case 3:log.info("Enter Details to Login");
			log.info("1.) Enter email");

			CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
			CustomerLoginDAO customerLoginDAO = new CustomerLoginDAOImpl();
			String email1 = scanner.nextLine();

			try {
				if (customerLoginService.checkEmail(email1)) {
					//customer1.setEmail(email1);
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
				continue;
			}

			log.info("2.) Enter password");

			String password1 = scanner.nextLine();

			try {
				if (customerLoginService.checkPassword(password1)) {
					//customer1.setPassword(password1);
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
				continue;
			}

			try {
				Customer customer2 = customerLoginDAO.loginCustomer(email1, password1);

				if (customer2 != null) {
					log.info("Customer logged in successfully");
					log.info("Hello " + customer2.getFname() + " " + customer2.getLname()+ "\nWhat do u wanna do today?");
				}

			} catch (BusinessException e) {
				log.warn(e.getMessage());
			}
			break;
			
		
			case 4:log.info("Hope u had a good time");
			break;
			default:
				log.warn("Invalid choice! The choice should only be a number between 1-4...... try again.....");
				
	}
			
		}
			while (choice != 4);


}
	}
