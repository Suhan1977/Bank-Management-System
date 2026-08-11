package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    String pin;
    JButton b1,b2;
    JPasswordField p1, p2;
    Pin(String pin){
        this.pin=pin;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource(("icon/atm2.png")));
        Image i2= i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel l3= new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1=new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(430,180,400,35);
        label1.setForeground(Color.white);
        l3.add(label1);

        JLabel label2=new JLabel("NEW PIN");
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(430,220,150,35);
        label2.setForeground(Color.white);
        l3.add(label2);

        p1=new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.white);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p1);

        JLabel label3=new JLabel("RE-ENTER NEW PIN");
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(430,250,400,35);
        label3.setForeground(Color.white);
        l3.add(label3);

        p2=new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.white);
        p2.setBounds(600,255,180,25);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p2);




        b1=new JButton("SAVE");
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

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (e.getSource() == b1) {
                // 1. Check for empty fields
                if (pin1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (pin2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                // 2. Validate exactly 4 digits for pin1
                if (!pin1.matches("[0-9]{4}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits (Numbers only)");
                    return;
                }

                // 3. Compare the two entries
                if (!pin1.equals(pin2)) {
                    JOptionPane.showMessageDialog(null, "Entered PINs do not match!");
                    return;
                }

                // 4. Update Database
                Con c = new Con();
                // Note: Since you are updating the PIN, we update all three tables
                // that link the user by their old 'pin'
                String q1 = "update bank set pin= '" + pin1 + "' where pin = '" + pin + "' ";
                String q2 = "update login set pin= '" + pin1 + "' where pin = '" + pin + "'";
                String q3 = "update signup3 set pin= '" + pin1 + "' where pin = '" + pin + "'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully!");
                setVisible(false);
                new Main_Class(pin1); // Use the NEW pin for the main class session
            }

            if (e.getSource() == b2) {
                new Main_Class(pin);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try{
//            String pin1=p1.getText();
//            String pin2=p2.getText();
//
//            if(e.getSource()==b1){
//                if(p1.getText().equals("")){
//                    JOptionPane.showMessageDialog(null,"Enter New PIN");
//                    return;
//                }
//                if(p2.getText().equals("")){
//                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
//                    return;
//                }
//                if (!pin1.equals(pin2)) {
//                    JOptionPane.showMessageDialog(null, "Entered PIN Doesn't Match!");
//                    return;
//                }
//
//                Con c=new Con();
//                String q1="update bank set pin= '"+pin1+"' where pin = '"+pin+"' ";
//                String q2="update login set pin= '"+pin1+"' where pin = '"+pin+"'";
//                String q3="update signup3 set pin= '"+pin1+"' where pin = '"+pin+"'";
//
//                c.statement.executeUpdate(q1);
//                c.statement.executeUpdate(q2);
//                c.statement.executeUpdate(q3);
//
//                JOptionPane.showMessageDialog(null,"PIN changed Successfully!");
//                setVisible(false);
//                new Main_Class(pin);
//            }
//
//            if (e.getSource()==b2){
//                new Main_Class(pin);
//                setVisible(false);
//            }
//
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }


    public static void main(String[] args) {
        new Pin("");
    }
}
