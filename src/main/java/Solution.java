import java.util.*;

class Music implements Comparable<Music> {
    final Integer id;
    final Integer play;

    Music(Integer id, Integer play) {
        this.id = id;
        this.play = play;
    }

    @Override
    public int compareTo(Music o) {
        return o.play.compareTo(this.play);
    }
}

class Genre implements Comparable<Genre> {
    public static final int N = 2;
    final String genre;
    final List<Music> musics = new ArrayList<>();

    Genre(String genre) {
        this.genre = genre;
    }

    public Integer getTotalPlayCnt() {
        int sum = 0;
        for (Music music : musics) sum += music.play;
        return sum;
    }

    public List<Integer> getTopNMusics() {
        List<Integer> result = new ArrayList<>();
        Collections.sort(musics);
        int idx = 0;
        while (idx < musics.size() && result.size() < N) {
            result.add(musics.get(idx++).id);
        }
        return result;
    }

    @Override
    public int compareTo(Genre o) {
        return o.getTotalPlayCnt().compareTo(this.getTotalPlayCnt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre1 = (Genre) o;
        return Objects.equals(genre, genre1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre);
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> chart = new HashMap<>();

        initChart(chart, plays, genres);

        List<Genre> list = getSortedGenres(chart);
        List<Integer> result = getSortMusics(list);

        return getResult(result);
    }

    private void initChart(Map<String, Genre> chart, int[] plays, String[] genres) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            Genre gen = !chart.containsKey(genre) ? new Genre(genre) : chart.get(genre);
            gen.musics.add(new Music(i, play));
            chart.put(genre, gen);
        }
    }

    private List<Genre> getSortedGenres(Map<String, Genre> chart) {
        List<Genre> list = new ArrayList<>(chart.values());
        Collections.sort(list);
        return list;
    }

    private List<Integer> getSortMusics(List<Genre> list) {
        List<Integer> result = new ArrayList<>();
        for (Genre genre : list) {
            List<Music> musics = genre.musics;
            Collections.sort(musics);
            result.addAll(genre.getTopNMusics());
        }
        return result;
    }

    private int[] getResult(List<Integer> result) {
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}