package br.dev.hygino.gui;

import java.util.List;

import br.dev.hygino.dao.ConsoleDAO;
import br.dev.hygino.model.Console;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ConsoleFormController {

    private ConsoleDAO dao;

    @FXML
    private DatePicker dtReleaseDate;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnList;

    @FXML
    private ListView<Console> listView = new ListView<>();

    @FXML
    public void addConsole(Event event) {
        if (txtName.getText().isEmpty() || txtCompany.getText().isEmpty() || dtReleaseDate.getValue() == null) {
            System.out.println("Preencha todos os campos!");
            return;
        }

        Console console = new Console(txtName.getText(), txtCompany.getText(), dtReleaseDate.getValue());

        dao = ConsoleDAO.getInstance();
        dao.insert(console);
        System.out.println(console);
    }

    @FXML
    public void getConsoleList(Event event) {
        dao = ConsoleDAO.getInstance();
        final List<Console> list = dao.getConsoleList();
        // list.forEach(System.out::println);
        listView.getItems().addAll(list);
    }
}
