package ru.dmartynov.reporter.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ru.dmartynov.reporter.CategoryPropertyValueFactory;
import ru.dmartynov.reporter.models.Category;
import ru.dmartynov.reporter.models.Person;

/**
 * Created by Дмитрий on 24.11.2015.
 */
public class MainController extends AbstractController {
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private ListView catalogListView;
    @FXML
    private Pane catalogsPane;
    @FXML
    private TableView<Person> personsTable;

    public Node[] catalogsPaneNodes;


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

        TableColumn<Person, String> personTableColumn = (TableColumn<Person, String>) personsTable.getColumns().get(0);
        TableColumn<Person, String> personTableColumn2 = (TableColumn<Person, String>) personsTable.getColumns().get(1);
        personTableColumn2.setCellValueFactory(new CategoryPropertyValueFactory<Person>("category"));
        personTableColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));
        Person person = new Person();
        person.setCategory(Category.ENTREPRENEUR);
        person.setFullName("FIO");
        personsTable.getItems().add(person);
    }

    private void onCatalogListViewItemSelected(int selectedItemPosition) {
        catalogsPaneNodes[selectedItemPosition].toFront();
    }
}
