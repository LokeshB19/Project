package ATM_Simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener 
{
    JTextField A, P;
    JRadioButton Eyes, Eno, Syes, Sno;
    ButtonGroup seniorCitizenGroup, existingAccountGroup;
    JComboBox<String> Religion, Category, Income, Educational, Occupation;
    String formNo;
    JButton next;
    Random ran;
    long random;

    SignupTwo(String formNo) 
    {
        this.formNo = formNo;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");

        JLabel Additional = new JLabel("Page 2: Additional Details");
        Additional.setFont(new Font("Raleway", Font.BOLD, 22));
        Additional.setBounds(290, 80, 400, 30);
        add(Additional);

        JLabel Name = new JLabel("Religion: ");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140, 200, 30);
        add(Name);
        
        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"}; 
        Religion = new JComboBox<>(valreligion);
        Religion.setBounds(300, 140, 400, 30);
        Religion.setBackground(Color.WHITE);
        add(Religion);

        JLabel cName = new JLabel("Category: ");
        cName.setFont(new Font("Raleway", Font.BOLD, 20));
        cName.setBounds(100, 190, 200, 30);
        add(cName);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"}; 
        Category = new JComboBox<>(valcategory);
        Category.setBounds(300, 190, 400, 30);
        Category.setBackground(Color.WHITE);
        add(Category);

        JLabel Dob = new JLabel("Income P/A: ");
        Dob.setFont(new Font("Raleway", Font.BOLD, 20));
        Dob.setBounds(100, 240, 200, 30);
        add(Dob);
        
        String valincome[] = {"Null", "< 1.5L", "< 2.5L", "< 5L", "Above 10L"}; 
        Income = new JComboBox<>(valincome);
        Income.setBounds(300, 240, 400, 30);
        Income.setBackground(Color.WHITE);
        add(Income);

        JLabel Gen = new JLabel("Educational ");
        Gen.setFont(new Font("Raleway", Font.BOLD, 20));
        Gen.setBounds(100, 290, 200, 30);
        add(Gen);

        JLabel Mail = new JLabel("Qualification: ");
        Mail.setFont(new Font("Raleway", Font.BOLD, 20));
        Mail.setBounds(100, 320, 200, 30);
        add(Mail);
        
        String valeducational[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"}; 
        Educational = new JComboBox<>(valeducational);
        Educational.setBounds(300, 320, 400, 30);
        Educational.setBackground(Color.WHITE);
        add(Educational);

        JLabel Marital = new JLabel("Occupation: ");
        Marital.setFont(new Font("Raleway", Font.BOLD, 20));
        Marital.setBounds(100, 390, 200, 30);
        add(Marital);
        
        String valoccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"}; 
        Occupation = new JComboBox<>(valoccupation);
        Occupation.setBounds(300, 390, 400, 30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

        JLabel PAN = new JLabel("PAN Number: ");
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN.setBounds(100, 440, 200, 30);
        add(PAN);

        P = new JTextField();
        P.setBounds(300, 440, 400, 30);
        P.setFont(new Font("Arial", Font.BOLD, 14));
        add(P);

        JLabel Aadhar = new JLabel("Aadhar Number: ");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar.setBounds(100, 490, 200, 30);
        add(Aadhar);

        A = new JTextField();
        A.setBounds(300, 490, 400, 30);
        A.setFont(new Font("Arial", Font.BOLD, 14));
        add(A);

        JLabel seniorCitizenLabel = new JLabel("Senior Citizen: ");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizenLabel.setBounds(100, 540, 200, 30);
        add(seniorCitizenLabel);

        Syes = new JRadioButton("Yes");
        Syes.setBounds(300, 540, 100, 30);
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno = new JRadioButton("No");
        Sno.setBounds(450, 540, 120, 30);
        Sno.setBackground(Color.WHITE);
        add(Sno);
        
        seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(Syes);
        seniorCitizenGroup.add(Sno);

        JLabel existingAccountLabel = new JLabel("Existing A/C: ");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 590, 200, 30);
        add(existingAccountLabel);

        Eyes = new JRadioButton("Yes");
        Eyes.setBounds(300, 590, 100, 30);
        Eyes.setBackground(Color.WHITE);
        add(Eyes);

        Eno = new JRadioButton("No");
        Eno.setBounds(450, 590, 120, 30);
        Eno.setBackground(Color.WHITE);
        add(Eno);
        
        existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(Eyes);
        existingAccountGroup.add(Eno);

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
        String sreligion = (String) Religion.getSelectedItem();
        String scategory = (String) Category.getSelectedItem();
        String sincome = (String) Income.getSelectedItem();
        String seducation = (String) Educational.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();
        String seniorcitizen = null;

        if (Syes.isSelected()) 
        {
            seniorcitizen = "Yes";
        } 
        else if (Sno.isSelected()) 
        {
            seniorcitizen = "No";
        }
        
        String Mail = P.getText(); // Changed from M.getText() to P.getText()
        String Pin = null;

        if (Eyes.isSelected()) 
        {
            Pin = "Yes";
        } 
        else if (Eno.isSelected()) 
        {
            Pin = "No";
        }
        
        String Pan = P.getText();
        String Add = A.getText();
        
        try 
        {
            ConnectionDB c = new ConnectionDB();   
            String query = "INSERT INTO signupTwo VALUES('" + formNo + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + Pan + "','" + Add + "','" + seniorcitizen + "','" + Pin + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Added Successfully!");
            setVisible(false);
            new SignupTwo(formNo).setVisible(true);
            
          //SignupThree Object
			setVisible(false);
			new SignupThree(formNo).setVisible(true);
			
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) 
    {
        new SignupTwo("");
    }
}
