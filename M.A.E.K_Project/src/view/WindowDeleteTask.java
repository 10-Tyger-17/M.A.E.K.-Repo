package view;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Client;
import model.Task;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.awt.Color;

/**
 * The WindowDeleteTask class represents a dialog window for deleting an existing task.
 * It extends JDialog and implements ActionListener to handle user interactions.
 */
public class WindowDeleteTask extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;

    private final JPanel contentPanel = new JPanel();
    private JButton btnExit;
    private Controller cont;
    private JButton btnDelete;
    private JLabel lblDeleteTask;
    private JLabel lblTaskToBeDelete;
    private JComboBox<Task> comboBox;
    private Client client;

    /**
     * Constructs a new WindowDeleteTask dialog.
     *
     * @param parent the parent frame
     * @param client the client object
     * @param cont the controller object
     */
    public WindowDeleteTask(JFrame parent, Client client, Controller cont) {
        super(parent, true);
        this.cont = cont;
        this.client = client;
        setBounds(100, 100, 542, 472);
        setTitle("M.A.E.K.");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(248, 249, 250));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        lblDeleteTask = new JLabel("Delete Task");
        lblDeleteTask.setBounds(0, 0, 526, 84);
        lblDeleteTask.setFont(new Font("Source Code Pro", Font.PLAIN, 72));
        lblDeleteTask.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblDeleteTask);

        lblTaskToBeDelete = new JLabel("Task to be deleted");
        lblTaskToBeDelete.setBounds(36, 161, 264, 34);
        lblTaskToBeDelete.setHorizontalAlignment(SwingConstants.LEFT);
        lblTaskToBeDelete.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        contentPanel.add(lblTaskToBeDelete);

        btnExit = new JButton("Exit");
        btnExit.setBounds(414, 406, 112, 27);
        btnExit.setBorder(null);
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setBackground(new Color(33, 37, 41));
        btnExit.addActionListener(this);
        contentPanel.add(btnExit);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(68, 287, 391, 45);
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBackground(new Color(33, 37, 41));
        btnDelete.setFont(new Font("Source Code Pro", Font.PLAIN, 36));
        btnDelete.addActionListener(this);
        contentPanel.add(btnDelete);

        comboBox = new JComboBox<Task>();
        comboBox.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
        comboBox.setBounds(36, 206, 460, 29);
        comboBox.setModel(new DefaultComboBoxModel<>(cont.getTasks(client).toArray(new Task[0])));
        comboBox.setBackground(new Color(173, 181, 189));
        contentPanel.add(comboBox);
        comboBox.setSelectedIndex(-1);
    }

    /**
     * Handles action events for the delete and exit buttons.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            this.dispose();
        } else if (e.getSource() == btnDelete) {
            if (comboBox.getSelectedIndex() != -1) {
                Task selectedTask = (Task) comboBox.getSelectedItem();

                if (!cont.removeTask(selectedTask)) {
                    JOptionPane.showMessageDialog(this, "The task has been deleted successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);

                    DefaultComboBoxModel<Task> model = new DefaultComboBoxModel<>(cont.getTasks(client).toArray(new Task[0]));
                    comboBox.setModel(model);
                    comboBox.setSelectedIndex(-1);
                } else {
                    JOptionPane.showMessageDialog(this, "An error has occurred deleting the task", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select a valid task", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}