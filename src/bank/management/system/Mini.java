package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini(String pin){
        this.pin =  pin;

        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1=new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2=new JLabel("ACCOUNT STATEMENT");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3=new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4=new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Con c=new Con();
            ResultSet rs=c.statement.executeQuery("select * from login where pin = '"+pin+"' ");
            while (rs.next()){
                label3.setText("Card Number: "+rs.getString("crad_no").substring(0,4)+"XXXXXXXX"+
                        rs.getString("crad_no").substring(12));
            }


        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin= '" + pin + "'");
            int balance = 0;

            // Start the HTML string with a table and headers
            StringBuilder tableContent = new StringBuilder("<html>" +
                    "<table border='1' width='100%'>");
            tableContent.append("<tr>" +
                    "<th align='left'>Date</th>" +
                    "<th align='left'>Type</th>" +
                    "<th align='left'>Amount</th>" +
                    "</tr>");

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");

                // Add a row for each transaction
                tableContent.append("<tr>")
                        .append("<td>").append(date).append("</td>")
                        .append("<td>").append(type).append("</td>")
                        .append("<td>").append(amount).append("</td>")
                        .append("</tr>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            tableContent.append("</table></html>");
            label1.setText(tableContent.toString());
            label4.setText("Your Total Balance Is Rs. " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }


        button=new JButton("EXIT");
        button.setBounds(20,500,100,25);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==button){
                new Main_Class(pin);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
