package br.dev.hygino.gui;

import br.dev.hygino.dao.ConsoleDAO;
import br.dev.hygino.model.Console;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ConsoleForm2 {

    private ConsoleDAO dao=ConsoleDAO.getInstance();

    private static ConsoleForm2 instance;

    public static ConsoleForm2 getInstance() {
        if (instance == null) {
            instance = new ConsoleForm2();
        }
        return instance;
    }

    private JFrame mainWindow;
    private JLabel lbName, lbCompany, lbReleaseDate;
    private JTextField txtName, txtCompany, txtReleaseDate;
    private JButton btnInsert;

    private ConsoleForm2() {
        setupWindow();
    }

    private void setupWindow() {
        mainWindow = new JFrame("Console Form");
        mainWindow.setSize(640, 480);
        mainWindow.setLayout(new FlowLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbName = new JLabel("Nome");
        lbCompany = new JLabel("Empresa");
        lbReleaseDate = new JLabel("Lançamento");

        txtName = new JTextField(10);
        txtCompany = new JTextField(10);
        txtReleaseDate = new JTextField(10);

        btnInsert = new JButton("Inserir");

        btnInsert.addActionListener(e -> {
            String name = txtName.getText();
            String company = txtCompany.getText();
            String releaseDate = txtReleaseDate.getText();
            dao = ConsoleDAO.getInstance();

            Console c = new Console(name, company, LocalDate.parse(releaseDate));

            dao.insert(c);
            JOptionPane.showMessageDialog(mainWindow, "Console inserido:\n" + name + ", " + company + ", " + releaseDate);
        });

        mainWindow.add(lbName);
        mainWindow.add(txtName);
        mainWindow.add(lbCompany);
        mainWindow.add(txtCompany);
        mainWindow.add(lbReleaseDate);
        mainWindow.add(txtReleaseDate);
        mainWindow.add(btnInsert);

        mainWindow.setVisible(true);
    }

}
