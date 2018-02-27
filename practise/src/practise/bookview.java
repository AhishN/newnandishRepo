package practise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class bookview extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookview frame = new bookview();
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
	public bookview(String VID_) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickToView = new JButton("Click to view booking detail");
		btnClickToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");   
				   
					String sqll="select * from visitor where VID='"+VID_+"'"; 
			    PreparedStatement stm=con.prepareStatement(sqll);
			    ResultSet rs=stm.executeQuery(sqll);
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			    con.close();
			    }
				catch(Exception t){JOptionPane.showMessageDialog(null,t);}
				
				
				
			}
		});
		JButton button = new JButton("<--Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {visitorin obj=new visitorin();
			obj.setVisible(true);
			bookview.this.dispose();
			}
		});
		btnClickToView.setBounds(217, 22, 215, 23);
		contentPane.add(btnClickToView);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kalyanaraman\\Desktop\\images\\african-safaris.jpg"));
		lblNewLabel.setBounds(-369, -150, 987, 585);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 66, 561, 42);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

	public bookview() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 644, 474);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnClickToView = new JButton("Click to view booking detail");
	btnClickToView.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			
		}
	});
	btnClickToView.setBounds(217, 22, 215, 23);
	contentPane.add(btnClickToView);
	
	JButton button = new JButton("<--Back");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {visitorin obj=new visitorin();
		obj.setVisible(true);
		bookview.this.dispose();
		}
	});
	button.setBounds(283, 131, 89, 23);
	contentPane.add(button);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setIcon(new ImageIcon("F:\\Wallpapers\\african-safaris.jpg"));
	lblNewLabel.setBounds(-426, -150, 1054, 585);
	contentPane.add(lblNewLabel);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(23, 66, 561, 42);
	contentPane.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);

		// TODO Auto-generated constructor stub
	}
}
