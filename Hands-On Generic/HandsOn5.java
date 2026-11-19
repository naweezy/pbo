class CompareUtil {
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }
}

public class HandsOn5 {
    public static void main(String[] args) {
        System.out.println("5 == 5? " + CompareUtil.isEqual(5, 5));
        System.out.println("Hello == World? " + CompareUtil.isEqual("Hello", "World"));
        System.out.println("3.14 == 3.14? " + CompareUtil.isEqual(3.14, 3.14));
        
        System.out.println("A == A? " + CompareUtil.isEqual('A', 'A'));
    }
}

