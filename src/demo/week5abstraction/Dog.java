package demo.week5abstraction;

/**
 * Dog is a concrete class that extends Animal class.
 */
public class Dog extends Animal{
    // Non-default constructor is not inherited
    // - must have a constructor that calls the super constructor
    public Dog(String name) {
        super(name);
    }

    /**
     * A dog says "Woof!".
     *
     * <p>(Mandatory method in {@link Animal} class.
     * <br> Must implement - otherwise, compiler error)
     */
    @Override
    public void says() {
        System.out.println("Woof!");
    }

    /**
     * Prints Dog <&lt name>> is breathing...
     *
     * <p>Dog extends Animal so Dog class inherits {@link Alive} interface
     * and can use & override the breath() method.
     *
     * <br>(Since superclass Animal implemented this method,
     * not require to override.)
     */
    public void breath(){
        System.out.print("Dog ");
        super.breath();
    }
}
