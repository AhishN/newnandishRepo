package practise;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class workinfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					workinfo frame = new workinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public workinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterWid = new JLabel("Enter WID :");
		lblEnterWid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterWid.setBounds(176, 61, 134, 17);
		contentPane.add(lblEnterWid);
		
		textField = new JTextField();
		textField.setBounds(320, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			
				     String sql="Select WID from Workers Where WID=?";
				    PreparedStatement st=con.prepareStatement(sql);
				 st.setString(1,textField.getText());
				     ResultSet rs=st.executeQuery();
				     int c=0;
				     while(rs.next())
				     {
				    	c++; }
				     if(c==1){
				     String sqll="select * from Workers Where WID=?";
				     PreparedStatement stm=con.prepareStatement(sqll);
				     stm.setString(1,textField.getText());
				     ResultSet rss=stm.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rss));
				     
				     
				     }
				     
				     else{JOptionPane.showMessageDialog(null, "Invalid WID");}
				     con.close();
				}
				catch (Exception a){System.out.println(a);}
			}
		});
		btnNext.setBounds(431, 61, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnAccountdedails = new JButton("Click here for Account Details");
		btnAccountdedails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			    String sqll="select * from Workaccount Where Workerid=?";
			     PreparedStatement stm=con.prepareStatement(sqll);
			     stm.setString(1,textField.getText());
			     ResultSet rss=stm.executeQuery();
			     table_1.setModel(DbUtils.resultSetToTableModel(rss));
			    
				}
				catch(Exception q)
				{System.out.println(q);}
			}
		});
		btnAccountdedails.setBounds(154, 147, 252, 20);
		contentPane.add(btnAccountdedails);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame2 obj=new frame2();
				obj.setVisible(true);
				workinfo.this.dispose();
			}
		});
		btnBack.setBounds(249, 317, 89, 23);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 584, 41);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 194, 584, 41);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\wildlife-pictures.jpg"));
		lblNewLabel.setBounds(-383, 0, 967, 541);
		contentPane.add(lblNewLabel);
	}
}