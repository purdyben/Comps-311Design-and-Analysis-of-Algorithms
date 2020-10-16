import java.util.*;
import java.util.List;

/**
 * • IntervalTreap(): Constructor with no parameters.
 * • Node getRoot(): Returns a reference to the root node.
 * • int getSize(): Returns the number of nodes in the treap.
 * • int getHeight(): Returns the height of the treap.
 * • void intervalInsert(Node z): adds node z, whose interv attribute references an
 * Interval object, to the interval treap. This operation must maintain the required interval
 * treap properties. The expected running time of this method should be O(log n) on an
 * n-node interval treap.
 * • void intervalDelete(Node z): removes node z from the interval treap. This operation
 * must maintain the required interval treap properties. The expected running time of this
 * method should be O(log n) on an n-node interval treap.
 * • Node intervalSearch(Interval i): returns a reference to a node x in the interval
 * treap such that x.interv overlaps interval i, or null if no such element is in the treap.
 * This method must not modify the interval treap. The expected running time of this method
 * should be O(log n) on an n-node interval treap.
 */
public class IntervalTreap {
    public static Node root;
    private int size;

    /**
     * Constructor with no parameters.
     */
    IntervalTreap(){
        size = 0;
        root = null;
    }

    /**
     * Returns a reference to the root node.
     */
    public Node getRoot(){
        return root;
    }

