package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import controller.Controller;
import model.Client;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * The WindowLogin class represents the login window for the application.
 * It extends JFrame and implements ActionListener to handle user interactions.
 */
public class WindowLogin extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textField;
    private JButton btnSignUp;
    private JButton btnLogIn;
    private JLabel lblWelcome;
    private Controller cont;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private Client client;

    /**
     * Constructs a new WindowLogin frame.
     *
     * @param cont the controller object
     */
    public WindowLogin(Controller cont) {
        this.cont = cont;
        setTitle("M.A.E.K.");
        setBackground(new Color(173, 181, 189));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(WindowLogin.class.getResource("/view/Assets/Logo.jpg")));
        setResizable(false);
        setBounds(100, 100, 800, 530);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(224, 224, 224));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnSignUp = new JButton("Become a member");
        btnSignUp.setForeground(new Color(33, 37, 41));
        btnSignUp.setBorder(new LineBorder(new Color(33, 37, 41), 5));
        btnSignUp.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
        btnSignUp.setBackground(new Color(222, 226, 230));
        btnSignUp.setBounds(46, 400, 659, 45);
        btnSignUp.addActionListener(this);
        contentPane.add(btnSignUp);

        btnLogIn = new JButton("Sign In");
        btnLogIn.setForeground(new Color(222, 226, 230));
        btnLogIn.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
        btnLogIn.setBorder(null);
        btnLogIn.setBackground(new Color(33, 37, 41));
        btnLogIn.setBounds(46, 327, 659, 45);
        btnLogIn.addActionListener(this);
        contentPane.add(btnLogIn);

        passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        passwordField.setBackground(new Color(173, 181, 189));
        passwordField.setBounds(46, 240, 659, 40);
        contentPane.add(passwordField);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        lblPassword.setBounds(46, 206, 131, 34);
        contentPane.add(lblPassword);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        lblUsername.setBounds(47, 120, 131, 34);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBorder(null);
        textField.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        textField.setBackground(new Color(173, 181, 189));
        textField.setBounds(46, 150, 659, 40);
        contentPane.add(textField);
        textField.setColumns(10);

        lblWelcome = new JLabel("Welcome");
        lblWelcome.setForeground(new Color(33, 37, 41));
        lblWelcome.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(46, 11, 658, 84);
        contentPane.add(lblWelcome);
    }

    /**
     * Handles action events for the login and sign-up buttons.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogIn) {
            client = cont.login(textField.getText(), new String(passwordField.getPassword()));
            if (client == null) {
                textField.setBackground(new Color(255, 120, 120));
                passwordField.setBackground(new Color(255, 120, 120));
                JOptionPane.showMessageDialog(this, "Enter valid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                WindowMenu ventana = new WindowMenu(client, cont);
                ventana.setVisible(true);
                this.dispose();
            }
        } else if (e.getSource() == btnSignUp) {
            WindowSignUp windowSignUp = new WindowSignUp(this, cont);
            windowSignUp.setVisible(true);
        }
    }
}