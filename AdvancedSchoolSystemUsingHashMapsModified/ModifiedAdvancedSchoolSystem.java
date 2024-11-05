import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ModifiedAdvancedSchoolSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<HashMap<String, Object>> listOfSchools = new ArrayList<>();
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("===== School Management System =====");
            System.out.println("1. School Management");
            System.out.println("2. Student Management");
            System.out.println("3. Teacher Management");
            System.out.println("4. Subject Management");
            System.out.println("5. Library Management");
            System.out.println("6. Exit");

            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            switch (categoryChoice) {
                case 1 -> schoolManagementMenu(listOfSchools);
                case 2 -> studentManagementMenu(listOfSchools);
                case 3 -> teacherManagementMenu(listOfSchools);
                case 4 -> subjectManagementMenu(listOfSchools);
                case 5 -> libraryManagementMenu(listOfSchools);
                case 6 -> continueProgram = false;
                default -> System.out.println("Invalid category, please try again");
            }
        }

        scanner.close();
    }

    public static void schoolManagementMenu(List<HashMap<String, Object>> listOfSchools) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Manage Schools =====");
            System.out.println("1. Add School");
            System.out.println("2. Exit to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listOfSchools.add(addSchool());
                case 2 -> exit = true;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void teacherManagementMenu(List<HashMap<String, Object>> listOfSchools) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Manage Teachers =====");
            System.out.println("1. Add Teacher");
            System.out.println("2. Assign Teacher to Subject");
            System.out.println("3. Exit to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTeacherToSchool(listOfSchools);
                case 2 -> assignTeacherToSubject(listOfSchools);
                case 3 -> exit = true;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void studentManagementMenu(List<HashMap<String, Object>> listOfSchools) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Manage Students =====");
            System.out.println("1. Add Student");
            System.out.println("2. Retrieve Marks for a Student in a Subject");
            System.out.println("3. Calculate Average Marks for a Student");
            System.out.println("4. Exit to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudentToSchool(listOfSchools);
                case 2 -> retrieveMarks(listOfSchools);
                case 3 -> calculateAverageMarks(listOfSchools);
                case 4 -> exit = true;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void subjectManagementMenu(List<HashMap<String, Object>> listOfSchools) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Manage Subjects =====");
            System.out.println("1. Add Subject and Marks");
            System.out.println("2. Exit to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSubjectAndMarks(listOfSchools);
                case 2 -> exit = true;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void libraryManagementMenu(List<HashMap<String, Object>> listOfSchools) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Manage Library =====");
            System.out.println("1. Add Book to Library");
            System.out.println("2. List Available Books");
            System.out.println("3. Assign Book to Student");
            System.out.println("4. Return Book");
            System.out.println("5. List Assigned Books for Student");
            System.out.println("6. Exit to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBookToLibrary(listOfSchools);
                case 2 -> listAvailableBooks(listOfSchools);
                case 3 -> assignBookToStudent(listOfSchools);
                case 4 -> returnBook(listOfSchools);
                case 5 -> listAssignedBooks(listOfSchools);
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }


    public static HashMap<String, Object> addSchool() {
        HashMap<String, Object> school = new HashMap<>();
        //add elements to the school hashmap
        System.out.println("Enter school name: ");
        school.put("school name", scanner.nextLine());
        System.out.println("Enter address: ");
        school.put("address", scanner.nextLine());
        school.put("students", new ArrayList<HashMap<String, Object>>());
        school.put("teachers", new ArrayList<HashMap<String, Object>>());
        school.put("library", new ArrayList<HashMap<String, Object>>());
        return school;
    }

    public static void addStudentToSchool(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name to add the student to:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        //if the school exist, then add elements to the student hashmap
        if (school != null) {
            HashMap<String, Object> studentMap = new HashMap<>();
            System.out.println("Enter student name: ");
            studentMap.put("student name", scanner.nextLine());
            System.out.println("Enter student id: ");
            studentMap.put("student id", scanner.nextLine());
            System.out.println("Enter student grade: ");
            studentMap.put("grade", scanner.nextLine());
            System.out.println("Enter student age: ");
            studentMap.put("age", scanner.nextShort());
            scanner.nextLine();
            studentMap.put("subjects", new ArrayList<HashMap<String, Object>>());

            //add the student hashmap to the list
            List<HashMap<String, Object>> studentsList = (List<HashMap<String, Object>>) school.get("students");
            studentsList.add(studentMap);
        } else {
            System.out.println("School not found.");
        }
    }

    public static void addTeacherToSchool(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name to add the teacher to:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        //if the school exist, then add elements to the teacher hashmap
        if (school != null) {
            HashMap<String, Object> teacherMap = new HashMap<>();
            System.out.println("Enter teacher name: ");
            teacherMap.put("teacher name", scanner.nextLine());
            System.out.println("Enter teacher id: ");
            teacherMap.put("teacher id", scanner.nextLine());
            System.out.println("Enter teacher expertise: ");
            teacherMap.put("expertise", scanner.nextLine());
            System.out.println("Enter teacher years of experience: ");
            teacherMap.put("experience years", scanner.nextShort());
            scanner.nextLine();
            teacherMap.put("teacher subjects", new ArrayList<HashMap<String, Object>>());

            //add the teacher hashmap to the list
            List<HashMap<String, Object>> teacherList = (List<HashMap<String, Object>>) school.get("teachers");
            teacherList.add(teacherMap);
        } else {
            System.out.println("School not found.");
        }
    }

    public static void assignTeacherToSubject(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //to assign a teacher to a subject check that the school and the student exist
        if (school != null) {
            System.out.println("Enter student ID:");
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            //get the subject of the student
            if (student != null) {
                System.out.println("Enter subject name:");
                String subjectName = scanner.nextLine();
                List<HashMap<String, Object>> subjectsList = (List<HashMap<String, Object>>) student.get("subjects");
                HashMap<String, Object> targetSubjectMap = null;

                //set target subject
                for (HashMap<String, Object> subject : subjectsList) {
                    if (subject.get("subject name").equals(subjectName)) {
                        targetSubjectMap = subject;
                        break;
                    }
                }

                //assign a teacher to a subject
                if (targetSubjectMap != null) {
                    System.out.println("Enter teacher ID to assign:");
                    String teacherId = scanner.nextLine();

                    //get the teacher list from the school
                    List<HashMap<String, Object>> teacherList = (List<HashMap<String, Object>>) school.get("teachers");
                    HashMap<String, Object> assignedTeacherMap = null;
                    //set the assigned teacher map
                    for (HashMap<String, Object> teacher : teacherList) {
                        if (teacher.get("teacher id").equals(teacherId)) {
                            assignedTeacherMap = teacher;
                            break;
                        }
                    }

                    if (assignedTeacherMap != null) {
                        targetSubjectMap.put("assigned teacher", assignedTeacherMap);
                        System.out.println("Teacher assigned to subject successfully");
                    } else {
                        System.out.println("Teacher not found.");
                    }
                } else {
                    System.out.println("Subject not found.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }


    public static void addSubjectAndMarks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        //to add a subject ensure that the school and the student exist
        if (school != null) {
            System.out.println("Enter student ID:");
            //call the find student function
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            //if the there are students, then add elements to subject hashmap
            if (student != null) {
                HashMap<String, Object> subjectMap = new HashMap<>();
                System.out.println("Enter subject name: ");
                subjectMap.put("subject name", scanner.nextLine());
                System.out.println("Enter credit hours: ");
                subjectMap.put("credit hours", scanner.nextShort());
                scanner.nextLine();

                List<HashMap<String, Object>> marksList = new ArrayList<>();

                //take the marks of the subject tests
                boolean marksFlag = true;
                while (marksFlag) {
                    HashMap<String, Object> marksMap = new HashMap<>();
                    System.out.println("Enter test name:");
                    marksMap.put("test name", scanner.nextLine());
                    System.out.println("Enter marks:");
                    marksMap.put("marks", scanner.nextInt());
                    scanner.nextLine();
                    marksList.add(marksMap);

                    //check if there is more marks to enter
                    System.out.println("Add more marks? (yes/no)");
                    marksFlag = scanner.nextLine().equalsIgnoreCase("yes");
                }

                subjectMap.put("marks", marksList);
                List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("subjects");
                subjects.add(subjectMap);
                System.out.println("Subject added successfully, assign a teacher using the 'Assign Teacher to Subject' option");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    public static void retrieveMarks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //to retrieve info, ensure that the school and the student id exist
        if (school != null) {
            System.out.println("Enter student ID:");
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            //if the there is a student, then get the subjects
            if (student != null) {
                System.out.println("Enter subject name:");
                List<HashMap<String, Object>> subjectsList = (List<HashMap<String, Object>>) student.get("subjects");
                for (HashMap<String, Object> subject : subjectsList) {
                    //if the subject match the user input, then print the marks
                    if (subject.get("subject name").equals(scanner.nextLine())) {
                        System.out.println("Marks: " + subject.get("marks"));
                        return;
                    }
                }
                System.out.println("Subject not found.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    public static void calculateAverageMarks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //to calculate the marks, check that the school and student exist
        if (school != null) {
            System.out.println("Enter student ID:");
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            if (student != null) {
                List<HashMap<String, Object>> subjectsList = (List<HashMap<String, Object>>) student.get("subjects");
                double totalMarks = 0;
                int count = 0;

                for (HashMap<String, Object> subject : subjectsList) {
                    List<HashMap<String, Object>> marksList = (List<HashMap<String, Object>>) subject.get("marks");
                    for (HashMap<String, Object> marks : marksList) {
                        totalMarks += (int) marks.get("marks");
                        count++;
                    }
                }

                if (count > 0) {
                    System.out.println("Average Marks: " + (totalMarks / count));
                } else {
                    System.out.println("No marks available");
                }
            } else {
                System.out.println("Student not found");
            }
        } else {
            System.out.println("School not found");
        }
    }

    public static void addBookToLibrary(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name to add the book to library:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        //if the school exist, then add elements to the books hashmap
        if (school != null) {
            HashMap<String, Object> bookMap = new HashMap<>();
            System.out.println("Enter book name: ");
            bookMap.put("title", scanner.nextLine());
            System.out.println("Enter book id: ");
            bookMap.put("book id", scanner.nextLine());
            System.out.println("Enter the author of the book: ");
            bookMap.put("author", scanner.nextLine());
            System.out.println("Enter publication year: ");
            bookMap.put("publication year", scanner.nextShort());
            scanner.nextLine();
            bookMap.put("availability status", "available");

            List<HashMap<String, Object>> libraryList = (List<HashMap<String, Object>>) school.get("library");
            //add the books to the library
            libraryList.add(bookMap);
            System.out.println("Book added successfully to the library");
        } else {
            System.out.println("School not found.");
        }
    }

    public static void listAvailableBooks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        if (school != null) {
            List<HashMap<String, Object>> library = (List<HashMap<String, Object>>) school.get("library");

            //check if the library exist and there is book in it
            if (library != null && !library.isEmpty()) {
                System.out.println("Available books in " + school.get("school name") + " library:");
                boolean foundAvailableBook = false;
                //loop through the library list
                for (HashMap<String, Object> book : library) {
                    if ("available".equals(book.get("availability status"))) {
                        System.out.println("Title: " + book.get("title"));
                        System.out.println("Book ID: " + book.get("book id"));
                        System.out.println("Author: " + book.get("author"));
                        System.out.println("Publication Year: " + book.get("publication year"));
                        System.out.println("-----------------------------------");
                        foundAvailableBook = true;
                    }
                }
                if (!foundAvailableBook) {
                    System.out.println("No available books");
                }
            } else {
                System.out.println("The library has no books");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    public static void assignBookToStudent(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //if the school exist, then check if the book exist
        if (school != null) {
            System.out.println("Enter book ID:");
            String bookID = scanner.nextLine();
            //find the book in the school library list
            List<HashMap<String, Object>> libraryList = (List<HashMap<String, Object>>) school.get("library");
            HashMap<String, Object> bookMap = null;

            //loop through the library list and check if the book id match, and if the book is available
            for (HashMap<String, Object> book : libraryList) {
                if (book.get("book id").equals(bookID) && "available".equals(book.get("availability status"))) {
                    bookMap = book;
                    break;
                }
            }
            //if the book exist, then check if the student exist
            if (bookMap != null) {
                System.out.println("Enter student ID:");
                String studentID = scanner.nextLine();
                List<HashMap<String, Object>> studentsList = (List<HashMap<String, Object>>) school.get("students");
                HashMap<String, Object> studentMap = null;
                for (HashMap<String, Object> student : studentsList) {
                    if (student.get("student id").equals(studentID)) {
                        studentMap = student;
                        break;
                    }
                }

                //if the student exist, then assign the book
                if (studentMap != null) {
                    //assign book to the student and mark it as unavailable
                    bookMap.put("availability status", "unavailable");
                    bookMap.put("assigned to", studentID);

                    //add book to the assigned books list
                    List<HashMap<String, Object>> assignedBooksList = (List<HashMap<String, Object>>) studentMap.get("assigned books");
                    //if the list is null, then initialize it
                    if (assignedBooksList == null) {
                        assignedBooksList = new ArrayList<>();
                        studentMap.put("assigned books", assignedBooksList);
                    }
                    //otherwise, add it to the list
                    assignedBooksList.add(bookMap);

                    System.out.println("Book assigned successfully to student " + studentID);
                } else {
                    System.out.println("Student not found");
                }
            } else {
                System.out.println("Book not available or not found");
            }
        } else {
            System.out.println("School not found");
        }
    }

    public static void returnBook(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //check if the book exist
        if (school != null) {
            System.out.println("Enter book ID:");
            String bookID = scanner.nextLine();
            List<HashMap<String, Object>> libraryList = (List<HashMap<String, Object>>) school.get("library");
            HashMap<String, Object> bookMap = null;
            for (HashMap<String, Object> b : libraryList) {
                if (b.get("book id").equals(bookID)) {
                    bookMap = b;
                    break;
                }
            }

            //check that the book is unavailable to change it status
            if (bookMap != null && "unavailable".equals(bookMap.get("availability status"))) {
                //get the id of the student who borrowed it and remove them from the list of assigned books
                String studentID = (String) bookMap.get("assigned to");

                List<HashMap<String, Object>> studentsList = (List<HashMap<String, Object>>) school.get("students");
                for (HashMap<String, Object> s : studentsList) {
                    if (s.get("student id").equals(studentID)) {
                        List<HashMap<String, Object>> assignedBooksList = (List<HashMap<String, Object>>) s.get("assigned books");
                        if (assignedBooksList != null) {
                            assignedBooksList.remove(bookMap);
                        }
                        break;
                    }
                }

                //update book availability and clear the assigned student
                bookMap.put("availability status", "available");
                bookMap.remove("assigned to");

                System.out.println("Book returned successfully");
            } else {
                System.out.println("Book not found or already available");
            }
        } else {
            System.out.println("School not found");
        }
    }

    public static void listAssignedBooks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        //call find school function to check if the school exist
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //check if the student exist
        if (school != null) {
            System.out.println("Enter student ID:");
            String studentID = scanner.nextLine();

            List<HashMap<String, Object>> studentsList = (List<HashMap<String, Object>>) school.get("students");
            HashMap<String, Object> studentMap = null;

            for (HashMap<String, Object> s : studentsList) {
                if (s.get("student id").equals(studentID)) {
                    studentMap = s;
                    break;
                }
            }
            //if the student exist, then display the assigned books
            if (studentMap != null) {
                List<HashMap<String, Object>> assignedBooksList = (List<HashMap<String, Object>>) studentMap.get("assigned books");

                if (assignedBooksList != null && !assignedBooksList.isEmpty()) {
                    System.out.println("Books assigned to student " + studentID + ":");
                    for (HashMap<String, Object> book : assignedBooksList) {
                        System.out.println("Title: " + book.get("title"));
                        System.out.println("Book ID: " + book.get("book id"));
                        System.out.println("Author: " + book.get("author"));
                        System.out.println("Publication Year: " + book.get("publication year"));
                        System.out.println("-----------------------------------");
                    }
                } else {
                    System.out.println("No books currently assigned to this student");
                }
            } else {
                System.out.println("Student not found");
            }
        } else {
            System.out.println("School not found");
        }
    }

    public static HashMap<String, Object> findSchool(List<HashMap<String, Object>> listOfSchools, String schoolName) {
        for (HashMap<String, Object> school : listOfSchools) {
            if (school.get("school name").equals(schoolName)) {
                return school;
            }
        }
        return null;
    }

    public static HashMap<String, Object> findStudent(List<HashMap<String, Object>> students, String studentId) {
        for (HashMap<String, Object> student : students) {
            if (student.get("student id").equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}