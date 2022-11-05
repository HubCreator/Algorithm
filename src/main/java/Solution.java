import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Music {
    String title;
    int duration;
    List<String> notes = new ArrayList<>();


    public Music(String musicinfo) {
        String[] split = musicinfo.split(",");
        this.duration = parseTime(split[1]) - parseTime(split[0]);
        this.title = split[2];
        split[3] += " ";
        for (int i = 0; i < split[3].length() - 1; i++) {
            if (split[3].charAt(i + 1) == '#') {
                notes.add(String.valueOf(split[3].charAt(i)) + split[3].charAt(i + 1));
                i++;
            } else {
                notes.add(String.valueOf(split[3].charAt(i)));
            }
        }
    }

    private int parseTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public String getNotes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < duration; i++) {
            sb.append(notes.get(i % notes.size()));
        }
        return sb.toString();
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> answer = new ArrayList<>();
        List<Music> list = new ArrayList<>();
        for (String musicinfo : musicinfos) {
            list.add(new Music(musicinfo));
        }

        for (Music music : list) {
            if (music.getNotes().contains(m)) {
                answer.add(music);
            }
        }

        if (answer.size() == 0) return "(None)";
        if (answer.size() == 1) return answer.get(0).title;

        Collections.sort(answer, (a, b) -> {
            if (a.title.length() == b.title.length()) {
                return a.duration - b.duration;
            }
            return a.title.length() - b.title.length();
        });
        return answer.get(0).title;
    }
}