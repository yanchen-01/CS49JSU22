package demo.week6collections;

/**
 * Incomparable object - equals based on var1.
 * <br> (Constructor/getters/equals/hashCode/toString auto-generated
 * using Alt + Enter in IntelliJ
 */
public class MyObjIncomparable {
    private final String var1;
    private final int var2;

    public MyObjIncomparable(String var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public String getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyObjIncomparable that = (MyObjIncomparable) o;

        return var1.equals(that.var1);
    }

    @Override
    public int hashCode() {
        return var1.hashCode();
    }

    @Override
    public String toString() {
        return "MyObjIncomparable{" +
                "var1='" + var1 + '\'' +
                ", var2=" + var2 +
                '}';
    }
}
