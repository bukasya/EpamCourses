package task05;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupManagerTest {
    @Test
    public void testCreateGroups() throws Exception {
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Aviana"));
        studentsList.add(new Student("Orisa"));
        studentsList.add(new Student("Genji"));
        studentsList.add(new Student("Pharah"));
        studentsList.add(new Student("Thrall"));
        studentsList.add(new Student("Uther"));
        studentsList.add(new Student("Ana"));

        GroupManager groupManager = new GroupManager();
        ArrayList<ArrayList<Student>> s = groupManager.createGroups(studentsList);

        assertEquals(4, s.size());
        for (ArrayList<Student> st:s) {
            for (Student stud:st) {
                System.out.print(stud.getName() + " ");
            }
            System.out.println();
        }
    }

}