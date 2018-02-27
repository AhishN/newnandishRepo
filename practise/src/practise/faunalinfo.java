package practise;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class faunalinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					faunalinfo frame = new faunalinfo();
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
	public faunalinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickToLoad = new JButton("Click to load");
		btnClickToLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
				     String sql="select * from faunalcategories";
				     PreparedStatement st=con.prepareStatement(sql);
				     ResultSet rs=st.executeQuery();
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				      con.close();
				}
				catch(Exception e)
				{System.out.println(e);}
				
			}
		});
		btnClickToLoad.setBounds(227, 27, 121, 23);
		contentPane.add(btnClickToLoad);
		
		JButton button = new JButton("<-- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				visitorin obj=new visitorin();
				obj.setVisible(true);
				faunalinfo.this.dispose();
			}
		});
		button.setBounds(254, 320, 89, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 566, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\Wildlife-Photos14.jpg"));
		lblNewLabel.setBounds(-74, 0, 933, 477);
		contentPane.add(lblNewLabel);
	}
}