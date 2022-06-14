import java.util.*;

public class 二刷 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*输入一个链表，反转链表后，输出新链表的表头。*/
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        //pre为null cur是head
        ListNode pre = null, cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 7, 2, 1, 6, 8, 0, 1,111,-10,-5,-40,55555};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //交换排序 冒泡
    public static void BubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] nums, int i, int j) {
        if(i>=j) return;
        int partition  = partition(nums,i,j);
        quickSort(nums,i,partition-1);
        quickSort(nums,partition+1,j);
    }

    private static int partition(int[] nums, int i, int j) {
        int pivot = i;
        int left = i,right = j;
        while (true){
            //从右往左找一个小于基准元素的下标值
            while (left<right&&nums[right]>=nums[pivot]){
                right--;
            }
            while (left>right&&nums[left]<=nums[pivot]){
                left++;
            }
            if(left<right){
                 int tmp = nums[left];
                 nums[left] = nums[right];
                 nums[right] = tmp;
            }else {
                break;
            }
        }
        int tmp = nums[pivot];
        nums[pivot] = nums[left];
        nums[left] = tmp;
        return left;
    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i-1;
            while (index>=0&&arr[index]>insertValue){
                arr[index+1] = arr[index];
                index = index-1;
            }
            arr[index+1] = insertValue;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        int dk = arr.length/3+1;
        while (dk>=1){
            shellSort(arr,dk);
            dk = dk/2;
        }
    }
    private static void shellSort(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i-dk;
            while (index>=0&&arr[index]>insertValue){
                arr[index+dk] = arr[index];
                index = index-dk;
            }
            arr[index+dk] = insertValue;
        }
    }

    //简单选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    //堆排序  升序
    public static void heapSort(int[] arr){
        int len = arr.length;
        //构建堆   调整为最大堆
        for (int i = (len-1)/2; i >= 0 ; i--) {
            adjustHeap(arr,i,len);
        }
        System.out.println(Arrays.toString(arr));
        //调整堆
        for (int i = len-1; i > 0  ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void adjustHeap(int[] arr, int i,int len) {
        //下移元素
        int downValue = arr[i];
        //该节点是否要和叶子节点交换   叶子节点中找最大的
        for (int k = i*2+1; k < len ; k++) {
            if(k+1<len&&arr[k+1]>arr[k]){
                k = k+1;
            }
            if(arr[k]>downValue){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = downValue;
    }

    //归并排序
    public static void mergeSort(int[] nums ){
        mergeSort(nums,0,nums.length-1);
    }

    private static void mergeSort(int[] nums, int i, int j) {
        if(i>=j) return;
        int mid = i+(j-i)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        merge(nums,i,mid,j);
    }

    private static void merge(int[] nums, int i, int mid, int j) {
        int[] newNums = new int[j - i + 1];
        int k = 0;
        int p1 = i,p2 = mid+1;
        while (p1<=mid&&p2<=j){
            if(nums[p1]<=nums[p2]){
                newNums[k++] = nums[p1++];
            }else {
                newNums[k++] = nums[p2++];
            }
        }
        while (p1<=mid){
            newNums[k++] = nums[p1++];
        }
        while(p2<=j){
            newNums[k++] = nums[p2++];
        }
        for (int l = 0; l < newNums.length; l++) {
            nums[i++] = newNums[l];
        }
    }

    //实现LRU缓存   hashmap+双向链表
    class LRUCache{
        class Node{
            int key;
            int value;
            Node pre;
            Node next;
            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        //hashmap
        HashMap<Integer,Node> hashMap = new HashMap<>();
        //双向链表
        Node head;
        Node tail;
        //lru最大容量
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.next = head;
        }

        public void set(int key,int value){
            Node node = hashMap.get(key);
            if(node==null){
                Node newNode = new Node(key, value);
                //添加到链表头
                hashMap.put(key,newNode);
                addToHead(newNode);
                //检查是否超过capacity
                if(hashMap.size()>capacity){
                    //移除边表尾元素
                    Node lastNode = removeTail();
                    //hashMap 移除
                    hashMap.remove(lastNode.key);
                }
            }else {
                //已经存在  则更新
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        private Node removeTail() {
            Node node = this.tail.pre;
            removeNode(node);
            return node;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public int get(int key){
            Node node = hashMap.get(key);
            if(node==null) return -1;
            else {
                moveToHead(node);
            }
            return node.value;
        }
    }

    //链表是否有环
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow = head,fast = head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //最小的k个数   构建大顶堆

    //容器盛水问题
    public long maxWater (int[] arr) {
        long ans = 0;
        int left = 0,right = arr.length-1;
        int max_left=0,max_right = 0;
        while (left<right){
            if(arr[left]<arr[right]){
                if(max_left<=arr[left]){
                    max_left = arr[left];
                }else {
                    ans+=max_left-arr[left];
                }
                left++;
            }else {
                if(arr[right]>=max_right){
                    max_right = arr[right];
                }else {
                    ans+=max_right-arr[right];
                }
                right--;
            }
        }
        return ans;
    }

    //重构二叉树   先序+中序推出树
    private int[] buildTree(int[] xianxu, int[] zhongxu) {
        //先序的第一个节点是根节点
        int root = xianxu[0];
        int index = -1;
        for (int i = 0; i < zhongxu.length; i++) {
            if(zhongxu[i] == root){
                index = i;
                break;
            }
        }
        //对于中序遍历    根节点左边元素是左子树  右边是右子树
        return new int[1];
    }
}
