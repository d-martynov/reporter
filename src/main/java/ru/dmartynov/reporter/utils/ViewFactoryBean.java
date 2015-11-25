package ru.dmartynov.reporter.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dmartynov.reporter.View;
import ru.dmartynov.reporter.controllers.AbstractController;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class ViewFactoryBean implements FactoryBean<View> {
    @Autowired
    private ConfigurableApplicationContext context;

    private String viewFile;

    public ViewFactoryBean(String viewFile) {
        this.viewFile = viewFile;
    }

    @Override
    public View getObject() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(viewFile));
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> aClass) {
                return context.getBean(aClass);
            }
        });
        loader.load(getClass().getClassLoader().getResourceAsStream(viewFile));
        AbstractController controller = loader.getController();
        controller.init();
        return new View<AbstractController>((Parent) loader.getRoot(), controller);
    }

    @Override
    public Class<?> getObjectType() {
        return View.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
