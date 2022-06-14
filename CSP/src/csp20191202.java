import java.util.*;

public class csp20191202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(hashmap.containsKey(x)==false){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(y);
                hashmap.put(x,list);
            }else {
                hashmap.get(x).add(y);
                Collections.sort(hashmap.get(x));
            }
        }
        int[] result = {0,0,0,0,0};
        Set<Map.Entry<Integer, List<Integer>>> entries = hashmap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry: entries
             ) {
            int location = 0;
            List<Integer> list = entry.getValue();
            if(list.size()>=3){
                ArrayList<Integer> listY = new ArrayList<>();
                int temp;
                for (int i = 1; i < list.size()-1; i++) {
                    temp = list.get(i);
                    if((list.get(i-1)+1)== temp &&(list.get(i+1)-1)== temp){
                        listY.add(temp);
                    }
                }
                if(listY==null){
                    break;
                }else {
                    Integer x = entry.getKey();
                    for (int i = 0; i < listY.size(); i++) {
                        Integer y = listY.get(i);
                        if (hashmap.containsKey(x - 1)&&hashmap.containsKey(x + 1)) {
                            if(hashmap.get(x-1).contains(y)==false){
                                break;
                            }
                            if(hashmap.get(x+1).contains(y)==false){
                                break;
                            }
                        }else {
                            break;
                        }

                        if (hashmap.containsKey(x - 1)) {
                            if(hashmap.get(x-1).contains(y-1)){
                                location++;
                            }
                            if(hashmap.get(x-1).contains(y+1)){
                                location++;
                            }
                        }
                        if (hashmap.containsKey(x + 1)) {
                            if(hashmap.get(x+1).contains(y-1)){
                                location++;
                            }
                            if(hashmap.get(x+1).contains(y+1)){
                                location++;
                            }
                        }
                        result[location]++;
                        location = 0;

                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
/*
7
1 2
2 1
0 0
1 1
1 0
2 0
0 1


11
9 10
10 10
11 10
12 10
13 10
11 9
11 8
12 9
10 9
10 11
12 11

2
0 0
-100000 10
 */