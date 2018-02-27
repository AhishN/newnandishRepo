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

public class dbworkaccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public void refreshtable()
	{
		try{Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
	     
	     String sql="select * from workaccount";
	     PreparedStatement st=con.prepareStatement(sql);
	     ResultSet rs=st.executeQuery();
	     table.setModel(DbUtils.resultSetToTableModel(rs));
	      con.close();
	}
	catch(Exception l)
	{JOptionPane.showMessageDialog(null,l);}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbworkaccount frame = new dbworkaccount();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dbworkaccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			     
			     String sql="select * from workaccount";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{JOptionPane.showMessageDialog(null,l);}
			
				}
		});
		btnNewButton.setBounds(464, 11, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Workerid");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 132, 68, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 129, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 170, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 167, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("wmonth");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 207, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 204, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("wyear");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 246, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 243, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="insert into workaccount(Workerid,Salary,wmonth,wyear) values (?,?,?,?)"; 
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
		btnInsert.setBounds(42, 296, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="update  workaccount set Workerid='"+textField.getText()+"',Salary='"+textField_1.getText()+"',wmonth='"+textField_2.getText()+"',wyear='"+textField_3.getText()+"' where Workerid='"+textField.getText()+"'"; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row updated");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				refreshtable();}
		});
		btnNewButton_1.setBounds(42, 330, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			dbaupdate obj=new dbaupdate();
			obj.setVisible(true);
			dbworkaccount.this.dispose();
			}
		});
		btnBack.setBounds(42, 364, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnClickToKnow = new JButton("Click to know avg and total");
		btnClickToKnow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			     
			     String sql="select * from  totalsalary ";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table_1.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{JOptionPane.showMessageDialog(null,l);}
				 
			}
		});
		btnClickToKnow.setBounds(212, 296, 205, 23);
		contentPane.add(btnClickToKnow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 70, 434, 179);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
					int row=table.getSelectedRow();
				    String Workerid_=(table.getModel().getValueAt(row,0)).toString();
					String query="select * from workaccount where Workerid='"+Workerid_+"' ";
					PreparedStatement pst=con.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	 textField.setText(rs.getString("Workerid"));
					    textField_1.setText(rs.getString("Salary"));
					    textField_2.setText(rs.getString("wmonth"));
					    textField_3.setText(rs.getString("wyear"));
					    
				    }
					con.close();}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null,ee);}
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(238, 333, 159, 44);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\rishikesh-wildlife-tour.jpg"));
		lblNewLabel_4.setBounds(-472, 0, 1090, 402);
		contentPane.add(lblNewLabel_4);
	}

}
