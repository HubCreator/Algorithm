import java.util.Arrays;

class File implements Comparable<File> {
    final String head;
    final String number;
    final String tail;

    File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(File o) {
        Integer thisNum = Integer.parseInt(this.number);
        Integer objectNum = Integer.parseInt(o.number);
        if (head.equalsIgnoreCase(o.head) && thisNum.equals(objectNum)) {
            return 0;
        } else if (head.equalsIgnoreCase(o.head)) {
            return thisNum.compareTo(objectNum);
        } else {
            return head.compareToIgnoreCase(o.head);
        }
    }

    @Override
    public String toString() {
        return head + number + tail;
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] fileArr = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            // 파일 명을 세 부분으로 나눈다. (HEAD, NUMBER, TAIL)
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            String tail;

            String file = files[i];
            int idx = 0, cnt = 0;
            while (Character.isAlphabetic(file.charAt(idx)) || Character.isSpaceChar(file.charAt(idx)) ||
                    Character.getType(file.charAt(idx)) == Character.DASH_PUNCTUATION) {
                head.append(file.charAt(idx++));
            }
            while (idx <= file.length() - 1  && Character.isDigit(file.charAt(idx)) && cnt < 5) {
                number.append(file.charAt(idx++));
                cnt++;
            }
            tail = file.substring(idx);
            fileArr[i] = new File(head.toString(), number.toString(), tail);
        }
        Arrays.sort(fileArr);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fileArr[i].toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"ABC12", "AbC12", "aBc12"};
        for (String s : T.solution(arr)) {
            System.out.println("s = " + s);
        }
    }
}