package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class VotingSystem {

    //list of active polls
    private ArrayList<Voting> votingList;

    public VotingSystem(){
        votingList = new ArrayList<Voting>();
    }

    /**
     * It gets the question, type of voting and list of choices to creat a new voting.
     * @param question Question of new voting
     * @param type Type of new voting
     * @param choices Choices of new voting
     */
    public void creatVoting(String question, int type, ArrayList<String> choices){
        Voting toAdd = new Voting(type,question);
        for(String it : choices){
            toAdd.creatPoll(it);
        }
        votingList.add(toAdd);
    }

    /**
     * Prints questions of saved voting.
     */
    public void printListOfVoting(){
        int i=1;
        for(Voting it : votingList){
            System.out.println(i + ") " + it.getQuestion());
            i++;
        }
    }

    /**
     * It prints the choices of the voting which number is received.
     * @param index Number of the voting to print
     */
    public void printVoting(int index){
        Voting it = votingList.get(index-1);
        System.out.println(it.getQuestion());
        int i=1;
        for(Map.Entry<String, HashSet<Vote>> choice : it.getPolls().entrySet()){
            System.out.println(i + ") " + choice.getKey());
            i++;
        }
    }

    /**
     * It gets the number of voting, the name of the person and the list of choices to save.
     * @param index Number of the voting
     * @param name Name of the person wants to vote
     * @param choices List of choices
     */
    public void vote(int index, String name, ArrayList<String> choices){
        Voting it = votingList.get(index-1);
        it.vote(name,choices);
    }

    /**
     * Gets a number of voting to print it's results.
     * @param index number of the voting to print
     */
    public void printResult(int index){
        votingList.get(index-1).printVotes();
    }

    /**
     * It prints the result of all the exist voting.
     */
    public void printAllVotingResults(){
        for(Voting it : votingList){
            System.out.println(it.getQuestion());
            it.printVotes();
        }
    }

    /**
     * Returns the type of the voting
     * @param index Number of the voting
     * @return Type of the voting
     */
    public int getType(int index){
        Voting it = votingList.get(index-1);
        return it.getType();
    }
    
    public int getSize(int index){
        return votingList.get(index-1).getPolls().size();
    }

    public String stringOfRandom(int index, int indexOfChoice){
        Voting it = votingList.get(index-1);
        int i=0;
        String res= new String();
        for(Map.Entry<String, HashSet<Vote>> choice : it.getPolls().entrySet()){
            if(i==indexOfChoice){
                res = choice.getKey();
                break;
            }
            i++;
        }
        return res;
    }
}
