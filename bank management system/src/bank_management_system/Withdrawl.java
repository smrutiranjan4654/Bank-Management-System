package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel text;
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter Amount You Want to Withdraw");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == withdraw) {

            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
                return;
            }

            try {
                int withdrawAmount = Integer.parseInt(number);

                // ------------------------------
                // CALCULATE CURRENT BALANCE
                // ------------------------------
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(
                        "SELECT * FROM bank WHERE pin = '" + pinnumber + "'");

                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                // ------------------------------
                // CHECK IF ENOUGH BALANCE
                // ------------------------------
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient Balance!\nYour current balance is Rs " + balance);
                    return;
                }

                // ------------------------------
                // ALLOW WITHDRAWAL
                // ------------------------------
                String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','Withdrawl','" + number + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
