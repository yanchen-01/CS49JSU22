package demo.week5inheritance;

/**
 * A Graduate is a student with a stricter age restriction (24 to 70).
 * <br>String representation = (Graduate student) <&lt name>>, age = <&lt age>>
 */
public class GraduateStudent extends Student {
    public GraduateStudent(String name, int age, char grade) {
        super(name, 30, grade);
        this.setAge(age);
    }

    @Override
    public void setAge(int age) {
        if (age >= 24 && age <= 70)
            super.setAge(age);
        else
            throw new IllegalArgumentException("Graduate student age must be between 24 and 70");
    }

    @Override
    public String toString() {
        return super.toString().replace("(Student)", "(Graduate student)");
    }
}
