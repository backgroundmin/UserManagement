package src;

import java.util.ArrayList;

public class UserManagementFunction {
    public void createUser(ArrayList<User> user) {
        System.out.print("\033[H\033[2J");
        System.out.println("=====사용자 정보 입력=====");
        InputInformation inputInformation = new InputInformation();
        String name = inputInformation.name();
        int age = inputInformation.integer("나이");
        String phoneNumber = inputInformation.PhoneNumber();
        int day = inputInformation.integer("이용기간");
        user.add(new User(name,age,phoneNumber,day));
    }
    public void allUserOutPut(ArrayList<User> user){
        System.out.print("\033[H\033[2J");
        System.out.println("=====전체 사용자 정보 출력=====");
        for(int i = 0 ; i < user.size() ; i++){
            userOutPut(user.get(i));
        }
    }
    public void userOutPut(User user){
        System.out.println("유저번호>"+user.uniqueNumber + " 이름>" +
                user.name + " 나이>" + user.age + " 전화번호>"+
                user.phoneNumber+" 남은이용기간>"+user.remainingAvailabilityDates);
    }
    public void findUser(ArrayList<User> user){
        System.out.println("=====유저검색=====");
        ArrayList<Integer> foundIndex = new ArrayList<Integer>();
        InputInformation inputInformation = new InputInformation();
        int choiceInfo = inputInformation.list();
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
}
