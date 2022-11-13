package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ClientMain;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField IP;
	private JTextField port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setLayout(null);
		panel_1.setBounds(24, 11, 345, 276);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 65, 70, 25);
		panel_1.add(lblNewLabel);
		
		Name = new JTextField("Default");
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Name.setColumns(10);
		Name.setBounds(70, 61, 272, 33);
		panel_1.add(Name);
		
		JLabel lblNewLabel_1 = new JLabel("IP");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 117, 70, 25);
		panel_1.add(lblNewLabel_1);
		
		IP = new JTextField("localhost");
		IP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		IP.setColumns(10);
		IP.setBounds(70, 113, 272, 33);
		panel_1.add(IP);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 170, 70, 25);
		panel_1.add(lblNewLabel_2);
		
		port = new JTextField("3333");
		port.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		port.setColumns(10);
		port.setBounds(70, 166, 272, 33);
		panel_1.add(port);
		
		JButton Join_bt = new JButton("Join");
		Join_bt.setBackground(Color.WHITE);
		Join_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = IP.getText();
				int Port = Integer.parseInt(port.getText());
				try {
					new ClientMain(ip, Port, Name.getText()).start();
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Join_bt.setBounds(65, 225, 215, 33);
		panel_1.add(Join_bt);
		
		JLabel lblNewLabel_3 = new JLabel("Client", SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 11, 346, 27);
		panel_1.add(lblNewLabel_3);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
