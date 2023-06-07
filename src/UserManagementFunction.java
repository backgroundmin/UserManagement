package src;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementFunction {
    public void createUser(ArrayList<User> user) { // 유저생성
        System.out.println("=====사용자 정보 입력=====");
        InputInformation inputInformation = new InputInformation();
        String name = inputInformation.name();
        int age = inputInformation.integer("나이");
        String phoneNumber = inputInformation.PhoneNumber();
        int day = inputInformation.integer("이용기간");
        user.add(new User(name,age,phoneNumber,day));
    }
    public void allUserOutPut(ArrayList<User> user){ // 유저출력

        System.out.println("=====전체 사용자 정보 출력=====");
        for(int i = 0 ; i < user.size() ; i++){
            System.out.print(i+1+". ");
            userOutPut(user.get(i));
        }
    }
    public void userOutPut(User user){ // 유저 테이터 리턴
        System.out.println("유저번호>"+user.uniqueNumber + " 이름>" +
                user.name + " 나이>" + user.age + " 전화번호>"+
                user.phoneNumber+" 남은이용기간>"+user.remainingAvailabilityDates);
    }
    public void findUser(ArrayList<User> user){ // 유저 검색
        System.out.println("=====유저검색=====");
        ArrayList<Integer> foundIndex = new ArrayList<Integer>();
        InputInformation inputInformation = new InputInformation();
        int choiceInfo = inputInformation.list("유저번호","이름");
        switch (choiceInfo){
            case 1:
                int findUniqueNumber = inputInformation.integer("유저번호");
                for(int i = 0 ; i < user.size() ; i++){
                    if(user.get(i).uniqueNumber == findUniqueNumber){
                        foundIndex.add(i);
                    }
                }
                break;
            case 2:
                String findName = inputInformation.name();
                for(int i = 0 ; i < user.size() ; i++){
                    if(user.get(i).name.equals(findName)){
                        foundIndex.add(i);
                    }
                }
                break;
        }
        if(foundIndex.isEmpty()){
            System.out.println("검색결과가 없습니다.");
        }
        else{
            System.out.println("검색결과 " +foundIndex.size()+"건 존재합니다");
            for(int i = 0 ; i < foundIndex.size() ; i++){
                userOutPut(user.get(foundIndex.get(i)));
            }
        }
    }
    public void changeInformation(ArrayList<User> user){ // 정보수정
        InputInformation inputInformation = new InputInformation();
        System.out.println("=====유저 정보 변경=====");
        allUserOutPut(user);
        System.out.println("=변경할 유저를 선택하세요"+System.lineSeparator()+">>");
        int choiceUserIndex = inputInformation.selectList(user.size())-1;
        int choiceInfoNum = inputInformation.selectChangeInformation();
        User tempUserData = user.get(choiceUserIndex);
        switch (choiceInfoNum){
            case 1:
                String name = inputInformation.name();
                tempUserData.name = name;
                break;
            case 2:
                int age = inputInformation.integer("나이");
                tempUserData.age = age;
                break;
            case 3:
                String phoneNumber = inputInformation.PhoneNumber();
                tempUserData.phoneNumber = phoneNumber;
                tempUserData.uniqueNumber = Integer.parseInt(phoneNumber.substring(phoneNumber.length()-4,phoneNumber.length()));
                break;
            case 4:
                int day = inputInformation.integer("이용기간");
                tempUserData.remainingAvailabilityDates = day;
                break;
        }
        user.set(choiceUserIndex,tempUserData);
        System.out.println("=변경완료=");
    }
}
