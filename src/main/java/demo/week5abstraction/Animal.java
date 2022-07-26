package demo.week5abstraction;

/**
 * An abstract class for animal objects and each animal has its name.
 * <br> Animals are alive and comparable to another animal (based on name).
 */
public abstract class Animal implements Alive, Comparable<Animal>{
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    /**
     * An abstract method so that each subclass must implement this method.
     */
    abstract public void says();

    /**
     * Mandatory method in Comparable interface which defines
     * how this animal object is compared to other animal object.
     * <br>(Must implement - if this method is not implemented,
     * no compiler error in Animal class since it is abstract,
     * concrete subclasses of Animal will have compiler error.)
     *
     * @param o the object to be compared
     * @return result based on the name of the animal
     */
    @Override
    public int compareTo(Animal o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Prints <&lt name>> is breathing...
     *
     * <p>(Mandatory method in {@link Alive} interface.
     * <br>Must implement - if this method is not implemented,
     * no compiler error in Animal class since it is abstract,
     * but concrete subclasses of Animal will have compiler error.)
     */
    @Override
    public void breath(){
        System.out.println(name + " is breathing...");
    }

    /**
     * The default method in {@link Alive} interface can also be overridden
     * <br>(Not required to implement - no compiler error if this is not overridden.)
     */
    @Override
    public void forDemo() {
        System.out.println("Demo only");
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
