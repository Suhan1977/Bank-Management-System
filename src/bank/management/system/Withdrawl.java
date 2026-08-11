package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1,b2;


    Withdrawl(String pin){

        this.pin=pin;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource(("icon/atm2.png")));
        Image i2= i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);


        JLabel label1=new JLabel("MAXIMIUM WITHDRAWL IS RS.10,000/-");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,400,35);
        label1.setForeground(Color.white);
        l3.add(label1);

        JLabel label2=new JLabel("PLEASE ENTER YOUR AMOUNT ");
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(460,220,400,35);
        label2.setForeground(Color.white);
        l3.add(label2);


        textField=new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(460,280,320,30);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1=new JButton("CASH WITHDRAW");
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
            String amount = textField.getText();
            Date date = new Date();

            if (e.getSource() == b1) {
                // 1. Validation: Check if empty
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                    return;
                }

                // 2. Validation: Check for numbers only
                if (!amount.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid Amount! Please enter numbers only.");
                    return;
                }

                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='" + pin + "'");
                int balance = 0;

                // Calculate current balance
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                // 3. Validation: Insufficient Balance Check
                int withdrawAmount = Integer.parseInt(amount);
                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance. Current Balance: Rs. " + balance);
                    return;
                }

                // 4. Execution: Insert the withdrawal record
                String query = "insert into bank values ('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                setVisible(false);
                new Main_Class(pin);

            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Better than throwing RuntimeException for debugging Swing apps
        }
    }








//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try {
//            String amount = textField.getText();
//            Date date = new Date();
//            if (e.getSource()==b1){
//                if(textField.getText().equals("")){
//                    JOptionPane.showMessageDialog(null,"Please enter  the Amount you want to Withdraw");
//                }else {
//                    Con c=new Con();
//                    ResultSet resultSet=c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
//                    int balance=0;
//                    while (resultSet.next()){
//                        if(resultSet.getString("type").equals("Deposit")){
//                            balance+=Integer.parseInt(resultSet.getString("amount"));
//                        }else{
//                            balance-=Integer.parseInt(resultSet.getString("amount"));
//                        }
//                    }
//                    if(balance < Integer.parseInt(amount)){
//                        JOptionPane.showMessageDialog(null,"Insuffient Balance");
//                        return;
//                    }
//
//                    c.statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
//                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfull");
//                    setVisible(false);
//                    new Main_Class(pin);
//                }
//            } else if (e.getSource()==b2) {
//                setVisible(false);
//                new Main_Class(pin);
//            }
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//
//
//    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
