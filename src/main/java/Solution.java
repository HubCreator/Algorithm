class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int durationTmp = 0;
        String myNote = transform(m);

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int duration = getDuration(split[0], split[1]);
            if (duration >= myNote.length()) {
                String target = transform(split[3]);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < duration; i++) {
                    sb.append(target.charAt(i % target.length()));
                }
                if (sb.toString().contains(myNote) && duration > durationTmp) {
                    answer = split[2];
                    durationTmp = duration;
                }
            }
        }
        return answer;
    }

    private String transform(String m) {
        return m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    private int getDuration(String t1, String t2) {
        return parseTime(t2) - parseTime(t1);
    }

    private int parseTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}