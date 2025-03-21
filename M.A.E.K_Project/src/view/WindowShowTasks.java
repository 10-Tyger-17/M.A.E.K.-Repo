package view;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Category;
import model.Client;
import model.Task;
import model.Task_state_Enum;

import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JComboBox;

public class WindowShowTasks extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel lblShowTasks;
	private JLabel lblTasks;
	private JScrollPane scrollPane;
	private JCheckBox chckbxPending;
	private JCheckBox chckbxCompleted;
	private JLabel lblCategory;
	private JButton btnExit;
	private DefaultTableModel model;
	private Client client;
	private Controller cont;
	private JComboBox<String> comboBox;

	public WindowShowTasks(JFrame parent, Client client, Controller cont) {
		this.cont = cont;
		this.client = client;
		setBounds(100, 100, 550, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblShowTasks = new JLabel("Show Tasks");
		lblShowTasks.setBounds(7, 0, 433, 84);
		lblShowTasks.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
		contentPanel.add(lblShowTasks);

		lblTasks = new JLabel("Tasks");
		lblTasks.setBounds(13, 93, 74, 34);
		lblTasks.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		contentPanel.add(lblTasks);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 124, 512, 197);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		model = new DefaultTableModel(new String[]{"ID", "Name", "Description", "Due date", "State", "Category"}, 0);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
		table.getColumnModel().getColumn(4).setPreferredWidth(35);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		scrollPane.setViewportView(table);

		chckbxPending = new JCheckBox("Pending");
		chckbxPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxPending.setForeground(new Color(33, 37, 41));
		chckbxPending.setBounds(76, 352, 157, 34);
		contentPanel.add(chckbxPending);
		chckbxPending.addActionListener(this);

		chckbxCompleted = new JCheckBox("Completed");
		chckbxCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxCompleted.setBounds(77, 398, 183, 34);
		contentPanel.add(chckbxCompleted);
		chckbxCompleted.addActionListener(this);

		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(298, 354, 117, 34);
		contentPanel.add(lblCategory);

		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(422, 468, 112, 25);
		btnExit.addActionListener(this);
		contentPanel.add(btnExit);
		
		comboBox = new JComboBox<>();
		ArrayList<Category> categories = cont.getCategories(client);
		String[] categoryNames = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
		    categoryNames[i] = categories.get(i).getCategory_name();
		}
		comboBox.setModel(new DefaultComboBoxModel<>(categoryNames));
        comboBox.setSelectedIndex(-1);
		comboBox.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		comboBox.setBounds(298, 398, 142, 25);
		contentPanel.add(comboBox);
		comboBox.addActionListener(this);
		
		actualizarTabla(true, true, null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnExit) {
	        dispose();
	    } else if (e.getSource() == chckbxPending || e.getSource() == chckbxCompleted) {
	        actualizarTabla(chckbxCompleted.isSelected(), chckbxPending.isSelected(), null);
	    } else if (e.getSource() == comboBox) {
	        actualizarTabla(true, true, String.valueOf(comboBox.getSelectedItem()));
	    }
	}

	private void actualizarTabla(boolean completed, boolean pending, String category) {
	    ArrayList<Task> tasks = cont.getTasks(client);
	    boolean isCategoryMatch = false;;
        boolean isStateMatch = false;
        
	    model.setRowCount(0);

	    for (Task task : tasks) {
	    	isCategoryMatch = category == null || category.equalsIgnoreCase(task.getCategory());
	    	
	        if (!completed && !pending) {
	            isStateMatch = true;
	        } else {
	            isStateMatch = (completed && task.getTask_state().equals(Task_state_Enum.COMPLETED)) || (pending && task.getTask_state().equals(Task_state_Enum.PENDING));
	        }

	        if (isCategoryMatch && isStateMatch) {
	            String[] rowData = {
	                String.valueOf(task.getId()),
	                task.getTask_name(),
	                task.getTask_description(),
	                String.valueOf(task.getDue_date()),
	                String.valueOf(task.getTask_state().value()),
	                task.getCategory()
	            };
	            
	            model.addRow(rowData);
	        }
	    }
	}

}
