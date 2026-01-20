//Student.java
public class Student {

    private String rollno;
    private String name;
    private String dept;
    private String city;

    public Student(String rollno, String name, String dept, String city) {
        this.rollno = rollno;
        this.name = name;
        this.dept = dept;
        this.city = city;
    }

    public String getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getCity() {
        return city;
    }
}
