package ATM_Simulator;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener
{
    JTextField N, F, M, A, c, s, P;
    JRadioButton male, female, married, unmarried, other;
    ButtonGroup genderGroup, maritalGroup;
    JDateChooser dateChooser;
    JButton next;
    Random ran;
    long random;


    SignUp() 
    {
        setLayout(null);

        ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel Personal = new JLabel("Page 1: Personal Details");
        Personal.setFont(new Font("Raleway", Font.BOLD, 22));
        Personal.setBounds(290, 80, 400, 30);
        add(Personal);

        JLabel Name = new JLabel("Name: ");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140, 200, 30);
        add(Name);

        N = new JTextField();
        N.setBounds(300, 140, 400, 30);
        N.setFont(new Font("Raleway", Font.BOLD, 14));
        add(N);

        JLabel fName = new JLabel("Father's Name: ");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);

        F = new JTextField();
        F.setBounds(300, 190, 400, 30);
        F.setFont(new Font("Arial", Font.BOLD, 14));
        add(F);

        JLabel Dob = new JLabel("Date of Birth: ");
        Dob.setFont(new Font("Raleway", Font.BOLD, 20));
        Dob.setBounds(100, 240, 200, 30);
        add(Dob);

        dateChooser = new JDateChooser(); // Using JDateChooser
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setFont(new Font("Arial", Font.BOLD, 14));
        dateChooser.setDateFormatString("dd-MM-yyyy"); // Setting date format
        add(dateChooser);

        JLabel Gen = new JLabel("Gender: ");
        Gen.setFont(new Font("Raleway", Font.BOLD, 20));
        Gen.setBounds(100, 290, 200, 30);
        add(Gen);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel Mail = new JLabel("Email ID: ");
        Mail.setFont(new Font("Raleway", Font.BOLD, 20));
        Mail.setBounds(100, 340, 200, 30);
        add(Mail);

        M = new JTextField();
        M.setBounds(300, 340, 400, 30);
        M.setFont(new Font("Arial", Font.BOLD, 14));
        add(M);

        JLabel Marital = new JLabel("Marital Status: ");
        Marital.setFont(new Font("Raleway", Font.BOLD, 20));
        Marital.setBounds(100, 390, 200, 30);
        add(Marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel Add = new JLabel("Address: ");
        Add.setFont(new Font("Raleway", Font.BOLD, 20));
        Add.setBounds(100, 440, 200, 30);
        add(Add);

        A = new JTextField();
        A.setBounds(300, 440, 400, 30);
        A.setFont(new Font("Arial", Font.BOLD, 14));
        add(A);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        c = new JTextField();
        c.setBounds(300, 490, 400, 30);
        c.setFont(new Font("Arial", Font.BOLD, 14));
        add(c);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        s = new JTextField();
        s.setBounds(300, 540, 400, 30);
        s.setFont(new Font("Arial", Font.BOLD, 14));
        add(s);

        JLabel Pin = new JLabel("Pin Code: ");
        Pin.setFont(new Font("Raleway", Font.BOLD, 20));
        Pin.setBounds(100, 590, 200, 30);
        add(Pin);

        P = new JTextField();
        P.setBounds(300, 590, 400, 30);
        P.setFont(new Font("Arial", Font.BOLD, 14));
        add(P);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE); // Set text color to white
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 630, 100, 30); // Adjusted position for better visibility
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	String formNo = "" + random;
    	String Name  =  N.getText();
    	String fName = F.getText();
    	String Dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    	String Gen  = null;
    	if(male.isSelected())
    	{
    		Gen = "Male";
    	}
    	else if(female.isSelected())
    	{
    		Gen = "Female";
    	}
    	
    	String Mail = M.getText();
    	String Marital = null;
    	if(married.isSelected())
    	{
    		Marital = "Married";
    	}
    	else if(unmarried.isSelected())
    	{
    		Marital = "Unmarried";
    	}
    	else if(other.isSelected())
    	{
    		Marital = "Other";
    	}
    	
    	String Add  = A.getText();
    	String city = c.getText();
    	String state = s.getText();
    	String Pin  = P.getText();
    	
    	try
    	{
    		if (N.getText().isEmpty()) 
    		{
    		    JOptionPane.showMessageDialog(null, "Name is Required");
    		}

    		else
    		{
    			ConnectionDB c = new ConnectionDB();
    			String query = "insert into signup values('"+formNo+"','"+Name+"','"+fName+"','"+Dob+"','"+Gen+"','"+Mail+"','"+Marital+"','"+Add+"','"+city+"','"+Pin+"','"+state+"')";
    			c.s.executeUpdate(query);
    			JOptionPane.showMessageDialog(null, "Details Added Successfully!");
    			
    			//SignupTwo Object
    			setVisible(false);
    			new SignupTwo(formNo).setVisible(true);

    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    public static void main(String[] args) 
    {
        new SignUp();
    }
} 