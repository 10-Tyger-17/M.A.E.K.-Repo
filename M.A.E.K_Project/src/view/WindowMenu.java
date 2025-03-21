package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Client;
import model.Task;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class WindowMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnExit;
	private JButton btnShowTasks;
	private JButton btnAddTask;
	private JButton btnDeleteTask;
	private JButton btnModifyTask;
    private JButton btnPrevMonth;
    private JButton btnNextMonth;
    private JButton btnPrevYear;
    private JButton btnNextYear;
	private Controller cont;
	private Client client;
	private JPanel calendarPanel;
    private int currentMonth;
    private int currentYear;
    private JLabel lblMonth;
    private JLabel lblYear;

	public WindowMenu(JDialog parent, Client client, Controller cont) {
		this.cont = cont;
		this.client = client;
		setBounds(100, 100, 910, 624);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowLogin.class.getResource("/visual/Assets/Logo.jpg")));
		contentPanel.setBackground(new Color(248, 249, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnShowTasks = new JButton("Show Tasks");
		btnShowTasks.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnShowTasks.setBackground(new Color(173, 181, 189));
		btnShowTasks.setBorder(null);
		btnShowTasks.setBounds(0, 0, 131, 36);
		contentPanel.add(btnShowTasks);

		btnAddTask = new JButton("Add Task");
		btnAddTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnAddTask.setBackground(new Color(173, 181, 189));
		btnAddTask.setBorder(null);
		btnAddTask.setBounds(133, 0, 131, 36);
		contentPanel.add(btnAddTask);

		btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnDeleteTask.setBackground(new Color(173, 181, 189));
		btnDeleteTask.setBorder(null);
		btnDeleteTask.setBounds(266, 0, 131, 36);
		contentPanel.add(btnDeleteTask);

		btnModifyTask = new JButton("Modify Task");
		btnModifyTask.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		btnModifyTask.setBackground(new Color(173, 181, 189));
		btnModifyTask.setBorder(null);
		btnModifyTask.setBounds(399, 0, 131, 36);
		contentPanel.add(btnModifyTask);

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

		calendarPanel = new JPanel();
		calendarPanel.setBounds(20, 131, 860, 323);
		calendarPanel.setLayout(new BorderLayout());
		contentPanel.add(calendarPanel);

        btnPrevYear = new JButton("<<");
        btnPrevYear.setBounds(20, 100, 50, 25);
        contentPanel.add(btnPrevYear);

        btnPrevMonth = new JButton("<");
        btnPrevMonth.setBounds(80, 100, 50, 25);
        contentPanel.add(btnPrevMonth);

        btnNextMonth = new JButton(">");
        btnNextMonth.setBounds(770, 100, 50, 25);
        contentPanel.add(btnNextMonth);

        btnNextYear = new JButton(">>");
        btnNextYear.setBounds(830, 100, 50, 25);
        contentPanel.add(btnNextYear);
        
        lblMonth = new JLabel("");
        lblMonth.setFont(new Font("Source Code Pro", Font.PLAIN, 25));
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonth.setBounds(326, 94, 233, 33);
        contentPanel.add(lblMonth);
        
        lblYear = new JLabel("");
        lblYear.setFont(new Font("Source Code Pro", Font.PLAIN, 25));
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setBounds(376, 61, 131, 25);
        contentPanel.add(lblYear);

        this.currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
		createCalendar();

		btnExit.addActionListener(this);
        btnShowTasks.addActionListener(this);
        btnAddTask.addActionListener(this);
        btnDeleteTask.addActionListener(this);
        btnModifyTask.addActionListener(this);
        btnPrevMonth.addActionListener(this);
        btnNextMonth.addActionListener(this);
        btnPrevYear.addActionListener(this);
        btnNextYear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			this.dispose();
		} else if (e.getSource() == btnPrevMonth) {
            currentMonth--;
            if (currentMonth < 0) {
                currentMonth = 11;
                currentYear--;
            }
            createCalendar();
        } else if (e.getSource() == btnNextMonth) {
            currentMonth++;
            if (currentMonth > 11) {
                currentMonth = 0;
                currentYear++;
            }
            createCalendar();
        } else if (e.getSource() == btnPrevYear) {
            currentYear--;
            createCalendar();
        } else if (e.getSource() == btnNextYear) {
            currentYear++;
            createCalendar();
        } else if (e.getSource() == btnShowTasks) {
        	WindowShowTasks windowShowTasks = new WindowShowTasks(this, client, cont);
			windowShowTasks.setVisible(true);
		} else if (e.getSource() == btnAddTask) {
			WindowAddTask windowAddTask = new WindowAddTask(this, client, cont);
			windowAddTask.setVisible(true);
		} else if (e.getSource() == btnDeleteTask) {
			
		} else if (e.getSource() == btnModifyTask) {
			WindowModifyTask windowModifyTask = new WindowModifyTask(this, client, cont);
			windowModifyTask.setVisible(true);
		}
	}

	private void createCalendar() {
        calendarPanel.removeAll();

        DefaultTableModel model = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        String[] columnNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        model.setColumnIdentifiers(columnNames);

        JTable table = new JTable(model);
        table.setRowHeight(50);
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(true);

        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth, 1);
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        int firstDayAdjusted = (firstDay == Calendar.SUNDAY) ? 6 : firstDay - 2;
        int day = 1;

        for (int row = 0; row < 6; row++) {
            Object[] rowData = new Object[7];
            for (int col = 0; col < 7; col++) {
                rowData[col] = (row == 0 && col < firstDayAdjusted) || day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH) ? "" : day++;
            }
            model.addRow(rowData);
        }

        calendarPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        calendarPanel.revalidate();
        calendarPanel.repaint();
        lblMonth.setText(monthNames[currentMonth]);
        lblYear.setText(String.valueOf(currentYear));
    }
	
	public void calendarColors() {
		ArrayList<Task> tasks = cont.getTasks(client);
		
		
	}
}