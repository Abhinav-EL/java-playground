package dsa;

public class BinarySearchTree {
    Node root;

    public void put(Integer key, String value){
        Node node = new Node(key, value);
        root = put(root, node);
    }
    public void put(Node node){
        root = put(root, node);
        //System.out.println("Root: "+root);
    }

    public Node get(int key){
        Node node = root;
        while(node!=null){
            int cmp = node.key.compareTo(key);
            if(cmp>0) node = node.left;
            if(cmp<0) node = node.right;
            else return node;
        }
        return null;
    }

    private Node put(Node prevNode, Node newNode){
        if(prevNode == null)
            return newNode;
        int cmp = prevNode.compareTo(newNode);
        if(cmp>0) prevNode.left = put(prevNode.left, newNode);
        else if(cmp<0) prevNode.right = put(prevNode.right, newNode);
        else prevNode = newNode;

        return prevNode;
    }

    public static void main(String[] args){
        Node node1 = new Node(5, "A");
        Node node2 = new Node(15, "B");
        Node node3 = new Node(25, "C");
        Node node4 = new Node(50, "D");
        Node node5 = new Node(-5, "E");

        BinarySearchTree bst = new BinarySearchTree();
        //put
        bst.put(node1);
        bst.put(node2);
        bst.put(node3);
        bst.put(node5);
        // Not putting node4
        //get
        Node returned = bst.get(25);
        assert(returned!=null);
        assert(returned.value=="C");
        assert(bst.get(50)==null);

    }
}