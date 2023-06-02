package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GuiRun extends JFrame implements ActionListener{
    Button createUserBtn;
    Button allUserOutPutBtn;
    Button findUserBtn;
    Button changeInformationBtn;
    JPanel bigJPanel;
    JPanel startjPanel;
    JFrame jFrame;
    JPanel createUserPanel = new JPanel();
    JPanel allUserOutPutPanel = new JPanel();
    JPanel changeInformation = new JPanel();
    JPanel findUser = new JPanel();
    JPanel actionPanel;
    int a;
    JTextField jTextField;
    public void run(){
        bigJPanel = new JPanel();
        actionPanel = new JPanel();
        bigJPanel.setLayout(null);
        bigJPanel.setBackground(Color.BLACK);
        setSize(1000,700);
        startjPanel = new JPanel();
        startjPanel.setLayout(new BoxLayout(startjPanel,BoxLayout.Y_AXIS));
        startjPanel.setBounds(0,0,100,130);
        startjPanel.setBackground(Color.BLUE);
        actionPanel.setBounds(100,0,getWidth()-100,getHeight());
        actionPanel.setBackground(Color.YELLOW);
        a=0;
        setTitle("유저관리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUserBtn = new Button("회원 생성");
        allUserOutPutBtn = new Button("전체 회원 출력");
        findUserBtn = new Button("회원검색");
        changeInformationBtn= new Button("회원정보 수정");
        createUserBtn.addActionListener(this);
        allUserOutPutBtn.addActionListener(this);
        findUserBtn.addActionListener(this);
        changeInformationBtn.addActionListener(this);
        startjPanel.add(createUserBtn);startjPanel.add(allUserOutPutBtn);startjPanel.add(findUserBtn);startjPanel.add(changeInformationBtn);
        bigJPanel.add(startjPanel);
        bigJPanel.add(actionPanel);
        add(bigJPanel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        actionPanel.removeAll();
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
        createUserPanel.removeAll();
        Label label1 = new Label("유저생성");
        createUserPanel.add(label1);
        actionPanel.add(createUserPanel);
        setVisible(true);
    }
    public void allUserOutPut(){
        Label label1 = new Label("회원출력");
        allUserOutPutPanel.add(label1);
        actionPanel.add(allUserOutPutPanel);
        setVisible(true);
    }
    public void changeInformation(){
        Label label1 = new Label("정보 수정");
        changeInformation.add(label1);
        actionPanel.add(changeInformation);
        setVisible(true);
    }
    public void findUser(){
        Label label1 = new Label("회원 검색");
        findUser.add(label1);
        actionPanel.add(findUser);
        setVisible(true);
    }
}
