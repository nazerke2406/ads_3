import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Testing MyHashTable
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomId = rand.nextInt(100000);
            MyTestingClass key = new MyTestingClass(randomId);
            Student value = new Student("Student" + randomId, randomId);
            table.put(key, value);
        }

        System.out.println("Bucket sizes in MyHashTable:");
        table.printBucketSizes();

        // Testing BST
        BST<Integer, String> tree = new BST<>();

        // Inserting elements
        tree.put(50, "Root");
        tree.put(30, "Left");
        tree.put(70, "Right");
        tree.put(20, "Left-Left");
        tree.put(40, "Left-Right");
        tree.put(60, "Right-Left");
        tree.put(80, "Right-Right");

        System.out.println("\nBST in-order traversal (only keys):");
        for (Integer key : tree) { // <----- ВАЖНО! Теперь проходим по ключам
            String value = tree.get(key); // ищем значение по ключу
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("\nSize of BST: " + tree.size());
    }
}
