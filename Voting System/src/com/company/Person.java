package com.company;

/**
 * It is a person who wants to vote.
 */
public class Person {

    //first name of the person
    private String firstName;

    //last name of the person
    private String lastName;

    /**
     * Sets the initial information of the person
     * @param firstName First name of the person
     * @param lastName Last name of the person
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the person.
     * @return First name
     */
    public String getFirstName(){ return firstName; }

    /**
     * Returns last name of the person
     * @return Last name
     */
    public String getLastName(){ return lastName; }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(firstName);
        builder.append(lastName);
        return builder.toString();
    }
    
}
