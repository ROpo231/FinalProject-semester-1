import java.util.Scanner;
import java.lang.Thread;
public class ATM {
    private Scanner scan;
    private Account saveAccount;
    private Account checkAccount;
    private Customer user;






    public ATM() {
        this.scan = new Scanner(System.in);
    }
    public void start() {


    }


    public void welcoming() {
        System.out.println("Welcome to your friendly local ATM!!!\n You dont have a account yet would you like to create one? (y/n) : ");
        String makeAccount = scan.nextLine();
        if(makeAccount.equals("y")) {
            creatingAccount();
            enterPin();


        }else if(makeAccount.equals("n")) {
            System.out.println("Ok then goodbye!!!");
        } else {
            System.out.println("Sorry I only take y or n please start again");
            try {
                Thread.sleep(5000);
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            } catch (InterruptedException e) {
                System.out.println("something went wrong with the delay thing in the welcoming method");
            }
            this.welcoming();
        }
    }


    private void creatingAccount() {
        System.out.println("Ok great but i will need some information first");
        System.out.println("Whats your name? :");
        String name = scan.nextLine();
        System.out.println("What do you want your pin to be?(pins are only 4 integers and no spaces please!!!) :");
        String pin = scan.nextLine();
        while(!checkPinContents(pin)){
            System.out.println("Something went wrong with your pin! Try again. (pins are only 4 integers and no spaces please!!!) ");
            pin = scan.nextLine();
        }
        user = new Customer(pin, name);
        saveAccount = new Account(user, "SavingsAccount");
        checkAccount = new Account(user, "CheckingAccount");
        System.out.println("Your CHECKING and SAVING accounts have successfully been made.");
    }


    private void mainMenu() {
        System.out.println("Would you like to :\n1. Withdraw money\n2. Deposit money\n3. Transfer money between accounts\n4. Get account balances\n5. Get transaction history\n6. Change PIN\n7. Exit\nOption :");
        String option = scan.nextLine();
        switch (option){
            case "1":

            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                changePin();
            case "7":
            default:
                System.out.println("Something went wrong. \nPlease retype option number only");
                option = scan.nextLine();
        }


    }


    private void changePin(){
        System.out.println("What do you want your new pin to be? :");
        String pin = scan.nextLine();
        while(!checkPinContents(pin)){
            System.out.println("Something went wrong with your pin! Try again. (pins are only 4 integers and no spaces please!!!) ");
            pin = scan.nextLine();
        }
        user.setPin(pin);
        System.out.println("The new pin has been successfully set");
    }


    private void withdrawMoney() {
        System.out.println("Which account do you want to deposit from? 1.Savings or 2.Checking (Pick number)\nOption :");

        System.out.println("How much money do you want? (Must be evenly divisible by 5)\nAmount :");


    }


    private void enterPin() {
        System.out.println("Please enter a pin to access you account.(No spaces please)");
        String pin = scan.nextLine();
        while(!user.getPin().equals(pin)){
            System.out.println("Somethings worng. Try again.(No spaces please)");
            pin = scan.nextLine();
        }
        System.out.println("Access granted.");
    }
    private boolean checkPinContents(String thePin) {
        if(thePin.length() != 4) {
            return false;
        }
        try {
            int varChecker = Integer.parseInt(thePin);
        }catch (Exception e) {
            return false;
        }
        return true;
    }


    private Account accountPicker(){



        return  ;
    }


}


