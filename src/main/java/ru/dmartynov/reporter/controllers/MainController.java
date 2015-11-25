package ru.dmartynov.reporter.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmartynov.reporter.CategoryPropertyValueFactory;
import ru.dmartynov.reporter.View;
import ru.dmartynov.reporter.models.Person;
import ru.dmartynov.reporter.repos.PersonRepo;

import java.util.List;

/**
 * Created by Дмитрий on 24.11.2015.
 */
@Component
@SuppressWarnings("unchecked")
public class MainController extends AbstractController {
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private ListView catalogListView;
    @FXML
    private Pane catalogsPane;
    @FXML
    private TableView<Person> personsTable;
    @FXML
    private Button createButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;

    @Autowired
    private PersonRepo personRepo;

    private final int PERSONS_CATALOG_INDEX = 0;

    public Node[] catalogsPaneNodes;

    @Autowired
    private View<NewPersonController> newPersonView;
    private Stage newPersonDialogStage;

    /**
     * Инициализация первоначального состояния, навешивание обработчиков
     */
    @Override
    public void init() {
        ObservableList<Node> childs = catalogsPane.getChildren();
        catalogsPaneNodes = childs.toArray(new Node[childs.size()]);

        catalogListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                onCatalogListViewItemSelected(catalogListView.getSelectionModel().getSelectedIndex());
            }
        });

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onCreateButtonClicked();
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDeleteButtonClicked();
            }
        });

        ((TableColumn<Person, String>) personsTable.getColumns().get(0))
                .setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));
        ((TableColumn<Person, String>) personsTable.getColumns().get(1))
                .setCellValueFactory(new CategoryPropertyValueFactory<Person>("category"));

    }

    private void onDeleteButtonClicked() {
        switch (catalogListView.getSelectionModel().getSelectedIndex()) {
            case PERSONS_CATALOG_INDEX: {
                deleteSelectedPerson();
                break;
            }
        }

    }

    /**
     * Вызывается при выборе пункта в списке "Справочники"
     *
     * @param selectedItemPosition позиция пункта в списке
     */
    private void onCatalogListViewItemSelected(int selectedItemPosition) {
        catalogsPaneNodes[selectedItemPosition].toFront();
        switch (selectedItemPosition) {
            case PERSONS_CATALOG_INDEX: {
                displayPersonsCatalog();
                break;
            }
        }
    }

    /**
     * Отображает справочник "Контрагенты"
     */
    private void displayPersonsCatalog() {
        if (personsTable.getItems().size() != 0)
            return;
        List<Person> all = personRepo.findAll();
        personsTable.getItems().addAll(all);
    }


    /**
     * Вызывается при нажатии на кнопку "Создать", определяет какой диалог нужно отобразить.
     */
    private void onCreateButtonClicked() {
        switch (catalogListView.getSelectionModel().getSelectedIndex()) {
            case (PERSONS_CATALOG_INDEX): {
                showNewPersonDialog();
                break;
            }
        }
    }

    /**
     * Отображает диалог создания нового Контрагента.
     */
    private void showNewPersonDialog() {
        if (this.newPersonDialogStage == null) {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(newPersonView.getParent()));
            this.newPersonDialogStage = stage;
        }
        this.newPersonDialogStage.show();
    }

    /**
     * Выполняет удаление выбранного контрагента.
     */
    private void deleteSelectedPerson() {
        Person person = personsTable.getSelectionModel().getSelectedItem();
        personRepo.delete(person);
        personsTable.getItems().removeAll(person);
    }

    public Stage getNewPersonDialogStage() {
        return newPersonDialogStage;
    }
}
