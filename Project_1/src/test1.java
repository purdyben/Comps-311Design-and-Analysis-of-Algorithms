import java.util.List;

public class test1 {

    static final int count = 10;

    public static void main(String[] args) {

        IntervalTreap treap = new IntervalTreap();
//        treap.intervalInsert(new Node(new Interval(16, 21), 1000, 21));
//        print2DUtil(treap.getRoot(), 0);
//        Node x = new Node(new Interval(15, 30),2000, 30);
//        treap.intervalInsert(new Node(new Interval(12, 32), 7000, 9));
//
//        treap.intervalInsert(x);
//       // treap.intervalInsert(new Node(new Interval(16, 21)));
//        print2DUtil(treap.getRoot(), 0);
//        Node n = new Node(new Interval(8, 9), 6199, 9);
//
//        treap.intervalInsert(n);
        //print2DUtil(treap.getRoot(), 0);
        //treap.intervalDelete(x);
//////
        Node n = new Node(new Interval(16, 21));
        Node x = new Node(new Interval(15, 23));
        treap.intervalInsert(n);
        treap.intervalInsert(new Node(new Interval(21, 30)));
        treap.intervalInsert(new Node(new Interval(8, 9)));
        treap.intervalInsert(new Node(new Interval(12, 13)));
        treap.intervalInsert(new Node(new Interval(1, 23)));
        treap.intervalInsert(x);
        treap.intervalInsert(new Node(new Interval(1, 1)));
        treap.intervalInsert(new Node(new Interval(2, 2)));
//        treap.intervalInsert(new Node(new Interval(1, 1)));
//        treap.intervalInsert(new Node(new Interval(2, 2)));

//        print2D(treap.getRoot());
        print2D((treap.getRoot()));
        treap.intervalDelete(treap.root);
        //List<Interval> list = treap.overlappingIntervals(treap.root.interv);

//        for (Interval interval : list) {
//            System.out.println("(" + interval.getLow() + "," + interval.getHigh() + ")");
//        }
//        Node t = treap.intervalSearchExactly(new Interval(2, 2));
//        System.out.println(t.interv.getLow() + "," + t.interv.getHigh());
//        print2D(treap.getRoot());

//        treap.intervalDelete(x);
        //print2D(treap.getRoot());
        print2D((treap.getRoot()));
        System.out.println("size : " + treap.getSize());

        //System.out.println("(" + treap.getRoot().interv.getLow() + "," + treap.getRoot().interv.getHigh() + ") - par =" + treap.getRoot().parent.priority + " - " + treap.getRoot().priority);
       // Node seachtest = treap.intervalSearch(new Interval(2,4));
        //System.out.println("(" + seachtest.interv.getLow() + "," + seachtest.interv.getHigh() + ") - par =" + seachtest.parent.priority + " - " + seachtest.priority);

        //test
//        IntervalTreap test= new IntervalTreap();
//        test.intervalInsert(new Node(new Interval(16, 21), 8, 30));
//        test.intervalInsert(new Node(new Interval(8, 9), 12, 23));
//
//        test.intervalInsert(new Node(new Interval(5, 8), 17, 10));
//
//        test.intervalInsert(new Node(new Interval(16, 21), 8, 30));
//
//        test.intervalInsert(new Node(new Interval(16, 21), 8, 30));


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

//        if(root.parent == null){
//            System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax + ": null");
//
//        }else{
//            System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax );
//
//        }
        //        System.out.println("(" + root.interv.getLow() + "," + root.interv.getHigh() + ")"+ ":" + root.imax + " - par =" + root.parent.priority + " - " + root.priority + ", height - " + root.hight);

        //System.out.println(root.hight + "," + root.priority);
        System.out.println(root.hight + ", " + root.priority);
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
}