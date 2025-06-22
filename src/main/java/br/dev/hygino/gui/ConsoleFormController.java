package br.dev.hygino.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.dev.hygino.dao.ConsoleDAO;
import br.dev.hygino.model.Console;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ConsoleFormController implements Initializable {

    private ConsoleDAO dao;
    private boolean editMode = false;
    private int selectedId = 0;

    @FXML
    private DatePicker dtReleaseDate;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnNewConsole;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnList;

    @FXML
    private Button btnDelete;

    @FXML
    private Label lbResult;

    @FXML
    private ListView<Console> listView = new ListView<>();

    @FXML
    public void addConsole(Event event) {
        if (txtName.getText().isEmpty() || txtCompany.getText().isEmpty() || dtReleaseDate.getValue() == null) {
            System.out.println("Preencha todos os campos!");
            return;
        }

        dao = ConsoleDAO.getInstance();

        if (!editMode) {
            Console console = new Console(txtName.getText(), txtCompany.getText(), dtReleaseDate.getValue());
            dao.insert(console);
            lbResult.setText("Console Inserido!");
        } else {
            Console console = new Console(selectedId, txtName.getText(), txtCompany.getText(),
                    dtReleaseDate.getValue());
            dao.update(console);
            lbResult.setText("Console Atualizado!");
        }

        populateList();
    }

    @FXML
    public void getConsoleList(Event event) {
        populateList();
    }

    private void populateList() {
        dao = ConsoleDAO.getInstance();
        final List<Console> list = dao.getConsoleList();
        listView.getItems().clear();
        listView.getItems().addAll(list);
    }

    @FXML
    public void createNewConsole(Event event) {
        editMode = false;
        txtName.setText(" ");
        txtCompany.setText("");
        dtReleaseDate.setValue(null);
        lbResult.setText("");
        selectedId = 0;
    }

    @FXML
    public void removeConsole(Event event) {
        dao = ConsoleDAO.getInstance();

        if (selectedId > 0) {
            dao.remove(selectedId);
            lbResult.setText("Console Removido!");
            populateList();
        } else {
            lbResult.setText("Erro ao remover: Id inválido");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateList();

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedItem) -> {
            if (selectedItem != null) {
                txtName.setText(selectedItem.getName());
                txtCompany.setText(selectedItem.getCompany());
                dtReleaseDate.setValue(selectedItem.getReleaseDate());
                editMode = true;
                selectedId = selectedItem.getId();
            }
        });
    }
}
