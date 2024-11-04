import java.util.*;

public class JavaNonOOPExample {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Object> school = new HashMap<>();
    static HashMap<String, Object> studentMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getSchools());

        scanner.close();
    }

    public static void addSchool(String name, String address) {
        school.put("school name", name);
        school.put("address", address);
    }

    public static void addStudent(String id, String studentName, String grade, short age) {
        studentMap.put("student name", studentName);
        studentMap.put("student id", id);
        studentMap.put("grade", grade);
        studentMap.put("age", age);
    }

    public static List<HashMap<String, Object>> getSchools() {
        List<HashMap<String, Object>> listOfSchools = new ArrayList<>();
        Boolean schoolFlag = Boolean.TRUE;
        while (schoolFlag) {
            System.out.println("Enter school name: ");
            String nameOfSchool = scanner.nextLine();
            System.out.println("Enter address: ");
            String address = scanner.nextLine();
            //call the function addSchool
            addSchool(nameOfSchool, address);

            List<HashMap<String, Object>> studentsForThisSchool = new ArrayList<>();
            Boolean studentFlag = Boolean.TRUE;
            while (studentFlag) {
                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Enter student id: ");
                String id = scanner.nextLine();
                System.out.println("Enter student grade: ");
                String grade = scanner.nextLine();
                System.out.println("Enter student age");
                Short age = scanner.nextShort();

                //call the addStudent function
                addStudent(id,studentName,grade,age);


                studentsForThisSchool.add(studentMap);

                List<HashMap<String, Object>> subjectsForThisStudent = new ArrayList<>();

                Boolean subjectFlag = Boolean.TRUE;
                while (subjectFlag) {
                    System.out.println("Enter subject name: ");
                    String subjectName = scanner.nextLine();
                    System.out.println("Enter teacher name: ");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter credit: ");
                    Short creditHours = scanner.nextShort();
                    HashMap<String, Object> subjectMap = new HashMap<>();
                    subjectMap.put("Subject Name: ", subjectName);
                    subjectMap.put("Teacher's Name", teacherName);
                    subjectMap.put("Credit Hours: ", creditHours);

                    List<HashMap<String, Object>> marksForThisSubject = new ArrayList<>();

                    Boolean marksFlag = Boolean.TRUE;
                    while (marksFlag) {
                        System.out.println("Enter the test name :");
                        String testName = scanner.nextLine();
                        System.out.println("Enter the marks:");
                        Integer marks = scanner.nextInt();

                        HashMap<String, Object> marksHashmaps = new HashMap<>();
                        marksHashmaps.put("Test Name", testName);
                        marksHashmaps.put("Marks", marks);

                        marksForThisSubject.add(marksHashmaps);
                    }
                    subjectMap.put("Marks", marksForThisSubject);
                    subjectsForThisStudent.add(subjectMap);
                }
                studentMap.put("Subjects", subjectsForThisStudent);
                studentsForThisSchool.add(studentMap);
            }
            school.put("Students", studentsForThisSchool);
            listOfSchools.add(school);
        }
        return listOfSchools;
    }

}
