package basic;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:39 2021/7/2
 */
public class waybillsign {
    public static void main(String[] args) {
        String waybillSign = "30000100010900050000000000000100000000060102000000002000010000000000001000000010000101002000100000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        System.out.println("第89位:"+waybillSign.charAt(89-1));
        System.out.println("第89位:"+waybillSign.substring(88,89));
        System.out.println("第40位:"+waybillSign.charAt(40-1));
        System.out.println("第40位:"+waybillSign.substring(39,40));
        System.out.println("第80位:"+waybillSign.charAt(80-1));
        System.out.println("第80位:"+waybillSign.substring(79,80));
        boolean b = (waybillSign.charAt(89-1) == '1' || waybillSign.charAt(89-1) == '2') || (waybillSign.charAt(89-1) == '0' && (waybillSign.charAt(40-1) == '7' || waybillSign.charAt(40-1) == '6'));
        System.out.println(b);
    }
}
