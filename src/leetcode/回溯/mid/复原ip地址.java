package leetcode.回溯.mid;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:06 2021/6/23
 */
public class 复原ip地址 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> track = new ArrayList<>();
        trackback(track,s,0);
        return res;
    }

    private void trackback(ArrayList<String> track, String s, int start) {
        if(track.size()==4){
            if(start==s.length()){
                String str = "";
                for (int i = 0; i < track.size()-1; i++) {
                    str+=track.get(i)+".";
                }
                str+=track.get(track.size()-1);
                res.add(str);
            }
            return;
        }
//        //一位
//        if(start+1>s.length()){
//            return;
//        }else {
//            String s1 = s.substring(start, start + 1);
//            track.add(s1);
//            trackback(track,s,start+1);
//            track.remove(track.size()-1);
//        }
//        //二位
//        if(start+2>s.length()){
//            return;
//        }else {
//            String s2 = s.substring(start, start + 2);
//            if(s2.startsWith("0")){
//                return;
//            }else {
//                track.add(s2);
//                trackback(track,s,start+2);
//                track.remove(track.size()-1);
//            }
//        }
//        //三位
//        if(start+3>s.length()){
//            return;
//        }else {
//            String s3 = s.substring(start, start + 3);
//            if(Integer.parseInt(s3)>255){
//                return;
//            }else {
//                track.add(s3);
//                trackback(track,s,start+3);
//                track.remove(track.size()-1);
//            }
//        }
        //改写成3层循环
        for (int i = 1; i <= 3 ; i++) {
            if(start+i>s.length()) return;
            if(s.charAt(start)=='0'&&i!=1) return;
            if(Integer.parseInt(s.substring(start,start+i))>255) return;
            String str = s.substring(start,start+i);
            track.add(str);
            trackback(track,s,start+i);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new 复原ip地址().restoreIpAddresses("010010");
        for (String str:strings
             ) {
            System.out.println(str);
        }
    }
}
