package demo;

public class Student {
    private final String lastName;
    private String firstName;
    private int score;

    public Student(String first, String lastName, int score) {
        firstName = first;
        this.lastName = lastName;
        this.score = score;
    }

    public Student(String firstName, String lastName) {
        this(firstName, lastName, 100);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        // if score <= 100, set
        // otherwise, don't set
        if (score <= 100)
            this.score = score;
    }
}
