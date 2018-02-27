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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dbdonate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	
	public void refreshtable()
	{
		try{Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
	     
	     String sql="select * from Donation";
	     PreparedStatement st=con.prepareStatement(sql);
	     ResultSet rs=st.executeQuery();
	     table.setModel(DbUtils.resultSetToTableModel(rs));
	      con.close();
	}
	catch(Exception l)
	{System.out.println(l);}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbdonate frame = new dbdonate();
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
	public dbdonate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDid = new JLabel("DID");
		lblDid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDid.setForeground(Color.WHITE);
		lblDid.setBounds(10, 75, 46, 14);
		contentPane.add(lblDid);
		
		textField = new JTextField();
		textField.setBounds(47, 72, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals(""))
				    {JOptionPane.showMessageDialog(null, "field missing");}
					else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="delete from Donation where DID='"+textField.getText()+"' "; 
				    
				    PreparedStatement st=con.prepareStatement(sql);
				    st.execute();
				    
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row deleted");}
				}
				catch(Exception l){System.out.println(l);}
				refreshtable();}
		});
		btnDelete.setBounds(20, 106, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			     
			     String sql="select * from Donation";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{System.out.println(l);}
			}
		});
		btnLoadTable.setBounds(355, 11, 116, 23);
		contentPane.add(btnLoadTable);
		
		JButton button = new JButton("<--  Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dbaupdate obj=new dbaupdate();
			obj.setVisible(true);
			dbdonate.this.dispose();
			}
		});
		button.setBounds(261, 267, 89, 23);
		contentPane.add(button);
		
		JButton btnTotalAndAvg = new JButton("Total And Avg");
		btnTotalAndAvg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			     
			     String sql="select * from  TotalDonations ";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table_1.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{System.out.println(l);}
			}
		});
		btnTotalAndAvg.setBounds(20, 160, 113, 23);
		contentPane.add(btnTotalAndAvg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\Wildlife-Photos14.jpg"));
		lblNewLabel.setBounds(0, 0, 578, 318);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 60, 440, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
					int row=table.getSelectedRow();
				    String DID_=(table.getModel().getValueAt(row,1)).toString();
					String query="select * from Donation where DID='"+DID_+"' ";
					PreparedStatement pst=con.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	 textField.setText(rs.getString("DID"));
					    
					    
				    	
				    }
					con.close();}
				catch(Exception ee)
				{ee.printStackTrace();}
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 194, 125, 39);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}

}