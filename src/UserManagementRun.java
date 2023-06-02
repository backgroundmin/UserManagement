package src;
import java.util.ArrayList;

public class UserManagementRun {
    public ArrayList<User> user = new ArrayList<>();
    UserManagementFunction userMF = new UserManagementFunction();
    public void run(){
        FileManagement fileManagement = new FileManagement();
        fileManagement.Load(user);
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
        fileManagement.save(user);
    }

    public void testUserAdd(){
        user.add(new User("테스트1",20, "01012345678",34));
        user.add(new User("test2",23, "01010235678",15));
        user.add(new User("테스트1",20, "11111111111",20));
        user.add(new User("테스트2",21, "22222222222",30));
        user.add(new User("테스트3",22, "33333333333",40));
        user.add(new User("테스트4",23, "44444444444",50));
        user.add(new User("테스트5",24, "55555555555",60));
        user.add(new User("테스트6",25, "66666666666",70));
        user.add(new User("테스트7",26, "77777777777",80));
        user.add(new User("테스트8",27, "88888888888",90));
        user.add(new User("테스트9",28, "11111111111",100));
        user.add(new User("테스트10",29, "01032803208",3));
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
