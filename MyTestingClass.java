// A custom testing class used as a key in MyHashTable
public class MyTestingClass {
    private int id; // An integer field for generating hash codes

    // Constructor
    public MyTestingClass(int id) {
        this.id = id;
    }

    // Custom hashCode() method
    @Override
    public int hashCode() {
        // A simple custom hash function
        return id * 31 + 7;
    }

    // Equals method is important for HashTable operations
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass that = (MyTestingClass) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "id=" + id + '}';
    }
}