    /**
     * Returns the number of nodes in the treap.
     * @return
     */
    public int getSize(){
        return size-1;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns the height of the treap.
     * @return
     */
    public int getHeight(){
        return root.hight-1;
    }

    /**
     * adds node z, whose interv attribute references an
     *  Interval object, to the interval treap. This operation must maintain the required interval
     *  treap properties. The expected running time of this method should be O(log n) on an
     *  n-node interval treap.
     * @param z
     */
    public void intervalInsert(Node z){
        setSize(getSize() + 1);
        setImax(z);
        root = insertNode(z, root);
        //insertNode1(z);
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public static Node rotateLeft(Node root)
    {
        Node R = root.right;
        Node X = root.right.left;

        // rotate
        R.left = root;
        root.right = X;

        int h = R.hight;
        R.hight = root.hight;
        root.hight = h;

        R.parent = root.parent;
        root.parent = R;



        if(X != null)
            X.parent = root;

        // set new root
        return R;
    }
    public static Node rotateRight(Node root)
    {
        Node L = root.left;
        Node Y = root.left.right;

        // rotate
        L.right = root;
        L.parent = root.parent;
        root.parent = L;
        root.left = Y;

        int h = L.hight;
        L.hight = root.hight;
        root.hight = h;



        if(Y != null)
            Y.parent = root;

        // set new root'

        return L;
    }
    public static Node insertNode(Node newNode, Node root) {
        // base case
        if (root == null) {
            root = (newNode);
            root.parent = null;
            return root;
        }
        if (newNode.interv.getLow() < root.interv.getLow()) {
            root.left = insertNode(newNode, root.left);
            root.left.parent = root;
            // rotate right if heap property is violated
            if (root.left != null && root.left.priority < root.priority) {
                root = rotateRight(root);
                setHight(root.right);
                setImax(root.right);
                setImax(root);
            }
        }else {
            root.right = insertNode(newNode, root.right);
            root.right.parent = root;
            // rotate left if heap property is violated
            if (root.right != null && root.right.priority < root.priority) {
                root = rotateLeft(root);
                setHight(root.left);
                setImax(root.left);
                setImax(root);
            }
        }
        if(root == newNode){
            newNode.parent = null;
        }
        Node curr = root;
        while(curr != null){
            setHight(curr);
            setImax(curr);
            curr = curr.parent;
        }

        setImax(root);

        return root;
    }
    public static void setImax(Node root) {
        Node right = root.right;
        Node left = root.left;
        if(root == null){
            ///
        } else if (root.left == null && root.right == null) {
            root.imax = root.interv.getHigh();
        } else if (right != null && left == null) {
            root.imax = Math.max(right.imax, root.interv.getHigh());
        } else if (right == null && left != null) {
            root.imax = Math.max(left.imax, root.interv.getHigh());
        } else {
            root.imax = Math.max(Math.max(right.imax, left.imax), root.interv.getHigh());
        }
    }
    public static void setHight(Node curr){
        Node right = curr.right;
        Node left = curr.left;
        if (curr.left == null && curr.right == null) {
            curr.hight = 1;
        } else if (right != null && left == null) {
            curr.hight = curr.right.hight + 1;
        } else if (right == null && left != null) {
            curr.hight = curr.left.hight + 1;
        } else {
            curr.hight = Math.max(curr.left.hight, curr.right.hight) + 1;

        }
    }
    /**
     * removes node z from the interval treap. This operation
     * must maintain the required interval treap properties. The expected running time of this
     * method should be O(log n) on an n-node interval treap.
     * @param z Node
     */
    public void intervalDelete(Node z){
        // get pointer to node
        while (true) {
            if(z == null) {
                break;
            }else if (z == root) {
                if (z.left == null) {
                    root = z.right;
                    root.parent = null;
                    break;
                } else if (z.right == null) {
                    root = z.left;
                    root.parent = null;
                    break;
                } else if (z.left.priority < z.right.priority) {
                    z =  rotateLeft(z);
                    setImax(z.left);
                    setImax(z);
                    root = z;
                    root.parent = null;
                    setHight(z.left);
                    z =z.left;
                    //print2D(root);

                }else{
                    z = rotateRight(z);
                    setImax(z.right);
                    setImax(z);
                    root = z;
                    root.parent = null;
                    setHight(z.right);
                    z =z.right;
                    // print2D(root);

                }
            } else if (z.left == null) {
                Node curr = cutNode(z.parent, z.right, z);
                while (curr != null) {
                    setHight(curr);
                    curr = curr.parent;
                }
                break;
            } else if (z.right == null) {
                Node curr = cutNode(z.parent, z.left, z);
                while (curr != null) {
                    setHight(curr);
                    curr = curr.parent;
                }
                break;
            } else if (z.left.priority < z.right.priority)
            {
                Node parent = z.parent;
                if(z.parent.left == z){
                    z =  rotateLeft(z);
                    setImax(z.left);
                    setImax(z);
                    parent.left = z;
                }else{
                    z =  rotateLeft(z);
                    setImax(z.left);
                    setImax(z);
                    parent.right = z;
                }
                z.parent = parent;

                Node curr = z;
                while(curr != null){
                    setHight(curr);
                    curr = curr.parent;
                }

                z = z.left;


            }else {
                Node parent = z.parent;
                if (z.parent.left == z) {
                    z = rotateRight(z);
                    setImax(z.right);
                    setImax(z);
                    parent.left = z;
                } else {
                    z = rotateRight(z);
                    setImax(z.right);
                    setImax(z);
                    parent.right = z;
                }
                z.parent = parent;

                Node curr = z;
                while (curr != null) {
                    setHight(curr);
                    curr = curr.parent;
                }

                z = z.right;
            }
            //print2D(root);

        }
        size--;
    }
    public Node cutNode(Node root, Node replacement, Node z ){
        if(root.left == z){

            if(replacement == null){
                return root;
            }
            root.left = replacement;
            replacement.parent = root;

        }else if(root.right == z) {
            if(replacement == null){
                return root;
            }
            root.right = replacement;

            replacement.parent = root;
        }
        else{
            System.out.println("error didnt find z");
        }
        return replacement;
    }
    /**
     *  returns a reference to a node x in the interval
     *  treap such that x.interv overlaps interval i, or null if no such element is in the treap.
     *  This method must not modify the interval treap. The expected running time of this method
     *  should be O(log n) on an n-node interval treap.
     * @param i Interval
     * @return Node
     */
    public Node intervalSearch(Interval i){
        Node x = root;
        while(x != null){
            if((!(x.interv.getHigh() < i.getLow()) && !(x.getInterv().getLow() > i.getHigh())) ){
                return x;
            }
            if(x.left != null && x.left.getIMax() >= i.getLow())
                x = x.left;
            else
                x = x.right;
        }
        return null;
    }
    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null) {
            return;
        }

        // Increase distance between levels
        space += 10;
        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");

        System.out.println(root.hight + "," + root.priority);

        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
        System.out.println("----------------------------------------------------------------");

    }

