%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Weisi Fan
04/27/2020
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
1. This is a very small test case for treap. The test case use the same nodes(same interval and same priority) in Figure 3(D) of Project Instruction.
2. To test your code, run the code file "main.java". Before you run "main.java", you need to do the following things in your code.
  	(1) Adding a function for setting priority(in Node class). 
		public void setPriority(int v) {
       		 	this.priority = v;
    			}
  	(2) Adding a function for inOrder walk(in IntervalTreap class).
    public void inOrder(Node i){
        if(i != null){
            inOrder(i.getLeft());
            Node parent = i.getParent();
            Node left = i.getLeft();
            Node right = i.getRight();

            System.out.print("Node: ("+i.getInterv().getLow()+" "+i.getInterv().getHigh()+" "+ i.getIMax()+" "+i.getPriority()+" "+i.getHeight()+") ");
            if(parent != null)
                System.out.print("Parent: ("+parent.getInterv().getLow()+" "+parent.getInterv().getHigh()+" "+ parent.getIMax()+" "+parent.getPriority()+" "+parent.getHeight()+") ");
            else
                System.out.print("Parent: (null) ");
            if(left != null)
                System.out.print(" Left: ("+left.getInterv().getLow()+" "+left.getInterv().getHigh()+" "+ left.getIMax()+" "+left.getPriority()+" "+left.getHeight()+") ");
            else
                System.out.print("Left: (null) ");
            if(right != null)
                System.out.println("Right: ("+right.getInterv().getLow()+" "+right.getInterv().getHigh()+" "+ right.getIMax()+" "+right.getPriority()+" "+right.getHeight()+") ");
            else
                System.out.println("Right: (null)");
            inOrder(i.getRight());
        }
    }
3. Since this test case is very small, it can be traced by hand. Each time you do a insertion, deletion or search, you can know what the result is. The inOrder() will print every attribute of each node. Just check if every attibute is correct.
4. You also can add smoe other nodes or change the attibute of nodes for testing.
5. When I was writing my own code, first I use this small test to check my code. And it finds a lot of bugs. If you have no clue where the bug is, you can start with this small test to see if you can find some bugs.
 