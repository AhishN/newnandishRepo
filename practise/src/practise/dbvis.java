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

public class dbvis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	public void refreshtable()
	{
		try{Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
	     
	     String sql="select * from visitor";
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
					dbvis frame = new dbvis();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dbvis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVid = new JLabel("VID");
		lblVid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVid.setForeground(Color.WHITE);
		lblVid.setBounds(10, 60, 46, 14);
		contentPane.add(lblVid);
		
		textField = new JTextField();
		textField.setBounds(52, 58, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(textField.getText().equals(""))
			    {JOptionPane.showMessageDialog(null, "field missing");}
				else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				    String sql="delete from visitor where VID='"+textField.getText()+"' "; 
			
				    PreparedStatement st=con.prepareStatement(sql);
			
			
				    st.execute();
				    
				    con.close();
				    JOptionPane.showMessageDialog(null, "1 row deleted");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				refreshtable();}
		});
		btnDelete.setBounds(32, 86, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
			     
			     String sql="select * from visitor";
			     PreparedStatement st=con.prepareStatement(sql);
			     ResultSet rs=st.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			      con.close();
			}
			catch(Exception l)
			{JOptionPane.showMessageDialog(null,l);}
			}
		});
		btnLoadTable.setBounds(373, 23, 126, 23);
		contentPane.add(btnLoadTable);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dbaupdate obj=new dbaupdate();
			obj.setVisible(true);
			dbvis.this.dispose();
			}
		});
		btnBack.setBounds(32, 120, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 62, 433, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
					int row=table.getSelectedRow();
				    String VID_=(table.getModel().getValueAt(row,0)).toString();
					String query="select * from Visitor where VID='"+VID_+"' ";
					PreparedStatement pst=con.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	 textField.setText(rs.getString("VID"));
					    
					    
				    	
				    }
					con.close();}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null,ee);}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\rishikesh-wildlife-tour.jpg"));
		lblNewLabel.setBounds(-711, 0, 1292, 340);
		contentPane.add(lblNewLabel);
	}

}
