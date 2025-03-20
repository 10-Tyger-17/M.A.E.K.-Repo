package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import model.Client;
import model.Task;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;

public class WindowShowTasks extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textFieldCategory;
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


	/**
	 * Create the dialog.
	 */
	public WindowShowTasks(JFrame parent, Client client, Controller cont) {
		this.cont = cont;
		this.client = client;
		setBounds(100, 100, 464, 532);
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
		scrollPane.setBounds(12, 124, 391, 179);
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
		scrollPane.setViewportView(table);
		
		chckbxPending = new JCheckBox("Pending");
		chckbxPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxPending.setForeground(new Color(33, 37, 41));
		chckbxPending.setBounds(26, 350, 157, 34);
		contentPanel.add(chckbxPending);
		
		chckbxCompleted = new JCheckBox("Completed");
		chckbxCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxCompleted.setBounds(27, 396, 183, 34);
		contentPanel.add(chckbxCompleted);
		
		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(248, 352, 117, 34);
		contentPanel.add(lblCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(248, 382, 142, 31);
		contentPanel.add(textFieldCategory);
		textFieldCategory.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(338, 470, 112, 25);
		contentPanel.add(btnExit);
		actualizarTabla();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void actualizarTabla() {
    	ArrayList<Task> tasks = cont.getTasks(client);
    	
        model.setRowCount(0);
        
        for (Task task : tasks) {
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
