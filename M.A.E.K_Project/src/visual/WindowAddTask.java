package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class WindowAddTask extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldCategory;
	private JTextField textFieldDueDate;

	

	/**
	 * Create the dialog.
	 */
	public WindowAddTask() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowAddTask.class.getResource("/visual/Assets/Logo.jpg")));
		setBounds(100, 100, 464, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Task");
		lblNewLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblNewLabel.setBounds(45, 0, 356, 84);
		contentPanel.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setBounds(28, 124, 391, 39);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(29, 93, 74, 34);
		contentPanel.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDescription.setBounds(28, 172, 168, 34);
		contentPanel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBackground(new Color(173, 181, 189));
		textFieldDescription.setBounds(29, 203, 391, 39);
		contentPanel.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		JLabel lblDueDate = new JLabel("Due date");
		lblDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDueDate.setBounds(29, 251, 121, 34);
		contentPanel.add(lblDueDate);
		
		JRadioButton rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnPending.setBounds(45, 336, 130, 34);
		contentPanel.add(rdbtnPending);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Completed");
		rdbtnNewRadioButton.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnNewRadioButton.setBounds(45, 370, 157, 34);
		contentPanel.add(rdbtnNewRadioButton);
		
		JLabel lblCategory = new JLabel("Category");
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(33, 37, 41));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(28, 425, 391, 45);
		contentPanel.add(btnAdd);
	}
}
