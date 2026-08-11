package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1,b2;

    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource(("icon/atm2.png")));
        Image i2= i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);


        JLabel label1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,400,35);
        label1.setForeground(Color.white);
        l3.add(label1);


        textField=new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(460,230,320,30);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1=new JButton("DEPOSIT");
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.setBounds(700,362,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.setBounds(700,406,150,35);
        b2.addActionListener(this);
        l3.add(b2);




        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String amt = textField.getText();
            if (amt.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                return;
            }

            // 2. Check if it contains only numbers (No alphabets or symbols)
            if (!amt.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Invalid Amount! Please enter numbers only.");
                return;
            }

            Date date = new Date();
            if (e.getSource()==b1){
                int amountVal = Integer.parseInt(amt);
                if (amountVal <= 0) {
                    JOptionPane.showMessageDialog(null, "Deposit amount must be greater than zero.");
                    return;
                }else {
                    Con c=new Con();
                    String q="insert into bank values('"+pin+"','"+date+"','Deposit','"+amt+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs. "+amt+" Deposit Successfull");
                    setVisible(false);
                    new Main_Class(pin);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
