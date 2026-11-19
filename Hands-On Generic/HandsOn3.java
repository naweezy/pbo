class Cell<T> {
    private T data;

    public void setValue(T data) { this.data = data; }
    public T getValue() { return data; }

    public void displayType() {
        System.out.println("Tipe data di dalam Cell ini adalah: " + data.getClass().getSimpleName());
    }
}

public class HandsOn3 {
    public static void main(String[] args) {
        
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);
        System.out.println("Nilai: " + intCell.getValue());
        intCell.displayType();

        Cell<String> strCell = new Cell<>();
        strCell.setValue("Hello, Uyu!");
        System.out.println("Nilai: " + strCell.getValue());
        strCell.displayType();
    }
}

