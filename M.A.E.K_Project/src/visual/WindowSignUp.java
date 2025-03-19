package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;

public class WindowSignUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WindowSignUp dialog = new WindowSignUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WindowSignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowSignUp.class.getResource("/visual/Assets/Logo.jpg")));
		setBounds(100, 100, 464, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setForeground(new Color(33, 37, 41));
		lblSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblSignUp.setBounds(60, 11, 326, 91);
		contentPanel.add(lblSignUp);
		
		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setBounds(32, 124, 391, 39);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(33, 37, 41));
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(33, 93, 74, 34);
		contentPanel.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(33, 37, 41));
		lblAge.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblAge.setBounds(34, 172, 74, 34);
		contentPanel.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setBackground(new Color(173, 181, 189));
		textFieldAge.setBounds(33, 203, 391, 39);
		contentPanel.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(33, 37, 41));
		lblUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblUsername.setBounds(33, 251, 121, 34);
		contentPanel.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBackground(new Color(173, 181, 189));
		textFieldUsername.setBounds(33, 282, 391, 39);
		contentPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(33, 37, 41));
		lblPassword.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblPassword.setBounds(32, 330, 122, 34);
		contentPanel.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBackground(new Color(173, 181, 189));
		textFieldPassword.setBounds(33, 364, 391, 39);
		contentPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(33, 37, 41));
		btnSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
		btnSignUp.setBounds(32, 425, 391, 45);
		contentPanel.add(btnSignUp);
	}
}
