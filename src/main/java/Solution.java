import java.util.ArrayList;
import java.util.List;

class Music {
    String title;
    int duration;
    List<String> originalNotes = new ArrayList<>();
    List<String> playedNotes = new ArrayList<>();

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
        List<String> notes = getNotes(str);
        for (String playedNote : playedNotes) {
            if (!notes.isEmpty() && playedNote.equalsIgnoreCase(notes.get(0))) {
                notes.remove(0);
            }
            if (notes.isEmpty()) return true;
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
        System.out.println(T.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}