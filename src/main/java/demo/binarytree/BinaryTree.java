package demo.binarytree;

import demo.binarytree.bean.Node;

import java.util.Stack;

/**
 * 二叉树样例
 */
public class BinaryTree {
    /**
     * 根结点
     */
    private Node root;

    /**
     * 查找元素
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node curr = root;
        while (curr != null) {
            if (curr.getValue() == value) {
                return curr;
            } else if (curr.getValue() > value) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return null;
    }

    public void insert(int... values) {
        if (values != null && values.length > 0) {
            for (int value : values) {
                insert(value);
            }
        }
    }

    /**
     * 插入元素
     *
     * @param value
     * @return
     */
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node curr = root;
            while (curr != null) {
                if (curr.getValue() > value) {
                    if (curr.getLeft() == null) {
                        curr.setLeft(newNode);
                        return true;
                    } else {
                        curr = curr.getLeft();
                    }
                } else {
                    if (curr.getRight() == null) {
                        curr.setRight(newNode);
                        return true;
                    } else {
                        curr = curr.getRight();
                    }
                }
            }
            return false;
        }
    }

    /**
     * 中序遍历（非递归）
     */
    public void middleTraverse() {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                System.out.print(curr.getValue()+" ");
                curr = curr.getRight();
            }
        }
    }

    /**
     * 中序遍历（递归）
     *
     * @param curr
     */
    private void middleTraverse(Node curr) {
        if (curr != null) {
            middleTraverse(curr.getLeft());
            System.out.print(curr.getValue() + " ");
            middleTraverse(curr.getRight());
        }
    }

    /**
     * 中序遍历（递归）
     */
    public void middleTraverseRecursion() {
        middleTraverse(root);
    }

    /**
     * 先序遍历
     *
     * @param curr
     */
    public void preTraverse(Node curr) {
        if (curr != null) {
            System.out.print(curr.getValue() + " ");
            preTraverse(curr.getLeft());
            preTraverse(curr.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param curr
     */
    public void postTraverse(Node curr) {
        if (curr != null) {
            postTraverse(curr.getLeft());
            postTraverse(curr.getRight());
            System.out.print(curr.getValue() + " ");
        }
    }


    /**
     * 找最大值
     *
     * @return
     */
    public Integer findMax() {
        Node curr = root;
        Node max = null;
        while (curr != null) {
            max = curr;
            curr = curr.getRight();
        }
        return max == null ? null : max.getValue();
    }

    /**
     * 找最小值
     *
     * @return
     */
    public Integer findMin() {
        Node curr = root;
        Node min = null;
        while (curr != null) {
            min = curr;
            curr = curr.getLeft();
        }
        return min == null ? null : min.getValue();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10,8,15,4,9,11,20,5);
        System.out.print("middle traverse:");
        tree.middleTraverse();
        System.out.println();
        System.out.print("post traverse:");
        tree.postTraverse(tree.root);
        System.out.println();
        System.out.print("middle traverse:");
        tree.middleTraverseRecursion();
        System.out.println();
        System.out.print("pre traverse:");
        tree.preTraverse(tree.root);
        System.out.println();
        System.out.println("max value:" + tree.findMax());
        System.out.println("min value:" + tree.findMin());
    }
}
