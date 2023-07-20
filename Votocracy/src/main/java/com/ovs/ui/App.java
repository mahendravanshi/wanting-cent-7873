package com.ovs.ui;

import java.util.Scanner;

import com.masai.ui.AdminUI;



public class App {
	
	
	static void adminMenu(Scanner sc) {
		   
		int choice = 0;
		do {
//			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//AdminUI.addCompany(sc);
    				break;
    			case 2:
    				//AdminUI.viewCompanies();
    				break;
    			case 3:
    				//AdminUI.updateCompanyDetails(sc);
    				break;
    			case 4:
    				//AdminUI.addPlan(sc);
    				break;
    			case 5:
    				//AdminUI.viewPlan();
    				break;
    			case 6:
    				//AdminUI.updatePlan(sc);
    				break;
    			case 7:
    				//AdminUI.updatePremiumAndSurcharge(sc);
    				break;
    			case 8:
    				//AdminUI.viewAllCustomers();
    				break;
    			case 9:
    				//AdminUI.viewPolicyReport();
    				break;
    			case 10:
    				//AdminUI.makePoliciesDiscontinued();
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}

	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username or Password");
		}
	}
	
	  public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	    	int choice = 0;
	    	do {
	    		System.out.println("1. Admin Login");
	    		System.out.println("2. Voter Login");
	    		System.out.println("3. Voter Registration");
	    		System.out.println("0. Exit");
	    		System.out.print("Enter Selection ");
	    		choice = sc.nextInt();
	    		switch(choice) {
	    			case 1:
	    				adminLogin(sc);
	    				break;
	    			case 2:
	    				//CustomerUI.userLogin(sc);
	    				break;
	    			case 3:
	    				//CustomerUI.customerRegistration(sc);
	    				break;
	    			case 0:
	    				System.out.println("Thanks for using the services");
	    				break;
	    			default:
	    				System.out.println("Invalid Selection, try again");
	    		}
	    	}while(choice != 0);
	    	sc.close();
		  
	   }
}
