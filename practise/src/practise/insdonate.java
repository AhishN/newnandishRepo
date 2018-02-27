package practise;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class insdonate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insdonate frame = new insdonate();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public insdonate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDname = new JLabel("DName");
		lblDname.setForeground(Color.WHITE);
		lblDname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDname.setBounds(198, 119, 61, 14);
		contentPane.add(lblDname);
		
		JLabel lblDamount = new JLabel("Damount");
		lblDamount.setForeground(Color.WHITE);
		lblDamount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDamount.setBounds(184, 150, 75, 14);
		contentPane.add(lblDamount);
		
		JLabel lblPhNo = new JLabel("Ph no.");
		lblPhNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhNo.setForeground(Color.WHITE);
		lblPhNo.setBounds(199, 188, 46, 14);
		contentPane.add(lblPhNo);
		
		textField = new JTextField();
		textField.setBounds(255, 118, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(255, 149, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(255, 185, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDonate = new JButton("Donate"); 
		
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ 
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") )
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{String s = null;
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");   
				   
				    String sql="insert into Donation(Dname,DID,Damount,Phno) values (?,?,?,?)"; 
				    
				    PreparedStatement st=con.prepareStatement(sql);
				    String sqll="select * from did where ROWNUM=1"; 
				    PreparedStatement stm=con.prepareStatement(sqll);
				    ResultSet rs=stm.executeQuery(sqll);
				    st.setString(1, textField.getText());
					while(rs.next()){s=rs.getString("DID_");}
				    st.setString(2,s);
				    st.setString(3, textField_1.getText());
				    st.setString(4, textField_2.getText());
				    
				   
				    st.execute();
				    String sqlll="delete from did where ROWNUM=1"; 
				    PreparedStatement stmt=con.prepareStatement(sqlll);
		           stmt.execute();
				    con.close();
				 //   JOptionPane.showMessageDialog(null,("DID is '"+did+"'"));
   JOptionPane.showMessageDialog(null, "Donation sucessful");don obj=new don(s);
	obj.setVisible(true);
	insdonate.this.dispose();}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);System.out.println(l);}
			}
		});
		btnDonate.setBounds(236, 227, 89, 23);
		contentPane.add(btnDonate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 obj=new frame2();
				obj.setVisible(true);
				insdonate.this.dispose();
			}
		});
		btnBack.setBounds(236, 260, 89, 23);
		contentPane.add(btnBack);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\wildlife_sanctuaries_of_india.jpg"));
		lblNewLabel_1.setBounds(0, 0, 577, 504);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 72, 143, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
