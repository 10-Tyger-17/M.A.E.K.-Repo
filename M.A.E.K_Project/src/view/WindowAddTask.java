package view;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import exceptions.IllegalDateException;
import model.Client;
import model.Task;
import model.Task_state_Enum;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class WindowAddTask extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldCategory;
	private JTextField textFieldDueDate;
	private JLabel lblAddTask;
	private JLabel lblName;
	private JLabel lblDescription;
	private JLabel lblDueDate;
	private JRadioButton rdbtnPending;
	private JRadioButton rdbtnCompleted;
	private JLabel lblCategory;
	private JButton btnAdd;
	private ButtonGroup btnGroupPC;
	private Controller cont;
	private Client client;

	public WindowAddTask(JFrame parent, Client client, Controller cont) {
		super(parent, true);
		this.cont = cont;
		this.client = client;
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowAddTask.class.getResource("/visual/Assets/Logo.jpg")));
		setBounds(100, 100, 464, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblAddTask = new JLabel("Add Task");
		lblAddTask.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblAddTask.setBounds(45, 0, 356, 84);
		contentPanel.add(lblAddTask);

		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setBounds(28, 124, 391, 39);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(29, 93, 74, 34);
		contentPanel.add(lblName);

		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDescription.setBounds(28, 172, 168, 34);
		contentPanel.add(lblDescription);

		textFieldDescription = new JTextField();
		textFieldDescription.setBackground(new Color(173, 181, 189));
		textFieldDescription.setBounds(29, 203, 391, 39);
		contentPanel.add(textFieldDescription);
		textFieldDescription.setColumns(10);

		lblDueDate = new JLabel("Due date (yyyy-MM-dd)");
		lblDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDueDate.setBounds(29, 251, 372, 34);
		contentPanel.add(lblDueDate);

		rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnPending.setBounds(45, 336, 130, 34);
		contentPanel.add(rdbtnPending);
		rdbtnPending.setSelected(true);

		rdbtnCompleted = new JRadioButton("Completed");
		rdbtnCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnCompleted.setBounds(45, 370, 157, 34);
		contentPanel.add(rdbtnCompleted);
		btnGroupPC = new ButtonGroup();
		btnGroupPC.add(rdbtnPending);
		btnGroupPC.add(rdbtnCompleted);

		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(255, 331, 157, 34);
		contentPanel.add(lblCategory);

		textFieldCategory = new JTextField();
		textFieldCategory.setBackground(new Color(173, 181, 189));
		textFieldCategory.setBounds(255, 365, 165, 39);
		contentPanel.add(textFieldCategory);
		textFieldCategory.setColumns(10);

		textFieldDueDate = new JTextField();
		textFieldDueDate.setBackground(new Color(173, 181, 189));
		textFieldDueDate.setBounds(28, 282, 391, 39);
		contentPanel.add(textFieldDueDate);
		textFieldDueDate.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(33, 37, 41));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(28, 425, 391, 45);
		btnAdd.addActionListener(this);
		contentPanel.add(btnAdd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			try {
				checkDate();
				JOptionPane.showMessageDialog(this, "The task " + textFieldName.getText() + " is added succesfully", "Completed", JOptionPane.INFORMATION_MESSAGE);
				textFieldName.setText("");
				lblDescription.setText("");
				textFieldCategory.setText("");
				textFieldDueDate.setText("");
			} catch (IllegalDateException e1) {
				JOptionPane.showMessageDialog(this, "There is a problem with the date\n" + e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public void checkDate() throws IllegalDateException {
	    Task_state_Enum state = rdbtnPending.isSelected() ? Task_state_Enum.PENDING : Task_state_Enum.COMPLETED;

	    try {
	        LocalDate dueDate = LocalDate.parse(textFieldDueDate.getText());
	        
	        if (dueDate.isBefore(LocalDate.now())) {
	            throw new IllegalDateException("The date cant be in the past");
	        }
	        
	        cont.setTask(new Task(0, textFieldName.getText(), textFieldDescription.getText(), dueDate, state, client.getUsername(), textFieldCategory.getText()));
	    } catch (DateTimeParseException e) {
	        throw new IllegalDateException("Date format invalid. Must be yyyy-MM-dd.");
	    }
	}

}
