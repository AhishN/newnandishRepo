package practise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;




public class cancelvisit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelvisit frame = new cancelvisit();
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
	public cancelvisit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVid = new JLabel("VID");
		lblVid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVid.setForeground(Color.WHITE);
		lblVid.setBounds(254, 89, 46, 14);
		contentPane.add(lblVid);
		
		textField = new JTextField();
		textField.setBounds(310, 87, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Cancel Booking");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(textField.getText().equals(""))
			    {JOptionPane.showMessageDialog(null, "field missing");}
				else{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kalyan12#");
				    String sql="delete from visitor where VID='"+textField.getText()+"' "; 
			
				    PreparedStatement st=con.prepareStatement(sql);
			
			
				    st.execute();
				    
				    con.close();
				    JOptionPane.showMessageDialog(null, "Booking Cancelled");}
				}
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
				}
		});
		btnDelete.setBounds(254, 114, 132, 28);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			visitorin obj=new visitorin();
			obj.setVisible(true);
			cancelvisit.this.dispose();
			}
		});
		btnBack.setBounds(278, 153, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Wallpapers\\african-safaris.jpg"));
		lblNewLabel.setBounds(0, -157, 991, 577);
		contentPane.add(lblNewLabel);
		
		
	}

}
