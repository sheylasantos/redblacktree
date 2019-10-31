import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> pessoas;
        pessoas = new RedBlackTree<>();
        //AVLTree<Time> times = new AVLTree<>();

        pessoas.insert(1);
        pessoas.insert((2));
        pessoas.insert((3));
        pessoas.insert((4));
        pessoas.insert((5));
        pessoas.insert((6));

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
        ArvoreBinariaView view = new ArvoreBinariaView(pessoas);
        //frame.add(view);

    }
}
