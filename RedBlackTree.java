import javafx.scene.chart.ValueAxis;

public class RedBlackTree <Value extends Comparable<Value>>{
    private RedBlackNode<Value> root;


    public boolean isEmpty() {
        return root == null;
    }
    public RedBlackNode<Value> getRoot() {
        return root;
    }
    public void insert(Value value) {

        //insert(new Node<Value>(value));

        root = insert(new RedBlackNode<Value>(value),root);
    }

    private RedBlackNode<Value> insert(RedBlackNode<Value> node, RedBlackNode<Value> parent) {
        if (parent==null){
            node.setNodeColor(NodeColor.black);
            return node;
        }
        if (node.getValue().compareTo(parent.getValue())>0){
            parent.setValue(node.getValue());
            return parent;
        }
        if (node.getValue().compareTo(parent.getValue())<0){
            parent.setLeft(insert(node,parent.getLeft()));
        }else {
            parent.setRight(insert(node,parent.getRight()));
        }
        return balance(parent);
    }
}
