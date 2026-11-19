import java.io.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; 
    String name;
    int age;

    public Employee(String n, int a) {
        name = n;
        age = a;
    }
}
public class HandsOn9 {
    public static Employee deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Keiysa", 30);
        Employee e2 = new Employee("Alifa", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.ser"))) {
            oos.writeObject(e1);
            oos.writeObject(e2);
            System.out.println("Serialized successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee restored1 = deserialize("emp.ser");
        System.out.println("Membaca objek 1:");
        if (restored1 != null) System.out.println("Name: " + restored1.name + ", Age: " + restored1.age);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.ser"))) {
            ois.readObject(); // skip objek pertama
            Employee restored2 = (Employee) ois.readObject();
            System.out.println("Membaca objek 2: Name: " + restored2.name + ", Age: " + restored2.age);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}



