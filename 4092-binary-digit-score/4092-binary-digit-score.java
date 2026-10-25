class Solution {
    public int calculateScore(int a, int b) {
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toBinaryString(b);

        int set1 = 0, set2 = 0;

        for(char i: str1.toCharArray()){
            if(i == '1'){
                set1 += 1;
            }
        }
        for(char i: str2.toCharArray()){
            if(i=='1'){
                set2 += 1;
            }
        }
        if(set1>=set2) return set1*set2;
        return set2/set1;
    }
}