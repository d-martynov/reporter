package ru.dmartynov.reporter;

import javafx.util.StringConverter;
import ru.dmartynov.reporter.models.Category;

/**
 * Created by d.martynov on 25.11.2015.
 */
public class CategoryStringConverter extends StringConverter<Category> {
    @Override
    public String toString(Category category) {
        return category.getReadableName();
    }

    @Override
    public Category fromString(String s) {
        for (Category c : Category.values())
            if (c.getReadableName().equals(s))
                return c;
        return null;
    }
}
