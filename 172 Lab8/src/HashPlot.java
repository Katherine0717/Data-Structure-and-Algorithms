import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HashPlot {
    public static void writeToFile(String filename,Integer[] key) {
        try {
            FileWriter fWriter=new FileWriter(filename);
            for(int i=0;i<key.length;i++) {
                fWriter.write(key[i]+" ");
            }
            fWriter.close();
        }catch(Exception e) {

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader reader;
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int m=Integer.parseInt(args[2]);
        String line=null;
        try {
            reader=new BufferedReader(new FileReader(args[3]));
            Map<Integer, Integer> map=new Map<>();
            while ((line = reader.readLine())!=null) {
                String[] part=line.split("\\s");
                Integer[] value=new Integer[part.length];
                Integer[] key=new Integer[part.length];
                for(int i=0;i<part.length;i++) {
                    value[i]=Integer.parseInt(part[i]);
                    key[i]=(value[i]*a+b)%m;
                }
                writeToFile("output_sequence", key);
                for(int i=0;i<part.length;i++) {
                    map.insert(key[i], value[i]);
                }
                BufferedImage image=new BufferedImage(1000, m, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g=image.createGraphics();
                g.setPaint(Color.BLUE);
                for (int i=0;i<part.length;i++) {
                    g.drawLine(value[i], key[i], value[i], key[i]);
                    g.setBackground(Color.white);
                }
                ImageIO.write(image, "PNG", new File("plot.PNG"));
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

}
