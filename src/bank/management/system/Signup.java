package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JButton next,submit,clear;

    JRadioButton r1,r2,m1,m2,m3;

    JDateChooser dateCHooser;

    JTextField textName,textFname,textEmail,textAdd,textCity,textPin,textState;


    Random ran=new Random();
    long first4=(ran.nextLong() %9000L) + 1000L;
    String first=" "+Math.abs(first4);

    Signup(){
        super("Application Form");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);


        JLabel label1=new JLabel("Application Form No.: "+first);
        label1.setBounds(130,20,600,40);
        label1.setFont(new Font("Ralway",Font.BOLD,38));
        add(label1);


        JLabel label2=new JLabel("Page 1:");
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3=new JLabel("Personal Detials: ");
        label3.setFont(new Font("Ralway",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName=new JLabel("Name :");
        labelName.setFont(new Font("Ralway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName=new JTextField();
        textName.setFont(new Font("Ralway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);


        JLabel labelFname=new JLabel("Father's Name :");
        labelFname.setFont(new Font("Ralway",Font.BOLD,20));
        labelFname.setBounds(100,240,200,30);
        add(labelFname);

        textFname=new JTextField();
        textFname.setFont(new Font("Ralway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);


        JLabel DOB=new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Ralway",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateCHooser=new JDateChooser();
        dateCHooser.setForeground(new Color(105,105,105));
        dateCHooser.setBounds(300,340,400,30);
        add(dateCHooser);

        JLabel labelG=new JLabel("Gender : ");
        labelG.setFont(new Font("Ralway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1=new JRadioButton("male");
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBounds(300,290,60,30);
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2=new JRadioButton("female");
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBounds(450,290,90,30);
        r2.setBackground(new Color(222,255,228));
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail=new JLabel("Email Address: ");
        labelEmail.setFont(new Font("Ralway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail=new JTextField();
        textEmail.setFont(new Font("Ralway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs=new JLabel("Martial Status :  ");
        labelMs.setFont(new Font("Ralway",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        m1=new JRadioButton("Maried");
        m1.setBounds(300,440,100,30);
        m1.setFont(new Font("Ralway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        add(m1);

        m2=new JRadioButton("Unmaried");
        m2.setBounds(450,440,100,30);
        m2.setFont(new Font("Ralway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        add(m2);

        m3=new JRadioButton("Others");
        m3.setBounds(635,440,100,30);
        m3.setFont(new Font("Ralway",Font.BOLD,14));
        m3.setBackground(new Color(222,255,228));
        add(m3);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);



        JLabel labelAdd=new JLabel("Address :  ");
        labelAdd.setFont(new Font("Ralway",Font.BOLD,20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd=new JTextField();
        textAdd.setFont(new Font("Ralway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);


        JLabel labelCity=new JLabel("City :  ");
        labelCity.setFont(new Font("Ralway",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textCity=new JTextField();
        textCity.setFont(new Font("Ralway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);


        JLabel labelPin=new JLabel("PinCode :  ");
        labelPin.setFont(new Font("Ralway",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin=new JTextField();
        textPin.setFont(new Font("Ralway",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        add(textPin);

        JLabel labelState=new JLabel("State :  ");
        labelState.setFont(new Font("Ralway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textState=new JTextField();
        textState.setFont(new Font("Ralway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next=new JButton("Next");
        next.setFont(new Font("Ralway",Font.BOLD,14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname=textFname.getText();
        String dob=((JTextField) dateCHooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(r1.isSelected()){
            gender ="Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String email=textEmail.getText();
        String marial=null;
        if(m1.isSelected()){
            marial="Married";
        } else if (m2.isSelected()) {
            marial="Unmarried";
        }else if(m3.isSelected()){
            marial="Other";
        }
        String addr=textAdd.getText();
        String city=textCity.getText();
        String pincode=textPin.getText();
        String state=textState.getText();

        try{
            if (name.equals("") || !name.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Name (Alphabets only)");
                return; // Stops the execution
            }
            if (fname.equals("") || !fname.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Father's Name");
                return;
            }
            if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select a Date of Birth");
                return;
            }
            String emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
            if (email.equals("") || !email.matches(emailPattern)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Email Address");
                return;
            }
            if (gender == null) {
                JOptionPane.showMessageDialog(null, "Please select a Gender");
                return;
            }
            if (marial == null) {
                JOptionPane.showMessageDialog(null, "Please select Marital Status");
                return;
            }
            if (pincode.equals("") || !pincode.matches("[0-9]{6}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 6-digit Pincode");
                return;
            }
            else{
                Con con1 = new Con();
                String q="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marial+"','"+addr+"','"+city+"','"+pincode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Signup();
    }

}
