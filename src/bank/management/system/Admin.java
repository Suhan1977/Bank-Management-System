package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton btn;
    JTextField textField1;
    JPasswordField passwordField1;
    Admin(){

        super("Admin Dashboard - Database Viewer");
        setLayout(null);
        getContentPane().setBackground(new Color(200, 230, 255));

        JLabel label=new JLabel("ADMIN LOGIN ");
        label.setFont(new Font("System",Font.BOLD,20));
        label.setBounds(150,60,200,30);
        add(label);


        JLabel label1=new JLabel("Username: ");
        label1.setBounds(100,100,100,30);
        add(label1);

        textField1=new JTextField();
        textField1.setBounds(200,100,100,30);
        add(textField1);

        JLabel label2=new JLabel("Password: ");
        label2.setBounds(100,200,100,30);
        add(label2);

        passwordField1=new JPasswordField();
        passwordField1.setBounds(200,200,100,30);
        add(passwordField1);

        btn=new JButton("Submit");
        btn.setBounds(150,300,100,30);
        btn.addActionListener(this);
        add(btn);


        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username=textField1.getText();
            String pswrd=passwordField1.getText();
            if(e.getSource()==btn){
                if(username.equals("admin") && pswrd.equals("admin@123")){
                    JOptionPane.showMessageDialog(null,"Valid Detials!");
                    new Admin_Display ();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Detials! Please enter the Valid Detials!");
                    return;
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
