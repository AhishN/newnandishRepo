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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class visitenter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visitenter frame = new visitenter();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public visitenter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVname = new JLabel("First Name");
		lblVname.setForeground(Color.WHITE);
		lblVname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVname.setBounds(169, 74, 89, 14);
		contentPane.add(lblVname);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastname.setEnabled(true);
		lblLastname.setBounds(183, 109, 86, 14);
		contentPane.add(lblLastname);
		
		JLabel lblA = new JLabel("Age");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(212, 134, 46, 14);
		contentPane.add(lblA);
		
		JLabel lblPhno = new JLabel("phno");
		lblPhno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhno.setForeground(Color.WHITE);
		lblPhno.setBounds(212, 159, 46, 14);
		contentPane.add(lblPhno);
		
		textField = new JTextField();
		textField.setBounds(260, 71, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 102, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(260, 131, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(260, 156, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") )
			    {JOptionPane.showMessageDialog(null, "field missing");}
				else{String s = null;
				try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");   
			   
			    String sql="insert into Visitor(VID,age,vfname,vlname,Pheno) values (?,?,?,?,?)"; 
			    
			    PreparedStatement st=con.prepareStatement(sql);
			    String sqll="select * from vid where ROWNUM=1"; 
			    PreparedStatement stm=con.prepareStatement(sqll);
			    ResultSet rs=stm.executeQuery(sqll);
			    while(rs.next()){ s=rs.getString("VID_");}
			    st.setString(1,s);
			    st.setString(3, textField.getText());
				
			    st.setString(4, textField_1.getText());
			    st.setString(2, textField_2.getText());
			    st.setString(5, textField_3.getText());
			    
			   
			    st.execute();
			    
			    String sqlll="delete from vid where ROWNUM=1"; 
			    PreparedStatement stmt=con.prepareStatement(sqlll);
	           stmt.execute();
			    con.close();
JOptionPane.showMessageDialog(null, "Booking sucessful");
bookview obj=new bookview(s);
obj.setVisible(true);
visitenter.this.dispose();
				}
				catch(Exception t){JOptionPane.showMessageDialog(null,t);}
				}}
				
			
		});
		btnBook.setBounds(247, 184, 89, 23);
		contentPane.add(btnBook);
		
		JButton btnClickHereTo = new JButton("Back");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {visitorin obj= new visitorin();
			obj.setVisible(true);
			visitenter.this.dispose();
			}
		});
		btnClickHereTo.setBounds(247, 216, 99, 23);
		contentPane.add(btnClickHereTo);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("F:\\Wallpapers\\african-safaris.jpg"));
		lblNewLabel.setBounds(-434, -172, 1007, 543);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 23, 174, 47);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
