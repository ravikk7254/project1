package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.ProductCreateDAO;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.dao.impl.ProductCreateDAOImpl;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.CustomerCreateService;
import com.app.service.CustomerLoginService;
import com.app.service.CustomerSearchService;
import com.app.service.EmployeeLoginService;
import com.app.service.ProductCreateService;
import com.app.service.ProductSearchService;
import com.app.service.impl.CustomerCreateServiceImpl;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.CustomerSearchServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.ProductCreateServiceImpl;
import com.app.service.impl.ProductSearchServiceImpl;

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
				log.info("Enter associate login details: ");
				log.info("1.) Enter username");

				EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();

				String username = scanner.nextLine();

				try {
					if (employeeLoginService.checkUserName(username)) {

					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				

				log.info("2.) Enter password");

				String password = scanner.nextLine();

				try {
					if (employeeLoginService.checkPassword(password)) {
						log.info("Associate login successful!");
						log.info("Welcome");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				int choiceass = 0;

				do {

					log.info("What would you want to do today admin?");

					log.info("1.) Search Products");
					log.info("2.) Add new Product");
					log.info("3.) Search Customers");
					log.info("4.) View all orders");
					log.info("5.) Logout");

					try {
						choiceass = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						log.warn("Please enter a digit between 1 and 5 only");
						continue;
					}

					switch (choiceass) {
					case 1:
						log.info("Under Construction");

						break;
					case 2:
						ProductCreateService productCreateService = new ProductCreateServiceImpl();
						ProductCreateDAO productCreateDAO = new ProductCreateDAOImpl();

						log.info("Enter the Product details to be added to the app: ");
						log.info("1.) Enter Product ID:");

						int id = 0;
						try {
							id = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn("Please enter a number only");
							break;
						}

						try {
							if (productCreateService.checkId(id)) {

							}
						} catch (BusinessException e3) {
							log.warn(e3.getMessage());
							break;

						}

						log.info("2.) Enter Product Name");

						String name = scanner.nextLine();

						try {
							if (productCreateService.checkName(name)) {

							}
						} catch (BusinessException e3) {
							log.warn(e3.getMessage());
							break;
						}

						int price = 0;

						log.info("3.) Enter Product Price");

						try {
							price = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn("Please enter a valid number");
							break;
						}

						try {
							if (productCreateService.checkPrice(price)) {

							}
						} catch (BusinessException e3) {
							log.warn(e3.getMessage());
							break;
						}

						Product product = new Product(id, name, price);

						try {
							int c = productCreateDAO.createProduct(product);

							if (c == 1) {
								log.info("Product Created Successfully with the details: ");
								log.info(product);

							} else {
								log.info("Could not create product");
							}

						} catch (BusinessException e3) {
							log.warn(e3.getMessage());
						}

						break;
					case 3:
						log.info("Okay admin, search for customers using below...");
						int cust = 0;

						do {
							CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
							CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();

							log.info("1.) Search Customer by email");
							log.info("2.) Search Customer(s) by First Name");
							log.info("3.) Search Customer(s) by Last Name");
							log.info("4.) Show All Customers");
							log.info("5.) Return back to the Previous Menu");

							log.info("Please Enter your choice: ");

							try {
								cust = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Please enter a valid number only");
							}

							switch (cust) {

							case 1:
								log.info("1.) Enter Customer's email: ");

								String email = scanner.nextLine();

								try {
									if (customerSearchService.checkEmail(email)) {

									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
									continue;
								}

								try {
									Customer customer1 = customerSearchDAO.getCustomerByEmail(email);

									if (customer1 != null) {
										log.info("Printing Customer details: ");
										log.info("\nCustomer's email :" + customer1.getEmail()
												+ ", Customer's First Name: " + customer1.getFname()
												+ ", Customer's Last Name: " + customer1.getLname());
									}

								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}

								break;

							case 2:
								log.info("2.) Enter Customer's First Name");

								String fname = scanner.nextLine();

								try {
									if (customerSearchService.checkFname(fname)) {

									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
									continue;
								}

								try {
									List<Customer> customerListf = customerSearchDAO.getCustomersByFname(fname);
									if (customerListf.size() > 0) {
										log.info("There are : " + customerListf.size()
												+ " customers with the First Name: " + fname);
										log.info("Printing their details:");

										for (Customer customer : customerListf) {
											log.info("\nCustomer's email :" + customer.getEmail()
													+ ", Customer's First Name: " + customer.getFname()
													+ ", Customer's Last Name: " + customer.getLname());
										}
									}

								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}

								break;

							case 3:
								log.info("3.) Enter Customer's Last Name");

								String lname = scanner.nextLine();

								try {
									if (customerSearchService.checkLname(lname)) {

									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
									continue;
								}

								try {
									List<Customer> customerListl = customerSearchDAO.getCustomersByLname(lname);
									if (customerListl.size() > 0) {
										log.info("There are : " + customerListl.size()
												+ " customers with the Last Name: " + lname);
										log.info("Printing their details:");

										for (Customer customer : customerListl) {
											log.info("\nCustomer's email :" + customer.getEmail()
													+ ", Customer's First Name: " + customer.getFname()
													+ ", Customer's Last Name: " + customer.getLname());
										}
									}

								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}

								break;

							case 4:
								log.info("4.) Showing All Customers: ");

								try {
									List<Customer> customerList = customerSearchDAO.getAllCustomers();

									if (customerList.size() > 0) {
										log.info("There are : " + customerList.size() + " customers in the database");
										log.info("Printing all the Customers:");
										for (Customer customer : customerList) {
											log.info("\nCustomer's email :" + customer.getEmail()
													+ ", Customer's First Name: " + customer.getFname()
													+ ", Customer's Last Name: " + customer.getLname());
										}
									}

								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

								break;

							case 5:
								log.info("Returning back to the Previous Menu...");

								break;

							default:
								log.info("Please enter a digit between 1 and 5 only.");
								continue;
							// break;
							}

						} while (cust != 5);

						
						break;
					case 4:
						log.info("Okay admin, Logging you out...");
						break;
					case 5:
						log.info("Okay admin, Logging you out...");

						break;

					default:
						log.warn("Please enter a number between 1 and 5 only.");
						continue;
					// break;
					}

				} while (choiceass != 5);

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

				String password2 = scanner.nextLine();

				try {
					if (customerCreateService.checkPassword(password2)) {
						customer.setPassword(password2);
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
			log.info("1.) Enter your email");
			CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
			CustomerLoginDAO customerLoginDAO = new CustomerLoginDAOImpl();
			CustomerCreateService customerCreateService1 = new CustomerCreateServiceImpl();
			//CustomerCreateDAO customerCreateDAO = new CustomerCreateDAOImpl();

			String email2 = scanner.nextLine();
			Customer customer1= new Customer();
			try {
				if (customerCreateService1.checkEmail(email2)) {
					
					customer1.setEmail(email2);
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
				continue;
			}

			log.info("2.) Enter password");

			String password1 = scanner.nextLine();

			try {
				if (customerLoginService.checkPassword(password1)) {
					customer1.setPassword(password1);
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
				continue;
			}

			try {
				Customer customer2 = customerLoginDAO.loginCustomer(email2, password1);

				if (customer2 != null) {
					log.info("Customer logged in successfully");
					log.info("Hello " + customer2.getFname() + " " + customer2.getLname()+ "\nWhat do u wanna do today?");
				}

			} catch (BusinessException e) {
				log.warn(e.getMessage());
			}
			
			int choice1 = 0;

			do {

				log.info("1.) Search products");
				log.info("2.) View your orders");
				log.info("3.) Logout");

				log.info("\nPlease enter your choice");

				try {
					choice1 = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					log.warn("Please enter a digit between 1 and 3 only");
					continue;
				}

				switch (choice1) {
				case 1:
					int choice2 = 0;
					do {

						log.info("Welcome to Product Search");
						log.info("How would you want to search the products?");

						//log.info("1.) By name");
						//log.info("2.) By Id");
						log.info("3.) Show all products");
						log.info("4.) Add Product To Cart");
						log.info("5.) Return back to the previous menu");

						log.info("Please enter your choice");

						try {
							choice2 = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn("Please enter digits between 1 and 4 only");
							continue;
						}
						
						ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
						
						ProductSearchService productSearchService = new ProductSearchServiceImpl();
						
						switch (choice2) {
						/*case 1:
							log.info("Enter product name: ");
							
							String name = scanner.nextLine();
							
							try {
								if(productSearchService.checkName(name)) {
									
								}
							} catch (BusinessException e1) {
								log.warn(e1.getMessage());
							}
							
							try {
								List<Product> productList = productSearchDAO.getProductsByName(name);
								
								log.info("There are "+productList.size()+" products with the name: "+name);
								log.info("Printing product details");
								
								for(Product product:productList) {
									log.info(product);
								}
								
							} catch (BusinessException e2) {
								log.warn(e2.getMessage());
							}
							

							break;

						case 2:
							log.info("Enter product id");
							int id = 0;
							
							try{
								id = Integer.parseInt(scanner.nextLine());
							}catch(NumberFormatException e) {
								log.warn("Please enter digits only");
								continue;
							}
							
							try {
								if(productSearchService.checkId(id)) {
									
								}
							} catch (BusinessException e1) {
								log.warn(e1.getMessage());
							}
							
							try {
								
								Product product = productSearchDAO.getProductById(id);
								
								log.info("Printing product details with ID : "+id);
								log.info(product);
								
							} catch (BusinessException e1) {
								log.warn(e1.getMessage());
							}
							
							break;*/

						case 3:
							log.info("All the available products are listed below");
							
							try {
								List<Product> productList = productSearchDAO.getAllProducts();
								for(Product product:productList) {
									log.info(product);
								}
								
							} catch (BusinessException e) {
								log.warn(e.getMessage());
								continue;
							}
							 

							break;
						case 4:
							log.info("Enter Product Id to add the product to your cart");
							
							break;
						case 5:
							log.info("Please Wait...loading you to previous menu");
							break;

						default:
							break;
						}

					} while (choice2 != 5);

					break;

				case 2:
					log.info("Under Construction");

					break;

				case 3:
					log.info("Logging you out...");

					break;
				default:
					break;
				}

			} while (choice1 != 3);
			
		
			case 4:log.info("Hope u had a good time");
			break;
			default:
				log.warn("Invalid choice! The choice should only be a number between 1-4...... try again.....");
				
	}
			
		}
			while (choice != 4);


}
	}
