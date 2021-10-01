package part3;

import java.util.Scanner;












public class UserInterface {
	 String title = "Bank Management";
	 final String options[] = {"Create The Profile Of A Bank Client", "Create Bank Account", "Update The Profile Of A Bank-Client", 
			"Delete A Bank Account", "Money Transfer", "Printing The Profile Of A Bank Client", "Printing the Bank Accounts Of A Bank Client" , "Quit"};
	 final int QUIT = options.length;
	 Menu myMenu = new Menu(title, options);
	 Scanner input = new Scanner(System.in);
	
	
	 final short MAXCLIENT = 1000;//maximum amount of clients in array
	 BankClient client[] = new BankClient[MAXCLIENT];//create the array for the bank clients
	 short clientCount = 0;
	
	 final byte MAXACC = 5;//maximum amount of accounts in array
	
	 BankAccount account[] = new BankAccount[ MAXACC ];//create array for bank accounts
	 byte accCount = 0;
	 short currentUser;
	
	
	
	
	public static void main( String[] args ) {//Start-up use-case
		UserInterface userInterface = new UserInterface();
		
		userInterface.batchRegistration();//calling the batch registration of the bank clients
		userInterface.Login();
	}


	
		
			
	private void Login() {
		
		
		
		System.out.println("Enter your clientID: ");
		currentUser = (short) (input.nextShort() - 1);
		
		if (currentUser < getClientNames().length) {
			System.out.println("Welcome to the system");
		}
		else {
			System.out.println("The clientID you entered is invalid");
			Login();
			
			
		}

	
		
			
		int choice;
			do {
				myMenu.display();
				choice = myMenu.getChoice();
				if (choice != QUIT) {
					processChoice(choice);
				}
		}
		while( choice != QUIT ); 
			System.out.println("\nGoodbye!");
			
		}
	
		
		
	
	
//present management options that the user can select from and display this section of the program
	private void processChoice(int choice) {
		
		
		switch (choice) {
		case 1:
			System.out.println("Use Case 3. Create The Profile Of A Bank Client :\n");
			createNewClient();
			break;
		case 2:
			System.out.println("Use Case 4. Create Bank Account :\n");
			createBankAccount();
			break;
		case 3:
			System.out.println("Use Case 5. Update The Profile Of A Bank-Client :\n");
			updateBankCLient();
			break;
		case 4:			
			System.out.println("Use Case 6. Delete A Bank Account  :\n");
			deleteBankAccount();
			break;
		case 5:
			System.out.println("Use Case 7. Money Transfer: \n ");
			transferMoney();
			break;
		case 6:
			System.out.println("Use Case 8. Printing The Profile Of A Bank Client: \n");
			ClientDetails();
			break;
		case 7:
			System.out.println("Use Case 9. Printing the Bank Accounts Of A Bank Client: \n");
			BankAccountDetails();
			break;	
		default: 	System.out.println("Option "+choice+" is invalid.");
		}
		System.out.println();
		
	}
	
	
	
	
	
	//create new clients 
	private void createNewClient() {
		if ( clientCount < MAXCLIENT ) {//check that there is enough room for new clients 
			BankClient clt = new BankClient();
			System.out.println("Enter first Name: ");
			String firstName = input.nextLine();
			clt.profile.setFirstName(firstName);
			
			System.out.println("Enter last Name: ");
			String lastName = input.nextLine();
			clt.profile.setLastName(lastName);
			
			System.out.println("Enter address: ");
			String address = input.nextLine();
			clt.details.setAddress(address);
			
			System.out.println("Enter age: ");
			int clientAge = input.nextInt();
			clt.details.setClientAge(clientAge);
	           
	       
			if (clientAge>=0 && address!= "" && lastName!= "" && firstName!= "") {
				if (clt.profile.getLastName()!=null) {
					client[clientCount] = clt;
					clientCount++;
					System.out.println("Sucessfully added new client");
				}else {
					System.out.println("Already Exists");
					}
				}else {
				System.out.println("Errors Exist in inputs account could not be created");
			}
			
				
			
		}
		
		else {
			System.out.println("No room for a new client.");
		}
		
	}
	
	private void updateBankCLient() {
		
			System.out.print("Enter Age: ");
			int age = input.nextInt();
			
			
			input.nextLine();
			System.out.print("Enter Address: ");
			String address = input.nextLine();
			
			
			
			if (age >=0 && address != "") {
				client[currentUser].details.setAddress(address);
				client[currentUser].details.setClientAge(age);
				System.out.println("Data successfully updated");
			}
			else {
				System.out.println("Errors exist in input data please try again");
			}
			
			
			
			
	 }
	
	
	
	
	  String[] getClientNames() {
		String[] res = null;
		if ( clientCount > 0) {
			res = new String[clientCount];
			for(int index=0;index<clientCount;index++) {
				res[index] = client[index].profile.getFirstName();
			}
		}
		return res;
	  }
	

	
	  private void createBankAccount() {
		if ( accCount < MAXACC ) {//check that there is room for a new bank account
			
			
			
			System.out.println( "1: Basic bank account or 2: Premium bank account" );
			
			byte choice = input.nextByte();


			if( choice == 1 ) {

				BankAccount acc = new BasicBankAccount();

				((BasicBankAccount) acc).accounts.setBankClientID(currentUser);
				((BasicBankAccount) acc).accounts.setBankAccountID((byte)accCount);
				((BasicBankAccount) acc).calculation.setBalance( 1000 );
				
				account[accCount] = acc;
				accCount++;
				System.out.println( "Bank Account created " );
				
			}

			else if( choice == 2 ) {

				BankAccount acc = new PremiumBankAccount();

				((PremiumBankAccount) acc).accounts.setBankClientID(currentUser);
				((PremiumBankAccount) acc).accounts.setBankAccountID((byte)accCount);
				((PremiumBankAccount) acc).calculation.setBalance( 1000 );
				((PremiumBankAccount) acc).setFee(5);
				((PremiumBankAccount) acc).setTotalCashBackAmount( 10 );
				
				account[accCount] = acc;
				accCount++;
				System.out.println( "Bank Account created " );
			}
		}
		else {
			System.out.println( "Sorry cannot create bank account " );
		}
	 }	

	
	
