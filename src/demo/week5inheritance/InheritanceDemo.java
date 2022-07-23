package demo.week5inheritance;

public class InheritanceDemo {

    /*
    Demoed:
    1. Substitution principle: when a superclass object is required, can supply
    a subclass object (but not other way around).
    2. Polymorphism - which constructor/method to use is based on the actual object
    (the one on the right-hand side after new)
    3. toString - when "print" a person object, the format is based on the toString method
    4. equals method - as long as two person object have the same name and age,
    they are equal to each other, even if they are different type of person.
     */
    public static void main(String[] args) {
        // Can construct
        construct("Person", "Alice", 16);
        // Can't construct since student age should between 18 & 70.
        construct("Student", "Alice", 16);
        // Can construct
        construct("Student", "Bob", 20);
        // Can't construct since graduate student age should between 24 & 70.
        construct("GraduateStudent", "Bob", 20);

        Person student1 = new Student("Cathy", 25);
        GraduateStudent student2 = new GraduateStudent("Cathy", 25, 'B');
        /*
         Although student1 is a student object and student2 is a graduate student,
         student1 equals to student2 since they have the same name and age.
         */
        System.out.println("student1 equal to student2? " + student1.equals(student2));
    }

    /**
     * Construct a person object based on the person type, name and age
     * @param type a general Person or a Student or a Graduate Student
     * @param name name of the person
     * @param age age of the person
     */
    private static void construct(String type, String name, int age) {
        try {
            Person person = switch (type){
                case "Person" -> new Person(name, age);
                case "Student" -> new Student(name, age);
                case "GraduateStudent" -> new GraduateStudent(name, age, 'B');
                default -> throw new IllegalArgumentException("Unsupported type");
            };

            System.out.println(person + " is constructed successfully");
        } catch (Exception e) {
            System.out.println("!!Fail to construct: " + e.getMessage());
        }
    }

}
