package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class GuiRun extends JFrame implements ActionListener{
    Button createUserBtn, allUserOutPutBtn, findUserBtn, changeInformationBtn;
    JPanel bigJPanel, actionJPanel;
    UserManagementFunction userMF = new UserManagementFunction();
    public ArrayList<User> user = new ArrayList<>();
    public void run(){
        FileManagement fileManagement = new FileManagement();
        fileManagement.Load(user);
        InputInformation inputInfo = new InputInformation();
        setting();
    }
    public void setting(){
        setTitle("유저관리");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBigJPanel();
        setActionJPanel();
        btnCreate();
        add(bigJPanel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        actionJPanel.removeAll();
        if(e.getSource() == createUserBtn){
            createUser();
        }
        else if(e.getSource() == allUserOutPutBtn){
            allUserOutPut();
        }
        else if(e.getSource() == findUserBtn){
            findUser();
        }
        else if(e.getSource() == changeInformationBtn){
            changeInformation();
        }
    }
    public void createUser(){
        JPanel createUserPanel = new JPanel();
        createUserPanel.removeAll();
        JTextField inputRemainingAvailabilityDates= new JTextField();
        actionJPanel.add(inputRemainingAvailabilityDates);
        actionJPanel.add(createUserPanel);
        setVisible(true);
    }
    public void allUserOutPut(){
        JPanel allUserOutPutPanel = new JPanel();
        allUserOutPutPanel.setLayout(null);
        allUserOutPutPanel.removeAll();
        Label label1 = new Label("전체회원출력");
        label1.setBounds(10,10,100,30);
        String [] header = {"고유번호","이름","나이","전화번호","남은이용기간"};
        String [][] userInfo = userMF.allUserOutPut(user);
        JTable userInfoTable = new JTable(userInfo,header);
        JScrollPane scrollUserInfoTable = new JScrollPane(userInfoTable);
        scrollUserInfoTable.setBounds(10,50,getWidth()-190,getHeight()-100);
        allUserOutPutPanel.add(label1);
        allUserOutPutPanel.add(scrollUserInfoTable);
        actionJPanel.add(allUserOutPutPanel);
        label1.setVisible(true);
        setVisible(true);
    }
    public void changeInformation(){
        JPanel changeInformation = new JPanel();
        changeInformation.removeAll();
        Label label1 = new Label("정보 수정");
        changeInformation.add(label1);
        actionJPanel.add(changeInformation);
        setVisible(true);
    }
    public void findUser(){
        JPanel findUser = new JPanel();
        findUser.removeAll();
        Label label1 = new Label("회원 검색");
        findUser.add(label1);
        actionJPanel.add(findUser);
        setVisible(true);
    }
    public void btnCreate(){
        JPanel btnJPanel = new JPanel();
        btnJPanel.setLayout(new BoxLayout(btnJPanel,BoxLayout.Y_AXIS));
        btnJPanel.setBounds(0,0,100,130);
        btnJPanel.setBackground(Color.white);
        createUserBtn = new Button("회원 생성");
        allUserOutPutBtn = new Button("전체 회원 출력");
        findUserBtn = new Button("회원검색");
        changeInformationBtn= new Button("회원정보 수정");
        createUserBtn.addActionListener(this);
        allUserOutPutBtn.addActionListener(this);
        findUserBtn.addActionListener(this);
        changeInformationBtn.addActionListener(this);
        btnJPanel.add(createUserBtn);btnJPanel.add(allUserOutPutBtn);
        btnJPanel.add(findUserBtn);btnJPanel.add(changeInformationBtn);
        bigJPanel.add(btnJPanel);
    }
    public void setBigJPanel(){
        bigJPanel = new JPanel();
        bigJPanel.setLayout(null);
        bigJPanel.setBackground(Color.white);
    }
    public void setActionJPanel(){
        actionJPanel = new JPanel();
        actionJPanel.setBounds(100,0,getWidth()-100,getHeight());
        actionJPanel.setBackground(Color.gray);
        actionJPanel.setLayout(new BoxLayout(actionJPanel,BoxLayout.Y_AXIS));
        bigJPanel.add(actionJPanel);
    }
}
