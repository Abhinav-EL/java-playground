package dsa;
public class Node implements Comparable<Node>{
    public Integer key;
    public String value;
    public Node left, right;

    public Node(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    public int compareTo(Node otherObj){
        return key.compareTo(otherObj.key);
    }

    public String toString(){
        return "Key: "+key+ " Value:"+value;
    }
}