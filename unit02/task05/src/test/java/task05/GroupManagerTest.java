package task05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupManagerTest {

    ArrayList<Student> studentsList = new ArrayList<>();
    GroupManager groupManager = new GroupManager();
    ArrayList<HashMap<Student, Mark>> groups;
    @Test
    public void testCreateGroups() throws Exception {
        studentsList.add(new Student("Aviana"));
        studentsList.add(new Student("Orisa"));
        studentsList.add(new Student("Genji"));
        studentsList.add(new Student("Pharah"));
        studentsList.add(new Student("Thrall"));
        studentsList.add(new Student("Uther"));
        studentsList.add(new Student("Ana"));

        groups = groupManager.createGroups(studentsList);

        assertEquals(4, groups.size());
        Disciplines[] d = Disciplines.values();
        int i = 0;
        for (HashMap<Student, Mark> studentMarkHashMap:groups) {
            System.out.print(d[i].name() + ": ");
            for (Map.Entry<Student,Mark> entry: studentMarkHashMap.entrySet()) {
                Student student = entry.getKey();
                Mark mark = entry.getValue();

                System.out.printf(student.getName() + " " + mark.getValue() + ", ");
            }
            i++;
            System.out.println();
        }
    }

    @Test
    public void testCompareMarksForStudent() throws Exception {
        Student aviana = new Student("Aviana");

        groups = groupManager.createGroupsWithOneStudent(aviana);

        groupManager.compareMarksForStudent(aviana);
    }

}
