class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (String tree : skill_trees) {
            int idx = 0, tmp = -1;
            for (int i = 0; i < skill.length(); i++) {
                int e = tree.indexOf(skill.charAt(i));
                if (e != -1) {
                    if (tree.charAt(e) != skill.charAt(idx)) {
                        answer--;
                        break;
                    }
                    if (tmp < e) {
                        tmp = e;
                        idx++;
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}