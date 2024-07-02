package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
   JButton search , update, print, add, cancel;
    StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);      
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20 , 150, 20);
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
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        
        search = new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
                
        print = new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
                
                
        setSize(900,700);
        setLocation(300,100);
        setVisible (true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
        
        else if (ae.getSource() == search){
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
            try{
               Conn c = new Conn(); 
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] srgs){
        new StudentLeaveDetails();
    }
}
