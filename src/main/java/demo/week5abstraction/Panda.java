package demo.week5abstraction;

public class Panda extends Animal{
    // Non-default constructor is not inherited
    // - must have a constructor that calls the super constructor
    public Panda(String name) {
        super(name);
    }

    /**
     * A panda says "Nihao!".
     *
     * <p>(Mandatory method in {@link Animal} class.
     * <br> Must implement - otherwise, compiler error)
     */
    @Override
    public void says() {
        System.out.println("Nihao!");
    }
}
