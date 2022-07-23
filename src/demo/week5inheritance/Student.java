package demo.week5inheritance;

/**
 * A student is a person with age restriction (18 to 70) and has grade.
 * <br>Default grade = A if not specified.
 * <br>String representation = (Student) <&lt name>>, age = <&lt age>>
 */
public class Student extends Person {

    private final char grade;

    public Student(String name, int age, char grade) {
        super(name, 18);
        this.setAge(age);
        this.grade = grade;
    }

    public Student(String name, int age) {
        this(name, age, 'A');
    }

    @Override
    public void setAge(int age) {
        if (age >= 18 && age <= 70)
            super.setAge(age);
        else
            throw new IllegalArgumentException("Student age must be between 18 and 70");
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "(Student)" + super.toString();
    }

}
