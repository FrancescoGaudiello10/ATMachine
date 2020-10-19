package it.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{
	
	Scanner sc = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'€'###, ##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>(); 
	
	int selection; 
	
	//Validazione informazioni di login e pin
	public void getLogin() throws IOException {
		int x = 1; 
		do {
			try {
				data.put(000001, 1234);
				data.put(000002, 4567);
				data.put(000003, 6789);
				
				System.out.println("***Benvenuto al Bancomat!***");
				System.out.print("Inserisci il Numero Account: ");
				setCustomerAccount(sc.nextInt()); 
				
				System.out.print("Inserisci il PIN: ");
				setPinNumber(sc.nextInt());
				
			} catch (Exception e) {
				System.out.println("Caratteri non validi, inserire solo numeri.");
				x=2; 
			}
			
			for(Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey() == getCustomerAccount() && entry.getValue()== getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("Numero Account/Pin errati!");
		}while(x == 1);
	}
	
	public void getAccountType() throws IOException {
		System.out.println("[-] Cosa vuoi fare?");
		System.out.println("[Tasto 0]: Uscita.");
		System.out.println("[Tasto 1]: Operazioni.");
		System.out.print("Scegli: ");
		
		selection = sc.nextInt(); 
		switch (selection) {
		case 1:
			getChecking(); 
			break;
		case 0:
			System.out.println("Grazie per aver usato questo Bancomat.");
			System.out.println("***Arrivederci***");
			break;
		default:
			System.out.println("Tasto non valido, riprova.");
			getAccountType();
		}
	}
	
	public void getChecking() throws IOException {
		System.out.println("[--] Cosa vuoi fare?");
		System.out.println("Tasto 1: Visualizza saldo.");
		System.out.println("Tasto 2: Prelievo.");
		System.out.println("Tasto 3: Deposito.");
		System.out.println("Tasto 4: Esci.");
		System.out.print("Scegli: ");
		
		selection = sc.nextInt(); 
		switch (selection) {
		case 1:
			System.out.println("Il tuo saldo è di: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2: 
			getCheckingWithdrawInput(); 
			getAccountType();
			break;
		case 3: 
			getCheckingDepositInput(); 
			getAccountType();
			break; 
		case 4: 
			System.out.println("Grazie per aver usato questo Bancomat.");
			System.out.println("***Arrivederci***");
			break;
		default:
			System.out.println("Tasto non valido, riprova.");
			getChecking();
		}
	}
	
	
	
	
//	public void getSaving() {
//		System.out.println("Scegli tra...");
//		System.out.println("Tasto 1: Visualizza il saldo");
//		System.out.println("Tasto 2: Preleva soldi");
//		System.out.println("Tasto 3: Deposita soldi");
//		System.out.println("Tasto 4: Uscita");
//		
//		selection = sc.nextInt(); 
//		switch (selection) {
//		case 1:
//			System.out.println("Salvataggio conto: " + moneyFormat.format(getSavingBalance()));
//			getAccountType();
//			break;
//		case 2: 
//			getSavingWithdrawInput(); 
//			getAccountType();
//			break;
//		case 3: 
//			getSavingDepositInput(); 
//			getAccountType();
//			break; 
//		case 4: 
//			System.out.println("Grazie per aver usato questo Bancomat. Arrivederci!");
//			break;
//		default:
//			System.out.println("Carattere non valido.");
//			getSaving();
//		}
	}

//}
