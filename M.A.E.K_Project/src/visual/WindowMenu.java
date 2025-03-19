package visual;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
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
import java.util.Calendar;

public class WindowMenu extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JButton btnExit;
    private Controller cont;

    public WindowMenu(JFrame parent, Controller cont) {
    	super(parent, true);
        this.cont = cont;
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

        JPanel calendarPanel = new JPanel();
        calendarPanel.setBounds(20, 131, 860, 402);
        calendarPanel.setLayout(new BorderLayout());
        contentPanel.add(calendarPanel);

        crearCalendario(calendarPanel);
    }

    private void crearCalendario(JPanel calendarPanel) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columnNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        model.setColumnIdentifiers(columnNames);

        JTable table = new JTable(model);
        table.setRowHeight(50);
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(true);

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);

        int firstDayAdjusted = (firstDay == Calendar.SUNDAY) ? 6 : firstDay - 2;

        int day = 1;
        for (int row = 0; row < 6; row++) {
            Object[] rowData = new Object[7];
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < firstDayAdjusted) {
                    rowData[col] = "";
                } else if (day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    rowData[col] = day++;
                } else {
                    rowData[col] = "";
                }
            }
            model.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        calendarPanel.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            this.dispose();
        }
    }
}
