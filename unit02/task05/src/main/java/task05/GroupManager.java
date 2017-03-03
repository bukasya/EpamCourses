package task05;

import java.util.*;

public class GroupManager {
    private final double MIN_MARK = 2.0;
    private final double MAX_MARK = 5.0;
    private ArrayList<HashMap<Student, Mark>> groups = new ArrayList<>();

    public ArrayList<HashMap<Student, Mark>> createGroupsWithOneStudent(Student student){
        for(Disciplines d: Disciplines.values()) {
            HashMap<Student, Mark> group = new HashMap<>();
            if (d.ordinal() % 2 == 0) {
                group.put(student, new Mark<>(randomValue(MIN_MARK, MAX_MARK)));
            }
            else
                group.put(student, new Mark<Double>((double)(Integer)randomValue(MIN_MARK, MAX_MARK).intValue()));
            groups.add(group);
        }
        return groups;
    }

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

    private Double randomValue(double min, double max){
        Random rand = new Random();
        return new Double(min + (max - min) * rand.nextDouble());
    }

    public HashMap<Disciplines, Mark> compareMarksForStudent(Student student){
        HashMap<Disciplines, Mark> h = new HashMap<>();
        Disciplines[] d = Disciplines.values();
        int i = 0;
        for (HashMap<Student, Mark> studentMarkHashMap: groups) {
            if(studentMarkHashMap.containsKey(student)){
                h.put(d[i], studentMarkHashMap.get(student));
            }
            i++;
        }

        HashMap<Disciplines, Mark> sortedMarks = sortByComparator(h);

        return sortedMarks;
    }

    private HashMap<Disciplines, Mark> sortByComparator(HashMap<Disciplines, Mark> unsortedMap){
        List<Map.Entry<Disciplines, Mark>> list = new ArrayList<>(unsortedMap.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        HashMap<Disciplines, Mark> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Disciplines,Mark> entry: list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
