package views;

import models.Student;
import controllers.StudentController;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInformationSystemSwing extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField idField, nameField, courseField;
    private JButton addButton, updateButton, deleteButton;
    private StudentController controller;

    public StudentInformationSystemSwing() {
        controller = new StudentController();

        // Frame setup
        setTitle("Student Information System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table and model
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Course"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input fields
        idField = new JTextField(10);
        nameField = new JTextField(10);
        courseField = new JTextField(10);

        // Buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        // Adding components
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String course = courseField.getText();
                    controller.addStudent(new Student(id, name, course));
                    updateTable();
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        String name = nameField.getText();
                        String course = courseField.getText();
                        controller.updateStudent(selectedRow, new Student(id, name, course));
                        updateTable();
                        clearFields();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student to update.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    controller.deleteStudent(selectedRow);
                    updateTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student to delete.");
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                courseField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            }
        });
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Student student : controller.getStudents()) {
            tableModel.addRow(new Object[]{student.getId(), student.getName(), student.getCourse()});
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        courseField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentInformationSystemSwing().setVisible(true);
        });
    }
}
