package bank_management_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 350, 200);
        add(mini);

        JLabel bank = new JLabel("Canara Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");

            while (rs.next()) {
                String cardNum = rs.getString("cardnumber");
                card.setText("Card Number: " + cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    try {
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pinnumber + "' ORDER BY date DESC LIMIT 3");

            StringBuilder data = new StringBuilder("<html>");

            while (rs.next()) {
                data.append(rs.getString("date"))
                    .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append(rs.getString("type"))
                    .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append(rs.getString("amount"))
                    .append("<br><br>");
            }

            data.append("</html>");
            mini.setText(data.toString());

        } catch (Exception e) {
            System.out.println(e);
        }

         try {
            Conn conn = new Conn();

            String sumQuery =
                "SELECT SUM(CASE WHEN UPPER(type) = 'DEPOSIT' " +
                "THEN CAST(REPLACE(amount, ',', '') AS SIGNED) " +
                "ELSE -CAST(REPLACE(amount, ',', '') AS SIGNED) END) AS bal " +
                "FROM bank WHERE pin = '" + pinnumber + "'";

            ResultSet rs = conn.s.executeQuery(sumQuery);

            int bal = 0;
            if (rs.next()) {
                bal = rs.getInt("bal");
                if (rs.wasNull()) bal = 0;
            }

            balance.setText("Your current balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
            balance.setText("Your current balance is Rs 0");
        }

        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
