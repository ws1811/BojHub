class Solution {
    int removedZeros = 0; 
    int transformCount = 0;
    
    public int[] solution(String s) {
        
        String str = s;        
        
        while(str.length() > 1) {
            str = removeZero(str);
            str = convertLengthToBinary(str);
            transformCount++;
        }
        
        return new int[] {transformCount, removedZeros};
    }
    
    public String removeZero(String pStr) {
        for(int i=0; i<pStr.length(); i++) {
            if(pStr.charAt(i) == '0') {
                removedZeros++;
            }
        }
        return pStr.replaceAll("0", "");
    }
    
    public String convertLengthToBinary(String pStr) {
        int len = pStr.length();
        StringBuilder sb = new StringBuilder();
        
        while (len > 0) {
            sb.append((len % 2) + "");
            len = len / 2;
        }
        
        return sb.toString();
    }
    
}