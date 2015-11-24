package ru.dmartynov.reporter;

import javafx.scene.Parent;
import ru.dmartynov.reporter.controllers.AbstractController;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class View<ControllerClass extends AbstractController> {
    private Parent parent;
    private ControllerClass controller;

    public View(Parent parent, ControllerClass controller) {
        this.parent = parent;
        this.controller = controller;
    }

    public Parent getParent() {
        return parent;
    }

    public ControllerClass getController() {
        return controller;
    }
}
