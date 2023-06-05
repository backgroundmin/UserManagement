package src;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

public class GuiRun extends JFrame implements ActionListener{
    Button createUserBtn, allUserOutPutBtn, findUserBtn, changeInformationBtn;
    JPanel bigJPanel, actionJPanel;
    GUIUserManagementFunction userMF = new GUIUserManagementFunction();
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
        setBigJPanel();
        setActionJPanel();
        btnCreate();
        add(bigJPanel);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FileManagement fileManagement = new FileManagement();
                fileManagement.save(user);
                dispose();
                System.exit(0);
            }
        });
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
        createUserPanel.setLayout(null);
        Label label1 = new Label("유저생성"); label1.setBounds(10,10,50,30);
        createUserPanel.add(label1);

        Label info = new Label("이름"); info.setBounds(50,50,50,20); createUserPanel.add(info);
        JTextField inputName = new JTextField(); inputName.setBounds(100,50,100,20); createUserPanel.add(inputName);
        info = new Label("나이"); info.setBounds(50,70,50,20);createUserPanel.add(info);
        JTextField inputAge = new JTextField(); inputAge.setBounds(100,70,100,20);createUserPanel.add(inputAge);
        info = new Label("전화번호"); info.setBounds(50,90,50,20); createUserPanel.add(info);
        JTextField inputPhoneNumber= new JTextField(); inputPhoneNumber.setBounds(100,90,100,20); createUserPanel.add(inputPhoneNumber);
        info = new Label("이용기간"); info.setBounds(50,110,50,20); createUserPanel.add(info);
        JTextField inputRemainingAvailabilityDates= new JTextField(); inputRemainingAvailabilityDates.setBounds(100,110,100,20);createUserPanel.add(inputRemainingAvailabilityDates);
        JButton checkBtn = new JButton("생성"); checkBtn.setBounds(50,130,50,20); createUserPanel.add(checkBtn);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == checkBtn){
                    Boolean checkInfo = userMF.createUser(user,new String[]{inputName.getText(),inputAge.getText(),inputPhoneNumber.getText(),inputRemainingAvailabilityDates.getText()});
                    if(!checkInfo){
                        JOptionPane.showMessageDialog(null,"생성 실패");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"생성 성공");
                    }
                    inputName.setText(""); inputAge.setText("");inputPhoneNumber.setText(""); inputRemainingAvailabilityDates.setText("");
                }
            }
        });
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
        setVisible(true);
    }
    public void changeInformation(){
        JPanel changeInformation = new JPanel();changeInformation.setLayout(null);
        changeInformation.removeAll();
        Label label1 = new Label("정보 수정"); label1.setBounds(10,10,100,30);
        changeInformation.add(label1);
        String [] header = {"고유번호","이름","나이","전화번호","이용기간"};
        Object [][] userInfo = userMF.allUserOutPut(user);
        JButton [] selectList = new JButton[user.size()];
        JTable userInfoTable = new JTable(userInfo,header);
        final int[] selectIndex = {-1};
        Label info = new Label("이름"); info.setBounds(50,50,50,20); changeInformation.add(info);
        JTextField inputName = new JTextField(); inputName.setBounds(100,50,150,20); changeInformation.add(inputName);
        info = new Label("나이"); info.setBounds(50,70,50,20);changeInformation.add(info);
        JTextField inputAge = new JTextField(); inputAge.setBounds(100,70,150,20);changeInformation.add(inputAge);
        info = new Label("전화번호"); info.setBounds(50,90,50,20); changeInformation.add(info);
        JTextField inputPhoneNumber= new JTextField(); inputPhoneNumber.setBounds(100,90,150,20); changeInformation.add(inputPhoneNumber);
        info = new Label("이용기간"); info.setBounds(50,110,50,20); changeInformation.add(info);
        JTextField inputRemainingDates= new JTextField(); inputRemainingDates.setBounds(100,110,150,20);changeInformation.add(inputRemainingDates);
        JButton retouchBtn = new JButton("수정"); retouchBtn.setBounds(50,130,50,20); changeInformation.add(retouchBtn);
        JButton deleteBtn = new JButton("삭제"); deleteBtn.setBounds(100,130,50,20); changeInformation.add(deleteBtn);
        userInfoTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                    selectIndex[0] = userInfoTable.getSelectedRow();
                    inputName.setText(user.get(selectIndex[0]).name);
                    inputAge.setText(String.valueOf(user.get(selectIndex[0]).age));
                    inputPhoneNumber.setText(user.get(selectIndex[0]).phoneNumber);
                    inputRemainingDates.setText(String.valueOf(user.get(selectIndex[0]).remainingAvailabilityDates));
                }
            }
        });

        ActionListener ActionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == deleteBtn){
                    user.remove(selectIndex[0]);
                    actionJPanel.removeAll();
                    JOptionPane.showMessageDialog(null,"삭제되었습니다");
                    changeInformation.removeAll();
                    changeInformation();
                } else if (e.getSource() == retouchBtn) {
                    boolean checkInfo = userMF.changeInformation(user,new String[]{inputName.getText(),inputAge.getText(),inputPhoneNumber.getText(),inputRemainingDates.getText()},selectIndex[0]);
                    if(!checkInfo){
                        JOptionPane.showMessageDialog(null,"수정 실패");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"수정 성공");
                        actionJPanel.removeAll();
                        changeInformation.removeAll();
                        changeInformation();
                        inputName.setText(""); inputAge.setText("");inputPhoneNumber.setText(""); inputRemainingDates.setText("");

                    }
                }
            }
        };;
        retouchBtn.addActionListener(ActionListener);
        deleteBtn.addActionListener(ActionListener);
        userInfoTable.getTableHeader().setReorderingAllowed(false);
        userInfoTable.getColumn("고유번호").setPreferredWidth(35);
        userInfoTable.getColumn("나이").setPreferredWidth(20);
        userInfoTable.getColumn("이용기간").setPreferredWidth(20);
        userInfoTable.getColumn("이름").setPreferredWidth(20);
        JScrollPane scrollUserInfoTable = new JScrollPane(userInfoTable);
        scrollUserInfoTable.setBounds(400,50,400,getHeight()-200);
        changeInformation.add(scrollUserInfoTable);
        actionJPanel.add(changeInformation);
        setVisible(true);
    }
    public void findUser(){
        JPanel findUserPanel = new JPanel();
        findUserPanel.setLayout(null);
        findUserPanel.removeAll();
        Label label1 = new Label("회원 검색"); label1.setBounds(10,10,100,30);findUserPanel.add(label1);
        JComboBox<String> comboBoxKindInfo = new JComboBox<String>(new Vector<>(Arrays.asList("고유번호","이름")));
        comboBoxKindInfo.setBounds(10,50,100,20); findUserPanel.add(comboBoxKindInfo);
        JTextField inputText= new JTextField(); inputText.setBounds(110,50,100,20); findUserPanel.add(inputText);
        JButton checkBtn = new JButton("검색"); checkBtn.setBounds(220,50,50,20); findUserPanel.add(checkBtn);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == checkBtn){
                    String selectInfo = comboBoxKindInfo.getSelectedItem().toString();
                    String text = inputText.getText();
                    if(selectInfo.equals("고유번호")&&!text.chars().allMatch(Character::isDigit)){
                        JOptionPane.showMessageDialog(null,"입력 오류");
                    }
                    else{
                        String [] header = {"고유번호","이름","나이","전화번호","남은이용기간"};
                        String [][] userInfo = userMF.findUser(user,selectInfo,text);
                        JTable userInfoTable = new JTable(userInfo,header);
                        JScrollPane scrollUserInfoTable = new JScrollPane(userInfoTable);
                        scrollUserInfoTable.setBounds(10,80,getWidth()-190,200);
                        findUserPanel.add(scrollUserInfoTable);
                    }
                    inputText.setText("");
                }
            }
        });
        actionJPanel.add(findUserPanel);
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
        //actionJPanel.setBackground(Color.gray);
        actionJPanel.setLayout(new BoxLayout(actionJPanel,BoxLayout.Y_AXIS));
        bigJPanel.add(actionJPanel);
    }
}
