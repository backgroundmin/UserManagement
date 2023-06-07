package src;

import java.util.ArrayList;
public class GUIUserManagementFunction {
    public boolean createUser(ArrayList<User> user,String [] info) { // 유저생성
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
    public String[][] allUserOutPut(ArrayList<User> user){ // 유저 출력
        String [][] usersInfo = new String[user.size()][5];
        for(int i = 0 ; i < user.size() ; i++){
            usersInfo[i] = userOutPut(user.get(i));
        }
        return usersInfo;
    }
    public String[] userOutPut(User user){ // 유저 데이터 리턴
        String [] userInfo = new String[5];
        userInfo[0] = String.valueOf(user.uniqueNumber);
        userInfo[1] = user.name;
        userInfo[2] = String.valueOf(user.age);
        userInfo[3] = user.phoneNumber;
        userInfo[4] = String.valueOf(user.remainingAvailabilityDates);
        return userInfo;
    }
    public String[][] findUser(ArrayList<User> user,String kindInfo, String text){ //유저검색
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
    public boolean changeInformation(ArrayList<User> user, String [] info, int selectIndex){ // 정보수정
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
            User tempUser = new User(info[0],Integer.parseInt(info[1]),info[2],Integer.parseInt(info[3]));
            user.set(selectIndex,tempUser);
        }
        return returnBoolean;
    }
}
