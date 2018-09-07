package demo.binarytree.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 节点信息
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(){

    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map = Collections.synchronizedMap(map);
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
