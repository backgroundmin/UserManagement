package src;

public class User {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected int remainingAvailabilityDates;
    protected int uniqueNumber;

    public User(String name, int age, String phoneNumber, int remainingAvailabilityDates){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.remainingAvailabilityDates = remainingAvailabilityDates;
        this.uniqueNumber = Integer.parseInt(phoneNumber.substring(phoneNumber.length()-4,phoneNumber.length()));
    }
}
