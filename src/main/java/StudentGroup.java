import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentGroup {

    private Map<Integer, Student> studentsList = new HashMap<>();
    private Map <Student, ArrayList<String>> studentsHomework = new HashMap<>();

    public Map<Student, ArrayList<String>> getStudentsHomework() {
        return studentsHomework;
    }

    private Student headman;

    public StudentGroup(Student headman) {
        this.headman = headman;
    }

    public void changeHeadman(Student headman){
        this.headman = headman;
    }

    public void addStudent(Student student){
        this.studentsList.put(student.getId(), student);
        System.out.printf("New student '%s %s' was add! %n", student.getFirstName(),student.getLastName());
    }

    public void removeStudent(Student student) {
        if (student.getId() != headman.getId()) {
            this.studentsList.remove(student.getId());
            System.out.printf("Student '%s %s' was remove! %n", student.getFirstName(),student.getLastName());
        } else {
            System.out.println("You can't remove headman! At first you should change headman");
        }
    }

    public void renameStudent(Student student, String firstName, String lastName){
        Student st = this.studentsList.get(student.getId());
        st.setFirstName(firstName);
        st.setLastName(lastName);
    }

    public void renameStudent(Student student, String lastName){
        Student st = this.studentsList.get(student.getId());
        st.setLastName(lastName);
    }

    public void addHomework(String homework) {
        for (Student stud: studentsList.values()) {
            if (this.studentsHomework.containsKey(stud)){
                this.studentsHomework.get(stud).add(homework);
            }
            else {
                 ArrayList <String> homeworkList = new ArrayList<>();
                 homeworkList.add(homework);
                this.studentsHomework.put(stud,homeworkList);
            }
        }
        System.out.printf("New homework '%s' was add! %n", homework);
    }

    public void markPassHomework(Student student, String homework){
        if(this.studentsHomework.containsKey(student)) {
            if (this.studentsHomework.get(student).contains(homework)) {
                this.studentsHomework.get(student).remove(homework);
            } else {
                System.out.printf("Homework '%s' already was pass for user '%s %s' %n", homework, student.getFirstName(), student.getLastName());
            }
        }
        else {
            System.out.printf("You can't mark pass homework for removed user - %s %s!", student.getFirstName(), student.getLastName());
        }
    }
}
