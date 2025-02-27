package ATM_Simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener 
{
    JButton deposit, Withdrawl, fastcash, ministate, pinchange, Balance, exit;
    String PinNumber;

    FastCash(String PinNumber) 
    {
        this.PinNumber = PinNumber;
        setLayout(null);

        // Load image from imported folder inside Eclipse project
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        Withdrawl = new JButton("Rs 500");
        Withdrawl.setBounds(355, 415, 150, 30);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministate = new JButton("Rs 2000");
        ministate.setBounds(355, 450, 150, 30);
        ministate.addActionListener(this);
        image.add(ministate);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        Balance = new JButton("Rs 10000");
        Balance.setBounds(355, 485, 150, 30);
        Balance.addActionListener(this);
        image.add(Balance);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == exit) 
        {
            setVisible(false);
            new Transaction(PinNumber).setVisible(true);
        } 
        else 
        {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            
            ConnectionDB c = new ConnectionDB();
            try 
            {
                ResultSet rs = c.s.executeQuery("select * from bank where PinNumber = '" + PinNumber + "'");
                int balance = 0;
                while (rs.next()) 
                {
                    if (rs.getString("type").equals("Deposit")) 
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } 
                    else 
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) 
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
            
                String query = "insert into bank values('" + PinNumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transaction(PinNumber).setVisible(true);
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) 
    {
        new FastCash("");
    }
}
