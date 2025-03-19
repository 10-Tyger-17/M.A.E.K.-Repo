package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarPanel extends JPanel {
    private int year, month;
    private JTable calendarTable;
    private JButton prevButton, nextButton;
    private Map<Integer, String> tasks; // Mapa de tareas por día

    public CalendarPanel(int year, int month) {
        this.year = year;
        this.month = month;
        this.tasks = new HashMap<>();

        setLayout(new BorderLayout());

        // Crear botones de navegación
        JPanel topPanel = new JPanel();
        prevButton = new JButton("<<");
        nextButton = new JButton(">>");
        topPanel.add(prevButton);
        topPanel.add(nextButton);

        add(topPanel, BorderLayout.NORTH);

        // Crear la tabla de calendario
        createCalendarTable();

        // Escuchar eventos de los botones
        prevButton.addActionListener(e -> {
            this.month--;
            if (this.month < 0) {
                this.month = 11;
                this.year--;
            }
            updateCalendar();
        });

        nextButton.addActionListener(e -> {
            this.month++;
            if (this.month > 11) {
                this.month = 0;
                this.year++;
            }
            updateCalendar();
        });

        updateCalendar();
    }

    // Actualizar la tabla de calendario
    private void updateCalendar() {
        String[][] calendarData = generateCalendarData(year, month);
        calendarTable.setModel(new javax.swing.table.DefaultTableModel(calendarData, new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}));
    }

    // Generar los días del mes para el calendario
    private String[][] generateCalendarData(int year, int month) {
        Calendar calendar = new GregorianCalendar(year, month, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        String[][] data = new String[6][7];  // Hasta 6 filas en el calendario (algunos meses tienen 5)
        int dayCounter = 1;

        // Llenar la matriz con días
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDayOfWeek || dayCounter > daysInMonth) {
                    data[i][j] = "";  // Celda vacía
                } else {
                    data[i][j] = String.valueOf(dayCounter);
                    dayCounter++;
                }
            }
        }

        return data;
    }

    // Crear la tabla de calendario
    private void createCalendarTable() {
        calendarTable = new JTable();
        calendarTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        calendarTable.setFillsViewportHeight(true);

        // Cuando se hace clic en una celda, mostrar el formulario para agregar una tarea
        calendarTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                int row = calendarTable.rowAtPoint(me.getPoint());
                int col = calendarTable.columnAtPoint(me.getPoint());
                if (row >= 0 && col >= 0 && !calendarTable.getValueAt(row, col).toString().isEmpty()) {
                    int day = Integer.parseInt(calendarTable.getValueAt(row, col).toString());
                    showTaskForm(day);
                }
            }
        });

        add(new JScrollPane(calendarTable), BorderLayout.CENTER);
    }

    // Mostrar formulario para agregar tarea
    private void showTaskForm(int day) {
        String task = JOptionPane.showInputDialog(this, "Ingrese tarea para el día " + day + ":");

        if (task != null && !task.isEmpty()) {
            tasks.put(day, task);
            JOptionPane.showMessageDialog(this, "Tarea guardada para el día " + day);
        }
    }
}

