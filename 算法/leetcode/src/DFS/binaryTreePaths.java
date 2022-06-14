package DFS;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root){
        ArrayList<String> paths = new ArrayList<>();
        constructPaths(root,"",paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, ArrayList<String> paths) {
        if(root!=null){
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if(root.left==null&&root.right==null){
                paths.add(pathSB.toString());
            }else{
                pathSB.append("->");
                constructPaths(root.left,pathSB.toString(),paths);
                constructPaths(root.right,pathSB.toString(),paths);
            }
        }
    }
}
