class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                sb.append(c);
                isFirst = true;
            } 
            else {
                sb.append(isFirst ? Character.toUpperCase(c)
                                  : Character.toLowerCase(c));
                isFirst = false;
            }
        }
        return sb.toString();
    }
}