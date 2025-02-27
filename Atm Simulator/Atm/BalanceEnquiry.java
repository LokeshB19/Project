package ATM_Simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener 
{
    JButton back;
    String Pinnumber;

    BalanceEnquiry(String Pinnumber) 
    {
        this.Pinnumber = Pinnumber;
        setLayout(null);

        // Fix: Use getClass().getResource() to load the image correctly
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        ConnectionDB c = new ConnectionDB();
        int balance = 0;

        try 
        {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE Pinnumber = '" + Pinnumber + "'");
            while (rs.next()) 
            {
                if ("Deposit".equals(rs.getString("type"))) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        JLabel text = new JLabel("Your Current A/c Balance Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        setVisible(false);
        new Transaction(Pinnumber).setVisible(true);
    }

    public static void main(String[] args) 
    {
        new BalanceEnquiry(""); // Test with a sample PIN
    }
}
