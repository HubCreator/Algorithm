import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person>{
    int w;
    int h;
    Person(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(Person o) {
        // o : 자식, this : 부모 (부모가 더 크다고 생각하자. 부모 아래에 자식 있음)
        return o.h - this.h; // 자식에서 부모를 뺐으므로 내림차순 정렬 (음수)
    }
}

// 정렬 해놓고 해결해 나감
public class Main {
    private int solution(int n, List<Person> people) {
        int cnt = 0, max = Integer.MIN_VALUE;
        Collections.sort(people); // overriding된 compareTo를 활용한 정렬
        for (Person person : people) {
            if (person.w > max) {
                max = person.w;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Person(h, w));
        }
        System.out.println(T.solution(n, list));
    }
}