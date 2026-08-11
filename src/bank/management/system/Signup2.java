package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textAadhar,textPan;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    String formno;

    Signup2(String formno){

        super("Application form");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno=formno;

        JLabel l1=new JLabel("PAGE 2: ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2=new JLabel("Additional Detials ");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3=new JLabel("Religion: ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,100,30);
        add(l3);

        String religion[]={
          "Hindu","Muslim","Sikh","Christan","Other"
        };

        comboBox =new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4=new JLabel("Category: ");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String category[]={
                "General","OBC","SC","ST","Others"
        };

        comboBox2 =new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);


        JLabel l5=new JLabel("Income: ");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,220,100,30);
        add(l5);

        String income[]={
                "Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,00","above 10,00,000"
        };

        comboBox3 =new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);


        JLabel l6=new JLabel("Educational: ");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,270,150,30);
        add(l6);

        String educational[]={
                "Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"
        };

        comboBox4 =new JComboBox(educational);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);


        JLabel l7=new JLabel("Occupation: ");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,340,150,30);
        add(l7);

        String occupation[]={
                "Salaried","Self-Employed","Business","Student","Retired","Others"
        };

        comboBox5 =new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("raleway",Font.BOLD,14));
        comboBox5.setBounds(350,340,320,30);
        add(comboBox5);


        JLabel l9=new JLabel("Pan Card No: ");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,390,150,30);
        add(l9);

        textPan =new JTextField();
        textPan.setBounds(350,390,320,30);
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        add(textPan);


        JLabel l8=new JLabel("Aadhar Number:  ");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,440,180,30);
        add(l8);

        textAadhar =new JTextField();
        textAadhar.setBounds(350,440,320,30);
        textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        add(textAadhar);


        JLabel l10=new JLabel("Senior Citizen:  ");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,490,180,30);
        add(l10);

        r1= new JRadioButton("Yes");
        r1.setBounds(350,490,100,30);
        r1.setBackground(new Color(252,208,76));
        r1.setFont(new Font("raleway",Font.BOLD,14));
        add(r1);

        r2=new JRadioButton("No");
        r2.setBounds(460,490,100,30);
        r2.setBackground(new Color(252,208,76));
        r2.setFont(new Font("raleway",Font.BOLD,14));
        add(r2);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);


        JLabel l11=new JLabel("Existing Account :  ");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,540,180,30);
        add(l11);

        e1= new JRadioButton("Yes");
        e1.setBounds(350,540,100,30);
        e1.setBackground(new Color(252,208,76));
        e1.setFont(new Font("raleway",Font.BOLD,14));
        add(e1);

        e2=new JRadioButton("No");
        e2.setBounds(460,540,100,30);
        e2.setBackground(new Color(252,208,76));
        e2.setFont(new Font("raleway",Font.BOLD,14));
        add(e2);

        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);



        JLabel l12=new JLabel("Form No :  ");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13=new JLabel(formno );
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(760,10,100,30);
        add(l13);

        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.black);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen=" ";
        if(r1.isSelected()){
            scitizen= "Yes";
        }else if(r2.isSelected()){
            scitizen="No";
        }

        String eAccount=" ";
        if(r1.isSelected()){
            eAccount= "Yes";
        }else if(r2.isSelected()){
            eAccount="No";
        }


        try{
            if (rel.equals("Select") || rel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a Religion");
                return;
            }

            // 2. Category Validation
            if (cate.equals("Select") || cate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a Category");
                return;
            }

            // 3. Income Validation
            if (inc.equals("Select") || inc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select Income details");
                return;
            }

            // 4. Education Validation
            if (edu.equals("Select") || edu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select Educational Qualification");
                return;
            }

            // 5. Occupation Validation
            if (occ.equals("Select") || occ.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select an Occupation");
                return;
            }

            // 6. PAN Number Validation
            // Logic: 10 characters, first 5 letters, 4 digits, last 1 letter
            if (pan.equals("") || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit PAN Number (Uppercase)");
                return;
            }

            // 7. Aadhar Number Validation
            // Logic: Exactly 12 digits
            if (aadhar.equals("") || !aadhar.matches("[0-9]{12}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhar Number");
                return;
            }

            if (scitizen == null) {
                JOptionPane.showMessageDialog(null, "Please select if you are a Senior Citizen");
                return;
            }
            if (eAccount == null) {
                JOptionPane.showMessageDialog(null, "Please select if you have an Existing Account");
                return;
            }


            else{
                Con c1=new Con();
                String q="insert into signup2 values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
