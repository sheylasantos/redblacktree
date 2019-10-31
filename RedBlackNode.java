import javax.xml.soap.Node;

public class RedBlackNode <Value extends Comparable<Value>>{
    private Value value;
    private RedBlackNode<Value> parent = null;
    private RedBlackNode<Value> left = null;
    private RedBlackNode<Value> right = null;
    private NodeColor color;
    //TODO Construtor
    public RedBlackNode(Value value) {
        this.value=value;
        this.color = NodeColor.red;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setParent(RedBlackNode<Value> parent) {
        this.parent = parent;
    }

    public RedBlackNode<Value> getParent() {
        return parent;
    }

    public void setNodeColor(NodeColor nodeColor) {
        this.color = nodeColor;
    }

    public NodeColor getNodeColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }


    public RedBlackNode<Value> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<Value> left) {
        this.left = left;
    }

    public RedBlackNode<Value> getRight() {
        return right;
    }

    public void setRight(RedBlackNode<Value> right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        int leftHeight = getLeft() == null ? 0 : 1 + getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : 1 + getRight().getHeight();

        return leftHeight - rightHeight;
    }

    public int getHeight(){
        if (getLeft() == null && getRight() == null){
            return 0;
        }
        if (getLeft() == null && getRight().getNodeColor()==color.black){
            return 1 + getRight().getHeight();
        }
        if (getRight() == null && getLeft().getNodeColor()==color.black){
            return 1 + getLeft().getHeight();
        }

        return Math.max(1 + getLeft().getHeight(), 1 + getRight().getHeight());
    }

    protected Value search(int key, RedBlackNode<Value> root) {
        if (root == null) {
            return null;
        }
        if (root.getValue().compareTo(key)==0){
            return root.getValue();
        }
        if (root.getValue().compareTo(key)<0){
            search(key,root.getLeft());
        }
        return search(key, root.getRight());

    }


}
