package task05;

import java.util.ArrayList;
import java.util.Random;

public class GroupManager {
    private ArrayList<ArrayList<Student>> groups = new ArrayList<>();

    public ArrayList<ArrayList<Student>> createGroups(ArrayList<Student> studentsList){
        for (Disciplines d: Disciplines.values()) {
            ArrayList<Student> group = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                Student s = randomStudent(studentsList);
                if(group.contains(s)){
                    continue;
                }
                group.add(s);
            }
            groups.add(group);
        }
        return groups;
    }

    private Student randomStudent(ArrayList<Student> studentsList){
        Random rand = new Random();
        Student randomStud = studentsList.get(rand.nextInt(studentsList.size()));
        return randomStud;
    }
}
