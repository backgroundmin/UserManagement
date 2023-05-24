package src;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserManagementRun {
    public User [] user = new User[1000];
    public int userCount;
    public void run(){

    }
    public void createUser() {
        System.out.print("\033[H\033[2J");
        System.out.println("=====사용자 정보 입력=====");
        InputInformation inputInformation = new InputInformation();
        String name = inputInformation.name();
        int age = inputInformation.integer("나이");
        String phoneNumber = inputInformation.PhoneNumber();
        int day = inputInformation.integer("이용기간");
        user[userCount] = new User(name,age,phoneNumber,day);
    }
}
