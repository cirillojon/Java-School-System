# Personnel Management System (Java)

This Java application is designed to manage and interact with information about personnel in an educational institution. It manages data for two types of personnel: `Student` and `Faculty`.

## Classes

- `Person`: This is an abstract class that defines the basic attributes and methods for a person in the system, such as ID and full name.

- `Student`: This class extends `Person` and adds specific attributes for students, including GPA and credit hours. It also contains methods to get and set these attributes, as well as a method `printInfo()` which calculates the total payment based on the student's GPA and credit hours.

- `Faculty`: This class also extends `Person` but adds attributes specific to faculty members such as department and rank. It also contains a `printInfo()` method, which prints out the faculty member's information.

- `IdException`: This is a custom Exception class that throws an exception when an invalid ID format is input.

- `PersonnelSystem`: This is the main driver class that interacts with the user. It allows the user to input information about students and faculty, as well as print their information. It contains methods for setting the information of students and faculty. 

## Functionality

The `PersonnelSystem` class provides a simple text-based user interface to perform the following actions:

1. Enter the information of the faculty.
2. Enter the information of a student.
3. Print tuition invoice for a student.
4. Print faculty information.
5. Exit the program.

All entered faculty and students are stored in an `ArrayList` of `Person` objects.

The application ensures valid input for IDs through the use of the `IdException` class. The ID should follow the format of two letters followed by four digits. If the entered ID does not follow this format, an `IdException` is thrown and the user is informed of the correct format.

## Usage

Compile and run the `PersonnelSystem.java` class. Interact with the program using the console. Choose the appropriate option from the main menu to enter information, print information, or exit the program.
