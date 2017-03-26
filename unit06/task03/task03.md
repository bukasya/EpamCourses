```java
class MedicalStaff(){}  
class Doctor extends MedicalStaff(){}  
class Nurse extends MedicalStaff(){}  
class HeadDoctor extends Doctor(){}  
```

|                                                           | Correct | Explanation                       |
|-----------------------------------------------------------|---------|-----------------------------------|
| ```Doctor doctor1 = new Doctor();```                      | +       | No class cast                     |
| ```Doctor doctor2 = new MedicalStaff();```                | -       | Descendant class cast             |
| ```Doctor doctor3 = new HeadDoctor();```                  | +       | Ascendant class cast              |
| ```Object object1 = new HeadDoctor();```                  | +       | Ascendant class cast              |
| ```HeadDoctor doctor5 = new Object();```                  | -       | Descendant class cast             |
| ```Doctor doctor6 = new Nurse();```                       | -       | Disjoint classes                  |
| ```Nurse nurse = new Doctor();```                         | -       | Disjoint classes                  |
| ```Object object2 = new Nurse();```                       | +       | Ascendant class cast              |
| ```List<Doctor> list1 = new ArrayList<Doctor>();```       | +       | No class cast                     |
| ```List<MedicalStaff> list2 = new ArrayList<Doctor>();``` | -       | Generic types are not polymorphic |
| ```List<Doctor> list3 = new ArrayList<MedicalStaff>();``` | -       | Generic types are not polymorphic |
| ```List<Object> list4 = new ArrayList<Doctor>();```       | -       | Generic types are not polymorphic |
| ```List<Object> list5 = new ArrayList<Object>();```       | +       | No class cast                     |