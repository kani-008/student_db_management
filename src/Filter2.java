//Filter2.java
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.application.Platform;

public class Filter2 {

    public void filtere2(ComboBox<String> citycom, ObservableList<String> data) {
        FilteredList<String> filtered = new FilteredList<>(data, s -> true);
        citycom.setItems(filtered);
        citycom.setEditable(true);
        citycom.getEditor().textProperty().addListener((obs, oldVal, newVal) -> {
            String filter = newVal == null ? "" : newVal.toLowerCase();

            if (filter.isEmpty()) {
                filtered.setPredicate(s -> false);
                citycom.hide();
                return;
            }
            filtered.setPredicate(item -> item.toLowerCase().startsWith(filter));
            citycom.show();
            citycom.getEditor().setText(newVal);
            Platform.runLater(() -> {
                citycom.getEditor().positionCaret(citycom.getEditor().getText().length());
            });
        });
    }
}
