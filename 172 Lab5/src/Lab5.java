import java.io.*;

public class Lab5 {
    static Node root;
    static int height; // height of the tree

    //constructor
    Lab5(){
        this.root = null;
    }

    public static boolean insert(Node trie, String st){
        height = 0; //initialize height
        Node TF = insertHelper(trie, st);
        if(TF == null){
            return false;
        }else{
            root = TF;
            return true;
        }
    }

    //create an insertHelper method for recursion
    public static Node insertHelper(Node root, String st) {
        if(root == null) {
            return new Node(st);
        }
        if (root != null) {
            if (root.element != null) {
                if(root.element.charAt(height)=='0') {
                    root.left = new Node(root.element);
                }
                else {
                    root.right = new Node(root.element);
                }
                root.element = null;
            }
            if (st.charAt(height) == '0') {
                height++;
                root.setLeft(insertHelper(root.left, st));
            } else {
                height++;
                root.setRight(insertHelper(root.right, st));
            }
        }
        return root;
    }


    public static String search(Node trie, String st){
        int counter = 0; // initialize value count. count is index of st.
        searchHelper(trie, st, counter);
        return searchHelper(trie, st, counter);
    }

    // create value
    public static String searchHelper(Node trie, String st, int counter) {
        if (root.isLeaf()) {
            return trie.element;
        }
        if (counter < st.length()) {
            if (st.charAt(counter) == '0'){
                counter++;
                if (trie.left == null) {
                    return smallest(trie);
                } else {
                    return searchHelper(trie.left, st, counter);
                }
            }

            if (st.charAt(counter) == '1'){
                counter++;
                if (trie.right == null) {
                    return largest(trie);
                } else {
                    return searchHelper(trie.right, st, counter);
                }
            }
        }return null;
    }

    public static void trieToList (Node trie) {
        try {
            if (trie.left != null) {
                trieToList(trie.left);
            }
            if (trie.element != null) {
                System.out.print(trie.element + " ");
            }
            if (trie.right != null) {
                trieToList(trie.right);
            }
        } catch (NullPointerException e) {

        }

    }


    public static String largest(Node trie) {
        if (trie.isLeaf()) {
            return trie.element;
        }
        if(trie.right == null){
            return largest(trie.left);
        }
        return largest(trie.right);
    }


    public static String smallest (Node trie){
        if (trie.isLeaf()) {
            return trie.element;
        }
        if(trie.left == null){
            return smallest(trie.right);
        }
        return smallest(trie.left);
    }


    public static int size(Node trie){
        if (trie == null)
            return 0;
        if (trie.isLeaf())
            return 1;
        else
            return size(trie.left) + size(trie.right);
    }


    public static int height(Node trie){
        if (trie == null)
            return 0;
        return 1 + Math.max(height(trie.left), height(trie.right));
    }


    public static void main (String[]args){
        File file = new File(args[0]);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("\\s");
                if (part[0].equals("insert")) {
                    String st = part[1];
                    GUI gui = new GUI();
                    gui.setVisible(true);
                    insert(root, st);
                }else if(part[0].equals("height")) {
                    System.out.println(height(root));
                }else if(part[0].equals("size")) {
                    System.out.println(size(root));
                }else if(part[0].equals("smallest")) {
                    System.out.println(smallest(root));
                }
                else if(part[0].equals("largest")) {
                    System.out.println(largest(root));
                }else if(part[0].equals("search")){
                    String st = part[1];
                    System.out.println(search(root, st));
                }else if(part[0].equals("print")){
                    trieToList(root);
                    System.out.println();
                }
            }
            reader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

