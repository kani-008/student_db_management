//TestConnection.java(main)
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.sql.*;
public class TestConnection extends Application {
    final String url = "jdbc:mysql://localhost:3306/dbms";
    final String user = "root";
    final String pas = "7410";
    ObservableList<Student> students = FXCollections.observableArrayList();

    public void start(Stage stage) {
        GridPane g = new GridPane();
        g.setPadding(new Insets(20, 10, 0, 10));
        g.setVgap(10);
        g.setHgap(10);

        TextField t1 = new TextField();
        TextField t2 = new TextField();

        ComboBox<String> deptcom = new ComboBox<>();
        ObservableList<String> data1 = DataHolder.datadept;
        Filter1 fil1 = new Filter1();
        fil1.filtere1(deptcom, data1);
        ComboBox<String> citycom = new ComboBox<>();
        ObservableList<String> data2 = DataHolder.datacity;
        Filter2 fil2 = new Filter2();
        fil2.filtere2(citycom, data2);

        Label l1 = new Label("Name:");
        Label l2 = new Label("Regno:");
        Label l3 = new Label("Department:");
        Label l4 = new Label("City:");

        Button b = new Button("Submit");
        Button list = new Button("List");
        VBox main = new VBox();
        main.getChildren().add(g);

        TableView<Student> table = new TableView<>();
        main.getChildren().add(table);

        TableColumn<Student, String> rollcol = new TableColumn<>("Rollno");
        rollcol.setCellValueFactory(new PropertyValueFactory<>("rollno"));

        TableColumn<Student, String> namecol = new TableColumn<>("Name");
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> deptcol = new TableColumn<>("Department");
        deptcol.setCellValueFactory(new PropertyValueFactory<>("dept"));

        TableColumn<Student, String> citycol = new TableColumn<>("City");
        citycol.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Student, Void> delcol = new TableColumn<>("Delete");

        g.add(l1, 0, 0);
        g.add(t1, 1, 0);
        t1.setOnAction(e -> t2.requestFocus());

        g.add(l2, 4, 0);
        g.add(t2, 5, 0);
        t2.setOnAction(e -> deptcom.requestFocus());

        g.add(l3, 0, 1);
        g.add(deptcom, 1, 1);
        deptcom.setOnAction(e -> citycom.requestFocus());

        g.add(l4, 4, 1);
        g.add(citycom, 5, 1);

        g.add(b, 5, 2);
        g.setHalignment(b, HPos.LEFT);

        g.add(list, 5, 2);
        g.setHalignment(list, HPos.RIGHT);

        list.setOnAction(ee -> {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, pas);
                CallableStatement call = conn.prepareCall("{call display()}");
                ResultSet rs = call.executeQuery();
                students.clear();
                while (rs.next()) {
                    String rollno = rs.getString("rollno");
                    String name = rs.getString("name");
                    String dept = rs.getString("dept");
                    String city = rs.getString("city");
                    students.add(new Student(rollno, name, dept, city));

                }
                if (table.getColumns().isEmpty()) {

                    table.getColumns().addAll(rollcol, namecol, deptcol, citycol, delcol);
                }

                table.setItems(students);
                System.out.println(" :) display procedue  executed successfully!");

                rs.close();
                call.close();
                conn.close();
            } catch (Exception ec) {
                ec.printStackTrace();
            }
        });
        b.setOnAction(e -> {
            try {
                String name = t1.getText();
                String rollno = t2.getText();
                String dept = deptcom.getValue();
                String city = citycom.getValue();

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection conn = DriverManager.getConnection(url, user, pas);
                CallableStatement call = conn.prepareCall("{call insertstu (?,?,?,?)}");

                call.setString(1, rollno);
                call.setString(2, name);
                call.setString(3, dept);
                call.setString(4, city);
                call.execute();

                System.out.println(" :) Stored procedure executed successfully!");
                if (!table.getColumns().isEmpty()) {
                    students.add(0, new Student(rollno, name, dept, city));
                }
                t1.clear();
                t2.clear();
                deptcom.setValue(null);
                citycom.setValue(null);
                call.close();
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        delcol.setCellFactory(column -> new DeleteButtonCell());

        Scene scene = new Scene(main, 700, 450);
        //scene.getStylesheets().add(new File("K:\\program\\java project\\style.css").toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Student Form");
        stage.show();
        stage.setUserData(this);
    }

    void deletest(String rollno) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pas);
            CallableStatement call = conn.prepareCall("{ call deletestu(?)}");
            call.setString(1, rollno);
            call.execute();
            call.close();
            conn.close();
            System.out.println("deleted successfully");
        } catch (Exception er) {
            er.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

