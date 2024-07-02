package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener{
    
    JLabel labelempid , lbname , lbempNo , lbAddress , lbEmail , lbclass12, lbqualification , lbfathername, lbdob, lbphone, lb10, lbAadhar, lbdepartment ;
    JTextField tfname , tfAddress , tfEmail , class12,   tffathername,  tfphone, tf10, tfAadhar;
    JDateChooser dcdob;
    JComboBox cbqualification;
    JComboBox cbdepartment;
    JButton cancel;
    JButton submit;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddTeacher(){
        
        setSize(900, 700);
        setLocation(350 , 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel ("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font ("serif", Font.BOLD,30));
        add(heading);
        
        lbname = new JLabel ("Name");
        lbname.setBounds(50,150,200,50);
        lbname.setFont(new Font ("serif", Font.BOLD,20));
        add(lbname);
        
        tfname = new JTextField() ;
        tfname.setBounds(180,160,200,30);
        add(tfname);
        
        lbempNo = new JLabel ("EMP No");
        lbempNo.setBounds(50,200,500,50);
        lbempNo.setFont(new Font ("serif", Font.BOLD,20));
        add(lbempNo);
        
        labelempid = new JLabel ("1033" + first4);
        labelempid.setBounds(180,200,500,50);
        labelempid.setFont(new Font ("serif", Font.BOLD,20));
        add(labelempid);
      
        
        lbAddress = new JLabel ("Address");
        lbAddress.setBounds(50,250,500,50);
        lbAddress.setFont(new Font ("serif", Font.BOLD,20));
        add(lbAddress);
        
        tfAddress = new JTextField() ;
        tfAddress.setBounds(180,260,200,30);
        add(tfAddress);
        
        lbEmail = new JLabel ("Email id");
        lbEmail.setBounds(50,300,500,50);
        lbEmail.setFont(new Font ("serif", Font.BOLD,20));
        add(lbEmail);
        
        tfEmail = new JTextField() ;
        tfEmail.setBounds(180,310,200,30);
        add(tfEmail);
        
        lbclass12 = new JLabel ("Class XII%");
        lbclass12.setBounds(50,350,500,50);
        lbclass12.setFont(new Font ("serif", Font.BOLD,20));
        add(lbclass12);
        
        class12 = new JTextField() ;
        class12.setBounds(180,360,200,30);
        add(class12);
        
        lbqualification = new JLabel ("Qualification");
        lbqualification.setBounds(50,400,500,50);
        lbqualification.setFont(new Font ("serif", Font.BOLD,20));
        add(lbqualification);
        
        String qualification[] = {"B.Tech" , "BBA" ,"BCA","MBA","MSc", "BSc"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(180,410,200,30);
        cbqualification.setBackground(Color.white);
        add(cbqualification);
        
        lbfathername = new JLabel ("Father's Name");
        lbfathername.setBounds(450,150,200,50);
        lbfathername.setFont(new Font ("serif", Font.BOLD,20));
        add(lbfathername);
        
        tffathername = new JTextField() ;
        tffathername.setBounds(650,160,200,30);
        add(tffathername);
        
        lbdob = new JLabel ("Date of Birth");
        lbdob.setBounds(450,200,200,50);
        lbdob.setFont(new Font ("serif", Font.BOLD,20));
        add(lbdob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(650,210,200,30);
        add(dcdob);
        
        lbphone = new JLabel ("Phone");
        lbphone.setBounds(450,250,200,50);
        lbphone.setFont(new Font ("serif", Font.BOLD,20));
        add(lbphone);
        
        tfphone = new JTextField() ;
        tfphone.setBounds(650,260,200,30);
        add(tfphone);
        
        
        lb10 = new JLabel ("Class X(%)");
        lb10.setBounds(450,300,200,50);
        lb10.setFont(new Font ("serif", Font.BOLD,20));
        add(lb10);
        
        tf10 = new JTextField() ;
        tf10.setBounds(650,310,200,30);
        add(tf10);
        
        lbAadhar = new JLabel ("Aadhar No");
        lbAadhar.setBounds(450,350,200,50);
        lbAadhar.setFont(new Font ("serif", Font.BOLD,20));
        add(lbAadhar);
        
        tfAadhar = new JTextField() ;
        tfAadhar.setBounds(650,360,200,30);
        add(tfAadhar);
        
        
        lbdepartment = new JLabel ("Department");
        lbdepartment.setBounds(450,400,200,50);
        lbdepartment.setFont(new Font ("serif", Font.BOLD,20));
        add(lbdepartment);
        
        String department[] = {"CSE" , "Mechanical" ,"Electronic","Civil","IT", "EEE"};
        cbdepartment = new JComboBox(department);
        cbdepartment.setBounds(650,410,200,30);
        cbdepartment.setBackground(Color.white);
        add(cbdepartment);
        
        submit = new JButton ("SUBMIT");
        submit.setBounds(220,500,200,30);
        submit.setBackground(Color.pink);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(460, 500, 200, 30);
        cancel.setBackground(Color.pink);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
     
        if(ae.getSource() == submit){
            //tfname , tfAddress , tfEmail , class12,   tffathername,  tfphone, tf10, tfAadhar;
            String empno = labelempid.getText();
            String name = tfname.getText();
            String tffname = tffathername.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address= tfAddress.getText();
            String email = tfEmail.getText();
            String cla12 = class12.getText();
            String phone = tfphone.getText();
            String cla10 = tf10.getText();
            String aadhar = tfAadhar.getText();
            String qualification = (String)cbqualification.getSelectedItem();
            String department = (String)cbdepartment.getSelectedItem();
            
            try {
                String query = "INSERT INTO Teacher VALUES ('" + empno + "', '" + name + "', '" + tffname + "','" + dob + "', '" + address + "', '" + email + "', '" + cla12 + "', '" + phone + "', '" + cla10 + "',  '" + aadhar + "', '" + qualification + "',  '" + department + "')";

            
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Inseted Successfully");
                setVisible(false);
                
            
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
     }
    public static void main (String[] args){
    
        new AddTeacher();
    }
}

