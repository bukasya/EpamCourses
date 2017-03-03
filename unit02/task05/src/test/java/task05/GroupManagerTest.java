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
    }

    @Test
    public void testCompareMarksForStudent() throws Exception {
        ArrayList<Mark> markList = new ArrayList<>();
        Student aviana = new Student("Aviana");

        groups = groupManager.createGroupsWithOneStudent(aviana);
        HashMap<Disciplines, Mark> disciplinesMarkHashMap = groupManager.compareMarksForStudent(aviana);

        for (Map.Entry<Disciplines, Mark> entry: disciplinesMarkHashMap.entrySet()) {
            markList.add(entry.getValue());
        }

        assertTrue(isSorted(markList));

    }

    public boolean isSorted(ArrayList<Mark> list)
    {
        boolean sorted = false;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = true;
        }

        return sorted;
    }

}
