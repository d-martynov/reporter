package ru.dmartynov.reporter;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.dmartynov.reporter.models.Category;

import java.lang.reflect.Field;

/**
 * Приводит в пригодный для отображения в таблице вид enum типа Category
 * @param <T> родительский тип
 */
public class CategoryPropertyValueFactory<T> extends PropertyValueFactory<T, String> {
    public CategoryPropertyValueFactory(String s) {
        super(s);
    }

    @Override
    public ObservableValue<String> call(final TableColumn.CellDataFeatures<T, String> cellDataFeatures) {
        return new ObservableValueBase<String>() {
            @Override
            public String getValue() {
                try {
                    Field propertyField = cellDataFeatures.getValue().getClass().getDeclaredField(getProperty());
                    propertyField.setAccessible(true);
                    Category category = (Category) propertyField.get(cellDataFeatures.getValue());
                    return category.getReadableName();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
