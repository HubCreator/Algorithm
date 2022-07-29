class Solution {
    public String solution(String phone_number) {
        int cnt = phone_number.length() - 4;
        StringBuilder stars = new StringBuilder();
        for(int i = 1; i <= cnt; i++) stars.append('*');
        return phone_number.replaceAll("^[0-9]{0,"+cnt+"}", stars.toString());
    }
}