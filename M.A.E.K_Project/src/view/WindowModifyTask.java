package view;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import exceptions.IllegalDateException;
import model.Client;
import model.Task;
import model.Task_state_Enum;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
	private JButton btnModify;
	private JComboBox<Task> comboBox;

	public WindowModifyTask(JFrame parent, Client client, Controller cont) {
		super(parent, true);
		this.cont = cont;
		setBounds(100, 100, 542, 472);
		setTitle("M.A.E.K.");
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

		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		comboBox.setBackground(new Color(173, 181, 189));
		comboBox.setModel(new DefaultComboBoxModel<>(cont.getTasks(client).toArray(new Task[0])));
		comboBox.setBounds(19, 104, 490, 29);
		contentPanel.add(comboBox);
		comboBox.setSelectedIndex(-1);

		rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnPending.setBounds(19, 152, 130, 34);
		contentPanel.add(rdbtnPending);
		rdbtnPending.setSelected(true);

		rdbtnCompleted = new JRadioButton("Completed");
		rdbtnCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		rdbtnCompleted.setBounds(19, 189, 157, 34);
		contentPanel.add(rdbtnCompleted);
		btnGroupPC = new ButtonGroup();
		btnGroupPC.add(rdbtnPending);
		btnGroupPC.add(rdbtnCompleted);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(294, 152, 184, 34);
		contentPanel.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setBorder(null);
		textFieldName.setColumns(10);
		textFieldName.setBounds(295, 182, 214, 31);
		contentPanel.add(textFieldName);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDescription.setBounds(16, 230, 184, 34);
		contentPanel.add(lblDescription);

		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
		textFieldDescription.setBackground(new Color(173, 181, 189));
		textFieldDescription.setBorder(null);
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(18, 264, 214, 31);
		contentPanel.add(textFieldDescription);

		textFieldDueDate = new JTextField();
		textFieldDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
		textFieldDueDate.setBackground(new Color(173, 181, 189));
		textFieldDueDate.setBorder(null);
		textFieldDueDate.setColumns(10);
		textFieldDueDate.setBounds(18, 352, 112, 31);
		contentPanel.add(textFieldDueDate);

		JLabel lblDueDate = new JLabel("Due date (yyyy-MM-dd)");
		lblDueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDueDate.setBounds(16, 318, 343, 34);
		contentPanel.add(lblDueDate);

		textFieldCategory = new JTextField();
		textFieldCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
		textFieldCategory.setBackground(new Color(173, 181, 189));
		textFieldCategory.setBorder(null);
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(295, 264, 214, 31);
		contentPanel.add(textFieldCategory);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(294, 230, 184, 34);
		contentPanel.add(lblCategory);

		btnExit = new JButton("Exit");
		btnExit.setBorder(null);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(414, 406, 112, 27);
		btnExit.addActionListener(this);
		contentPanel.add(btnExit);

		btnModify = new JButton("Modify");
		btnModify.setForeground(Color.WHITE);
		btnModify.setFont(new Font("Dialog", Font.PLAIN, 36));
		btnModify.setBackground(new Color(33, 37, 41));
		btnModify.setBounds(162, 377, 200, 45);
		btnModify.addActionListener(this);
		contentPanel.add(btnModify);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			dispose();
		} else if (e.getSource() == btnModify) {
			if (comboBox.getSelectedIndex() != -1) {
				try {
					Task task = (Task) comboBox.getSelectedItem();
					LocalDate dueDate = checkDate();
					String name = textFieldName.getText().isEmpty() ? null : textFieldName.getText();
					String description = textFieldDescription.getText().isEmpty() ? null : textFieldDescription.getText();
					String category = textFieldCategory.getText().isEmpty() ? null : textFieldCategory.getText();
					Task_state_Enum state = rdbtnPending.isSelected() ? Task_state_Enum.PENDING : Task_state_Enum.COMPLETED;

					if (!cont.modifyTask(new Task(task.getId(), name, description, dueDate, state, task.getUsername(), category))) {
						JOptionPane.showMessageDialog(this, "The task has been modified successfully", "Completed", JOptionPane.INFORMATION_MESSAGE);
						textFieldName.setText("");
						textFieldDescription.setText("");
						textFieldCategory.setText("");
						textFieldDueDate.setText("");
						rdbtnPending.setSelected(true);
						comboBox.setSelectedIndex(-1);
					} else {
						JOptionPane.showMessageDialog(this, "An error has ocurred modifying the task", "Error", JOptionPane.ERROR_MESSAGE);
					}					
				} catch (IllegalDateException e1) {
					JOptionPane.showMessageDialog(this, "There is a problem with the date\n" + e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Select a valid task", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public LocalDate checkDate() throws IllegalDateException {
		String dateText = textFieldDueDate.getText();
		LocalDate dueDate = null;

		if (!dateText.isEmpty()) {
			try {
				dueDate = LocalDate.parse(dateText);

				if (dueDate.isBefore(LocalDate.now())) {
					throw new IllegalDateException("The date can't be in the past.");
				}
			} catch (DateTimeParseException e) {
				throw new IllegalDateException("Date format invalid. Must be yyyy-MM-dd.");
			}
		}

		return dueDate;
	}
}
