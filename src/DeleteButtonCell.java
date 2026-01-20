//DeleteButtonCell.java
import javafx.scene.image.*;
import javafx.scene.control.*;
import java.io.File;

public class DeleteButtonCell extends TableCell<Student, Void> {
    private final Button delbu = new Button();
    {
        delbu.setOnAction(el -> {
            Student s = getTableView().getItems().get(getIndex());
            ((TestConnection) getTableView().getScene().getWindow().getUserData()).deletest(s.getRollno());
            getTableView().getItems().remove(s);
        });
    }

    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            Image img = new Image(new File("K:\\program\\java project\\trash_icon.jpg").toURI().toString());
            ImageView view = new ImageView(img);
            view.setFitHeight(10);
            view.setFitWidth(10);
            delbu.setGraphic(view);
            setGraphic(delbu);
        }

    }

}