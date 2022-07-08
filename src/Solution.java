import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class Student implements Comparable<Student> {
    int id;
    boolean lost, isChecked = false;

    public Student(int id, boolean lost) {
        this.id = id;
        this.lost = lost;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lost, isChecked);
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostSize = lost.length;
        ArrayList<Student> lostList = new ArrayList<>();
        ArrayList<Student> reserveList = new ArrayList<>();
        ArrayList<Student> mergedList = new ArrayList<>();
        for (int i : lost) lostList.add(new Student(i, true));
        for (int i : reserve) reserveList.add(new Student(i, false));
        mergedList.addAll(lostList);
        for (Student s : reserveList) {
            if (mergedList.contains(s)) {
                mergedList.remove(s);
                lostSize--;
            } else {
                mergedList.add(s);
            }
        }
//        mergedList.addAll(reserveList);
        Collections.sort(mergedList);

        for (int i = 0; i < mergedList.size(); i++) {
            Student ts = mergedList.get(i);
            if (mergedList.get(i).lost) {
                if (i - 1 >= 0) {
                    Student s = mergedList.get(i - 1);
                    if (!s.isChecked && !s.lost && Math.abs(s.id - ts.id) == 1) {
                        s.isChecked = true;
                        lostSize--;
                        continue;
                    }
                }
                if (i + 1 < mergedList.size()) {
                    Student s = mergedList.get(i + 1);
                    if (!s.isChecked && !s.lost && Math.abs(s.id - ts.id) == 1) {
                        s.isChecked = true;
                        lostSize--;
                    }
                }
            }
        }

        return n - lostSize;
    }
}