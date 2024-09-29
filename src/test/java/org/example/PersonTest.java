package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Person person = new Person("John", 30, "john@example.com");

        // Assert
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
        assertEquals("john@example.com", person.getEmail());
    }

    @Test
    void testSetName() {
        // Arrange
        Person person = new Person("John", 30, "john@example.com");

        // Act
        person.setName("Alice");

        // Assert
        assertEquals("Alice", person.getName());
    }

    @Test
    void testSetAge() {
        // Arrange
        Person person = new Person("John", 30, "john@example.com");

        // Act
        person.setAge(35);

        // Assert
        assertEquals(35, person.getAge());

        // Test invalid age
        person.setAge(-1);  // Should not change the age
        assertEquals(35, person.getAge());  // Age should remain 35
    }

    @Test
    void testSetEmail() {
        // Arrange
        Person person = new Person("John", 30, "john@example.com");

        // Act
        person.setEmail("alice@example.com");

        // Assert
        assertEquals("alice@example.com", person.getEmail());

        // Test invalid email
        person.setEmail("invalidemail");  // Invalid email, should not change
        assertEquals("alice@example.com", person.getEmail());  // Email should remain the same
    }

    @Test
    void testCompareAge() {
        // Arrange
        Person person1 = new Person("John", 30, "john@example.com");
        Person person2 = new Person("Alice", 25, "alice@example.com");

        // Act & Assert
        assertEquals("John is older than Alice", Person.compareAge(person1, person2));

        person2.setAge(35);
        assertEquals("John is younger than Alice", Person.compareAge(person1, person2));

        person2.setAge(30);
        assertEquals("John and Alice are of the same age.", Person.compareAge(person1, person2));
    }

    @Test
    void testPrintDetails() {
        // Arrange
        Person person = new Person("John", 30, "john@example.com");

        // Act and Assert (We can't check console output directly with JUnit, but this ensures the method runs without errors)
        assertDoesNotThrow(() -> person.printDetails());
    }
}
