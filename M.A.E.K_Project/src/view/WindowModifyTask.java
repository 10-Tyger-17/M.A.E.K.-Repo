package view;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Client;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;

public class WindowModifyTask extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldDueDate;
	private JTextField textFieldCategory;
	private JButton btnExit;
	private Controller cont;
	private JRadioButton rdbtnPending;
	private JRadioButton rdbtnCompleted;
	private ButtonGroup btnGroupPC;

	public WindowModifyTask(JFrame parent, Client client, Controller cont) {
		super(parent, true);
		this.cont = cont;
		setBounds(100, 100, 542, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 249, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModifyTask = new JLabel("Modify Task");
		lblModifyTask.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblModifyTask.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyTask.setBounds(0, 0, 526, 84);
		contentPanel.add(lblModifyTask);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(173, 181, 189));
		comboBox.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		comboBox.setBounds(19, 104, 490, 29);
		contentPanel.add(comboBox);
		
		rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnPending.setBounds(19, 164, 130, 34);
		contentPanel.add(rdbtnPending);
		rdbtnPending.setSelected(true);

		rdbtnCompleted = new JRadioButton("Completed");
		rdbtnCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnCompleted.setBounds(19, 201, 157, 34);
		contentPanel.add(rdbtnCompleted);
		btnGroupPC = new ButtonGroup();
		btnGroupPC.add(rdbtnPending);
		btnGroupPC.add(rdbtnCompleted);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(296, 164, 184, 34);
		contentPanel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldName.setBorder(null);
		textFieldName.setColumns(10);
		textFieldName.setBounds(295, 194, 214, 31);
		contentPanel.add(textFieldName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDescription.setBounds(19, 242, 184, 34);
		contentPanel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBackground(new Color(173, 181, 189));
		textFieldDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldDescription.setBorder(null);
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(19, 272, 214, 31);
		contentPanel.add(textFieldDescription);
		
		textFieldDueDate = new JTextField();
		textFieldDueDate.setBackground(new Color(173, 181, 189));
		textFieldDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldDueDate.setBorder(null);
		textFieldDueDate.setColumns(10);
		textFieldDueDate.setBounds(19, 355, 288, 31);
		contentPanel.add(textFieldDueDate);
		
		JLabel lblDueDate = new JLabel("Due date (yyyy-MM-dd)");
		lblDueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDueDate.setBounds(19, 318, 343, 34);
		contentPanel.add(lblDueDate);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBackground(new Color(173, 181, 189));
		textFieldCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldCategory.setBorder(null);
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(296, 272, 214, 31);
		contentPanel.add(textFieldCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(296, 238, 184, 34);
		contentPanel.add(lblCategory);
		
		btnExit = new JButton("Exit");
		btnExit.setBorder(null);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(414, 406, 112, 27);
		contentPanel.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
