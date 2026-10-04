import java.util.*;

public class Trees {
    public  static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree {
        int idx = -1;

        public Node buildBinaryTree(int[] arr) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildBinaryTree(arr);
            newNode.right = buildBinaryTree(arr);
            return newNode;
        }

        public void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }

        public void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }

        public void levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node curr = queue.remove();
                if (curr == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(curr.value + " ");
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }

        }

        public int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
        }

        public int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return countOfNodes(root.left) + countOfNodes(root.right) + 1;
        }

        public void iterativePreOrder(Node root) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node curr = stack.pop();
                System.out.print(curr.value + " ");
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }

        public List<Integer> iterativeInOrder(Node root) {
            List<Integer> inorder = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            Node temp = root;
            while (true) {
                if (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    temp = stack.pop();
                    inorder.add(temp.value);
                    temp = temp.right;
                }

            }
            return inorder;
        }

        public List<Integer> iterativePostOrder(Node root) {
            List<Integer> postorder = new ArrayList<>();
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            if (root == null) {
                return postorder;
            }
            s1.push(root);
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                s2.push(temp);
                if (temp.left != null) {
                    s1.push(temp.left);
                }
                if (temp.right != null) {
                    s1.push(temp.right);
                }
            }
            while (!s2.isEmpty()) {
                postorder.add(s2.pop().value);
            }
            return postorder;
        }

        public List<Integer>iterativePostOrder2(Node root){
            Stack<Node>stack = new Stack<>();
            List<Integer>postorder = new ArrayList<>();
            Node curr = root;
            while(curr != null||!stack.isEmpty()){
                if(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }else{
                    Node temp = stack.peek().right;
                    if(temp == null){
                        temp = stack.pop();
                        postorder.add(temp.value);
                        while(!stack.isEmpty() && temp == stack.peek().right){
                            temp = stack.pop();
                            postorder.add(temp.value);
                        }
                    }else{
                        curr = temp;
                    }
                }
            }
            return postorder;
        }

        public static class pair{
            Node node;
            int num;
            public pair(Node node,int num){
                this.node = node;
                this.num = num;
            }
        }
        public void traversals(Node root){
            List<Integer>preorder = new ArrayList<>();
            List<Integer>inorder = new ArrayList<>();
            List<Integer>postorder = new ArrayList<>();
            if(root == null){
                return;
            }
            Stack<pair>stack = new Stack<>();
            stack.push(new pair(root,1));
            while(!stack.isEmpty()){
                pair it = stack.pop();
                if(it.num == 1){
                    preorder.add(it.node.value);
                    it.num++;
                    stack.push(it);
                    if(it.node.left != null){
                        stack.push(new pair(it.node.left ,1));
                    }
                } else if (it.num == 2) {
                    inorder.add(it.node.value);
                    it.num++;
                    stack.push(it);
                    if(it.node.right != null){
                        stack.push(new pair(it.node.right,1));
                    }
                }else {
                    postorder.add(it.node.value);

                }
            }
            System.out.println(preorder);
            System.out.println(inorder);
            System.out.println(postorder);
        }
        public boolean checkBalanced(Node root){
            return dfsHeight(root) != -1;
        }
        public int dfsHeight(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = dfsHeight(root.left);

            if(leftHeight == -1){
                return -1;
            }
            int rightHeight = dfsHeight(root.right);
            if(rightHeight == -1){
                return -1;
            }
            if(Math.abs(leftHeight - rightHeight ) > 1){
                return -1;
            }
            return Math.max(leftHeight,rightHeight)+1;

        }
        public int diameterOfTree(Node root) {
            int[]diameter = new int[1];
            height(root,diameter);
            return diameter[0];
        }
        public int height(Node root,int[]diameter){
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left,diameter);
            int rightHeight = height(root.right,diameter);
            diameter[0]= Math.max(diameter[0],leftHeight+rightHeight);
            return Math.max(leftHeight,rightHeight)+1;
        }

        public int maxPathSum(Node root){
            int[]maxSum = new int[1];
            calculateSum(root,maxSum);
            return maxSum[0];
        }
        public int calculateSum(Node root,int[]maxSum){
            if(root == null){
                return 0;
            }
            int leftPathSum = Math.max(0,calculateSum(root.left,maxSum));
            int rightPathSum = Math.max(0,calculateSum(root.right,maxSum));
            maxSum[0] = Math.max(maxSum[0],leftPathSum+rightPathSum+root.value);
          return Math.max(leftPathSum,rightPathSum)+root.value;

        }
        public boolean isIdentical(Node root1, Node root2){
            if(root1 == null || root2 == null){
                return true;
            }

            if(root1.value != root2.value){
                return false;
            }

            return isIdentical(root1.left,root2.left)
                    && isIdentical(root1.right,root2.right);

        }

        public List<Integer> zigZag(Node root){
            List<Integer>zigzag = new ArrayList<>();
            if(root == null){
                return zigzag;
            }
            Queue<Node>queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight=true;
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer>level = new ArrayList<>(size);
                for(int i =0;i<size;i++){
                    Node curr = queue.remove();
                    int idx = leftToRight?i:size-1-i;
                    level.add(idx,curr.value);
                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                }
                leftToRight =! leftToRight;
                zigzag.addAll(level);
            }
            return zigzag;
        }
        public boolean isLeaf(Node root){
            return root.right == null && root.left == null;
        }
        public void leftBoundary(Node root,List<Integer>boundary){
            Node curr = root.left;
            while(curr != null){
                if(!isLeaf(curr)){
                    boundary.add(curr.value);
                }
                if(curr.left != null){
                    curr = curr.left;
                }else {
                    curr = curr.right;
                }
            }
        }
        public void rightBoundary(Node root,List<Integer>boundary){
            Node curr = root.right;
            List<Integer>temp = new ArrayList<>();
            while(curr != null){
                if(!isLeaf(curr)){
                    temp.add(curr.value);
                }
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            }
            for(int i=temp.size()-1;i>=0;i--) {
                boundary.add(temp.get(i));
            }
        }
        public void addLeaves(Node root,List<Integer>boundary){
            if(root == null){
                return;
            }
            if(isLeaf(root)){
                boundary.add(root.value);
            }
            addLeaves(root.left,boundary);
            addLeaves(root.right,boundary);
        }
        public List<Integer> boundaryTraversal(Node root){
            List<Integer>boundary = new ArrayList<>();
            if(!isLeaf(root)){
                boundary.add(root.value);
            }
            leftBoundary(root,boundary);
            addLeaves(root,boundary);
            rightBoundary(root,boundary);
            return  boundary;

        }
        public static class Tuple{
            Node node;
            int row;
            int column;
            Tuple(Node node,int row,int column){
                this.node = node;
                this.column = column;
                this.row = row;
            }
        }
        public List<List<Integer>> verticalTraversal(Node root){
            List<List<Integer>>list = new ArrayList<>();
            if(root == null){
                return list;
            }
            TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map = new TreeMap<>();
            Queue<Tuple>queue = new LinkedList<>();

            queue.add(new Tuple(root,0,0));
            while(!queue.isEmpty()){
                Tuple curr = queue.remove();
                Node node = curr.node;
                int x = curr.row;
                int y = curr.column;
                if(!map.containsKey(y)){
                    map.put(y,new TreeMap<>());
                }
                if(!map.get(y).containsKey(x)){
                    map.get(y).put(x,new PriorityQueue<>());
                }
                map.get(y).get(x).offer(node.value);
                if(node.left != null){
                    queue.add(new Tuple(node.left,x+1,y-1));
                }
                if(node.right != null){
                    queue.add(new Tuple(node.right,x+1,y+1));
                }

            }

            for(TreeMap<Integer,PriorityQueue<Integer>>ys: map.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer>nodes: ys.values()){
                   while(!nodes.isEmpty()){
                       System.out.println(nodes.peek());
                       list.get(list.size()-1).add(nodes.poll());
                   }
                }
            }
            return list;
        }
        public static class PairLine{
            Node node;
            int line;
            PairLine(Node node,int line){
                this.node = node;
                this.line = line;
            }
        }
        public List<Integer>topView(Node root){
            List<Integer>topview = new ArrayList<>();
            if(root == null){
                return topview;
            }
            Map<Integer,Integer>map = new TreeMap<>();
            Queue<PairLine>queue = new LinkedList<>();
            queue.add(new PairLine(root,0));
            while(!queue.isEmpty()){
                PairLine curr = queue.remove();
                Node currNode = curr.node;
                int line = curr.line;
                if(map.get(line) == null){
                    map.put(line,currNode.value);
                }
                if(currNode.left != null){
                    queue.add(new PairLine(currNode.left,line-1));
                }
                if(currNode.right != null){
                    queue.add(new PairLine(currNode.right,line+1));
                }

            }
            for(Map.Entry<Integer,Integer>entry: map.entrySet()){
                topview.add(entry.getValue());
            }
            return topview;
        }

        public List<Integer>bottomView(Node root){
            List<Integer>list = new ArrayList<>();
            if(root == null){
                return list;
            }
            Map<Integer,Integer>map = new TreeMap<>();
            Queue<PairLine>queue = new LinkedList<>();
            queue.add(new PairLine(root,0));
            while(!queue.isEmpty()){
                PairLine curr = queue.remove();
                Node currNode = curr.node;
                int line = curr.line;
                map.put(line, currNode.value);
                if(currNode.left != null){
                    queue.add(new PairLine(currNode.left,line-1));
                }
                if(currNode.right != null){
                    queue.add(new PairLine(currNode.right,line+1));
                }
            }
            for(Map.Entry<Integer,Integer>entry: map.entrySet()){
                list.add(entry.getValue());
            }
            return list;
        }
        public List<Integer>rightView(Node root){
            List<Integer>list = new ArrayList<>();
            rightView(root,0,list);
            return list;
        }
        public void rightView(Node root,int level,List<Integer>list){
            if(root == null){
                return;
            }
            if(list.size() == level){
                list.add(root.value);
            }
            rightView(root.right,level+1,list);
            rightView(root.left,level+1,list);

        }
        public List<Integer>leftView(Node root){
            List<Integer>list = new ArrayList<>();
            if(root == null){
                return list;
            }
            leftView(root,0,list);
            return list;
        }
        public void leftView(Node root,int level,List<Integer>list){
            if(root == null){
                return;
            }
            if(level == list.size()){
                list.add(root.value);
            }
            leftView(root.left,level+1,list);
            leftView(root.right,level+1,list);
        }

        public boolean isSymmetrical(Node root){
            return root == null || isSymmetricalHelp(root.left,root.right);
        }
        public boolean isSymmetricalHelp(Node left,Node right){
            if(left == null || right == null){
                return left == right;
            }
            if(left.value != right.value){
                return false;
            }
            return isSymmetricalHelp(left.left,right.right)
                    && isSymmetricalHelp(left.right,right.left);
        }

        public List<Integer>rootToNodePath(Node root,int key){
            List<Integer>path = new ArrayList<>();
            if(root == null){
                return path;
            }
            getPath(root,key,path);
            return path;
        }
        public boolean getPath(Node root,int key,List<Integer>path){
            if(root == null){
                return false;
            }
            path.add(root.value);
            if(root.value == key){
                return true;
            }
            if(getPath(root.left,key,path) || getPath(root.right,key,path)){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

//        public int lowestCommonAncestor(Node root,Node n1,Node n2){
//            List<Integer>path1 = rootToNodePath(root,n1.value);
//            List<Integer>path2 = rootToNodePath(root,n2.value);
//            int i =0;
//            int j =0;
//            while(true){
//                if(path1.get(i).equals(path2.get(j))){
//                    break;
//                }
//                i++;
//                j++;
//            }
//            return path1.get(i);
//        }

        public Node lowestCommonAncestor(Node root,Node n1,Node n2){
            if(root == null||root == n1 || root == n2){
                return root;
            }
            Node left = lowestCommonAncestor(root.left,n1,n2);
            Node right = lowestCommonAncestor(root.right,n1,n2);
            if(left == null){
                return right;
            } else if (right == null) {
                return left;
            }else{
                return root;
            }
        }
        public static class NodeIndex{
            int idx;
            Node node;
            NodeIndex(int idx,Node node){
                this.idx = idx;
                this.node = node;
            }
        }

        public int maxWidth(Node root){
            int maxwidth =0;
            if(root == null){
                return maxwidth;
            }
            Queue<NodeIndex>queue = new LinkedList<>();
            queue.add(new NodeIndex(0,root));
            while(!queue.isEmpty()) {
                int size = queue.size();
                int min = queue.peek().idx;
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    int curr_id = queue.peek().idx - min;
                    Node curr_node = queue.peek().node;
                    queue.remove();
                    if (i == 0) {
                        first = curr_id;
                    }
                    if (i == size - 1) {
                        last = curr_id;
                    }
                    if (curr_node.left != null) {
                        queue.add(new NodeIndex(2 * curr_id + 1, curr_node.left));
                    }
                    if (curr_node.right != null) {
                        queue.add(new NodeIndex(2 * curr_id + 2, curr_node.right));
                    }

                }
                maxwidth = Math.max(maxwidth,last-first+1);
            }
            return maxwidth;

        }

        public int childernSumProperty(){
            return 1;
        }

        public List<Integer>nodeAtDistance(Node root,Node target ,int k){
            if(root == null || target == null){
                return new ArrayList<>();
            }
            Map<Node,Node>parent_track = new HashMap<>();
            getParentNodes(root,parent_track);
            Map<Node,Boolean>isVisited = new HashMap<>();
            Queue<Node>queue = new LinkedList<>();
            queue.add(target);
            isVisited.put(target,true);
            int curr_level = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                if (curr_level == k){
                    break;
                }
                curr_level++;
                for(int i=0;i<size;i++){
                    Node curr = queue.remove();
                    if(curr.left != null && !isVisited.containsKey(curr.left)){
                        queue.add(curr.left);
                        isVisited.put(curr.left,true);
                    }
                    if(curr.right != null && !isVisited.containsKey(curr.right)){
                        queue.add(curr.right);
                        isVisited.put(curr.right,true);
                    }
                    if(parent_track.get(curr) != null && !isVisited.containsKey(parent_track.get(curr))){
                        queue.add(parent_track.get(curr));
                        isVisited.put(parent_track.get(curr),true);
                    }
                }
            }
            ArrayList<Integer>result = new ArrayList<>();
            while(!queue.isEmpty()){
                Node curr = queue.remove();
                result.add(curr.value);
            }
            return result;

        }

        public void getParentNodes(Node root,Map<Node,Node>parent_track){
            Queue<Node>queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node curr = queue.remove();
                if(curr.left != null){
                    parent_track.put(curr.left,curr);
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    parent_track.put(curr.right,curr);
                    queue.add(curr.right);
                }
            }
        }

        public int minimumTimeToBurn(Node root,Node target){
            if(root == null || target == null){
                return 0;
            }
            Map<Node,Node>parent_track = new HashMap<>();
            getParentNodes(root,parent_track);
            Queue<Node>queue = new LinkedList<>();
            Map<Node,Boolean>visited = new HashMap<>();
            queue.add(target);
            int time =0;
            while(!queue.isEmpty()){
                int size = queue.size();
                int flag = 0;
                for(int i=0;i<size;i++){
                    Node curr = queue.remove();

                    if(curr.left != null && !visited.containsKey(curr.left)){
                        queue.add(curr.left);
                        visited.put(curr.left,true);
                        flag = 1;
                    }
                    if(curr.right != null && !visited.containsKey(curr.right)){
                        queue.add(curr.right);
                        visited.put(curr.right,true);
                        flag = 1;
                    }
                    if(parent_track.get(curr) != null && !visited.containsKey(parent_track.get(curr))){
                        queue.add(parent_track.get(curr));
                        visited.put(parent_track.get(curr),true);
                        flag = 1;
                    }
                }
                if(flag == 1)time++;
            }

            return time;
        }

        public int countNodes(Node root){
            if(root == null){
                return  0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
            if (leftHeight == rightHeight){
                return 2<<leftHeight-1;
            }else {
                return countNodes(root.left)+countNodes(root.right)+1;
            }
        }

        public Node construct_BinaryTree(int[]preorder,int[]inorder){
            Map<Integer,Integer>inMap = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                inMap.put(inorder[i],i);
            }
            Node root = construct_BinaryTree(preorder,0,preorder.length-1,
                                              inorder,0,inorder.length-1,
                                              inMap);
            return root;
        }
        public Node construct_BinaryTree(int[]preorder,int prestart , int preEnd,
                                         int[]inorder,int inStart , int inEnd,
                                         Map<Integer,Integer>inMap){
            if(prestart > preEnd || inStart > inEnd){
                return null;
            }
            Node root = new Node(preorder[prestart]);
            int inRoot = inMap.get(root.value);
            int numsleft = inRoot - inStart;
            root.left= construct_BinaryTree(preorder,prestart+1,prestart+numsleft,
                                  inorder,inStart,inRoot-1,
                                  inMap);
            root.right = construct_BinaryTree(preorder,prestart+numsleft+1,preEnd,
                                              inorder,inRoot+1,inEnd,
                                              inMap);
            return root;
        }
        public Node construct_BinaryTree1(int[]inorder,int[]postorder){
            Map<Integer,Integer>inMap = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                inMap.put(inorder[i],i);
            }
            return construct_BinaryTree1(postorder,0,postorder.length-1,
                                         inorder,0,inorder.length-1,
                                         inMap);
        }
        public Node construct_BinaryTree1(int[]postorder,int postStart,int postEnd,
                                          int[]inorder,int inStart,int inEnd,
                                          Map<Integer,Integer>inMap){
            if(postStart > postEnd || inStart > inEnd){
                return null;
            }
            Node root = new Node(postorder[postEnd]);
            int inRoot = inMap.get(root.value);
            int numsLeft = inRoot - inStart;
            root.left = construct_BinaryTree1(postorder,postStart,postEnd-1-numsLeft,
                                              inorder,inStart,inRoot-1,
                                              inMap);
            root.right = construct_BinaryTree1(postorder,postStart+numsLeft,postEnd-1,
                                               inorder,inRoot+1,inEnd,
                                                inMap);
            return root;
        }

    }


    public static void main(String[]args){
        int[]arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root = BT.buildBinaryTree(arr);
        BinaryTree BT2 = new BinaryTree();
        Node root2 = BT2.buildBinaryTree(arr);
//        System.out.println(root.value);
//        BT.preorder(root);
//        BT.levelOrder(root);
//       System.out.print(BT.heightOfTree(root));
//        System.out.println(BT.countOfNodes(root));
//        BT.iterativePreOrder(root);
//        System.out.println();
//        BT.preorder(root);
//        System.out.println(BT.iterativeInOrder(root));
//        BT.inorder(root);
//        System.out.println(BT.iterativePostOrder2(root));
//        BT.postorder(root);
//        System.out.println(BT.diameterOfTree(root));
//        System.out.println(BT.maxPathSum(root));
        System.out.println(BT.isIdentical(root,root2));

    }
}

