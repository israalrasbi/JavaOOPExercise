import java.util.*;


public class AdvancedSchoolSystem {
    static Map<String, String> schoolMap = new HashMap<>();
    static Map<String, Map<Integer, Map<String, Object>>> nestedMainMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //add schools
        System.out.print("Enter number of school: ");
        int numOfSchools = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= numOfSchools; i++) {
            System.out.println("Enter details for School " + i);
            System.out.println("-----------------------------------");
            System.out.print("School Name: ");
            String schoolName = sc.nextLine();
            System.out.print("School Address: ");
            String address = sc.nextLine();
            addSchool(schoolName, address);

            System.out.println();
            //add students to each school
            System.out.print("Enter number of students: ");
            int numOfStudents = sc.nextInt();
            sc.nextLine();
            for (int j = 1; j <= numOfStudents; j++) {
                System.out.println("Enter details for Student " + j + " in " + schoolName);
                System.out.println("**********************************");
                System.out.print("Student ID: ");
                int studentId = sc.nextInt();
                sc.nextLine();
                System.out.print("Student Name: ");
                String studentName = sc.nextLine();
                System.out.print("Grade (A, B, etc.): ");
                char grade = sc.next().charAt(0);
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                addStudent(schoolName, studentId, studentName, grade, age);

                System.out.println();

                //add subjects for each student
                System.out.print("Enter number of subjects: ");
                int numOfSubjects = sc.nextInt();
                sc.nextLine();
                for (int k = 1; k <= numOfSubjects; k++) {
                    System.out.println("Enter details for Subject " + k + " for Student " + studentId);
                    System.out.println("********************************************");
                    System.out.print("Subject Name: ");
                    String subjectName = sc.nextLine();
                    System.out.print("Teacher Name: ");
                    String teacherName = sc.nextLine();
                    System.out.print("Credit Hours: ");
                    int credit = sc.nextInt();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    System.out.print("Grade (A, B, etc.): ");
                    char subjectGrade = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.print("Comments: ");
                    String comments = sc.nextLine();
                    addSubjectAndMarks(schoolName, studentId, subjectName, teacherName, credit, marks, subjectGrade, comments);
                }
            }
        }
        System.out.println("\nRetrieve Marks and Calculate Average:");
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine();

        Map<String, Object> marksDetails = getMark(schoolName, studentId, subjectName);
        System.out.println("Marks Details: " + marksDetails);

        float averageMarks = calculateAverage(schoolName, studentId);
        System.out.println("Average Marks for Student " + studentId + ": " + averageMarks);
    }

    public static void addSchool(String name, String address) {
        schoolMap.put(name, address);
        nestedMainMap.put(name, new HashMap<>());
    }

    public static void addStudent(String schoolName, int id, String studentName, char grade, int age) {
        //check if the school exist
        if (schoolMap.containsKey(schoolName)) {
            //define a HashMap for student in case the id doesn't exist
            //the key is the id, and the value is a map
            Map<Integer, Map<String, Object>> mainStudentMap = nestedMainMap.get(schoolName);
            if (!mainStudentMap.containsKey(id)) {
                //define a map to store the student details
                Map<String, Object> studentDetailsMap = new HashMap<>();
                studentDetailsMap.put("name", studentName);
                studentDetailsMap.put("grade", grade);
                studentDetailsMap.put("age", age);
                //the key subjects will contain a map of all the subjects the student took
                studentDetailsMap.put("subjects", new HashMap<String, Map<String, Object>>());

                //add the details of the student to the student map
                mainStudentMap.put(id, studentDetailsMap);
            }
            //if the id already exist, then print a message
            else {
                System.out.println("Student with ID " + id + " already exists in " + schoolName);
            }
        }
        //if the school doesn't exist, then print a message
        else {
            System.out.println("School " + schoolName + " does not exist");
        }
    }

    public static void addSubjectAndMarks(String schoolName, int id, String subjectName, String teacherName, int credit, int marks, char grade, String comment) {
        //check if the main HashMap contains the school name and the student id
        if (nestedMainMap.containsKey(schoolName) && nestedMainMap.get(schoolName).containsKey(id)) {
            //this map will retrieve the student details of a specific id from a specific school
            Map<String, Object> studentDetailsMap = nestedMainMap.get(schoolName).get(id);
            //this map will only retrieve the subjects key from the student details
            Map<String, Map<String, Object>> mainSubjectsMap = (Map<String, Map<String, Object>>) studentDetailsMap.get("subjects");

            //define the subject details map
            Map<String, Object> subjectDetails = new HashMap<>();
            subjectDetails.put("teacher", teacherName);
            subjectDetails.put("creditHours", credit);
            subjectDetails.put("marks", marks);
            subjectDetails.put("grade", grade);
            subjectDetails.put("comment", comment);

            //add the subject details to the subjects map
            mainSubjectsMap.put(subjectName, subjectDetails);
        } else {
            System.out.println("Student with ID " + id + " in " + schoolName + " does not exist");
        }
    }

    public static Map<String, Object> getMark(String schoolName, int id, String subjectName) {
        if (nestedMainMap.containsKey(schoolName) && nestedMainMap.get(schoolName).containsKey(id)) {
            Map<String, Object> studentDetailsMap = nestedMainMap.get(schoolName).get(id);
            Map<String, Map<String, Object>> mainSubjectsMap = (Map<String, Map<String, Object>>) studentDetailsMap.get("subjects");

            //check if the subject exist
            if (mainSubjectsMap.containsKey(subjectName)) {
                return mainSubjectsMap.get(subjectName);
            } else {
                System.out.println("Subject " + subjectName + " not found for student with ID " + id + " in " + schoolName);
            }
        } else {
            System.out.println("Student with ID " + id + " in " + schoolName + " does not exist");
        }
        return null;
    }

    public static float calculateAverage(String schoolName, int id) {
        if (nestedMainMap.containsKey(schoolName) && nestedMainMap.get(schoolName).containsKey(id)) {
            Map<String, Object> studentDetailsMap = nestedMainMap.get(schoolName).get(id);
            Map<String, Map<String, Object>> mainSubjectsMap = (Map<String, Map<String, Object>>) studentDetailsMap.get("subjects");

            int totalMarks = 0;
            int numOfSubjects = mainSubjectsMap.size();

            //loop through the subjects map to calculate the total marks
            for (Map<String, Object> subjectDetails : mainSubjectsMap.values()) {
                totalMarks += (int) subjectDetails.get("marks");
            }
            if (numOfSubjects > 0) {
                return (float) totalMarks / numOfSubjects;
            } else {
                return 0;
            }
        } else {
            System.out.println("Student with ID " + id + " in " + schoolName + " does not exist");
            return 0;
        }
    }
}
