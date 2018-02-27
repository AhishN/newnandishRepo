package practise;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class donat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donat frame = new donat();
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
	public donat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnList = new JButton("View Donation list");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				donati obj=new donati();
				obj.setVisible(true);
				donat.this.dispose();
		    
			}
		});
		btnList.setBounds(200, 184, 151, 23);
		contentPane.add(btnList);
		
		JButton btnClickHereTo = new JButton("Click here to Donate");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insdonate obj=new insdonate();
				obj.setVisible(true);
				donat.this.dispose();
			}
		});
		btnClickHereTo.setBounds(200, 218, 151, 23);
		contentPane.add(btnClickHereTo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame2 obj=new frame2();
			obj.setVisible(true);
			donat.this.dispose();
			}
		});
		btnBack.setBounds(230, 266, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\wildlife_sanctuaries_of_india.jpg"));
		lblNewLabel.setBounds(0, 0, 599, 403);
		contentPane.add(lblNewLabel);
	}

}