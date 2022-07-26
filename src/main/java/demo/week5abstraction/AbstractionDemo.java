package demo.week5abstraction;

import java.util.Arrays;

public class AbstractionDemo {
    /*
    Demoed:
    1. Substitution principle: when a superclass object is required, can supply
    a subclass object (but not other way around).
    2. Anonymous class - define a class and construct an object at the same time.
    (only can be used once and only works for a subclass of a named class)
    3. Anonymous object/variable - object without name (only can be used once)
    4. Polymorphism - which method to use is based on the actual object
    (the one on the right-hand side after new)
    5. toString - when "print" an Animal object, the format is based on the toString method
    6. Comparable interface - Animal objects are comparable
    so that we can sort an array of animal objects
    */
    public static void main(String[] args) {
        Panda panda = new Panda("Alice");

        // The following is valid because dog must be an animal,
        Animal dog = new Dog("Bob");
        /*
        But Panda = new Animal ... or Dog ... = new Animal ...
        are invalid since an animal may or may not be a panda/dog.
         */

        // Animal is abstract, so new Animal("Trudy"); is invalid.
        // Construct an animal object using an anonymous class
        Animal cat = new Animal("Trudy") {
            @Override
            public void says() {
                System.out.println("Meow!");
            }
        };


        Tree tree = new Tree(10);
        /* new Panda("Eve") is an Anonymous panda object.
        "Eve", dog and cat are all animal objects
         therefore they all inherit the implementation of Alive interface
         (i.e. they are all alive)
         */
        Alive[] alives = {new Panda("Eve"), dog, cat, tree};

        // Which "breath" to be called based on the actual object
        for (Alive a : alives) {
            a.breath();
        }

        // Sort an array of animals
        Animal[] animals = {dog, panda, cat};
        System.out.println("Before sorting: " + Arrays.toString(animals));
        Arrays.sort(animals);
        System.out.println("After sorting: " + Arrays.toString(animals));
    }
}
