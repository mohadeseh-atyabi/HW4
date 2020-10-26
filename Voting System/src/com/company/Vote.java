package com.company;

public class Vote {

    //person who votes
    private Person person;

    //the date in which the vote is done
    private String date;

    public Vote(String date, Person person){
        this.date = date;
        this.person = person;
    }

    /**
     * Returns the person who voted
     * @return Person who voted
     */
    public Person getPerson(){ return person; }

    /**
     * Returns the date.
     * @return Date
     */
    public String getDate(){ return date; }

    @Override
    public boolean equals(Object obj){
        if( this == obj ){
            return true;
        }
        if( !(obj instanceof Vote) ){
            return false;
        }

        Vote other = (Vote) obj;
        return other.getPerson().getFirstName().equals(this.getPerson().getFirstName())
                && other.getPerson().getLastName().equals(this.getPerson().getLastName());
    }

    @Override
    public int hashCode(){
        int res = 17;
        res = 37 * res + date.hashCode();
        res = 37 * res + person.hashCode();
        return res;
    }
}