	  private void deleteBankAccount() {
		
		System.out.println("Input account ID of account to be deleted");
		
		int selected = input.nextInt();
		
		if ( selected>=0 && selected<=accCount) {
			System.out.println("Deleting accountID: "+account[selected].accounts.getBankAccountID());
		
			for(int index = selected; index<accCount;index++) {//iterate through array to find data to be deleted
				account[index] = account[index+1];
			}
			accCount--;
			System.out.println( "Account Deleted" );
		
		}
		else {
			System.out.println( "Could not be deleted" );
		}
	
	 }
	
	
	
	
	  private void transferMoney() {
		
		  
		System.out.println("Input ID of target Bank Client");
		int ClientTarget = input.nextInt();
		  
		
		
		System.out.println("Input account ID of source account");
		int source = input.nextInt();
		

		
		System.out.println("Input account ID of target account");
		int target = input.nextInt();
		

		
		System.out.println("Input account to be transferred");
		double amt = input.nextInt();
		
		if (source <= accCount && target <= accCount && ClientTarget < getClientNames().length) {
			System.out.println("IDs correct");
			
			
			if (account[source].calculation.getBalance() <= amt) {
				System.out.println("Cannot be transfered");
			}
			else {
				account[source].calculation.withdraw(amt);
				account[target].calculation.deposit(amt);
				System.out.println("Transfer Successful");
			}
			
			
		}
		else {
			System.out.println("Error in IDs");
		}
		
		
		
		
		
		
		
	 }
	
	
	
	
	  private void batchRegistration() {
		System.out.println("Use Case 1. Batch Registration");
		BankClient clt = new BankClient();
		
		clt.profile.setFirstName ( "Matthew" );
		clt.profile.setLastName ( "Beattie" );
		clt.details.setClientAge ( 19 );
		clt.details.setAddress ( "Richhill" );
		
		client[clientCount] = clt;
		clientCount++;
		System.out.println("Registration of bank client with ID = 0");
		
		BankClient clt1 = new BankClient();
		
		clt1.profile.setFirstName ( "John" );
		clt1.profile.setLastName ( "Jo" );
		clt1.details.setClientAge ( 20 );
		clt1.details.setAddress ( "Belfast" );
		
		client[clientCount] = clt1;
		clientCount++;
		System.out.println("Registration of bank client with ID = 1");
		
		BankClient clt2 = new BankClient();
		
		clt2.profile.setFirstName ( "Bob" );
		clt2.profile.setLastName ( "Bobby" );
		clt2.details.setClientAge ( 26 );
		clt2.details.setAddress ( "Portadown" );
		
		client[clientCount] = clt2;
		clientCount++;
		System.out.println("Registration of bank client with ID = 2");
		
		BankClient clt3 = new BankClient();
		
		clt3.profile.setFirstName ( "Edd" );
		clt3.profile.setLastName ( "North" );
		clt3.details.setClientAge ( 50 );
		clt3.details.setAddress ( "Lisburn" );
		
		client[clientCount] = clt3;
		clientCount++;
		System.out.println("Registration of bank client with ID = 3");
		
		BankClient clt4 = new BankClient();
		
		clt4.profile.setFirstName ( "Charlie" );
		clt4.profile.setLastName ( "Robb" );
		clt4.details.setClientAge ( 43 );
		clt4.details.setAddress ( "Dublin" );
		
		client[clientCount] = clt4;
		clientCount++;
		System.out.println("Registration of bank client with ID = 4");
	 }
	
	
	
	
	
	  private void ClientDetails() {
			Menu m = new Menu("Select a Client to Display", getClientNames());
			m.display();
			int choice = m.getChoice();
			
			if ( choice>=1 && choice<=clientCount) {
				BankClient clt = client[choice-1]; 
				System.out.println(clt.profile.getFirstName()+" " + clt.profile.getLastName() +" " + clt.details.getAddress() + " " + clt.details.getClientAge() +" ");
			
			}
		
		}

	  private void BankAccountDetails() {

			if (accCount == 0) {
				System.out.println("Sorry, there are no Accounts.");
			}
			else {
				System.out.println("Following Bank accounts for this Client:");
				for(int index=0; index<accCount;index++) {
					BankAccount acc = account[index];
					if(account[index].accounts.getBankClientID() == currentUser) {
						System.out.println( "ClientID: " + acc.accounts.getBankClientID() +
								" -BALANCE- " + acc.calculation.getBalance() +
								" -ACCOUNTID- " + acc.accounts.getBankAccountID() 
								
						);
					}
					
		
					if( acc instanceof PremiumBankAccount ) System.out.println( "Fee: " + ((PremiumBankAccount) acc).getFee() +
											" - " + "Total Cash Back: " + ((PremiumBankAccount) acc).getTotalCashBackAmount()
												);
					}
			}	
		 }
			
	
	
		
	
		
	

}




