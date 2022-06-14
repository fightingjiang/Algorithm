package 字符串;

public class 字符串乘法 {
    public String solve (String s, String t) {
        if(s.equals("0")||t.equals(0)) return "0";
        int slen = s.length(),tlen = t.length();
        int[] nums = new int[slen+tlen];
        for (int i = slen-1; i >=0 ; i--) {
            int x = s.charAt(i)-'0';
            for (int j = tlen-1; j >=0 ; j--) {
                int y = t.charAt(j)-'0';
                nums[i+j+1] +=x*y;
            }
        }
        for (int i = slen+tlen-1; i >0 ; i--) {
            nums[i-1] +=nums[i]/10;
            nums[i] = nums[i]%10;
        }
        int index = nums[0]==0?1:0;
        StringBuilder res = new StringBuilder();
        for (int i = index; i < nums.length; i++) {
            res.append(nums[i]);
        }
        return res.toString();
    }
}
