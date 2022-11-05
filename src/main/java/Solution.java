import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Music {
    String title;
    int duration;
    List<String> originalNotes;
    List<String> playedNotes;

    public Music(String musicinfo) {
        String[] split = musicinfo.split(",");
        this.duration = parseTime(split[1]) - parseTime(split[0]);
        this.title = split[2];
        this.originalNotes = getNotes(split[3]);
        this.playedNotes = getPlayedNotes(originalNotes);
    }

    private int parseTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private List<String> getNotes(String str) {
        str += " ";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i + 1) == '#') {
                list.add(String.valueOf(str.charAt(i)) + str.charAt(i + 1));
                i++;
                continue;
            }
            list.add(String.valueOf(str.charAt(i)));
        }
        return list;
    }

    public List<String> getPlayedNotes(List<String> originalNotes) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < duration; i++) {
            result.add(originalNotes.get(i % originalNotes.size()));
        }
        return result;
    }

    public boolean hasNotes(String str) {
        Queue<String> myNotes = new LinkedList<>(getNotes(str));
        List<Integer> indxList = new ArrayList<>();
        for (int i = 0; i < playedNotes.size(); i++) {
            if (playedNotes.get(i).equals(myNotes.peek())) {
                indxList.add(i);
            }
        }

        for (Integer idx : indxList) {
            List<String> notes = new ArrayList<>();
            int cnt = 0;
            for (int i = idx; idx + myNotes.size() <= playedNotes.size() && cnt < myNotes.size(); i++) {
                notes.add(playedNotes.get(i));
                cnt++;
            }
            if (myNotes.equals(notes)) {
                return true;
            }
        }

        return false;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        Music answer = null;
        List<Music> list = new ArrayList<>();
        for (String musicinfo : musicinfos) {
            list.add(new Music(musicinfo));
        }

        for (Music music : list) {
            if (music.hasNotes(m) &&
                    (answer == null || answer.duration < music.duration)) {
                answer = music;
            }
        }
        return answer == null ? "(None)" : answer.title;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}