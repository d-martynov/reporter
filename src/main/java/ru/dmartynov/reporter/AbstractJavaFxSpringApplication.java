package ru.dmartynov.reporter;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by d.martynov on 23.11.2015.
 */
public abstract class AbstractJavaFxSpringApplication extends Application {
    private static String[] savedArgs;

    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(("beans.xml"), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxSpringApplication> clazz, String[] args) {
        AbstractJavaFxSpringApplication.savedArgs = args;
        Application.launch(clazz, args);
    }
}
