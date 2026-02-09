package dsa;

public class BinarySearchTree {
    Node root;

    public void put(Integer key, String value){
        Node node = new Node(key, value);
        root = put(root, node);
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

    public String get(int key){
        Node node = root;
        while(node!=null){
            int cmp = node.key.compareTo(key);
            if(cmp>0) node = node.left;
            if(cmp<0) node = node.right;
            else return node.value;
        }
        return null;
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        //put
        bst.put(5, "A");
        bst.put(15, "B");
        bst.put(25, "C");
        bst.put(-5, "E");
        //get
        String returned = bst.get(25);
        assert(returned!=null);
        assert(returned.equals("C"));
        assert(bst.get(50)==null);

        System.out.println("C returned: "+returned);
    }
}