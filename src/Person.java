//Person.java
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty rollno;
    private final StringProperty name;
    private final StringProperty branch;
    private final StringProperty city;

    public Person(String rollno, String name, String branch, String city) {
        this.rollno = new SimpleStringProperty(rollno);
        this.name = new SimpleStringProperty(name);
        this.branch = new SimpleStringProperty(branch);
        this.city = new SimpleStringProperty(city);
    }

    public String getRollno() {
        return rollno.get();
    }

    public StringProperty rollnoProperty() {
        return rollno;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getBranch() {
        return branch.get();
    }

    public StringProperty branchProperty() {
        return branch;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }
}