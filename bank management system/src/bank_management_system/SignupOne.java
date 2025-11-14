package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{

    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    long random;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;


    SignupOne(){

        setLayout(null);

        Random ran = new Random();
        random =Math.abs((ran.nextLong() % 9000L) +1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name :");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date OF Brith :");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);


        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendeGroup  = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);


        JLabel emial = new JLabel("Email Address :");
        emial.setBounds(100,340,200,30);
        emial.setFont(new Font("Raleway",Font.BOLD,20));
        add(emial);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup  = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        

        JLabel address = new JLabel("Address :");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("PINCODE :");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);


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
        String formno =""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if (unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of birth is Required");
            }
            else if(gender == null){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            else if(marital == null){
                JOptionPane.showMessageDialog(null, "Marital information is Required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
       new SignupOne(); 
    }
}
