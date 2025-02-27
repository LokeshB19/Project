package ATM_Simulator;
import java.awt.Image;
import java.sql.*;
import javax.swing.*; // Import all Swing components
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener 
{
    JButton login, Del, sin;
    JTextField C1;
    JPasswordField P1;

    Login() 
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel Card_No = new JLabel("Card No: ");
        Card_No.setFont(new Font("Raleway", Font.BOLD, 28));
        Card_No.setBounds(120, 150, 150, 30);
        add(Card_No);

        C1 = new JTextField();
        C1.setBounds(300, 150, 230, 30);
        C1.setFont(new Font("Arial", Font.BOLD, 14));
        add(C1);

        JLabel Pin = new JLabel("PIN: ");
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));
        Pin.setBounds(120, 220, 250, 30);
        add(Pin);

        P1 = new JPasswordField();
        P1.setBounds(300, 220, 230, 30);
        P1.setFont(new Font("Arial", Font.BOLD, 14));
        add(P1);

        login = new JButton("LOGIN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(300, 300, 100, 30);
        add(login);

        Del = new JButton("Clear");
        Del.setBackground(Color.BLACK);
        Del.setForeground(Color.WHITE);
        Del.addActionListener(this);
        Del.setBounds(430, 300, 100, 30);
        add(Del);

        sin = new JButton("SIGN UP");
        sin.setBackground(Color.BLACK);
        sin.setForeground(Color.WHITE);
        sin.addActionListener(this);
        sin.setBounds(300, 350, 230, 30);
        add(sin);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == login) 
        {
           ConnectionDB c = new ConnectionDB();
           String Card_No = C1.getText();
           String Pin = P1.getText();
           String query = "select * from Login where CardNumber = '"+Card_No+"' and PinNumber = '"+Pin+"'";
           try
           {
        	   ResultSet rs = c.s.executeQuery(query);
        	   if (rs.next())
        	   {
        		   setVisible(false);
        		   new Transaction(Pin).setVisible(true);
        	   }
        	   else
        	   {
        		   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
        	   }
           }
           catch(Exception e)
           {
        	   System.out.println(e);
           }
        } 
        else if (ae.getSource() == Del) 
        {
            C1.setText("");
            P1.setText("");
        } 
        else if (ae.getSource() == sin) 
        {
            setVisible(false);
            new SignUp().setVisible(true);
        } // <---- Missing closing bracket added here
    }

    public static void main(String[] args) 
    {
        new Login();
    }
}
