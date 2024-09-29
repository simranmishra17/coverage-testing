package org.example;

public class Person {

    private String name;
    private int age;
    private String email;

    // Constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        } else {
            System.out.println("Please enter a valid age.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email address.");
        }
    }

    // Method to print person details
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    // Static method to compare age of two people
    public static String compareAge(Person p1, Person p2) {
        if (p1.age > p2.age) {
            return p1.name + " is older than " + p2.name;
        } else if (p1.age < p2.age) {
            return p1.name + " is younger than " + p2.name;
        } else {
            return p1.name + " and " + p2.name + " are of the same age.";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Person person1 = new Person("John", 30, "john@example.com");
        Person person2 = new Person("Alice", 25, "alice@example.com");

        // Print details
        person1.printDetails();
        person2.printDetails();

        // Compare age
        System.out.println(Person.compareAge(person1, person2));
    }
}
