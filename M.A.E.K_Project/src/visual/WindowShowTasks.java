package visual;

import java.awt.BorderLayout;

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
	private static final long serialVersionUID = 1L;
	
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
		
		chckbxCompleted = new JCheckBox("Completed");
		chckbxCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxCompleted.setBounds(77, 398, 183, 34);
		contentPanel.add(chckbxCompleted);
		
		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(298, 354, 117, 34);
		contentPanel.add(lblCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(298, 389, 142, 31);
		contentPanel.add(textFieldCategory);
		textFieldCategory.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(422, 468, 112, 25);
		btnExit.addActionListener(this);
		contentPanel.add(btnExit);
		actualizarTabla();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			dispose();
		}		
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
