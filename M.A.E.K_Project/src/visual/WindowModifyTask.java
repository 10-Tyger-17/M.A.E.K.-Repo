package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextField;

public class WindowModifyTask extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldDueDate;
	private JTextField textFieldCategory;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WindowModifyTask dialog = new WindowModifyTask();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WindowModifyTask() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(173, 181, 189));
		comboBox.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		comboBox.setBounds(19, 104, 490, 29);
		contentPanel.add(comboBox);
		
		JCheckBox chckbxPending = new JCheckBox("Pending");
		chckbxPending.setBorder(null);
		chckbxPending.setForeground(new Color(33, 37, 41));
		chckbxPending.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxPending.setBounds(18, 148, 157, 34);
		contentPanel.add(chckbxPending);
		
		JCheckBox chckbxCompleted = new JCheckBox("Completed");
		chckbxCompleted.setBorder(null);
		chckbxCompleted.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		chckbxCompleted.setBounds(18, 194, 183, 34);
		contentPanel.add(chckbxCompleted);
		
		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblID.setBounds(269, 152, 184, 34);
		contentPanel.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setBackground(new Color(173, 181, 189));
		textFieldID.setBorder(null);
		textFieldID.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldID.setBounds(269, 182, 240, 31);
		contentPanel.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblName.setBounds(19, 239, 184, 34);
		contentPanel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(173, 181, 189));
		textFieldName.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldName.setBorder(null);
		textFieldName.setColumns(10);
		textFieldName.setBounds(18, 269, 240, 31);
		contentPanel.add(textFieldName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDescription.setBounds(269, 239, 184, 34);
		contentPanel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBackground(new Color(173, 181, 189));
		textFieldDescription.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldDescription.setBorder(null);
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(269, 269, 240, 31);
		contentPanel.add(textFieldDescription);
		
		textFieldDueDate = new JTextField();
		textFieldDueDate.setBackground(new Color(173, 181, 189));
		textFieldDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldDueDate.setBorder(null);
		textFieldDueDate.setColumns(10);
		textFieldDueDate.setBounds(18, 354, 240, 31);
		contentPanel.add(textFieldDueDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDueDate.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblDueDate.setBounds(18, 324, 184, 34);
		contentPanel.add(lblDueDate);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBackground(new Color(173, 181, 189));
		textFieldCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		textFieldCategory.setBorder(null);
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(269, 354, 240, 31);
		contentPanel.add(textFieldCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
		lblCategory.setBounds(269, 324, 184, 34);
		contentPanel.add(lblCategory);
		
		btnExit = new JButton("Exit");
		btnExit.setBorder(null);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 37, 41));
		btnExit.setBounds(414, 406, 112, 27);
		contentPanel.add(btnExit);
	}
}
