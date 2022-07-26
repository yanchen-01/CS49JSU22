package demo.week5abstraction;

public interface Alive {
   // Methods in interfaces are public and abstract by default
   // so no need to explicitly put the modifiers
   void breath();

   /**
    * A default method to demo that
    * an interface can have concrete default method.
    */
   default void forDemo(){
      System.out.println("Yo");
   }
}
