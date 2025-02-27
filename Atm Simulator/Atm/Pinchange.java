package ATM_Simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener 
{
    JPasswordField NPin, repin;
    JButton change, back;
    String PinNumber;

    Pinchange(String PinNumber) 
    {
        this.PinNumber = PinNumber;
        setLayout(null);

        // Load image correctly
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25); 
        image.add(pintext);

        NPin = new JPasswordField();
        NPin.setFont(new Font("Raleway", Font.BOLD, 25));
        NPin.setBounds(330, 320, 180, 25); 
        image.add(NPin);

        JLabel repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        // Buttons
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == change) 
        {
            try 
            {
                String npin = new String(NPin.getPassword());  
                String rpin = new String(repin.getPassword());

                // Validation checks
                if (npin.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }
                if (!npin.equals(rpin)) 
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                ConnectionDB c = new ConnectionDB();

                String query1 = "UPDATE bank SET PinNumber = '" + rpin + "' WHERE PinNumber = '" + PinNumber + "'";
                String query2 = "UPDATE login SET PinNumber = '" + rpin + "' WHERE PinNumber = '" + PinNumber + "'";
                String query3 = "UPDATE SignupThree SET PinNumber = '" + rpin + "' WHERE PinNumber = '" + PinNumber + "'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
            }
        } 
        else 
        {
            setVisible(false);
            new Transaction(PinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) 
    {
        new Pinchange("").setVisible(true);
    }
} 