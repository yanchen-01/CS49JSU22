package demo.week8others;

/**
 * A pair of objects in any type.
 * @param <First> the type of the first element
 * @param <Second> the type of the second element
 */
public class Pair<First, Second> {
    private final First first;
    private final Second second;

    public Pair(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }
}
