package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JLabel l1,type,card,number,pin,pnumber,carddetail,pindetail,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,27));
        l1.setBounds(280,40,400,40);
        add(l1);

        type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,160,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        r1.setFocusable(false);
        r2.setFocusable(false);
        r3.setFocusable(false);
        r4.setFocusable(false);

        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        carddetail = new JLabel("This is you 16 digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);

        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        pindetail = new JLabel("This is you 4 digit PIN");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);

        services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,150,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,170,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,150,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,150,30);
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,150,30);
        add(c6);

        c7 = new JCheckBox("I Hereby declares that the above entered details are correct tp the best of my knowladge CARD");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        c1.setFocusable(false);
        c2.setFocusable(false);
        c3.setFocusable(false);
        c4.setFocusable(false);
        c5.setFocusable(false);
        c6.setFocusable(false);
        c7.setFocusable(false);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit); 

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel); 

        submit.setFocusable(false);
        cancel.setFocusable(false);


        setSize(850,820);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposite Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);

            String pinnumber  = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";

            if(c1.isSelected()) facility += " ATM CARD";
            if(c2.isSelected()) facility += " Internet Banking";
            if(c3.isSelected()) facility += " Mobile Banking";
            if(c4.isSelected()) facility += " Email & SMS Alerts";
            if(c5.isSelected()) facility += " Cheque Book";
            if(c6.isSelected()) facility += " E Statement";


            try {
                if(accountType == null){
                    JOptionPane.showMessageDialog(null, "Please select an Account Type");
                    return;
                }

                boolean noServiceSelected = 
                !c1.isSelected() && 
                !c2.isSelected() && 
                !c3.isSelected() && 
                !c4.isSelected() && 
                !c5.isSelected() && 
                !c6.isSelected();

                if(noServiceSelected){
                    JOptionPane.showMessageDialog(null, "Please select at least one service");
                    return;
                }
                if(!c7.isSelected()){
                        JOptionPane.showMessageDialog(null, "Please confirm the declaration before proceeding");
                        return;
                    }

            else{
                Conn conn = new Conn();
                String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber +"\n"+"Pin: "+pinnumber);
            }

            } catch (Exception E) {
                System.out.println(E);
            }
            
        }   
        else if (e.getSource() == cancel){

        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
