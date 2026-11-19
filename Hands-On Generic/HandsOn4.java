class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }
    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }
    public T1 getFirst() { return first; }
    public T2 getSecond() { return second; }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class HandsOn4 {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(95, "Nurul Azisa");
        pair1.showTypes();
        System.out.println("Sebelum swap: " + pair1);
        
        Pair<String, Integer> swapped1 = pair1.swap();
        System.out.println("Setelah swap: " + swapped1);

        System.out.println(); 

        Pair<Double, Boolean> pair2 = new Pair<>(3.85, true);
        pair2.showTypes();
        System.out.println("Sebelum swap: " + pair2);
        
        Pair<Boolean, Double> swapped2 = pair2.swap();
        System.out.println("Setelah swap: " + swapped2);
    }
}

