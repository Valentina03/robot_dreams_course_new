public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Valya", "Mix");
        Student student2 = new Student("Anna", "Lux");
        Student student3 = new Student("Kate", "Nex");
        Student student4 = new Student("Ney", "Pull");

        StudentGroup studentGroup = new StudentGroup(student2);
        studentGroup.addStudent(student1);
        studentGroup.addStudent(student2);
        studentGroup.addStudent(student3);
        studentGroup.addStudent(student4);
        studentGroup.changeHeadman(student4);

        //can't remove headman from group
        studentGroup.removeStudent(student4);

        //try to remove other users from group
        studentGroup.removeStudent(student3);

        studentGroup.renameStudent(student4,"Poll");
        studentGroup.addHomework("Task1");
        studentGroup.addHomework("Task2");
        studentGroup.markPassHomework(student2,"Task1");
        studentGroup.markPassHomework(student2,"Task1");
        studentGroup.markPassHomework(student3,"Task2");
    }
}