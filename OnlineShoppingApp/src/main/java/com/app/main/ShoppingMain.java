package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CartAddDAO;

import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.ProductCreateDAO;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.CartAddDAOImpl;

import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.dao.impl.ProductCreateDAOImpl;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.CartAddService;

import com.app.service.CustomerCreateService;
import com.app.service.CustomerLoginService;
import com.app.service.CustomerSearchService;
import com.app.service.EmployeeLoginService;
import com.app.service.ProductCreateService;
import com.app.service.ProductSearchService;
import com.app.service.impl.CartAddServiceImpl;

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

			log.info("\n Please!!!!  Select your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.warn("Invalid entry...please add your choice between 1 to 4");
				continue;
			}
			
			switch (choice) {
			case 1:
				log.info("Enter Employee login details: ");
				log.info("1.) Enter your Username");

				EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();

				String username = scanner.nextLine();

				try {
					if (employeeLoginService.checkUserName(username)) {

					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				

				log.info("2.) Enter your Password");

				String password = scanner.nextLine();

				try {
					if (employeeLoginService.checkPassword(password)) {
						log.info("Employee logged in successfully!");
						log.info("Hiii");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				int choose = 0;

				do {

					log.info("What do you wannaaa do?");

					
					log.info("1.) Add  a new Product");
					log.info("2.) Search for Customers");
					log.info("3.) Logout from here");

					try {
						choose = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						log.warn("Please enter number between 1 and 5 only");
						continue;
					}

					switch (choose) {
					
					case 1:
						ProductCreateService productCreateService = new ProductCreateServiceImpl();
						ProductCreateDAO productCreateDAO = new ProductCreateDAOImpl();

						log.info("Enter the Product details which you wanna add to: ");
						log.info("1.) Enter Product ID:");

						int id = 0;
						try {
							id = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn("You should enter a number only");
							break;
						}

						try {
							if (productCreateService.checkId(id)) {

							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
							break;

						}

						log.info("2.) Enter your Product Name");

						String name = scanner.nextLine();

						try {
							if (productCreateService.checkName(name)) {

							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
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
								log.info("Product Created Successfully with the following details: ");
								log.info(product);

							} else {
								log.info("New product can not be created");
							}

						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}

						break;
					case 2:
						log.info("Okay Man.... search for customers using below...");
						int sec = 0;

						do {
							CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
							CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();

							log.info("1.) Search Customer by email");
							log.info("2.) Search Customers by First Name");
							log.info("3.) Search Customers by Last Name");
							log.info("4.) View All Customers");
							log.info("5.) Go back to the Previous Menu");

							log.info("Please Enter your choice: ");

							try {
								sec = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Please enter a valid number only");
							}

							switch (sec) {

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
										log.info("\nemail :" + customer1.getEmail()
												+ ",First Name: " + customer1.getFname()
												+ ", Last Name: " + customer1.getLname());
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
											log.info("\nCemail :" + customer.getEmail()
													+ ",First Name: " + customer.getFname()
													+ ",Last Name: " + customer.getLname());
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
											log.info("\nemail :" + customer.getEmail()
													+ ",First Name: " + customer.getFname()
													+ ",Last Name: " + customer.getLname());
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
										log.info("We have : " + customerList.size() + " customers in our database");
										log.info("Here is the list of the Customers:");
										for (Customer customer : customerList) {
											log.info("\n :" + customer.getEmail()
													+ ",  First Name: " + customer.getFname()
													+ ",  Last Name: " + customer.getLname());
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
								log.info("Please enter a number between 1 and 5 only.");
								continue;
							// break;
							}

						} while (sec != 5);

						
						break;
			
					case 3:
						log.info("Logged Out....Have a nice day");

						break;

					default:
						log.warn("Please enter a number between 1 to 3 only.");
						continue;
					
					}

				} while (choose != 3);

				break;

						
			case 2:
				log.info("Enter your details to register a new customer :\n");
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

			case 3:log.info("Enter  below Details to Login");
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
				log.info("2.) Place Order");
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
					int choc = 0;
					do {

						log.info("Welcome to Product Search");
						log.info("How would you like to search for products?");
						log.info("1.) By name");
						log.info("2.) Show all products");
						log.info("3.) Add Product To Your Cart");
						log.info("4.) Return back to the previous menu");

						log.info("Please enter your choice");

						try {
							choc = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn("Please enter digits between 1 and 4 only");
							continue;
						}
						
						ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
						
						ProductSearchService productSearchService = new ProductSearchServiceImpl();
						
						switch (choc) {
						case 1:
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
							log.info("Here is the List of products We have for You...");
							
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
						case 3:
							log.info("Enter Product ID of the product you wish to Add to your Cart:");
							int prodId = 0;

							CartAddDAO cartAddDAO = new CartAddDAOImpl();

							try {
								prodId = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Please enter a valid ID");
								continue;
							}

							
                             CartAddService cart = new CartAddServiceImpl();
							try {
								cart.checkProductID(prodId);
							} catch (BusinessException e1) {
								log.warn(e1.getMessage());
								continue;
							}

							try {
								int cartId = cartAddDAO.addToCart(customer1.getEmail(), prodId);

								if (cartId != 0) {
									log.info("Product added to cart successfully with Cart ID : " + cartId);
								}

							} catch (BusinessException e) {
								log.warn(e.getMessage());
								continue;
							}

							break;
						case 4:
							log.info("Taking You Back to Previous menu...");
							break;

						default:
							break;
						}

					} while (choc != 5);

					break;

				case 2:
					log.info("Sry...Cannot Process Your Order!!!!");
					
					break;


				

				case 3:
					log.info("Logging you out...");

					break;
				default:
					break;
				}

			} while (choice1 != 3);
			
		
			case 4:log.info("Hope u had a good time with us.....see you soon:))))");
			break;
			default:
				log.warn("Invalid choice! The choice should only be a number between 1-4...... try again.....");
				
	}
			
		}
			while (choice != 4);


}
	}
