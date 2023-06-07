package src;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class FileManagement {
    public void save(ArrayList<User> user){ // 파일 저장
        try {
            String nowTime = String.valueOf(LocalDateTime.now());
            OutputStream output = new FileOutputStream("data/userInformation.txt");
            output.write((nowTime+System.getProperty("line.separator")).getBytes());
            output.write((user.size()+System.getProperty("line.separator")).getBytes());
            System.out.println("저장중입니다.");
            String line = System.getProperty("line.separator");
            for(int i = 0 ; i < user.size() ; i++){
                User tempUser = user.get(i);
                String tempInputWord = tempUser.name+" "+tempUser.age+" "+tempUser.phoneNumber+" "+tempUser.remainingAvailabilityDates+"\n";
                output.write(tempInputWord.replace("\n",line).getBytes());
            }
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void Load(ArrayList<User> user){ // 파일 불러오기
        try {
            File file = new File("data/userInformation.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String beforeTime = bufferedReader.readLine();
            int numberOfUser = Integer.parseInt(bufferedReader.readLine());
            System.out.println(numberOfUser);
            for(int i = 0 ; i < numberOfUser ; i++){
                String [] splitInfo = bufferedReader.readLine().split(" ");
                user.add(new User(splitInfo[0],Integer.parseInt(splitInfo[1]),splitInfo[2],Integer.parseInt(splitInfo[3])));
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
