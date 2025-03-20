package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;

public class WindowSignUp extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblSignUp;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnSignUp;
	private Controller cont;
	
	

	/**
	 * Create the dialog.
	 */
	public WindowSignUp(JFrame parent,Controller cont) {
		super(parent,true);
		this.cont= cont;
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowSignUp.class.getResource("/visual/Assets/Logo.jpg")));
		setBounds(100, 100, 464, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setForeground(new Color(33, 37, 41));
		lblSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblSignUp.setBounds(60, 11, 326, 91);
		contentPanel.add(lblSignUp);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldName.setBorder(null);
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setBounds(32, 124, 391, 39);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(33, 37, 41));
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(33, 93, 74, 34);
		contentPanel.add(lblName);
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(33, 37, 41));
		lblAge.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblAge.setBounds(34, 172, 74, 34);
		contentPanel.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldAge.setBorder(null);
		textFieldAge.setBackground(new Color(173, 181, 189));
		textFieldAge.setBounds(33, 203, 391, 39);
		contentPanel.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(33, 37, 41));
		lblUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblUsername.setBounds(33, 251, 121, 34);
		contentPanel.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldUsername.setBorder(null);
		textFieldUsername.setBackground(new Color(173, 181, 189));
		textFieldUsername.setBounds(33, 282, 391, 39);
		contentPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(33, 37, 41));
		lblPassword.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblPassword.setBounds(32, 330, 122, 34);
		contentPanel.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldPassword.setBorder(null);
		textFieldPassword.setBackground(new Color(173, 181, 189));
		textFieldPassword.setBounds(33, 364, 391, 39);
		contentPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(33, 37, 41));
		btnSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
		btnSignUp.setBounds(32, 425, 391, 45);
		btnSignUp.addActionListener(this);
		contentPanel.add(btnSignUp);
	}
	
	public int changeColors(ArrayList<JTextField> fields) {
		int count;

		count = 0;
		for (JTextField i : fields) {
			if (i.getText().equals("")) {
				i.setBackground(new Color(255, 120, 120));
			} else {
				count++;
				i.setBackground(new Color(173, 181, 189));
			}
		}
		
		return count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnSignUp) {
			boolean valid=false;
			
			ArrayList<JTextField> fields=new ArrayList<JTextField>();
			fields.add(textFieldUsername);
			fields.add(textFieldName);
			fields.add(textFieldPassword);
			fields.add(textFieldAge);
			
			if (changeColors(fields) == 4) {
				try {
					cont.signUp(textFieldUsername.getText(), textFieldName.getText(), textFieldPassword.getText(), Integer.parseInt(textFieldAge.getText()));
					valid=true;
				} catch (NumberFormatException ex) {
					textFieldAge.setBackground(new Color(255, 120, 120));
				}
				
				if(valid) {
					this.dispose();
				}
			}
		}
		
	}
}
