package com.company;

import java.util.Scanner;

public class BankRunner {
    /*login username, password
    create account
    check balance
    add money
    send money
    withdraw money
     */
    public static void main(String[] args) {
        Bank SBIBank = new Bank();
        System.out.println("Welcome to SBI bank");
        int option;
       do {
           System.out.println("Choose the Option");
           System.out.println("1 Create an account");
           System.out.println("2 Transfer money to account");
           System.out.println("3 Add money");
           System.out.println("4 Check Balance");
           System.out.println("8 Exit");
           Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            int id, senderID, recieverID;
            double amount;
            boolean login;
            String password;
           switch (option){
               case 1 :
                   System.out.println("Enter your new user id");
                   id = sc.nextInt();
                   System.out.println("Enter your password ");
                   password = sc.next();
                   SBIBank.addUser(id, password);
                   break;

               case 2 :
                   System.out.println("Enter your user id");
                   senderID = sc.nextInt();
                   System.out.println("Enter password ");
                   password = sc.next();
                   login =SBIBank.verifyCredentials(senderID, password);
                   if(login){
                       System.out.println("successfully logged in");
                       System.out.println("Enter reciever id");
                       recieverID = sc.nextInt();
                       System.out.println("Enter the amount to transfer");
                       amount = sc.nextDouble();
                       SBIBank.sendMoney(senderID, password, recieverID, amount);
                   }else{
                       System.out.println("Bad credentials");
                   }
                   break;

               case 3 :
                   System.out.println("Enter your user id");
                   id = sc.nextInt();
                   System.out.println("Enter password ");
                   password = sc.next();
                   login =SBIBank.verifyCredentials(id, password);
                   if(login){
                       System.out.println("Enter the amount to add: ");
                       amount = sc.nextDouble();
                       SBIBank.addMoney(id,amount);
                   }else{
                       System.out.println("Bad credentials");
                   }
                   break;
               case 4 :
                   System.out.println("Enter your user id");
                   id = sc.nextInt();
                   System.out.println("Enter password ");
                   password = sc.next();
                   login =SBIBank.verifyCredentials(id, password);
                   if(login){
                       SBIBank.checkBalance(id);
                   }else{
                       System.out.println("Bad credentials");
                   }
                   break;

               case 8 :
                   break;


               default:
                   break;
           }
       }while (option != 8);
    }
}