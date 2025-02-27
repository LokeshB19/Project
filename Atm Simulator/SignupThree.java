package ATM_Simulator;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener
{
	JRadioButton S1,FD2,C3,R4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formNo;
	
	SignupThree(String formNo) 
	{
		this.formNo = formNo;
        setLayout(null);
        setTitle("Account Signup");

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);

        S1 = new JRadioButton("Saving Account");
        S1.setFont(new Font("Raleway", Font.BOLD, 16));
        S1.setBackground(Color.WHITE);
        S1.setBounds(100, 140, 200, 25);
        add(S1);

        FD2 = new JRadioButton("Fixed Deposit Account");
        FD2.setFont(new Font("Raleway", Font.BOLD, 16));
        FD2.setBackground(Color.WHITE);
        FD2.setBounds(350, 140, 250, 25);
        add(FD2);

        C3 = new JRadioButton("Current Account");
        C3.setFont(new Font("Raleway", Font.BOLD, 16));
        C3.setBackground(Color.WHITE);
        C3.setBounds(100, 180, 200, 25);
        add(C3);

        R4 = new JRadioButton("Recurring Deposit Account");
        R4.setFont(new Font("Raleway", Font.BOLD, 16));
        R4.setBackground(Color.WHITE);
        R4.setBounds(350, 180, 250, 25);
        add(R4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(S1);
        groupaccount.add(FD2);
        groupaccount.add(C3);
        groupaccount.add(R4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 240, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 240, 300, 30);
        add(number);

        JLabel CardDetails = new JLabel("Your 16 Digit Card Number");
        CardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        CardDetails.setBounds(100, 270, 300, 20);
        add(CardDetails);

        JLabel PIN = new JLabel("PIN: ");
        PIN.setFont(new Font("Raleway", Font.BOLD, 22));
        PIN.setBounds(100, 310, 200, 30);
        add(PIN);

        JLabel Pnumber = new JLabel("XXXX");
        Pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        Pnumber.setBounds(330, 310, 300, 30);
        add(Pnumber);

        JLabel PinDetails = new JLabel("Your 4 Digit Pin Number");
        PinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        PinDetails.setBounds(100, 340, 300, 20);
        add(PinDetails);

        JLabel Services = new JLabel("Services Required: ");
        Services.setFont(new Font("Raleway", Font.BOLD, 22));
        Services.setBounds(100, 380, 250, 30);
        add(Services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 420, 200, 25);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 420, 250, 25);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 460, 200, 25);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 460, 250, 25);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 500, 200, 25);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 500, 250, 25);
        add(c6);

        c7 = new JCheckBox("I Hereby Declare That The Above Entered Details Are Correct To The Best Of My Knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 580, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(200, 630, 150, 40);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(400, 630, 150, 40);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == submit)
		{
			String accountType = null;
			if(S1.isSelected())
			{
				accountType = "Saving Account";
			}
			else if(FD2.isSelected())
			{
				accountType = "Fixed Deposit Account";
			}
			else if(C3.isSelected())
			{
				accountType = "Current Account";
			}
			else if(R4.isSelected())
			{
				accountType = "Reccuring Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(c1.isSelected())
			{
				facility = facility + "ATM CARD";
			}
			else if(c2.isSelected())
			{
				facility = facility + "Internet Banking";
			}
			else if(c3.isSelected())
			{
				facility = facility + "Mobile Banking";
			}
			else if(c4.isSelected())
			{
				facility = facility + "EMAIL & SMS Alerts";
			}
			else if(c5.isSelected())
			{
				facility = facility + "Cheque Book";
			}
			else if(c6.isSelected())
			{
				facility = facility + "E-Statement";
			}
			
			try
			{
				if (accountType.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account Type is Requied");
				}
				else
				{
					ConnectionDB conn = new ConnectionDB();
					String query1 = "insert into signupthree values('"+formNo+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into Login values('"+formNo+"','"+cardnumber+"','"+pinnumber+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+ pinnumber);
				}
				
				setVisible(false);
				new Deposit(pinnumber).setVisible(false);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource() == cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String args[]) 
	{
		new SignupThree("");
	}

}