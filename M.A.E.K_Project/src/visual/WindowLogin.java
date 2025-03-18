package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WindowLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public WindowLogin() {
		setBackground(new Color(173, 181, 189));
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowLogin.class.getResource("/visual/Assets/Logo.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 224, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignUp = new JButton("Become a member");
		btnSignUp.setForeground(new Color(33, 37, 41));
		btnSignUp.setBorder(new LineBorder(new Color(33, 37, 41), 5));
		btnSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
		btnSignUp.setBackground(new Color(222, 226, 230));
		btnSignUp.setBounds(46, 400, 659, 45);
		contentPane.add(btnSignUp);
		
		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setForeground(new Color(222, 226, 230));
		btnLogIn.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
		btnLogIn.setBorder(null);
		btnLogIn.setBackground(new Color(33, 37, 41));
		btnLogIn.setBounds(46, 327, 659, 45);
		contentPane.add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(173, 181, 189));
		passwordField.setBounds(46, 240, 659, 40);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblPassword.setBounds(46, 206, 131, 34);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblUsername.setBounds(47, 120, 131, 34);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 181, 189));
		textField.setBounds(46, 150, 659, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(33, 37, 41));
		lblWelcome.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(46, 11, 658, 84);
		contentPane.add(lblWelcome);
	}
}
