
package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Client;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextField;

public class WindowDeleteTask extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnExit;
	private Controller cont;
	private JButton btnDelete;

	public WindowDeleteTask(JFrame parent, Client client, Controller cont) {
		super(parent, true);
		this.cont = cont;
		setBounds(100, 100, 542, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 249, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblModifyTask = new JLabel("Delete Task");
		lblModifyTask.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		lblModifyTask.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyTask.setBounds(0, 0, 526, 84);
		contentPanel.add(lblModifyTask);

		JComboBox<String> comboBoxTask = new JComboBox<>();
		comboBoxTask.setBackground(new Color(173, 181, 189));
		comboBoxTask.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		comboBoxTask.setBounds(19, 209, 490, 29);
		contentPanel.add(comboBoxTask);

		JLabel lblTaskToBeDelete = new JLabel("Task to be deleted");
		lblTaskToBeDelete.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaskToBeDelete.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblTaskToBeDelete.setBounds(19, 176, 264, 34);
		contentPanel.add(lblTaskToBeDelete);

		btnExit = new JButton("Exit");
		btnExit.setBorder(null);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(414, 406, 112, 27);
		contentPanel.add(btnExit);


		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(33, 37, 41));
		btnDelete.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
		btnDelete.setBounds(68, 287, 391, 45);
		btnDelete.addActionListener(this);
		contentPanel.add(btnDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

