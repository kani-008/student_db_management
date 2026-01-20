//Filter1.java
import javafx.scene.control.ComboBox;
import javafx.collections.transformation.FilteredList;
import javafx.collections.ObservableList;
import javafx.application.Platform;

public class Filter1 {

    public void filtere1(ComboBox<String> deptcom, ObservableList<String> data) {
        FilteredList<String> filteredData = new FilteredList<>(data, s -> true);
        deptcom.setItems(filteredData);
        deptcom.setEditable(true);

        deptcom.getEditor().textProperty().addListener((obs, oldVal, newVal) -> {
            String filter = newVal == null ? "" : newVal.toLowerCase();

            if (filter.isEmpty()) {
                filteredData.setPredicate(s -> false); 
                deptcom.hide();
                return;
            }

            filteredData.setPredicate(item -> item.toLowerCase().startsWith(filter));
            deptcom.show();

            deptcom.getEditor().setText(newVal);
            Platform.runLater(() -> {
                deptcom.getEditor().positionCaret(deptcom.getEditor().getText().length());
            });
        });
    }
}
