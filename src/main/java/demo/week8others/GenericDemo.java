package demo.week8others;

import java.util.Comparator;

/**
 * Generic class/method can work with any type of objects
 * without violating the type safety.
 */
public class GenericDemo {

    public static void main(String[] args) {
        // The elements in Pair can be of different types
        Pair<String, Integer> pair1 = new Pair<>("String", 1);
        Pair<Integer, Double> pair2 = new Pair<>(1, 2.3);
        Pair<Integer, Integer> pair3 = new Pair<>(1, 2);
        // Invalid since PairOfSame class only have 1 type parameter
        // PairOfSame<String, Integer> pair4 = new PairOfSame<>("String", 1);
        // Elements in PairOfSame must be the same type
        PairOfSame<Integer> pair4 = new PairOfSame<>(1, 2);
    }

    /**
     * A generic method that returns the minimum element of an array.
     * <br> The method works with any comparable objects.
     * <br> Type parameter is defined in <> before return type
     *
     * @param objects an array of comparable objects
     * @param <T>     T must be Comparable
     * @return the minimum element
     */
    public static <T extends Comparable<T>> T min(T[] objects) {
        T min = objects[0];
        for (T object : objects) {
            if (object.compareTo(min) < 0)
                min = object;
        }
        return min;
    }

    /**
     * A generic method that returns the minimum element of an array
     * and the order is based on the specified comparator.
     * <br> The method works with any objects (no need to be comparable).
     *
     * @param objects    an array of objects
     * @param comparator comparator that defines the order of the objects
     * @param <T>        T can be any type
     * @return the minimum element
     */
    public static <T> T min(T[] objects, Comparator<T> comparator) {
        T min = objects[0];
        for (T object : objects) {
            if (comparator.compare(object, min) < 0)
                min = object;
        }
        return min;
    }
}
