package practise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME   :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(160, 153, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(160, 184, 98, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(268, 151, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		passwordField.setBounds(268, 182, 86, 20);
		
		
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{String usr="Nandish";
					String pass="qwerty123";
					String psw=passwordField.getText();
					if(pass.equals(psw))
					{//JOptionPane.showMessageDialog(null, "Correct Password");
					dbaupdate obj=new dbaupdate();
					obj.setVisible(true);
					Admin.this.dispose();Admin.this.getRootPane().setDefaultButton(btnNewButton);}
					else{JOptionPane.showMessageDialog(null, "Wrong Password");}
				}
				catch(Exception e){System.out.println(e);}
			}
		});
		btnNewButton.setBounds(268, 232, 86, 23);
		contentPane.add(btnNewButton);
		Admin.this.getRootPane().setDefaultButton(btnNewButton);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame2 obj =new frame2();
				obj.setVisible(true);
				Admin.this.dispose();}
		});
		btnCancel.setBounds(268, 266, 86, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ravindra\\Downloads\\Wildlife-Photos14.jpg"));
		lblNewLabel.setBounds(-65, -90, 1247, 634);
		contentPane.add(lblNewLabel);
	}
}
