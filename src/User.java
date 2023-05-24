package src;

public class User {
    private String name;
    private int age;
    private String phoneNumber;
    protected int remainingAvailabilityDates;
    private int uniqueNumber;

    public User(String name, int age, String phoneNumber, int remainingAvailabilityDates){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.remainingAvailabilityDates = remainingAvailabilityDates;
        this.uniqueNumber = Integer.parseInt(phoneNumber.substring(phoneNumber.length()-4,phoneNumber.length()));
    }
}
