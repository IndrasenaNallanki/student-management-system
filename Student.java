package source;

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    // Setters (optional, if you want to update values)
}
