package demo.week6collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class NonLinearDemo {
    /*
    Demoed:
    1. Difference between Tree and Hash:
    Tree checks compareTo;
    Hash checks equals and hashCode.
    2. Use lambda expression to pass in an anonymous comparator
    3. Use method reference operator to pass in an anonymous comparator
     */
    public static void main(String[] args) {
        // obj1 & obj2 have the same var1 but different var2
        MyObj obj1 = new MyObj("obj1", 1);
        MyObj obj2 = new MyObj("obj1", 2);

        // MyObj is comparable so can put into a TreeSet directly
        TreeSet<MyObj> tree = new TreeSet<>();
        /* TreeSet checks compareTo,
        and MyObj's compareTo is based on var1.
        Since var1 is the same,
        TreeSet treats obj1 & obj2 as the same object.
        And since sets don't allow duplicates,
        only obj1 will be put into tree.
         */
        System.out.println("Putting into tree...");
        tree.add(obj1);
        tree.add(obj2);
        System.out.println("Tree: " + tree);

        /* HashSet checks equals & hashCode,
        and MyObj's equals & hashCode is based on var2.
        Since var2 is different,
        HashSet treats obj1 & obj2 as different objects.
        So both obj1 & obj2 can be put into hash.
         */
        HashSet<MyObj> hash = new HashSet<>();
        System.out.println("Putting into hash...");
        hash.add(obj1);
        hash.add(obj2);
        System.out.println("Hash: " + hash);

        // Play with incomparable objects...
        // still same var1 different var2
        MyObjIncomparable incomparableObj1 = new MyObjIncomparable("obj1", 1);
        MyObjIncomparable incomparableObj2 = new MyObjIncomparable("obj1", 2);
        /*
        Since MyObjIncomparable is incomparable,
        can't add to a TreeSet directly.
        Need to supply a comparator, otherwise, exception (runtime error)
        The comparator supplied checks var2.
         */
        // Most concise way: using reference operator
        TreeSet<MyObjIncomparable> tree2 = new TreeSet<>(Comparator.comparingInt(MyObjIncomparable::getVar2));
        /* Comparator.comparingInt(MyObjIncomparable::getVar2) is equivalent to...
        1. lambda expression: (o1, o2) -> o1.getVar2() - o2.getVar2()
        2. Anonymous class:
        new Comparator<MyObjIncomparable>() {
            @Override
            public int compare(MyObjIncomparable o1, MyObjIncomparable o2) {
                return o1.getVar2() - o2.getVar2();
            }
        }
         */
        System.out.println("Putting into tree 2...");
        tree2.add(incomparableObj1);
        tree2.add(incomparableObj2);
        /*
        The comparator supplied checks var2,
        and since var2 is different,
        TreeSet treats incomparableObj1 & incomparableObj2 as different objects.
        So both of them can be put into tree2.
         */
        System.out.println("Tree 2: " + tree2);
    }

    /**
     * A comparable object for demo purpose.
     * <br> compareTo based on var1.
     * <br> equals based on var2.
     */
    static class MyObj implements Comparable<MyObj> {
        String var1;
        int var2;

        public MyObj(String var1, int var2) {
            this.var1 = var1;
            this.var2 = var2;
        }

        @Override
        public int compareTo(MyObj o) {
            return var1.compareTo(o.var1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            MyObj myObj = (MyObj) o;
            return var2 == myObj.var2;
        }

        @Override
        public int hashCode() {
            return var2;
        }

        @Override
        public String toString() {
            return "MyObj{" +
                    "var1='" + var1 + '\'' +
                    ", var2=" + var2 +
                    '}';
        }
    }
}
