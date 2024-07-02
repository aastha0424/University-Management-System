package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener{
    
    JLabel labelrollnumber , lbname , lbRollNo , lbAddress , lbEmail , lbclass12, lbcourse , lbfathername, lbdob, lbphone, lb10, lbAadhar, lbBranch ;
    JTextField tfname , tfAddress , tfEmail , class12,   tffathername,  tfphone, tf10, tfAadhar;
    JDateChooser dcdob;
    JComboBox cbcourse;
    JComboBox cbbranch;
    JButton cancel;
    JButton submit;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddStudent(){
        
        setSize(900, 700);
        setLocation(350 , 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel ("New Student Details");
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
        
        lbRollNo = new JLabel ("Roll No");
        lbRollNo.setBounds(50,200,500,50);
        lbRollNo.setFont(new Font ("serif", Font.BOLD,20));
        add(lbRollNo);
        
        labelrollnumber = new JLabel ("1533" + first4);
        labelrollnumber.setBounds(180,200,500,50);
        labelrollnumber.setFont(new Font ("serif", Font.BOLD,20));
        add(labelrollnumber);
      
        
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
        
        lbcourse = new JLabel ("Course");
        lbcourse.setBounds(50,400,500,50);
        lbcourse.setFont(new Font ("serif", Font.BOLD,20));
        add(lbcourse);
        
        String course[] = {"B.Tech" , "BBA" ,"BCA","MBA","MSc", "BSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(180,410,200,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
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
        
        
        lbBranch = new JLabel ("Branch");
        lbBranch.setBounds(450,400,200,50);
        lbBranch.setFont(new Font ("serif", Font.BOLD,20));
        add(lbBranch);
        
        String branch[] = {"CSE" , "Mechanical" ,"Electronic","Civil","IT", "EEE"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(650,410,200,30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
        
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
            String rollno = labelrollnumber.getText();
            String name = tfname.getText();
            String tffname = tffathername.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address= tfAddress.getText();
            String email = tfEmail.getText();
            String cla12 = class12.getText();
            String phone = tfphone.getText();
            String cla10 = tf10.getText();
            String aadhar = tfAadhar.getText();
            String course = (String)cbcourse.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            
            try {
                String query = "INSERT INTO student VALUES ('" + rollno + "', '" + name + "', '" + tffname + "','" + dob + "', '" + address + "', '" + email + "', '" + cla12 + "', '" + phone + "', '" + cla10 + "',  '" + aadhar + "', '" + course + "',  '" + branch + "')";

            
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inseted Successfully");
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
    
        new AddStudent();
    }
}

