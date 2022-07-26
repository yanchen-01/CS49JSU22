package demo.week8others;

/**
 * A pair of elements in the same type.
 * @param <T> the type of elements in the pair
 */
public class PairOfSame <T>{
    private final T first;
    private final T second;

    public PairOfSame(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
