package ATM_Simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener
{
	JButton deposit,Withdrawl,fastcash,ministate,pinchange,Balance,exit;
	String Pin;
	
    Transaction(String Pin) //FastCash
    {
    	this.Pin = Pin;
        setLayout(null);

        // Load image from imported folder inside Eclipse project
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        Withdrawl = new JButton("Cash Withdrawl");
        Withdrawl.setBounds(355, 415, 150, 30);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Mini Statement");
        ministate.setBounds(355, 450, 150, 30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Pin change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        Balance = new JButton("Check Balance");
        Balance.setBounds(355, 485, 150, 30);
        Balance.addActionListener(this);
        image.add(Balance);
        
        exit = new JButton("Exit");
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
    	if(ae.getSource() == exit)
    	{
    		System.exit(0);
    	}
    	else if(ae.getSource() == deposit)
    	{
    		setVisible(false);
    		new Deposit(Pin).setVisible(true);
    	}
    	else if(ae.getSource() == Withdrawl)
    	{
    		setVisible(false);
    		new Withdraw(Pin).setVisible(true);
    	}
    	else if(ae.getSource() == fastcash)
    	{
    		setVisible(false);
    		new FastCash(Pin).setVisible(true);
    	}
    	else if(ae.getSource() == pinchange)
    	{
    		setVisible(false);
    		new Pinchange(Pin).setVisible(true);
    	}
    	else if(ae.getSource() == Balance)
    	{
    		setVisible(false);
    		new BalanceEnquiry(Pin).setVisible(true);
    	}
    	else if(ae.getSource() == ministate)
    	{
    		new MiniStatement(Pin).setVisible(true);
    	}
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
