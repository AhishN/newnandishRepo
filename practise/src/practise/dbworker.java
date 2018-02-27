package practise;
import java.sql.*; 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dbworker extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbworker frame = new dbworker();
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
	public dbworker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","oracle");
			     
			     String sql="select * from Workers";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception e)
			{System.out.println(e);}
			}
		});
		btnNewButton.setBounds(516, 23, 153, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(10, 79, 70, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setBounds(10, 104, 70, 14);
		contentPane.add(lblLastname);
		
		JLabel lblWid = new JLabel("WID");
		lblWid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWid.setForeground(Color.WHITE);
		lblWid.setBounds(20, 129, 46, 14);
		contentPane.add(lblWid);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(20, 160, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblPhNo = new JLabel("PH No.");
		lblPhNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhNo.setForeground(Color.WHITE);
		lblPhNo.setBounds(20, 191, 46, 14);
		contentPane.add(lblPhNo);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setBounds(20, 216, 46, 14);
		contentPane.add(lblEmailId);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDob.setForeground(Color.WHITE);
		lblDob.setBounds(20, 248, 46, 14);
		contentPane.add(lblDob);
		
		textField = new JTextField();
		textField.setBounds(81, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 101, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 127, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(81, 157, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(81, 188, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(81, 213, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(81, 245, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","SYSTEM","oracle");
				    String sql="insert into Workers (FirstName,LastName,WID,Gender,phoneno,emailid,DOB) values (?,?,?,?,?,?,?)"; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.setString(1, textField.getText());
				    st.setString(2, textField_1.getText());
				    st.setString(3, textField_2.getText());
				    st.setString(4, textField_3.getText());
				    st.setString(5, textField_4.getText());
				    st.setString(6, textField_5.getText());
				    st.setString(7, textField_6.getText());
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row inserted");
				}
				catch(Exception l){System.out.println(l);}
			}
		});
		btnInsert.setBounds(42, 294, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="delete from Workers where WID='"+textField_2.getText()+"' "; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row deleted");
				}
				catch(Exception l){System.out.println(l);}
			}
		});
		btnNewButton_1.setBounds(42, 328, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="update  Workers set FirstName='"+textField.getText()+"',LastName='"+textField_1.getText()+"',WID='"+textField_2.getText()+"',Gender='"+textField_3.getText()+"',phoneno='"+textField_4.getText()+"',emailid='"+textField_5.getText()+"',DOB='"+textField_6.getText()+"' where FirstName='"+textField.getText()+"'"; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row updated");
				}
				catch(Exception l){l.printStackTrace();System.out.println(l);}
			}
		});
		btnUpdate.setBounds(42, 362, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dbaupdate obj=new dbaupdate();
				obj.setVisible(true);
				dbworker.this.dispose();
			}
		});
		btnBack.setBounds(333, 391, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 53, 560, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			    int row=table.getSelectedRow();
			    String WID_=(table.getModel().getValueAt(row, 2)).toString();
			    String query="select * from Workers where WID='"+WID_+"' ";
			    PreparedStatement st=con.prepareStatement(query);
			    ResultSet rs=st.executeQuery();
			    while(rs.next())
			    {
			    	textField.setText(rs.getString("FirstName"));
			    	textField_1.setText(rs.getString("LastName"));
			    	textField_2.setText(rs.getString("WID"));
			    	textField_3.setText(rs.getString("Gender"));
			    	textField_4.setText(rs.getString("phoneno"));
			    	textField_5.setText(rs.getString("emailid"));
			    	textField_6.setText(rs.getString("DOB"));
			    }
			    con.close();
			    }
			catch(Exception l){l.printStackTrace();System.out.println(l);}
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\rishikesh-wildlife-tour.jpg"));
		lblNewLabel.setBounds(-488, -86, 1274, 597);
		contentPane.add(lblNewLabel);
	}
}