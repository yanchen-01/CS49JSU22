package edu.sjsu.assignment4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Gradebook {
    private final HashMap<Student, Character> studentsMap;

    public Gradebook() {
        this.studentsMap = new HashMap<>();
    }

    public boolean addStudent(Student student, char grade) {
        if (studentsMap.containsKey(student))
            return false;
        if (gradeInvalid(grade))
            grade = 'N';
        studentsMap.put(student, grade);
        return true;
    }

    public boolean addStudent(Student student) {
        return addStudent(student, 'N');
    }

    public boolean deleteStudent(int id) {
        Student toRemove = new Student(id);

        return studentsMap.remove(toRemove) != null;
    }

    public boolean updateStudent(int id, String newName) {
        Student toUpdate = new Student(id, newName);
        Character grade = studentsMap.remove(toUpdate);
        if (grade == null) return false;
        studentsMap.put(toUpdate, grade);
        return true;
    }

    public boolean updateGrade(int id, char newGrade) {
        if (gradeInvalid(newGrade))
            return false;
        return studentsMap.replace(new Student(id), newGrade) != null;
    }

    public void printGrades(Comparator<Student> comparator) {
        TreeMap<Student, Character> sorted = new TreeMap<>(comparator);
        sorted.putAll(studentsMap);
        sorted.forEach((student, grade) ->
                System.out.println(student + ": " + grade)
        );
    }

    private boolean gradeInvalid(char grade) {
        return !"ABCDFN".contains(String.valueOf(grade));
    }
}
