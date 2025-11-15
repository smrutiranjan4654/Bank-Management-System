package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox<String> religion,category,occupation,education,income;
    String formno;


    SignupTwo(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel addtionalDetails = new JLabel("Page 2: Additional Details");
        addtionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        addtionalDetails.setBounds(290,80,400,30);
        add(addtionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category :");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

        String valcategory []={"Genral","OBC","SC","ST","other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income :");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        String incomecategory []={"Null","< 1,50,00","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox<>(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        JLabel emial = new JLabel("Qulification :");
        emial.setBounds(100,315,200,30);
        emial.setFont(new Font("Raleway",Font.BOLD,20));
        add(emial);

        String eduactionValues []={"Non Graduation","Graduate","Post Graduation","Doctrate","Others"};
        education = new JComboBox<>(eduactionValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation :");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);

        String occupationValues []={"Salaried","Self Employeed","Bussiness","Student","Retried","Others"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number :");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number :");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen :");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup yorno = new ButtonGroup();
        yorno.add(syes);
        yorno.add(sno);



        JLabel pincode = new JLabel("Existing Account :");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup eyorno = new ButtonGroup();
        eyorno.add(eyes);
        eyorno.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected()){
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if (eno.isSelected()){
            existingaccount = "no";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        
        
        
    try {
        if(span.equals("")) {
        JOptionPane.showMessageDialog(null,"Pan Number is Required.");
         }
         else if(saadhar.equals("")){
            JOptionPane.showMessageDialog(null,"Addhar Number is Required.");
         }
         else if(seniorcitizen == null){
            JOptionPane.showMessageDialog(null,"Choose you are seniorcitizen or not ");
         }
         else if(existingaccount == null){
            JOptionPane.showMessageDialog(null,"Choose you have existing account or not ");
         }
         else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

                //signup3 object

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
            
         catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
       new SignupTwo(""); 
    }
}
