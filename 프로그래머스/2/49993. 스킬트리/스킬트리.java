class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (String skillTree : skill_trees) {
            for (int i = 0; i < skillTree.length(); i++) {
                if (skill.contains(String.valueOf(skillTree.charAt(i)))) {
                    sb.append(skillTree.charAt(i));
                }
            }
            if (skill.startsWith(sb.toString())) {
                answer++;
            }
            sb = new StringBuilder();
        }
        return answer;
    }
}