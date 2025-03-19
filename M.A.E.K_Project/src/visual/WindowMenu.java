package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Font;

public class WindowMenu extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnExit;
	private Controller cont;

	public WindowMenu(Controller cont) {
		this.cont=cont;
		setBounds(100, 100, 910, 624);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 249, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnShowTasks = new JButton("Show Tasks");
		btnShowTasks.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnShowTasks.setBackground(new Color(173, 181, 189));
		btnShowTasks.setBorder(null);
		btnShowTasks.setBounds(0, 0, 131, 36);
		contentPanel.add(btnShowTasks);
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnAddTask.setBackground(new Color(173, 181, 189));
		btnAddTask.setBorder(null);
		btnAddTask.setBounds(133, 0, 131, 36);
		contentPanel.add(btnAddTask);
		
		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnDeleteTask.setBackground(new Color(173, 181, 189));
		btnDeleteTask.setBorder(null);
		btnDeleteTask.setBounds(266, 0, 131, 36);
		contentPanel.add(btnDeleteTask);
		
		JButton btnModifyTask = new JButton("Modify Task");
		btnModifyTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnModifyTask.setBackground(new Color(173, 181, 189));
		btnModifyTask.setBorder(null);
		btnModifyTask.setBounds(399, 0, 131, 36);
		contentPanel.add(btnModifyTask);
		
		JButton btnOrganiseTask = new JButton("Organise Task");
		btnOrganiseTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnOrganiseTask.setBackground(new Color(173, 181, 189));
		btnOrganiseTask.setBorder(null);
		btnOrganiseTask.setBounds(532, 0, 131, 36);
		contentPanel.add(btnOrganiseTask);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnExit.setBackground(new Color(173, 181, 189));
		btnExit.setBorder(null);
		btnExit.setBounds(826, 0, 75, 36);
		contentPanel.add(btnExit);
		
		Canvas backgroundTop = new Canvas();
		backgroundTop.setEnabled(false);
		backgroundTop.setBackground(new Color(33, 37, 41));
		backgroundTop.setBounds(0, 0, 900, 36);
		contentPanel.add(backgroundTop);
		
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			this.dispose();
		}
	}
}
