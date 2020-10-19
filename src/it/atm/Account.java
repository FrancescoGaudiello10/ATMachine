package it.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	
	private int customerNumber; 
	private int pinNumber; 
	private double checkingBalance = 0; 
	private double savingBalance = 0; 

	Scanner sc = new Scanner(System.in);
	DecimalFormat dc = new DecimalFormat("'€'###, ##0.00");
	
	//Set Numero Account
	public int setCustomerAccount(int customerNumber) {
		this.customerNumber = customerNumber; 
		return customerNumber;
	}
	
	//Get Numero Account
	public int getCustomerAccount() {
		return customerNumber; 
	}
	
	//Set PIN
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber; 
		return pinNumber;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance-amount);
		return checkingBalance;
	}
	
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance-amount);
		return savingBalance;
	}
	
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance+amount);
		return checkingBalance;
	}
	
	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance+amount);
		return savingBalance;
	}
	
	//Gestire l'account dopo il prelievo
	public void getCheckingWithdrawInput() {
		System.out.println("Saldo attuale: " + dc.format(getCheckingBalance())); 
		System.out.print("Quanto vuoi prelevare? ");
		
		double amount = sc.nextDouble();
		if((checkingBalance - amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("Nuovo saldo: " + dc.format(getCheckingBalance())); 
		}
		else {
			System.out.println("Saldo insufficiente, operazione non consentita.");
		}
	}
	
	
	//Gestire l'account dopo il prelievo (saving)
		public void getSavingWithdrawInput() {
			System.out.println("Saldo attuale: " + dc.format(getSavingBalance()));
			System.out.print("Quanto vuoi prelevare? ");
			
			double amount = sc.nextDouble();
			if((savingBalance - amount) >= 0) {
				calcSavingWithdraw(amount); 
				System.out.println("Nuovo saldo: " + savingBalance + "\n");
			}
			else {
				System.out.println("Saldo insufficiente, operazione non consentita.");
			}
		}
		
		public void getCheckingDepositInput() {
			System.out.println("Saldo attuale: " + dc.format(getCheckingBalance()));
			System.out.print("Quanto vuoi depositare? ");
			
			double amount = sc.nextDouble();
			if((savingBalance + amount) >= 0) {
				calcCheckingDeposit(amount); 
				System.out.println("Nuovo saldo: " + dc.format(checkingBalance));
			}else {
				System.out.println("Saldo insufficiente, operazione non consentita.");
			}
		}
		
		public void getSavingDepositInput() {
			System.out.println("Saldo attuale: " + dc.format(getSavingBalance()));
			System.out.print("Quanto vuoi depositare? ");
			double amount = sc.nextDouble();
			if((savingBalance + amount) >= 0) {
				calcSavingWithdraw(amount); 
				System.out.println("Nuovo saldo: " + dc.format(getSavingBalance() + " \n"));
			}
			else {
				System.out.println("Saldo insufficiente, operazione non consentita.");
			}
		}
}
