package bank.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Admin_Display extends JFrame implements ActionListener {

    JTable table;
    JComboBox<String> tableSelector;
    JButton btnExit, btn;

    Admin_Display() {
        super("Admin Dashboard - Database Viewer");
        setLayout(null);
        getContentPane().setBackground(new Color(200, 230, 255));

        JLabel label = new JLabel("Admin Control Panel");
        label.setFont(new Font("Raleway", Font.BOLD, 25));
        label.setBounds(280, 20, 300, 30);
        add(label);

        // Dropdown to select which table to view
        JLabel selectLabel = new JLabel("Select View:");
        selectLabel.setBounds(50, 70, 100, 30);
        add(selectLabel);

        String[] options = {"Customer Details", "Login Info", "Bank Transactions"};
        tableSelector = new JComboBox<>(options);
        tableSelector.setBounds(150, 70, 200, 30);
        tableSelector.addActionListener(this);
        add(tableSelector);

        // Table Setup
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 120, 850, 400);
        add(sp);

        btnExit = new JButton("Back");
        btnExit.setBounds(300, 530, 100, 30);
        btnExit.addActionListener(this);
        add(btnExit);

        btn=new JButton("Exit");
        btn.setBounds(400,530,100,30);
        btn.addActionListener(this);
        add(btn);

        // Load default table data
        loadData("Customer Details");

        setSize(900, 650);
        setLocation(300, 100);
        setVisible(true);
    }

    private void loadData(String viewType) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Con c = new Con();
            String query = "";

            if (viewType.equals("Customer Details")) {
                // Joining signup and signup2 on form_no
                query = "select s1.form_no, s1.name, s1.email, s1.city, s2.category, s2.income from signup s1 join signup2 s2 on s1.form_no = s2.form_no";
                model.setColumnIdentifiers(new String[]{"Form No", "Name", "Email", "City", "Category", "Income"});
            } else if (viewType.equals("Login Info")) {
                query = "select * from login";
                model.setColumnIdentifiers(new String[]{"Form No", "Card Number", "PIN"});
            } else {
                query = "select * from bank";
                model.setColumnIdentifiers(new String[]{"PIN", "Date", "Type", "Amount"});
            }

            ResultSet rs = c.statement.executeQuery(query);
            int columnCount = model.getColumnCount();

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getString(i);
                }
                model.addRow(row);
            }
            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableSelector) {
            loadData(tableSelector.getSelectedItem().toString());
        } else if (e.getSource() == btnExit) {
            setVisible(false);
            new Admin(); // Goes back to Admin Login
        } else if (e.getSource()==btn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Admin_Display();
    }
}





//package bank.management.system;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.jar.JarFile;
//
//public class Admin_Display extends JFrame implements ActionListener {
//
//        Admin_Display(){
//            JLabel label=new JLabel("")
//        }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//
//    public static void main(String[] args) {
//        new Admin_Display();
//    }
//}
