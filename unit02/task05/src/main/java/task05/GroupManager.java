package task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GroupManager {
    private ArrayList<HashMap<Student, Mark>> groups = new ArrayList<>();

    public ArrayList<HashMap<Student, Mark>> createGroups(ArrayList<Student> studentsList){
        for (Disciplines d: Disciplines.values()) {
            HashMap<Student, Mark> group = new HashMap<>();
            for(int i = 0; i < 5; i++) {
                Student s = randomStudent(studentsList);
                if(group.containsKey(s)){
                    continue;
                }
                if(d.ordinal()%2 == 0)
                    group.put(s, new Mark<>(randomValue(2.0, 5.0)));
                else
                    group.put(s, new Mark<Double>((double)(Integer)randomValue(2.0, 5.0).intValue()));
            }
            groups.add(group);
        }
        return groups;
    }

    public Student randomStudent(ArrayList<Student> studentsList){
        Random rand = new Random();
        Student randomStud = studentsList.get(rand.nextInt(studentsList.size()));
        return randomStud;
    }

    //// TODO: 03.03.2017 replace with randomMark()
    private Double randomValue(double min, double max){
        Random rand = new Random();
        return new Double(min + (max - min) * rand.nextDouble());
    }

    public void compareMarksForStudent(Student student){
        //HashMap<Disciplines, Mark> h = new HashMap<>();
        ArrayList<Mark> marks = new ArrayList<>();
        Disciplines[] d = Disciplines.values();
        int i = 0;
        for (HashMap<Student, Mark> studentMarkHashMap: groups) {
            if(studentMarkHashMap.containsKey(student)){
                marks.add(studentMarkHashMap.get(student));
                //h.put(d[i], studentMarkHashMap.get(student));
            }
            else marks.add(new Mark(0.0));
        }
        for (Mark mark: marks) {
            if(!mark.getValue().equals((double)0)){
                System.out.println(d[i].toString() + " " + mark.getValue());
            }
            i++;
        }

    }
}
