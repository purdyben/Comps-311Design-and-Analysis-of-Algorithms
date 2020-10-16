import java.util.ArrayList;

import static org.junit.Assert.fail;

public class Main {
    static final int count = 14;
    // main function of the program
    public static void main(String[] args){
        //test cases, create nodes as the Figure 3 in Project instruction.
        //node n1 to n11 is same with the node in Figure 3.
        Interval i1 = new Interval(16,21);
        Node n1 = new Node(i1);
        n1.setPriority(8);

        Interval i2 = new Interval(8,9);
        Node n2 = new Node(i2);
        n2.setPriority(12);

        Interval i3 = new Interval(25,30);
        Node n3 = new Node(i3);
        n3.setPriority(10);

        Interval i4 = new Interval(5,8);
        Node n4 = new Node(i4);
        n4.setPriority(17);

        Interval i5 = new Interval(15,23);
        Node n5 = new Node(i5);
        n5.setPriority(16);

        Interval i6 = new Interval(17,19);
        Node n6 = new Node(i6);
        n6.setPriority(13);

        Interval i7 = new Interval(26,26);
        Node n7 = new Node(i7);
        n7.setPriority(11);

        Interval i8 = new Interval(0,3);
        Node n8 = new Node(i8);
        n8.setPriority(21);

        Interval i9 = new Interval(6,10);
        Node n9 = new Node(i9);
        n9.setPriority(20);

        Interval i10 = new Interval(19,20);
        Node n10 = new Node(i10);
        n10.setPriority(17);

        Interval i11 = new Interval(7,25);
        Node n11 = new Node(i11);
        n11.setPriority(9);

        Interval i12 = new Interval(27,41);
        Node n12 = new Node(i12);
        n12.setPriority(32);

        Interval i13 = new Interval(12,22);
        Node n13 = new Node(i13);
        n13.setPriority(18);

        Interval i14 = new Interval(13,25);
        Node n14 = new Node(i14);
        n14.setPriority(40);

        IntervalTreap T = new IntervalTreap();

        // You can insert the 14 nodes in any order, and the result should be same
        T.intervalInsert(n9);
        print2D((T.getRoot()));
        T.intervalInsert(n3);
        print2D((T.getRoot()));
        T.intervalInsert(n6);
        print2D((T.getRoot()));
        T.intervalInsert(n1);
        print2D((T.getRoot()));
        T.intervalInsert(n4);
        print2D((T.getRoot()));
        T.intervalInsert(n7);
        print2D((T.getRoot()));
        T.intervalInsert(n8);
        print2D((T.getRoot()));
        T.intervalInsert(n2);
        print2D((T.getRoot()));
        T.intervalInsert(n11);
        print2D((T.getRoot()));
        T.intervalInsert(n5);
        print2D((T.getRoot()));
        T.intervalInsert(n10);
        print2D((T.getRoot()));
        T.intervalInsert(n12);
//
        T.intervalInsert(n13);
//
        T.intervalInsert(n14);
        //System.out.println(T.getHeight());
//
//        ArrayList<Node> arr = new ArrayList<Node>();
//        inOrder(T.getRoot(),arr);
//
//        for (Node node : arr) {
//            System.out.print(node.priority + ",");
//        }
//        print2D((T.getRoot()));
////        // Deletion case1
        T.intervalDelete(n2);
//        arr = new ArrayList<Node>();
//        inOrder(T.getRoot(),arr);
//
//        for (Node node : arr) {
//            System.out.print(node.priority + ",");
//        }
//        System.out.println(" ");
//        print2D((T.getRoot()));
//        //print2D((T.getRoot()));
////        //T.inOrder(T.getRoot());
////        System.out.println(T.intervalSearch(i2).toString());
////        System.out.println(T.intervalSearchExactly(i2));
//
//
////        // Deletion case2
        T.intervalDelete(n14);
//        arr = new ArrayList<Node>();
//        inOrder(T.getRoot(),arr);
//
//        for (Node node : arr) {
//            System.out.print(node.priority + ",");
//        }
//        System.out.println(" ");
//////        //T.inOrder(T.getRoot());
////// print2D((T.getRoot()));
//////        // Deletion case3
        T.intervalDelete(n1);
////        System.out.println(T.intervalSearchExactly(i1).toString());
//        print2D((T.getRoot()));
//        arr = new ArrayList<Node>();


    }
    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null) {
            return;
        }

        // Increase distance between levels
        space += count;
        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = count; i < space; i++)
            System.out.print(" ");
        System.out.println(root.hight);
//        if(root.parent == null){
//            System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax +", " + root.priority +":");
//
//        }else{
//            System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax + ", " + root.priority );
//
//        }
        //        System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax + " - par =" + root.parent.priority + " - " + root.priority + ", height - " + root.hight);

        //System.out.println(root.hight + "," + root.priority);
//        if(root.parent != null){
//            System.out.println(root.parent.priority + ", " + root.imax+ ", " + root.priority);
//
//        }else{
//            System.out.println("null" + ", "+ root.imax + ", " + root.priority);
//
//        }
        //System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax);

        // Process left child

        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
        System.out.println("----------------------------------------------------------------");

    }
    public static void inOrder(Node node, ArrayList<Node> array){
        if(node == null){
            return;
        }
        inOrder(node.getLeft(), array);
        array.add(node);

        //As you visit each node, check for the heap property.
        if (node.getParent()!=null && node.getPriority() < node.getParent().getPriority()) {

            fail("failed treap's min-heap property!");
        }

        inOrder(node.getRight(), array);
    }
}