    /**
     * Returns a reference to a Node object x
     * in the treap such that x.interv.low = i.low and x.interv.high = i.high, or null if
     * no such node exists. The expected running time of this method should be O(log n) on an
     * n-node interval treap.
     * @param i Interval
     * @return Node
     */
    Node intervalSearchExactly(Interval i){
        Node x = root;
        while(x!= null &&
                (x.interv.getLow() != i.getLow() && x.interv.getHigh() != i.getHigh())) {
            if(i.getHigh() > x.imax)
                x = null;
            else if (i.getLow() < x.interv.getLow())
                        x = x.left;
            else if(i.getLow() > x.interv.getLow())
                x = x.right;
            else
                x = null;
        }
        return x;
    }

    /**
     * returns a list all intervals in
     * the treap that overlap i. This method must not modify the interval treap. The expected
     * running time of this method should be O(min(n, k log n)), where k is the number of intervals
     * in the output list.
     * @param i Interval
     * @return List<Interval>
     */
    List<Interval> overlappingIntervals(Interval i){
       // System.out.println("interval" + i.getLow() +"," +i.getHigh());
        List<Interval>  list = new LinkedList<Interval>();
        list = BFS(i,root,list);
        return list;
    }
    List<Interval> BFS(Interval i, Node n ,List<Interval> list){
        if(n == null){
          return list;
        }
        else if(overLap(i,n.interv)){
            list.add(n.interv);
        }
        list = BFS(i,n.left,list);
        list = BFS(i,n.right,list);
        return list;
    }
    public boolean overLap(Interval i1, Interval i2)
    {
        if (i1.getLow() <= i2.getHigh() && i2.getLow() <= i1.getHigh())
            return true;
        return false;
    }
}

/**
 * Node (Interval i): Constructor that takes an Interval object i as its parameter. The
 * constructor must generate a priority for the node. Therefore, after creation of a Node object,
 * getPriority() (defined below) must return the priority of this node.
 * • Node getParent(): Returns the parent of this node.
 * • Node getLeft(): Returns the left child of this node.
 * • Node getRight(): Returns the right child of this node.
 * • Interval getInterv(): Returns the interval object stored in this node.
 * • int getIMax(): Returns the value of the imax field of this node.
 * • int getPriority(): Returns the priority of this node.
 */
class Node{

    protected Interval interv ;
    protected int imax;
    protected int priority;
    protected int hight;
    protected Node parent;
    protected Node left;
    protected Node right;

    public Node(){
        this.interv = null;
        this.priority = 0;
        this.imax = 0;
    }

    /**
     * @param interv Interval
     */
    Node(Interval interv){
        this.interv = interv;
        this.priority = (int) (Math.random() * (1000000));
        this.imax = interv.getHigh();
        hight = 1;
        parent = null;
        left = null;
        right = null;
    }

    /**
     * @param interv Interval
     * @param priority int
     * @param max int
     */
    public Node(Interval interv, int priority, int max){
        this.interv = interv;
        this.priority = priority;
        this.imax = max;
        hight = 1;
        parent = null;
        left = null;
        right = null;

    }

    /**
     * Returns the parent of this node.
     * @return Node
     */
    public Node getParent(){
        return parent;
    };
    /**
     * Returns the left child of this node.
     * @return Node
     */
    public Node getLeft(){
        return left;
    };
    /**
     * Returns the Right child of this node.
     * @return Node
     */
    public Node getRight(){
        return right;
    };
    /**
     * Returns the interval object stored in this node.
     * @return Interval
     */
    public Interval getInterv(){
        return interv;
    };
    public int getIMax(){
        return imax;
    }
    public int getPriority() {
        return priority;
    }
    public void setInterv(Interval interv) {
        this.interv = interv;
    }
    public void setMax(int max) {
        this.imax = max;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public String toString(){
        return "[" + interv.getLow() +','+interv.getHigh() +"], "+imax +"," +priority +","+ hight + ",";
    }
}
