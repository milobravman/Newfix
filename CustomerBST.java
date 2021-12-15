public class CustomerBST implements java.io.Serializable{


    private Customer root;

    public CustomerBST(){
        root = null;
    }

    public boolean hasNoCustomers(){
        return root == null;
    }

    public void insert(Customer node){
        if (hasNoCustomers()){
            root = node;
        }
        else{
            insert2(root, node);
        }
    }

    private void insert2(Customer root, Customer node){

        if (node.getCreditNum()<root.getCreditNum()){
            if (root.getLeft() == null){
                root.setLeft(node);
            }
            else insert2(root.getLeft(),node);
        }
        else{
            if (root.getRight() == null){
                root.setRight(node);
            }
            else insert2(root.getRight(),node);
        }

    }

    public void printTree() {
        printTree2(root);
        System.out.println();
        }
    
    private void printTree2(Customer tree) {
        if (tree != null) {
            System.out.println(tree.getName() + " Creditnumber: " + tree.getCreditNum());
                // if (tree.getLeft() != null)
                //     System.out.print("Left: " + tree.getLeft().getName() + " ");
                // else
                //     System.out.print("Left: null ");
                // if (tree.getRight() != null)
                // System.out.println("Right: " + tree.getRight().getName() + " ");
                // else
                //     System.out.println("Right: null ");
            printTree2(tree.getLeft());
            printTree2(tree.getRight());
        }
    }

    public Customer search(int key){
        return search2(root, key);
    }
    private Customer search2(Customer node, int key){
        if (node == null) {
            return null;
        }else if(node.getCreditNum() == key){
            return node;
        }else if (key < node.getCreditNum()){
            return search2(node.getLeft(), key);
        }else{
            return search2(node.getRight(), key);
        }
    }

    public void traverse(){
        traverser(root);
        System.out.println();
    }

    private void traverser(Customer node_iteratior){
        if (node_iteratior!=null){
            traverser(node_iteratior.getLeft());
            System.out.print(node_iteratior.getCreditNum()+" ");
            traverser(node_iteratior.getRight());
        }

    }

    public void delete(Customer node){
        // System.out.println(node.getKey());
        // System.out.println(root.getKey());
        // System.out.println(node.getKey() == root.getKey());
        if (root == null){
            System.out.println("This tree is already empty!");
        }else if (node.getCreditNum() == root.getCreditNum()){
            root = deleteRoot(root);
        }else{
            delete2(root,node);
        }

    }

    
    // Delete root should check the case of the tree
    // if there are two children we need to find a succsessor
    // if there is one child that has to be the succsessor
    // if there are no children we were deleting a leaf
    private Customer deleteRoot(Customer node){
        if (node.getLeft() !=null && node.getRight() !=null){ // if we need to find a succsesor this
            // 2 main succsessor cases: when the succsessor is the right node of the node I am trying to delete, and when it is further down the tree and therefore not directly attached to the node we are trying to delete.
            Customer succsessor = succsessor(node);
            if (succsessor.getCreditNum() == node.getRight().getCreditNum()){ // if the successor is the right node of the node we are deleting do this
                succsessor.setLeft(node.getLeft());
                node.setLeft(null);
                node.setRight(null);
                return succsessor;

            }else{ // if the successor is not the right node of the node we are deleting do this instead
                Customer succsessorsRight = succsessor.getRight();
                //delete(succsessor); // delete succsor from the tree
                Customer succsessorsParent = succsessorParent(node); // with the successior deleted from the tree a call to successor should give us the successors parent
                //System.out.println(succsessorsParent.getKey());
                succsessorsParent.setLeft(succsessorsRight);
                succsessor.setLeft(node.getLeft());
                succsessor.setRight(node.getRight());
                node.setLeft(null);
                node.setRight(null);
                return succsessor;
            }
            // somehow relink up the succsessor to its new spot in the tree
            //

        }else if (node.getLeft() !=null){ // if there is just a left child do this
            Customer temp = node.getLeft();
            node.setLeft(null);
            node.setRight(null);
            return temp;
            
        }else if (node.getRight() !=null){ // if there is just a right child do this
            Customer temp = node.getRight();
            node.setLeft(null);
            node.setRight(null);
            return temp;
        }else{
            return null; // not sure if this else could even posibly happen but just in case something strage happens return null.
        }
	
    }

    // for discrete succsesors there is a need to accsess it parent but we do not have a parent field in node so I need to calculate it in a somewhat hacky way

    private Customer succsessorParent(Customer node){
        Customer succsessorParent = node.getRight(); // we start at the right of the head node because succsesor parent only needs to be called when the succsor is not imediatly to the right of the node we are deleting
        while (succsessor(node) != succsessorParent.getLeft()){
            succsessorParent = succsessorParent.getLeft();
        }
        return succsessorParent;
    }

    private Customer succsessor(Customer node){
        Customer succsessor = node.getRight();
        while (succsessor.getLeft() != null){
            succsessor = succsessor.getLeft();
        }
        return succsessor;
    }

    // getting a little turned around by my varible names. I pass in root when I call delete2 in delete but if I use root as the paramter varable. When I try to use the paramter var if it was still named root I can't tell which root (the paramter passed or the delclared feild) so I'm changing the name to head and node. I should probolby change the names more thoughuly or understand how to use the 'this' keyword here.

    // You need to keep accsess the node before the one you want to delete in case the node you delete has children

    private void delete2(Customer head, Customer node){
        // System.out.println("head is " + head.getKey());
        // System.out.println("node is " + node.getKey());
        if (node.getCreditNum() > head.getCreditNum()){ // if the key we are looking for is bigger than the node are at have look to the node's right
            if (head.getRight() == null){
                //System.out.println("The tree does not have this node!");
            }
            else if (node.getCreditNum() == head.getRight().getCreditNum()){ // case where we find the thing we want to delete
                //System.out.println("calling deleteRoot on"+ node.getCreditNum());
                head.setRight(deleteRoot(node));// the idea here is to set the right pointer of the 'head' of this tree or subtree to be the whatever deleteRoot returns beccause that should the be the joining og the new mutated secrion or the subtree that had the key node as its root/head to the original tree passed into the delete method.

                // Note before it was head.setRight(deleteRoot(node));
            }
            else{
                delete2(head.getRight(), node);
            }
        }
        else{
            // I need to go to the left side of the tree
            if (head.getLeft() == null){
                //System.out.println("The tree does not have this node!");
            }
            else if (node.getCreditNum() == head.getLeft().getCreditNum()){ // case where we find the thing we want to delete
                //System.out.println("calling deleteRoot on"+ node.getCreditNum());
                head.setLeft(deleteRoot(node)); // the idea here is to set the right pointer of the 'head' of this tree or subtree to be the whatever deleteRoot returns beccause that should the be the joining og the new mutated secrion or the subtree that had the key node as its root/head to the original tree passed into the delete method.

                // Note before it was head.setRight(deleteRoot(node));
            }
            else{
                delete2(head.getLeft(), node);
            }
        } 
    }

    public static void main(String[] args) {


        Customer bob = new Customer("bob", "bob@yahoo.com", 021234);
        Customer steve = new Customer("steve", "steve@yahoo.com", 2434509);
        Customer sarah = new Customer("sarah", "sarah@gmail.com", 2345567);
        CustomerBST all = new CustomerBST();
        all.insert(steve);
        all.insert(sarah);
        all.insert(bob);
        System.out.println();

        all.printTree();
    }

}
