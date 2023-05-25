package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInformation {
    public int list(){
        int num;
        System.out.println("1.유저번호");
        System.out.println("2.이름");
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                num = scan.nextInt();
                if(0 < num && num < 3){
                    break;
                }
                else{
                    System.out.println("잘못입력하셨습니다.");
                }
            } catch (InputMismatchException e){
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return num;
    }
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
        int integer;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.print("="+information+System.lineSeparator()+">>");
                integer = scan.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return integer;
    }
}
