import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private int width = 1200;
    private int height = 800;

    public GUI() {

        Canvas canvas = new Canvas();



        setTitle("Binary Tree");
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        add(canvas, BorderLayout.CENTER);
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(width, height));

    }

    public class Canvas extends JPanel {
        Lab5 BT;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int mid = 600;
            int top = 40;
            int counter = 0;

            Color c = g.getColor(); // set color
            paintHelper(BT.root, g, mid, top, counter, c);
        }

        //create paintHelper for recursion
        public void paintHelper(Node trie, Graphics g, int mid, int top, int counter, Color c){
            int diameter = 40;
            int recLength = 70;
            int recWid = 35;

            if(trie == null){
                return;
            }
            if(trie != null){
                if(trie.element != null){
                    g.drawRect(mid - recLength/2, top, recLength, recWid);
                    g.drawString(trie.element, mid-30, top + 20);
                }else{
                    g.setColor(Color.BLUE); //set circle color blue
                    g.drawOval(mid - diameter/2, top, diameter, diameter);
                    g.setColor(c);
                    top = top + diameter;
                    if(trie.left != null){
                        counter++;
                        g.drawLine(mid, top, mid-200/counter, top+150);
                        mid = mid-200/counter;
                        top = top+150;
                        paintHelper(trie.left, g, mid, top, counter, c);
                        mid = mid+200/counter;
                        top = top-150;
                    }
                    if(trie.right != null){
                        g.drawLine(mid, top, mid+200/counter, top+150);
                        mid = mid+200/counter;
                        top = top+150;
                        counter++;
                        paintHelper(trie.right, g, mid, top, counter, c);
                    }
                }
            }

        }
    }
}
