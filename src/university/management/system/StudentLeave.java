package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class StudentLeave extends JFrame implements ActionListener {
    JDateChooser dcdate;
    Choice crollno, ctime;
    JButton cancel;
    JButton submit;
    StudentLeave(){
        setSize(500,500);
        setLocation(500,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        JLabel heading = new JLabel("Apply leave (Student)");
        heading.setBounds(40, 30, 300, 30);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(heading);
        
        //rollno choice
        JLabel lblrollno = new JLabel("Search by RollNo. ");
        lblrollno.setBounds(40,100,160,20);
        lblrollno.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(230, 100 , 210, 20);
        crollno.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  student");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        //DATE
        
        JLabel lbdate = new JLabel("Date");
        lbdate.setBounds(40,150,160,20);
        lbdate.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(lbdate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(230,150,210,30);
        dcdate.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(dcdate);
        
        //TIME CHOICE
        
        JLabel lbtime = new JLabel("From ");
        lbtime.setBounds(40,200,160,20);
        lbtime.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(lbtime);
        
        ctime = new Choice();
        ctime.setBounds(230,200,210,30);
        ctime.add("Full Day");
        ctime.add("Half Day");
        ctime.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(ctime);
        
        submit = new JButton ("SUBMIT");
        submit.setBounds(50,300,150,30);
        submit.setBackground(Color.pink);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(250,300,150,30);
        cancel.setBackground(Color.pink);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        //cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String rollno = (String)crollno.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"' , '"+date+"' , '"+duration+"')";
            
            try{
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentLeave();
    }
}
