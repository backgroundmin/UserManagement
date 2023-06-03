package src;

import java.util.ArrayList;
public class GUIUserManagementFunction {
    public boolean createUser(ArrayList<User> user,String [] info) {
        boolean returnBoolean = true;
        if(info[0].length() > 20){
            returnBoolean = false;
        }
        else if (!info[1].chars().allMatch(Character::isDigit)) {
            returnBoolean = false;
        }
        else if(info[2].length() != 11 || info[2].contains("-")){
            returnBoolean = false;
        }
        else if (!info[3].chars().allMatch(Character::isDigit)) {
            returnBoolean = false;
        }
        else{
            returnBoolean = true;
            user.add(new User(info[0],Integer.parseInt(info[1]),info[2],Integer.parseInt(info[3])));
        }
        return returnBoolean;
    }
    public String[][] allUserOutPut(ArrayList<User> user){
        String [][] usersInfo = new String[user.size()][5];
        for(int i = 0 ; i < user.size() ; i++){
            usersInfo[i] = userOutPut(user.get(i));
        }
        return usersInfo;
    }
    public String[] userOutPut(User user){
        String [] userInfo = new String[5];
        userInfo[0] = String.valueOf(user.uniqueNumber);
        userInfo[1] = user.name;
        userInfo[2] = String.valueOf(user.age);
        userInfo[3] = user.phoneNumber;
        userInfo[4] = String.valueOf(user.remainingAvailabilityDates);
        return userInfo;
    }
    public String[][] findUser(ArrayList<User> user,String kindInfo, String text){
        ArrayList<Integer> foundIndex = new ArrayList<Integer>();
        String [][] findUsersInfo = new String[user.size()][5];
        if(kindInfo.equals("고유번호")){
            int findUniqueNumber = Integer.parseInt(text);
            for(int i = 0 ; i < user.size() ; i++){
                if(user.get(i).uniqueNumber == findUniqueNumber){
                    foundIndex.add(i);
                }
            }
        } else if (kindInfo.equals("이름")) {
            for(int i = 0 ; i < user.size() ; i++){
                if(user.get(i).name.equals(text)){
                    foundIndex.add(i);
                }
            }
        }
        for(int i = 0 ; i < foundIndex.size() ; i++){
            findUsersInfo[i] = userOutPut(user.get(foundIndex.get(i)));
        }
        return findUsersInfo;
    }
    public void changeInformation(ArrayList<User> user){
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
