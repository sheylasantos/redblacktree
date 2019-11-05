import javax.swing.*;
import java.awt.*;

public class ArvoreBinariaView extends JComponent {

    private RedBlackTree arvore = null;
    private int nodeSize=50;
    private int offSet=70;

    public ArvoreBinariaView(RedBlackTree arvore) {
        this.arvore=arvore;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (this.arvore==null) {
            return;
        }

        drawNode(g,this.arvore.getRoot(),getWidth()/2,50,0);

        //super.paintComponent(g);
        //drawNode(g,"1",170,80);
        //drawNode(g,"4",getWidth()/2,getHeight()/2);
        //drawNode(g,"2",250,150);
        //drawNode(g,"3",100,150);

        //g.drawLine(10,10,120,120);
        //g.draw3DRect(10,10,100,100,true);
    }
    private void drawNode(Graphics g,RedBlackNode node, int x, int y, int level){
        if (node!=null){
            if (node.getNodeColor()==NodeColor.red){
                g.setColor(Color.red);
            }else {
                g.setColor(Color.black);
            }
            g.drawOval(x,y,nodeSize,nodeSize);
            g.drawString(
                    String.valueOf(node.getValue()),
                    x+20,
                    y+20);

        }

        if (node.getLeft()!=null){
            if (node.getLeft().getNodeColor()==NodeColor.red){
                g.setColor(Color.red);
            }else {
                g.setColor(Color.black);
            }
            int childX=x-offSet;
            int childY=y+offSet;
            g.drawLine(x+nodeSize/2,y+nodeSize,childX+nodeSize/2,childY);
            drawNode(g,node.getLeft(),childX+10,childY,level+1);

        }

        if (node.getRight()!=null){
            if (node.getRight().getNodeColor()==NodeColor.red){
                g.setColor(Color.red);
            }else {
                g.setColor(Color.black);
            }
            int childX=x+offSet;
            int childY=y+offSet;
            g.drawLine(x+nodeSize/2,y+nodeSize,childX+nodeSize/3,childY);
            drawNode(g,node.getRight(),x+50,y+70,level+1);

        }
    }
}
