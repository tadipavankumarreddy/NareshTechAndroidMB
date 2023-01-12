package in.nareshtechnologies.firebaserealtimedatabases;

public class Person {
    String name;
    int age;

    public Person() {
        // Empty constructor is needed
    }

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
}
