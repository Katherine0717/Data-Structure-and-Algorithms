/**
 * Ningyuan Xiong
 * NetID: nxiong
 * Lab4
 * I did not collaborate with anyone on this assignment.
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DNAList {
    public static void main(String[] args) throws FileNotFoundException{
        int length=Integer.parseInt(args[0]); // get arraySize
        Sequence sq=new Sequence(length);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[1]));
            String line=null;
            while ((line = reader.readLine())!=null) {
                String[] part = line.split("\\s");

                if(part[0].equals("insert")){
                    int pos = Integer.parseInt(part[1]);
                    String type = part[2];
                    String sequence = part[3];
                    sq.insert(pos, type, sequence);
                }else if(part[0].equals("print")) {
                    if(part.length==1) {
                        sq.print();
                    }else {
                        int pos2 = Integer.parseInt(part[1]);
                        sq.print(pos2);
                    }
                }else if(part[0].equals("remove")) {
                    int pos1 = Integer.parseInt(part[1]);
                    sq.remove(pos1);
                }else if(part[0].equals("clip")) {
                    int pos = Integer.parseInt(part[1]);
                    int pos1 = Integer.parseInt(part[2]);
                    int pos2 = Integer.parseInt(part[3]);
                    sq.clip(pos, pos1, pos2);
                }
                else if(part[0].equals("copy")) {
                    int pos1 = Integer.parseInt(part[1]);
                    int pos2 = Integer.parseInt(part[2]);
                    sq.copy(pos1, pos2);
                }else if(part[0].equals("transcribe")){
                    int pos = Integer.parseInt(part[1]);
                    sq.transcribe(pos);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}