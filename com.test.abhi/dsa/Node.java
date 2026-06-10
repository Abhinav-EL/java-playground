package dsa;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other){
        if(this==other) return true;
        Node otherNode = (Node) other;
        return key==otherNode.key && 
            Objects.equals(this.value, otherNode.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(key, value);
    }
}