package main;

import java.util.Scanner;

public class ExecutableFile {
	static String enterkey;
	static Scanner sc = new Scanner(System.in);
	static Scanner scChar = new Scanner(System.in);
	
	public static void menu(){
		int flag=1;
		OperationFiles OF = new OperationFiles();
		while(flag == 1){
		System.out.print("\n\t\t\t Choose the option below (1, 2 or 3):");
		System.out.print("\n\t\t\t 1) To display directory location and files present in it.");
		System.out.print("\n\t\t\t 2) To perform operations in the present directory.");
		System.out.print("\n\t\t\t 3) To exit the application.");
		System.out.print("\n\n\t\t\t                 Please enter your choice: ");
		char ch = scChar.next().charAt(0);
			switch(ch){
			case '1':
				OF.display();
				break;

			case '2':
				OF.operationsMenu();
				break;
			
			case '3':
				OF.exit();
				break;
			
			default :
				System.out.print("\n\t\t\t Please enter an appropriate choice (1, 2, or 3). \n");
				break;
			}
			menu();
		}
	}
	
	public static void main(String[] args) {
		WelcomePage WP = new WelcomePage();
		OperationFiles OF = new OperationFiles();
		WP.frontPage();
		enterkey = sc.nextLine();
		if(enterkey.equals("")){
			System.out.print("\n\t\t\t\t\t       Main Menu!!!\n");
			menu();
		}
		else{
			OF.exit();
			menu();
		}
	}
}