import java.util.*;

public class JavaNonOOPExample {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<HashMap<String, Object>> listOfSchools = new ArrayList<>();

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("Choose an option:");
            System.out.println("1. Add School");
            System.out.println("2. Add Student");
            System.out.println("3. Add Subject and Marks");
            System.out.println("4. Retrieve Marks for a Student in a Subject");
            System.out.println("5. Calculate Average Marks for a Student");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> listOfSchools.add(addSchool());
                case 2 -> addStudentToSchool(listOfSchools);
                case 3 -> addSubjectAndMarks(listOfSchools);
                case 4 -> retrieveMarks(listOfSchools);
                case 5 -> calculateAverageMarks(listOfSchools);
                case 6 -> continueProgram = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static HashMap<String, Object> addSchool() {
        HashMap<String, Object> school = new HashMap<>();
        //add elements to the school hashmap
        System.out.println("Enter school name: ");
        school.put("school name", scanner.nextLine());
        System.out.println("Enter address: ");
        school.put("address", scanner.nextLine());
        school.put("students", new ArrayList<HashMap<String, Object>>());
        return school;
    }

    public static void addStudentToSchool(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name to add the student to:");
        //call find school function
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());
        //add elements to the school hashmap
        if (school != null) {
            HashMap<String, Object> student = new HashMap<>();
            System.out.println("Enter student name: ");
            student.put("student name", scanner.nextLine());
            System.out.println("Enter student id: ");
            student.put("student id", scanner.nextLine());
            System.out.println("Enter student grade: ");
            student.put("grade",  scanner.nextLine());
            System.out.println("Enter student age: ");
            student.put("age", scanner.nextShort());
            scanner.nextLine();
            student.put("subjects", new ArrayList<HashMap<String, Object>>());

            List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("students");
            students.add(student);
        } else {
            System.out.println("School not found.");
        }
    }

    public static void addSubjectAndMarks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        HashMap<String, Object> school = findSchool(listOfSchools, scanner.nextLine());

        //to add a subject ensure that the school and the student exist
        if (school != null) {
            System.out.println("Enter student ID:");
            //call the find student function
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            if (student != null) {
                //add elements to the subject hashmap
                HashMap<String, Object> subject = new HashMap<>();
                System.out.println("Enter subject name: ");
                subject.put("subject name", scanner.nextLine());
                System.out.println("Enter teacher name: ");
                subject.put("teacher name", scanner.nextLine());
                System.out.println("Enter credit hours: ");
                subject.put("credit hours",  scanner.nextShort());
                scanner.nextLine();

                List<HashMap<String, Object>> marksList = new ArrayList<>();

                //take the marks of the subject tests
                boolean marksFlag = true;
                while (marksFlag) {
                    HashMap<String, Object> marks = new HashMap<>();
                    System.out.println("Enter test name:");
                    marks.put("test name",  scanner.nextLine());
                    System.out.println("Enter marks:");
                    marks.put("marks", scanner.nextInt());
                    scanner.nextLine();
                    marksList.add(marks);

                    System.out.println("Add more marks? (yes/no)");
                    marksFlag = scanner.nextLine().equalsIgnoreCase("yes");
                }

                subject.put("marks", marksList);
                List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("subjects");
                subjects.add(subject);
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    public static void retrieveMarks(List<HashMap<String, Object>> listOfSchools) {
        System.out.println("Enter school name:");
        HashMap<String, Object> school = findSchool(listOfSchools,  scanner.nextLine());

        //to retrieve info, ensure that the school and the student id exist
        if (school != null) {
            System.out.println("Enter student ID:");
            String studentId = scanner.nextLine();
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), studentId);

            if (student != null) {
                System.out.println("Enter subject name:");
                List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("subjects");
                for (HashMap<String, Object> subject : subjects) {
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
        HashMap<String, Object> school = findSchool(listOfSchools,  scanner.nextLine());

        if (school != null) {
            System.out.println("Enter student ID:");
            HashMap<String, Object> student = findStudent((List<HashMap<String, Object>>) school.get("students"), scanner.nextLine());

            if (student != null) {
                List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("subjects");
                double totalMarks = 0;
                int count = 0;

                for (HashMap<String, Object> subject : subjects) {
                    List<HashMap<String, Object>> marksList = (List<HashMap<String, Object>>) subject.get("marks");
                    for (HashMap<String, Object> marks : marksList) {
                        totalMarks += (int) marks.get("marks");
                        count++;
                    }
                }

                if (count > 0) {
                    System.out.println("Average Marks: " + (totalMarks / count));
                } else {
                    System.out.println("No marks available.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static HashMap<String, Object> findSchool(List<HashMap<String, Object>> listOfSchools, String schoolName) {
        for (HashMap<String, Object> school : listOfSchools) {
            if (school.get("school name").equals(schoolName)) {
                return school;
            }
        }
        return null;
    }

    private static HashMap<String, Object> findStudent(List<HashMap<String, Object>> students, String studentId) {
        for (HashMap<String, Object> student : students) {
            if (student.get("student id").equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
