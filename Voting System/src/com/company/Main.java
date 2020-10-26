package com.company;

import ir.huri.jcal.JalaliCalendar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = new String();
        Scanner myObj = new Scanner(System.in);
        boolean run = true;
        int index;
        VotingSystem mySystem = new VotingSystem();

        while( run ){
            System.out.println("Main List");
            System.out.println("1) Creat voting");
            System.out.println("2) List of voting");
            System.out.println("3) Questions of special voting");
            System.out.println("4) Vote");
            System.out.println("5) Results of special voting");
            System.out.println("6) Results of all voting");
            System.out.println("7) Random voting");
            System.out.println("8) Exit");
            input = myObj.nextLine();

            switch (input){
                case "1":
                    String quest = new String();
                    String choice = new String();
                    ArrayList<String> choices = new ArrayList<String >();

                    System.out.println("Enter the question");
                    quest = myObj.nextLine();
                    System.out.println("Enter the choices in different lines. When finished, enter FINISHED");
                    do{
                        choice = myObj.nextLine();
                        if(!choice.equals("FINISHED")){
                            choices.add(choice);
                        }
                        else{
                            break;
                        }
                    }while( true );
                    System.out.println("Enter 0 if it's single choice and 1 otherwise");
                    index = myObj.nextInt();
                    input = myObj.nextLine();
                    mySystem.creatVoting(quest,index,choices);
                    break;

                case "2":
                    mySystem.printListOfVoting();
                    break;

                case "3":
                    System.out.println("Enter the number of voting want the choices");
                    index = myObj.nextInt();
                    input = myObj.nextLine();
                    mySystem.printVoting(index);
                    break;

                case "4":
                    String name = new String();
                    String choice1 = new String();
                    ArrayList<String > choices1 = new ArrayList<String>();

                    System.out.println("Enter the number of voting you want to vote");
                    index = myObj.nextInt();
                    input = myObj.nextLine();
                    mySystem.printVoting(index);
                    System.out.println("Enter your first and last name in order in one line");
                    name = myObj.nextLine();
                    if( mySystem.getType(index)==1 ) {
                        System.out.println("Enter the choices in different lines. When finished, enter FINISHED");
                        do {
                            choice1 = myObj.nextLine();
                            if (!choice1.equals("FINISHED")) {
                                choices1.add(choice1);
                            } else {
                                break;
                            }
                        } while (true);
                    }
                    else{
                        System.out.println("Enter your only choice");
                        choice1 = myObj.nextLine();
                        choices1.add(choice1);
                    }
                    mySystem.vote(index,name,choices1);
                    break;

                case "5":
                    System.out.println("Enter the number of voting");
                    index = myObj.nextInt();
                    input = myObj.nextLine();
                    mySystem.printResult(index);
                    break;

                case "6":
                    mySystem.printAllVotingResults();
                    break;

                case "7":
                    int i;
                    String name1 = new String();
                    System.out.println("Enter the numbet of voting");
                    index = myObj.nextInt();
                    input = myObj.nextLine();
                    System.out.println("Enter your first and last name in order in one line");
                    name1 = myObj.nextLine();
                    Random generate = new Random();
                    i = generate.nextInt(mySystem.getSize(index));
                    System.out.println("Your choice is " + mySystem.stringOfRandom(index,i));
                    ArrayList<String > toAdd = new ArrayList<String>();
                    toAdd.add(mySystem.stringOfRandom(index,i));
                    mySystem.vote(index,name1,toAdd);

                    break;

                case "8":
                    run = false;
                    break;

            }
        }
    }
}
