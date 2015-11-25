package ru.dmartynov.reporter.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmartynov.reporter.CategoryStringConverter;
import ru.dmartynov.reporter.models.Category;
import ru.dmartynov.reporter.models.Person;
import ru.dmartynov.reporter.repos.PersonRepo;

/**
 * Created by d.martynov on 25.11.2015.
 */
@Component
public class NewPersonController extends AbstractController {
    @FXML
    private ComboBox<Category> personTypeComboBox;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField personFullNameTextField;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private MainController mainController;

    @Override
    public void init() {
        personTypeComboBox.setConverter(new CategoryStringConverter());
        personTypeComboBox.getItems().addAll(Category.values());
        personTypeComboBox.getSelectionModel().select(0);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.getNewPersonDialogStage().close();
            }
        });

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createPerson();
            }
        });
    }

    private void createPerson() {
        Person person = new Person();
        person.setCategory(personTypeComboBox.getSelectionModel().getSelectedItem());
        person.setFullName(personFullNameTextField.getText());
        personRepo.save(person);
        mainController.getNewPersonDialogStage().close();
    }
}
