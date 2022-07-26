package demo.week5inheritance;

/**
 * A person with name & age.
 * <p>Demoed:
 * <ul>
 *     <li>Use Alt + Insert in IntelliJ to generate getters, setters
 *     equals, hashCode & toString
 *     <ul>
 *         <li>For equals & hashCode,
 *         select "Accept subclasses as parameter to equals() method" </li>
 *     </ul>
 *     </li>
 *     <li>String.format method</li>
 * </ul>
 */
public class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Two person objects are equal if they have the same name and age.
     *
     * @param o the other object to be compared to
     * @return true if the object is a person object and have same name & age.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    /**
     * Get the string representation of a person object.
     * <br>The format is <&lt name>>, age = <&lt age>>
     *
     * @return string representation of a person object
     */
    @Override
    public String toString() {
        return String.format("%s, age = %d", name, age);
    }
}
