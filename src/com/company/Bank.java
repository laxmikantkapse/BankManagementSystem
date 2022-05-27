package com.company;

import java.util.HashMap;

public class Bank {
   private HashMap<Integer,User>Users;

   Bank(){
       Users = new HashMap<Integer,User>();
   }
   public void addUser(int id, String password){
       if(Users.containsKey(id)){
           System.out.println("User id already exists");
       }else {
           User newUser = new User(id, password);
           Users.put(id, newUser);
           System.out.println("Account successfully created");
       }
   }
   public void sendMoney(int id, String password, int destID, double amount){
        User Sender = Users.get(id);

       if(verifyCredentials(id, password));{
         if(Sender.getBalance() >= amount){
             System.out.println("Transferring money");
             User reciever = Users.get(destID);
             if(reciever == null){
                 System.out.println("Reciever not found");
                 return;
             }
             Sender.setBalance(Sender.getBalance() - amount);
             reciever.setBalance(reciever.getBalance() + amount);
             System.out.println("Transferred money successfully");
             System.out.println("Your new balance is "+ Sender.getBalance());
         }else {
             System.out.println("Insufficient balance sorry");
         }
         return;
       }
   }
   public boolean verifyCredentials(int id,String password){
       User user = Users.get(id);
       if(user == null)
           return false;
       return user.verifyPassword(password);
   }
   public void addMoney(int id, double amount){
       User user = Users.get(id);
       user.addBalance(amount);
       System.out.println("Successfully added Money !!! \n Your new balance is " + user.getBalance());
   }
   public void checkBalance(int id){
       User user = Users.get(id);
       System.out.println("Your balance is "+ user.getBalance());
   }
}
