package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.time.LocalDate;
import java.util.*;

public class Voting {

    //type of the voting
    private int type;
    //question of the voting
    private String question;
    //list of voters
    private ArrayList<Person> voters;
    //HashMap to store votes
    private HashMap< String, HashSet<Vote> > polls;

    public Voting(int type, String question){
        polls = new HashMap<String ,HashSet<Vote>>();
        voters = new ArrayList<Person>();
        this.type = type;
        this.question = question;
    }

    /**
     * Returns the question
     * @return Question
     */
    public String getQuestion(){ return question; }

    /**
     * Returns the list of voters.
     * @return List of voters
     */
    public ArrayList<Person> getVoters(){ return voters; }

    /**
     * Creates new choice for voting.
     * @param choice New choice
     */
    public void creatPoll(String choice){
        HashSet<Vote> add = new HashSet<Vote>();
        polls.put(choice,add);
    }

    /**
     * It adds the votes of the person if not already registered.
     * @param name First and last name of the voter as an string
     * @param voted List of person votes
     */
    public void vote(String name, ArrayList<String> voted){
        String[] parts = name.split(" ");
        Person participant = new Person(parts[0],parts[1]);
        LocalDate lDate = LocalDate.now();
        JalaliCalendar jalali = new JalaliCalendar(
                new GregorianCalendar(lDate.getYear() ,lDate.getMonthValue(),lDate.getDayOfMonth()) );
        Vote vote = new Vote(jalali.toString(),participant);

        for(String it : voted){
            polls.get(it).add(vote);
        }
        if( !(voters.contains(participant)) ){
            voters.add(participant);
        }
    }

    /**
     * Prints the votes for each choice.
     * At the end prints the winner yet.
     */
    public void printVotes(){
        int i=1;
        for(Map.Entry<String,HashSet<Vote>> it : polls.entrySet() ){
            System.out.print(i + ") " + it.getKey() + " : ");
            if( it.getValue().size() == 0){
                System.out.println("No votes yet");
            }
            else {
                System.out.println(it.getValue().size() + " votes");
            }
            i++;
        }
    }

    /**
     * Returns the list of polls.
     * @return List of polls
     */
    public HashMap<String, HashSet<Vote>> getPolls(){ return polls; }

    public int getType(){ return type;}
}
