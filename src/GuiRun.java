package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GuiRun extends JFrame implements ActionListener{
    Button createUserBtn, allUserOutPutBtn, findUserBtn, changeInformationBtn;
    JPanel bigJPanel, actionJPanel;

    public void run(){
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
        Label label1 = new Label("유저생성");
        createUserPanel.add(label1);
        actionJPanel.add(createUserPanel);
        setVisible(true);
    }
    public void allUserOutPut(){
        JPanel allUserOutPutPanel = new JPanel();
        allUserOutPutPanel.removeAll();
        Label label1 = new Label("회원출력");
        allUserOutPutPanel.add(label1);
        actionJPanel.add(allUserOutPutPanel);
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
        btnJPanel.setBackground(Color.BLUE);
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
        bigJPanel.setBackground(Color.BLACK);
    }
    public void setActionJPanel(){
        actionJPanel = new JPanel();
        actionJPanel.setBounds(100,0,getWidth()-100,getHeight());
        actionJPanel.setBackground(Color.YELLOW);
        bigJPanel.add(actionJPanel);
    }
}
