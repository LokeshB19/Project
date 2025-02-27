package ATM_Simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener 
{
    JButton Withdraw, back;
    JTextField amount;
    String PinNumber; // Store the PIN

    // Corrected Constructor
    Withdraw(String PinNumber) 
    {
        this.PinNumber = PinNumber; // Fix the assignment
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355, 485, 150, 30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == Withdraw) 
        {
            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter an amount to Withdraw");
            } 
            else 
            {
                try 
                {
                    ConnectionDB c = new ConnectionDB();
                    // Corrected SQL Query
                    String query = "insert into bank values('" + PinNumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transaction(PinNumber).setVisible(true);
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
            }
        } 
        else if (ae.getSource() == back) 
        { 
            setVisible(false);
            new Transaction(PinNumber).setVisible(true); // Ensure Transaction accepts PinNumber
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
