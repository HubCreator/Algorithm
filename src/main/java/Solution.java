import java.util.*;
import java.util.stream.Collectors;

class Music implements Comparable<Music> {
    String genre;
    int play, index;

    public Music(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }

    @Override
    public int compareTo(Music o) {
        if (o.play == this.play) {
            return this.index - o.index;
        }
        return o.play - this.play;
    }
}

class Musics implements Comparable<Musics> {
    List<Music> musics = new ArrayList<>();

    public void add(Music music) {
        this.musics.add(music);
    }

    public int getTotalPlayCounts() {
        int sum = 0;
        for (Music music : musics) {
            sum += music.play;
        }
        return sum;
    }

    public List<Integer> getTop2PlayedMusic() {
        return musics.stream()
                .sorted()
                .map(i -> i.index)
                .limit(2)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Musics o) {
        return o.getTotalPlayCounts() - this.getTotalPlayCounts();
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Musics> chart = new HashMap<>(); // <장르, 장르에 해당하는 음악들>

        for (int i = 0; i < genres.length; i++) {
            Musics musics = chart.containsKey(genres[i]) ?
                    chart.get(genres[i]) :
                    new Musics();

            musics.add(new Music(genres[i], plays[i], i));
            chart.put(genres[i], musics);
        }

        List<Musics> musics = chart.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (Musics music : musics) {
            answer.addAll(music.getTop2PlayedMusic());
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}