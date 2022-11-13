package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Client_GUI extends JFrame {

	private JPanel contentPane;
	public JTextArea textArea;
	public JTextField textField;
	public JButton send;
	public JPanel panel;
	private JLabel Title;
	public String nameUser = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_GUI frame = new Client_GUI("", "", 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client_GUI(String name, String ip, int port) {
		super("Client - " + name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(23, 11, 345, 292);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 345, 204);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(0, 258, 260, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		send = new JButton("send");
		send.setBackground(Color.WHITE);
		send.setBounds(278, 258, 67, 34);
		panel.add(send);
		
		Title = new JLabel(name + " | " + ip + " | " + port, SwingConstants.CENTER);
		Title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Title.setBounds(0, 0, 345, 32);
		panel.add(Title);
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
