package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInformation {
    public String name() {
        Scanner scan = new Scanner(System.in);
        String name = new String();
        while(true){
            System.out.print("=성함"+System.lineSeparator()+">>");
            name = scan.next();
            if(name.length() < 20){
                break;
            }
            else{
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return name;
    }
    public String PhoneNumber() {
        Scanner scan = new Scanner(System.in);
        String phoneNumber = new String();
        while(true){
            System.out.print("=전화번호 예)01012345678"+System.lineSeparator()+">>");
            phoneNumber = scan.next();
            if(phoneNumber.length() == 11 && !phoneNumber.contains("-")){
                break;
            }
            else{
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return phoneNumber;
    }
    public int integer(String information){
        Scanner scan = new Scanner(System.in);
        int integer;
        while(true){
            try{
                System.out.print("="+information+System.lineSeparator()+">>");
                integer = scan.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("잘못입력하셨습니다.");
            }
        }
    }
}
