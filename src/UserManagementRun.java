package src;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserManagementRun {
    public ArrayList<User> user = new ArrayList<>();
    public int userCount=0;
    UserManagementFunction userMF = new UserManagementFunction();
    public void run(){
        testUserAdd();
        userMF.allUserOutPut(user);
    }
    public void testUserAdd(){
        user.add(new User("테스트1",20, "01012345678",34));
        user.add(new User("test2",23, "01010235678",15));
        userMF.createUser(user);
    }

}
