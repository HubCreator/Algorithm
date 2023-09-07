class Solution {
    private static enum Direction {
        NORTH {
            @Override
            public void go(int[] cur) {
                cur[1] += 1;
            }
            @Override
            public void back(int[] cur) {
                cur[1] -= 1;
            }
        },
        EAST {
            @Override
            public void go(int[] cur) {
                cur[0] += 1;
            }
            @Override
            public void back(int[] cur) {
                cur[0] -= 1;
            }
        },
        SOUTH {
            @Override
            public void go(int[] cur) {
                cur[1] -= 1;
            }
            @Override
            public void back(int[] cur) {
                cur[1] += 1;
            }
        },
        WEST {
            @Override
            public void go(int[] cur) {
                cur[0] -= 1;
            }
            @Override
            public void back(int[] cur) {
                cur[0] += 1;
            }
        };

        public abstract void go(int[] cur);
        public abstract void back(int[] cur);
    }

    public int[] solution(String command) {
        int[] answer = new int[]{0, 0};
        Direction[] dirs = new Direction[] {
                Direction.NORTH,
                Direction.EAST,
                Direction.SOUTH,
                Direction.WEST
        };
        int dirIdx = 0;

        for (int i = 0; i < command.length(); i++) {
            char t = command.charAt(i);
            if (t == 'R') {
                dirIdx = (dirIdx + 1) % 4;
            }
            if (t == 'L') {
                dirIdx = dirIdx == 0 ?
                        3 :
                        dirIdx - 1;
            }
            if (t == 'G') {
                dirs[dirIdx].go(answer);
            }
            if (t == 'B') {
                dirs[dirIdx].back(answer);
            }
        }

        return answer;
    }
}
