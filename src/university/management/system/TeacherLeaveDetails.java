package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class TeacherLeaveDetails extends JFrame implements ActionListener{
    
    Choice cempno;
    JTable table;
   JButton search ,  print,  cancel;
    TeacherLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);      
        setLayout(null);
        
        JLabel heading = new JLabel("Search by emp Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cempno = new Choice();
        cempno.setBounds(180, 20 , 150, 20);
        add(cempno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  Teacher");
            while (rs.next()){
                cempno.add(rs.getString("empno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  TeacherLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
         JScrollPane jsp = new  JScrollPane(table);
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
            String query = "select * from TeacherLeave where empno = '"+cempno.getSelectedItem()+"'";
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
        new TeacherLeaveDetails();
    }
}
