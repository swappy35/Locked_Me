package main;

import java.lang.String;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;  

public class OperationFiles {
	WelcomePage WP = new WelcomePage();
	static Scanner scChar = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static File obj;
	
	//To display directory location and files present in it.
	public void display(){
		System.out.print("\t\t\t You have choosen to display 'Current Directory and Files name in it'.");
		String currentDirectory = null;
		
		// To display directory location.
		try {
			currentDirectory = new java.io.File(".").getCanonicalPath();	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("\n\t\t\t Current Directory: " + currentDirectory);
		
		// To display files in the directory.
		File dir = new File(".");
		File[] filesList = dir.listFiles();
		System.out.print("\n\t\t\t Total Count: "+filesList.length);
		if(filesList.length == 0){
			System.out.print("\n\t\t\t Empty Directory");
		}
		else{
			System.out.print("\n\t\t\t Displaying Files and Directories:");
			int i=0; 
			for (File file : filesList) {
				i++;
				if(file.isFile()) {
					System.out.print("\n\t\t\t\t ("+i+")"+file.getName()+" [File]");
				}
		 	    if(file.isDirectory()){
		 	    	System.out.print("\n\t\t\t\t ("+i+")"+file.getName()+" [Directory]");
		 	    }
			}        	
		}
		System.out.print("\n");
	}

	//To perform operations in the present directory.
	public void operationsMenu(){
		System.out.print("\n\t\t\t You have choosen to perform operations inside the current directory.");
		System.out.print("\n\t\t\t\t What would you like to do:");
		System.out.print("\n\t\t\t\t 1) Add file in the directory.");
		System.out.print("\n\t\t\t\t 2) Search a file.");
		System.out.print("\n\t\t\t\t 3) Delete a file.");
		System.out.print("\n\t\t\t                   Choose the operation: ");
		char ch = scChar.next().charAt(0);
		switch(ch){
		case '1':
			add();
			break;

		case '2':
			search();
			break;
		
		case '3':
			delete();
			break;
		
		default :
			System.out.print("\n\t\t\t Please select appropriate option. ");
			operationsMenu();
			break;
		}
		
	}
	
	//To add a new file in the working directory.
	private void add() {
		int flag = 1;
		while(flag ==1){
		System.out.print("\n\t\t\t Enter the file name to be created: ");
		String str = sc.nextLine();
		obj = new File(str);
		try {
			if(obj.createNewFile()){
				System.out.print("\n\t\t\t\t File '" + obj.getName() + "' created successfully.");
			}
			else{
				System.out.print("\n\t\t\t File already exists");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("\n\n\t\t\t         To continue Adding files, press any key. ");
		System.out.print("\n\t\t\t           To return to Operations Menu, press 'N'.");
		System.out.print("\n\t\t\t             To enter Main Menu, press 'Y'. \n\t\t\t\t\t\t     ");
		char chExit = scChar.next().charAt(0);
		if(chExit == 'y'  || chExit == 'Y'){
			flag = 0;
			System.out.print("\n\t\t\t\t\t       Main Menu!!!\n");	
		}
		else if(chExit == 'n'  || chExit == 'N'){
			flag = 0;
			operationsMenu();
		}
		else{
			flag = 1;
		}
		}
	}
	
	//To search files and directories in the working directory. 
	private void search() {
		int flag = 1;
		while(flag ==1){
		System.out.print("\n\t\t\t Enter the file name to be searched: ");
		String str = sc.nextLine();
		File dir = new File(".");
		File[] filesList = dir.listFiles();
		if(filesList.length == 0){
			System.out.print("\t\t\t Sorry! Directory is Empty. ");
		}
		else{
			int counter = 0;
			for (File file : filesList) {
				if(file.getName().equals(str) ) {
					counter++;
					System.out.print("\t\t\t\t Successful, File is present in the Directory.");
				}
			}
			if(counter == 0)
				System.out.print("\t\t\t\t Sorry!!! File Not Found.");
		}
		System.out.print("\n\n\t\t\t         To continue Searching files, press any key. ");
		System.out.print("\n\t\t\t           To return to Operations Menu, press 'N'.");
		System.out.print("\n\t\t\t             To enter Main Menu, press 'Y'. \n\t\t\t\t\t\t     ");
		char chExit = scChar.next().charAt(0);
		if(chExit == 'y'  || chExit == 'Y'){
			flag = 0;	
			System.out.print("\n\t\t\t\t\t       Main Menu!!!\n");	
		}
		else if(chExit == 'n'  || chExit == 'N'){
			flag = 0;
			operationsMenu();
		}
		else{
			flag = 1;
		}
		}
	}
	
	//To delete files and directories from the working directory.
	private void delete() {
		int flag = 1;
		while(flag ==1){
		System.out.print("\n\t\t\t Enter the file name to be deleted: ");
		String str = sc.nextLine();
		File dir = new File(".");
		File[] filesList = dir.listFiles();
		if(filesList.length == 0){
			System.out.print("\t\t\t Sorry! Directory is Empty, nothing to delete ");
		}
		else{
			int counter = 0;
			for (File file : filesList) {
				if(file.getName().equals(str) ) {
					counter++;
					System.out.print("\t\t\t\t Successful, File '"+file.getName()+"' deleted from the directory.");
					file.delete();
				}
			}
			if(counter == 0)
				System.out.print("\t\t\t\t Sorry!!! File Not Found.");
		}
		System.out.print("\n\n\t\t\t         To continue Deleting files, press any key. ");
		System.out.print("\n\t\t\t           To return to Operations Menu, press 'N'.");
		System.out.print("\n\t\t\t             To enter Main Menu, press 'Y'. \n\t\t\t\t\t\t     ");
		char chExit = scChar.next().charAt(0);
		if(chExit == 'y'  || chExit == 'Y'){
			flag = 0;
			System.out.print("\n\t\t\t\t\t       Main Menu!!!\n");
		}
		else if(chExit == 'n'  || chExit == 'N'){
			flag = 0;
			operationsMenu();
		}
		else{
			flag = 1;
		}
		}
	}	
	
	//To ask before final exit from the application
	public int exit(){
		int flag = 1;
		System.out.print("\n\n\t\t\t       To continue the application, press any key.");
		System.out.print  ("\n\t\t\t           To Exit the application, press 'Y'. \n\t\t\t\t\t\t     ");
		char chExit = scChar.next().charAt(0);
		if(chExit == 'y'  || chExit == 'Y'){
			flag = 0;
			System.err.print("\n\n\t\t                                  EXITED!!!");
			System.exit(0);
		}
		else{
			flag = 1;
		}
		return flag;
	}

}
