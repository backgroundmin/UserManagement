package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInformation {
    public int list(String list1, String list2){
        int num;
        System.out.println("1. "+ list1);
        System.out.println("2. "+ list2);
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
    public int selectList(int size){
        int integer;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.print(">>");
                integer = scan.nextInt();
                if(0 < integer && integer < size+1){
                    break;
                }
                else{
                    System.out.println("잘못입력하셨습니다.");
                }
            } catch (InputMismatchException e){
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return integer;
    }
    public int selectChangeInformation(){
        System.out.println("=변경할 정보를 고르세요");
        System.out.println("1. 이름");
        System.out.println("2. 나이");
        System.out.println("3. 전화번호");
        System.out.println("4. 남은이용기간");
        int integer;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.print(">>");
                integer = scan.nextInt();
                if(0 < integer && integer < 5){
                    break;
                }
                else{
                    System.out.println("잘못입력하셨습니다.");
                }
            } catch (InputMismatchException e){
                System.out.println("잘못입력하셨습니다.");
            }
        }
        return integer;
    }
}
