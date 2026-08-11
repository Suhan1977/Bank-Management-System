package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1,button2,button3,button4;

    Login(){

        super("Bank Management System");    //set title

//        bank img
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

//      car image
        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);

        JLabel iimage=new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        //      labels

        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2=new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField1=new JTextField(15);
        textField1.setBounds(325,190,230,30);
        setFont(new Font("Arial",Font.BOLD,14));
        add(textField1);


        label3=new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField1=new JPasswordField(15);
        passwordField1.setBounds(325,250,230,30);
        passwordField1.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField1);

        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBounds(300,300,100,30);
        button1.setBackground(Color.black);
        button1.addActionListener(this);
        add(button1);


        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBounds(430,300,100,30);
        button2.setBackground(Color.black);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBounds(300,350,100,30);
        button3.setBackground(Color.black);
        button3.addActionListener(this);
        add(button3);


        button4=new JButton("Admin");
        button4.setFont(new Font("Arial",Font.BOLD,14));
        button4.setForeground(Color.WHITE);
        button4.setBounds(430,350,100,30);
        button4.setBackground(Color.black);
        button4.addActionListener(this);
        add(button4);


//      background image
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);

        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
//        setUndecorated(true);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                Con c1 = new Con();
                String cardno = textField1.getText();
                // passwordField1.getText() is deprecated, but works for simple projects
                String pin = passwordField1.getText();

                // 1. Check for empty fields
                if (cardno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Card Number is required");
                    return;
                } else if (pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "PIN is required");
                    return;
                }

                // 2. Validate Card Number length (16 digits)
                if (!cardno.matches("[0-9]{16}")) {
                    JOptionPane.showMessageDialog(null, "Card Number must be exactly 16 digits");
                    return;
                }

                // 3. Validate PIN length (4 digits)
                if (!pin.matches("[0-9]{4}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                    return;
                }

                // 4. Database Query
                String q = "select * from login where crad_no='" + cardno + "' and pin ='" + pin + "'";
                ResultSet resultSet = c1.statement.executeQuery(q);

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } else if (e.getSource() == button2) {
                textField1.setText("");
                passwordField1.setText("");
            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            } else if (e.getSource() == button4){
                new Admin();
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try{
//            if(e.getSource()==button1){
//                Con c1=new Con();
//                String cardno = textField1.getText();
//                String pin=passwordField1.getText();
//                String q="select * from login where crad_no='"+cardno+"' and pin ='"+pin+"'";
//                ResultSet resultSet=c1.statement.executeQuery(q);
//                if(resultSet.next()){
//                    setVisible(false);
//                    new Main_Class(pin);
//                }else{
//                    JOptionPane.showMessageDialog(null,"Incorrect Detials");
//                }
//
//            }
//            else if (e.getSource()==button2) {
//                textField1.setText("");
//                passwordField1.setText("");
//            } else if (e.getSource()==button3) {
//                new Signup();
//                setVisible(false);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public  static  void main(String[] args){
        new Login();
    }
}
