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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dbfaunalinfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void refreshtable()
	{
		try{Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
	     
	     String sql="select * from faunalcategories";
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
					dbfaunalinfo frame = new dbfaunalinfo();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dbfaunalinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
			     
			     String sql="select * from faunalcategories";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{JOptionPane.showMessageDialog(null,l);}
			}
		});
		btnLoadTable.setBounds(424, 11, 141, 23);
		contentPane.add(btnLoadTable);
		
		JLabel lblNewLabel = new JLabel("Bird");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(22, 98, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(78, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBno = new JLabel("BNO");
		lblBno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBno.setForeground(Color.WHITE);
		lblBno.setBounds(22, 123, 46, 14);
		contentPane.add(lblBno);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 120, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Terestrial");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 148, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 145, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTno = new JLabel("TNO");
		lblTno.setForeground(Color.WHITE);
		lblTno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTno.setBounds(22, 173, 46, 14);
		contentPane.add(lblTno);
		
		textField_3 = new JTextField();
		textField_3.setBounds(78, 170, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAquatic = new JLabel("Aquatic");
		lblAquatic.setForeground(Color.WHITE);
		lblAquatic.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAquatic.setBounds(10, 198, 58, 14);
		contentPane.add(lblAquatic);
		
		textField_4 = new JTextField();
		textField_4.setBounds(78, 195, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAno = new JLabel("ANO");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAno.setBounds(22, 223, 46, 14);
		contentPane.add(lblAno);
		
		textField_5 = new JTextField();
		textField_5.setBounds(78, 220, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblOtherspecies = new JLabel("Other species");
		lblOtherspecies.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtherspecies.setForeground(Color.WHITE);
		lblOtherspecies.setBounds(0, 248, 84, 14);
		contentPane.add(lblOtherspecies);
		
		textField_6 = new JTextField();
		textField_6.setBounds(78, 245, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblOno = new JLabel("ONO");
		lblOno.setForeground(Color.WHITE);
		lblOno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOno.setBounds(22, 276, 46, 14);
		contentPane.add(lblOno);
		
		textField_7 = new JTextField();
		textField_7.setBounds(78, 273, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try{
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals("") ||textField_4.getText().equals("") || textField_5.getText().equals("") ||textField_6.getText().equals("")||textField_7.getText().equals(""))
			    {JOptionPane.showMessageDialog(null, "field missing");}
				else{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
			    String sql="insert into faunalcategories(Birds,Bno,Terestrial,Tno,Aquatic,Ano,Otherspecies,Ono) values (?,?,?,?,?,?,?,?)"; 
			    PreparedStatement st=con.prepareStatement(sql);
			    st.setString(1, textField.getText());
			    st.setString(2, textField_1.getText());
			    st.setString(3, textField_2.getText());
			    st.setString(4, textField_3.getText());
			    st.setString(5, textField_4.getText());
			    st.setString(6, textField_5.getText());
			    st.setString(7, textField_6.getText());
			    st.setString(8, textField_7.getText());
			    st.execute();
			    con.close();
			   
			     JOptionPane.showMessageDialog(null, "1 row inserted");}
			}
			catch(Exception l){JOptionPane.showMessageDialog(null,l);}
			
			refreshtable();}
		});
		btnInsert.setBounds(36, 312, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(textField.getText().equals("")){JOptionPane.showMessageDialog(null, "field missing");}
				else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
				    String sql="delete from faunalcategories where Birds='"+textField.getText()+"' "; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row deleted");
				}
				}
				
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				refreshtable();}
		});
		btnDelete.setBounds(36, 338, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals("") ||textField_4.getText().equals("") || textField_5.getText().equals("") ||textField_6.getText().equals("")||textField_7.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
				    String sql="update  faunalcategories set Birds='"+textField.getText()+"',Bno='"+textField_1.getText()+"',Terestrial='"+textField_2.getText()+"',Tno='"+textField_3.getText()+"',Aquatic='"+textField_4.getText()+"',Ano='"+textField_5.getText()+"',Otherspecies='"+textField_6.getText()+"',Ono='"+textField_7.getText()+"' where Birds='"+textField.getText()+"'"; 
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row updated");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				refreshtable();}
		});
		btnUpdate.setBounds(36, 371, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dbaupdate obj=new dbaupdate();
			obj.setVisible(true);
			dbfaunalinfo.this.dispose();
			}
		});
		btnBack.setBounds(295, 371, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 71, 461, 166);
		contentPane.add(scrollPane);
		
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					try{Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
						int row=table.getSelectedRow();
					    String Birds_=(table.getModel().getValueAt(row,0)).toString();
						String query="select * from faunalcategories where Birds='"+Birds_+"' ";
						PreparedStatement pst=con.prepareStatement(query);
					    ResultSet rs=pst.executeQuery();
					    while(rs.next())
					    {
					    	 textField.setText(rs.getString("Birds"));
						    textField_1.setText(rs.getString("Bno"));
						    textField_2.setText(rs.getString("Terestrial"));
						    textField_3.setText(rs.getString("Tno"));
						    textField_4.setText(rs.getString("Aquatic"));
						     textField_5.setText(rs.getString("Ano"));
						    textField_6.setText(rs.getString("Otherspecies"));
						    textField_7.setText(rs.getString("Ono"));
					    }
						con.close();}
					catch(Exception ee)
					{JOptionPane.showMessageDialog(null,ee);}
				}
			});
			scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\rishikesh-wildlife-tour.jpg"));
		lblNewLabel_2.setBounds(-598, 0, 1233, 405);
		contentPane.add(lblNewLabel_2);
	}
}