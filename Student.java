// A simple Student class to be used as values in the hash table
public class Student {
    private String name;
    private int id;

    // Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + "', id=" + id + '}';
    }
}
