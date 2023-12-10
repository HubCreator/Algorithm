import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        PriorityQueue<Genre> queue = new PriorityQueue<>();

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Music(i, plays[i]));
        }

        for (Map.Entry<String, List<Music>> entry : map.entrySet()) {
            countMap.put(entry.getKey(), countMap.getOrDefault(entry.getKey(), 0) + entry.getValue().stream().map(m -> m.play).reduce(Integer::sum).get());
        }
        
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.offer(new Genre(entry.getKey(), map.get(entry.getKey())));
        }

        while (!queue.isEmpty()) {
            Genre genre = queue.poll();
            Collections.sort(genre.musics);
            int count = 0;
            for (Music music : genre.musics) {
                if (count > 1) {
                    break;
                }
                answer.add(music.index);
                count++;
            }
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private static class Music implements Comparable<Music> {
        private int index;
        private int play;

        public Music(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            if (this.play == o.play) {
                return this.index - o.index;
            }
            return o.play - this.play;
        }
    }

    private static class Genre implements Comparable<Genre> {
        private String genre;
        private List<Music> musics;

        public Genre(String genre, List<Music> musics) {
            this.genre = genre;
            this.musics = musics;
        }

        @Override
        public int compareTo(Genre o) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < this.musics.size(); i++) {
                sum1 += this.musics.get(i).play;
            }
            for (int i = 0; i < o.musics.size(); i++) {
                sum2 += o.musics.get(i).play;
            }
            return sum2 - sum1;
        }
    }
}