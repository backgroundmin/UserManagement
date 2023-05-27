package src;
import java.util.ArrayList;

public class UserManagementRun {
    public ArrayList<User> user = new ArrayList<>();
    public int userCount=0;
    UserManagementFunction userMF = new UserManagementFunction();
    public void run(){
        InputInformation inputInfo = new InputInformation();
        int selectNum = 0;
        while(selectNum != 5){
            printStartScreen();
            selectNum = inputInfo.selectList(5);
            switch (selectNum){
                case 1:
                    userMF.createUser(user);
                    break;
                case 2:
                    userMF.allUserOutPut(user);
                    break;
                case 3:
                    userMF.findUser(user);
                    break;
                case 4:
                    userMF.changeInformation(user);
                    break;
                case 5:
                    System.out.println("종료합니다.");
                    break;
            }
        }
    }

    public void printStartScreen(){
        System.out.println("======회원 관리 시스템 ======");
        System.out.println("1. 회원 생성");
        System.out.println("2. 전체 회원 출력");
        System.out.println("3. 회원 검색");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 종료");
        System.out.println("=========================");
    }
}
