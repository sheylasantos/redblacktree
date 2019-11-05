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
        if (node.getValue().compareTo(parent.getValue())==0){
            parent.setValue(node.getValue());
            node.setParent(parent);
            return parent;
        }
        if (node.getValue().compareTo(parent.getValue())<0){
            node.setParent(parent);
            parent.setLeft(insert(node,parent.getLeft()));
        }else {
            node.setParent(parent);
            parent.setRight(insert(node,parent.getRight()));
        }
        /*if (parent.getNodeColor()==NodeColor.black){
            insert(node,parent);
        }*/
        return balance(node,parent);
    }

    private RedBlackNode<Value> balance(RedBlackNode<Value> este,RedBlackNode<Value> node) {


        //if (balanceFactor>1){
            if (node.getNodeColor()!=NodeColor.black && este!=root){
                /*if (node.getParent().getLeft()==null){
                    if (este.getValue().compareTo(node.getParent().getRight().getValue())<0){
                        node.getParent().setLeft(este);
                    }else {
                        RedBlackNode<Value> tmp = node.getParent().getRight();
                        node.getParent().setRight(este);
                        node.getParent().setLeft(tmp);
                    }

                }*/
                 if (node.getParent().getRight()!=node && node.getParent().getLeft()!=null){
                    if (node.getParent().getRight().getNodeColor()==NodeColor.red){
                        //rotateRight(node);
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }else if(node.getLeft()==este){
                        rotateRight(node);
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }else if(node.getRight()==este){
                        node.setLeft(rotateLeft(node.getLeft()));
                        rotateRight(node);
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }
                }
                else if (node.getParent().getLeft()!=node && node.getParent().getRight()!=null){

                    if (node.getParent().getLeft().getNodeColor()==NodeColor.red){
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }else if(node.getRight()==este){
                        rotateLeft(node);
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }else if(node.getLeft()==este){
                        node.setRight(rotateRight(node.getRight()));
                        rotateLeft(node);
                        node.setNodeColor(NodeColor.black);
                        node.getLeft().setNodeColor(NodeColor.red);
                        node.getRight().setNodeColor(NodeColor.red);
                    }
                }

            }
            int balanceFactor = node.getBalanceFactor();
            //if (balanceFactor==0){
            //    return node;
            //}
            return node;
//            //TODO L
//            if (node.getLeft().getBalanceFactor()>0){
//                //TODO LL
//                return rotateRight(node);
//            }else {
//                //TODO LR
//                node.setLeft(rotateLeft(node.getLeft()));
//                return rotateRight(node);
//            }
//        //}else {
//            if (node.getRight().getBalanceFactor()<0){
//                //TODO RR
//                return rotateLeft(node);
//            }else {
//                //TODO RL
//                node.setRight(rotateRight(node.getRight()));
//                return rotateLeft(node);
//            }

        //}
        //return null;
    }
    public boolean isBalanced(){
        if (root == null){
            return true;
        }
        return Math.abs(root.getBalanceFactor())==0;
    }
    private RedBlackNode<Value> rotateLeft(RedBlackNode<Value> oldRoot) {
        RedBlackNode<Value> newRoot = oldRoot.getRight();
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);
        //newRoot.setLeft(node.getLeft());
        return newRoot;
    }

    private RedBlackNode<Value> rotateRight(RedBlackNode<Value> oldRoot) {
        RedBlackNode<Value> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);
        //newRoot.setLeft(node.getLeft());
        return newRoot;
    }

}
