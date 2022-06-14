package leetcode.拓扑排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:17 2021/7/22
 */
public class 课程表 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    //numCourses = 2, prerequisites = [[1,0],[0,1]]  0-1  1-0
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //边集合
        edges = new ArrayList<>();
        //numCourses 点的数量
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            //边0-1
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses&&valid; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        //搜索状态
        visited[u] = 1;
        //edges.get(u) 节点u的所有相邻点集合
        for (int v:edges.get(u)) {
            if(visited[v]==0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v]==1){
                valid = false;
                return;
            }
        }
        //搜索完成，节点状态变成已搜索
        visited[u] = 2;
    }


}
