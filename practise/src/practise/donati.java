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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class donati extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donati frame = new donati();
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
	public donati() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickToLoad = new JButton("Click to load");
		btnClickToLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try{Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
		    String sql="select * from Donation"; 
		    PreparedStatement st=con.prepareStatement(sql);
		     ResultSet rs=st.executeQuery();
		     table.setModel(DbUtils.resultSetToTableModel(rs));
		     con.close();
			
			}
			catch(Exception ee)
			{System.out.println(ee);}
				}
				
		});
		btnClickToLoad.setBounds(201, 43, 136, 23);
		contentPane.add(btnClickToLoad);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {donat obj=new donat();
			obj.setVisible(true);
			donati.this.dispose();
			}
		});
		btnBack.setBounds(235, 354, 89, 23);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 575, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\wildlife_sanctuaries_of_india.jpg"));
		label.setBounds(-35, 0, 628, 425);
		contentPane.add(label);
	}

}