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
    public void allUserOutPut(){
        System.out.print("\033[H\033[2J");
        System.out.println("=====전체 사용자 정보 출력=====");
        for(int i = 0 ; i < userCount ; i++){
            userOutPut(user[i]);
        }
    }
    public void userOutPut(User user){
        System.out.print("유저번호>"+user.uniqueNumber + " 이름>" +
                user.name + " 나이>" + user.age + " 전화번호>"+
                user.phoneNumber+" 남은이용기간>"+user.remainingAvailabilityDates);
    }
}
