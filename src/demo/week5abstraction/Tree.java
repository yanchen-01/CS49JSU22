package demo.week5abstraction;

/**
 * A Tree object with its age.
 * <br> Tree is Alive - there's no "is-a" between Tree & Animal
 * but they are both alive.
 */
public class Tree implements Alive{
    private final int age;

    public Tree(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    /**
     * Prints Tree is breathing
     *
     * <p>(Mandatory method in {@link Alive} interface.
     * <br>Must implement - otherwise compiler error.)
     */
    @Override
    public void breath() {
        System.out.println("Tree is breathing");
    }
}
