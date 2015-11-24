package ru.dmartynov.reporter;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmartynov.reporter.controllers.MainController;

/**
 * Created by d.martynov on 23.11.2015.
 */

@Component
public class EntryPoint extends AbstractJavaFxSpringApplication {
    @Autowired
    private View<MainController> mainView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(mainView.getParent()));
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launchApp(EntryPoint.class, args);
    }
}
