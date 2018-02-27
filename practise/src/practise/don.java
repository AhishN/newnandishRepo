package practise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class don extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					don frame = new don();
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
	public don() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickToView = new JButton("Click to view donation details");
		btnClickToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnClickToView.setBounds(212, 11, 191, 23);
		contentPane.add(btnClickToView);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				donat obj=new donat();
				obj.setVisible(true);
				don.this.dispose();
			}
		});
		button.setBounds(266, 164, 89, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\wildlife_sanctuaries_of_india.jpg"));
		lblNewLabel_1.setBounds(0, 0, 577, 504);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 67, 412, 46);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);


	}

	
	public don(String DID_) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnClickToView = new JButton("Click to view donation details");
		
		btnClickToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");   
			   
				String sqll="select * from donation where DID='"+DID_+"'"; 
		    PreparedStatement stm=con.prepareStatement(sqll);
		    ResultSet rs=stm.executeQuery(sqll);
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		    con.close();
		    }
			catch(Exception t){JOptionPane.showMessageDialog(null,t);}
				
				
			}
		});

		
		btnClickToView.setBounds(223, 11, 191, 23);
		contentPane.add(btnClickToView);
		
		
		JButton button = new JButton("<--Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				donat obj=new donat();
				obj.setVisible(true);
				don.this.dispose();
			}
		});
		button.setBounds(230, 162, 89, 23);
		contentPane.add(button);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kalyanaraman\\Desktop\\wildlife_sanctuaries_of_india.jpg"));
		lblNewLabel_1.setBounds(0, 0, 577, 504);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 67, 412, 46);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);


	}
}