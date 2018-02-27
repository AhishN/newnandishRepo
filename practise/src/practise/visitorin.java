package practise;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class visitorin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visitorin frame = new visitorin();
					frame.setVisible(true);
				} catch (Exception e) {JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public visitorin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFaunalInfo = new JButton("Faunal Info");
		btnFaunalInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				faunalinfo obj=new faunalinfo();
				obj.setVisible(true);
				visitorin.this.dispose();
				}
		});
		btnFaunalInfo.setBounds(259, 98, 124, 23);
		contentPane.add(btnFaunalInfo);
		
		JButton btnNewButton = new JButton("Book Passes");
		
		
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				visitenter obj=new visitenter();
				obj.setVisible(true);
				visitorin.this.dispose();
				
			}
		});
		btnNewButton.setBounds(259, 132, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame2 obj=new frame2();
				obj.setVisible(true);
				visitorin.this.dispose();
				
			}
		});
		btnNewButton_1.setBounds(259, 200, 124, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{cancelvisit obj=new cancelvisit();obj.setVisible(true);visitorin.this.dispose();}
				
				catch(Exception l){JOptionPane.showMessageDialog(null,l);}
			}
		});
		btnCancelBooking.setBounds(259, 166, 124, 23);
		contentPane.add(btnCancelBooking);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Wallpapers\\african-safaris.jpg"));
		lblNewLabel.setBounds(-443, -157, 1057, 554);
		contentPane.add(lblNewLabel);
	}
}
