package practise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dbaccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void refreshtable()
	{try{Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
    
    String sql="select * from Account";
    PreparedStatement st=con.prepareStatement(sql);
    ResultSet rs=st.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
     con.close();
}
catch(Exception l)
{JOptionPane.showMessageDialog(null,l);}}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbaccount frame = new dbaccount();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dbaccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try{Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
		     
		     String sql="select * from Account";
		     PreparedStatement st=con.prepareStatement(sql);
		     ResultSet rs=st.executeQuery();
		     table.setModel(DbUtils.resultSetToTableModel(rs));
		      con.close();
		}
		catch(Exception l)
		{JOptionPane.showMessageDialog(null,l);}
			}
		});
		btnLoadTable.setBounds(421, 11, 141, 23);
		contentPane.add(btnLoadTable);
		
		JLabel lblNewLabel = new JLabel("Maintenance_charges");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(0, 101, 132, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 98, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("faunal_feed_expences");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(0, 137, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 134, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("month");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(20, 172, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 169, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("year");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(20, 203, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(76, 200, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try{
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals("") )
			    {JOptionPane.showMessageDialog(null, "field missing");}
				else{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			    String sql="insert into Account(Maintenance_charges,faunal_feed_expences,month,year) values (?,?,?,?)"; 
			    PreparedStatement st=con.prepareStatement(sql);
			    st.setString(1, textField.getText());
			    st.setString(2, textField_1.getText());
			    st.setString(3, textField_2.getText());
			    st.setString(4, textField_3.getText());
			    st.execute();
			    con.close();
			    JOptionPane.showMessageDialog(null, "1 row inserted");}
			}
			catch(Exception l){JOptionPane.showMessageDialog(null,l);}
			refreshtable();}
		});
		btnInsert.setBounds(20, 242, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					if(textField_2.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="delete from Account where month='"+textField_2.getText()+"' "; 
				    
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row deleted");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				refreshtable();}
		});
		btnDelete.setBounds(20, 276, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="update  Account set Maintenance_charges='"+textField.getText()+"',faunal_feed_expences='"+textField_1.getText()+"',month='"+textField_2.getText()+"',year='"+textField_3.getText()+"'  where month='"+textField_2.getText()+"'"; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row updated");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);l.printStackTrace();}
				refreshtable();}
		});
		btnUpdate.setBounds(20, 307, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dbaupdate obj=new dbaupdate();
				obj.setVisible(true);
				dbaccount.this.dispose();
			}
			
		});
		btnBack.setBounds(20, 354, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 76, 425, 168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
					int row=table.getSelectedRow();
				    String month_=(table.getModel().getValueAt(row,2)).toString();
					String query="select * from Account where month='"+month_+"' ";
					PreparedStatement pst=con.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	 textField.setText(rs.getString("Maintenance_charges"));
					    textField_1.setText(rs.getString("faunal_feed_expences"));
					    textField_2.setText(rs.getString("month"));
					    textField_3.setText(rs.getString("year"));
					   
				    	
				    }
					con.close();}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null,ee);}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\rishikesh-wildlife-tour.jpg"));
		lblNewLabel_4.setBounds(-584, -31, 1226, 419);
		contentPane.add(lblNewLabel_4);
	}
}
