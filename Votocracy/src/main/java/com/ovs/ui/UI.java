package com.ovs.ui;

import java.util.HashSet;
import java.util.Scanner;

import com.ovs.entity.Election;
import com.ovs.exception.NoRecordFoundException;
import com.ovs.exception.SomethingWentWrongException;
import com.ovs.service.ElectionService;
import com.ovs.service.ElectionServiceImpl;



public class UI {
	
	public static void inititateElection(Scanner sc) throws SomethingWentWrongException {
		
		ElectionService electionService = new ElectionServiceImpl();
        
        try{
            Election election = electionService.getCurrentElection();
            if(election == null) throw new NoRecordFoundException("No Election found");
           
        }
        catch(NoRecordFoundException e){
            Election election = new Election(new HashSet<>());
            electionService.addElection(election);
            
        }
		  
	}
	public static void displayAdminMenu() {
		  
		System.out.println("""
				
				
	    1.Initiate Election,
        2. Terminate Election,
        3. View Candidates",
        4. View Participants,
        5. Manage Candidates,
        6. Manage Participants,
        7. Logout
				""");
	}
	
	static void adminMenu(Scanner sc) throws SomethingWentWrongException {
		   
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				inititateElection(sc);
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
	
	

	static void adminLogin(Scanner sc) throws SomethingWentWrongException {
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
	
	
	 public static void main(String[] args) throws SomethingWentWrongException{
		
		  Scanner sc = new Scanner(System.in);
	    	int choice = 0;
	    	do {
	    		System.out.println("1. Admin Login");
	    		System.out.println("2. Voter Login");
	    		System.out.println("3. Voter Registration");
	    		System.out.println("0. Exit");
	    		System.out.print("Enter Selection ");
	    		
	    		
	    		while (!sc.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a valid integer.");
	                sc.next(); // Clear the invalid input from the scanner buffer
//	                takeInput(sc);
	            }
	    		
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
