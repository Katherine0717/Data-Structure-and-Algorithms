public class Sequence {
    public SinglyLinkedList<Character>[] arrseq;
    public Sequence(int size) {
        arrseq=new SinglyLinkedList[size];
        for(int i=0;i<arrseq.length;i++) {
            arrseq[i]=new SinglyLinkedList();
            arrseq[i].setType(SinglyLinkedList.Type.Null);
        }
    }

    public void insert(int pos, String type, String sequence) {
        if(pos>arrseq.length||pos<0) {
            System.out.println("Error occurred while inserting");
        }
        else if(checkDNA(sequence)) { // check elements of the sequence
            if(type.equals("DNA")) {  // check the type of input sequence
                SinglyLinkedList.Type type2=SinglyLinkedList.Type.DNA;
                if(arrseq[pos]==null) {
                    for(int i=sequence.length()-1;i>=0;i--) {
                        arrseq[pos].addFirst(sequence.charAt(i));
                    }
                }
                else {
                    arrseq[pos]=null;
                    arrseq[pos]=new SinglyLinkedList();
                    for(int i=sequence.length()-1;i>=0;i--) {
                        arrseq[pos].addFirst(sequence.charAt(i));
                    }
                }
                arrseq[pos].setType(type2);
            }
            else {
                System.out.println("Error occurred while inserting");
            }
        }
        else {
            if(type.equals("RNA")) {
                SinglyLinkedList.Type type3=SinglyLinkedList.Type.RNA;
                if(arrseq[pos]==null) {
                    for(int i=sequence.length()-1;i>=0;i--) {
                        arrseq[pos].addFirst(sequence.charAt(i));
                    }
                }
                else {
                    arrseq[pos]=null;
                    arrseq[pos]=new SinglyLinkedList();
                    for(int i=sequence.length()-1;i>=0;i--) {
                        arrseq[pos].addFirst(sequence.charAt(i));
                    }
                }
                arrseq[pos].setType(type3);
            }
            else {
                System.out.println("Error occurred while inserting");
            }
        }

    }

    public boolean checkDNA(String sequence) {
        if(sequence==null) {
            return true;
        }
        else {
            for(int i=0;i<sequence.length();i++) {
                if(sequence.charAt(i)!='A'&&sequence.charAt(i)!='C'&&sequence.charAt(i)!='G'&&sequence.charAt(i)!='T') {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean checkRNA(String sequence) {
        if(sequence==null) {
            return true;
        }
        else {
            for(int i=0;i<sequence.length();i++) {
                if(sequence.charAt(i)!='A'&&sequence.charAt(i)!='C'&&sequence.charAt(i)!='G'&&sequence.charAt(i)!='U') {
                    return false;
                }
            }
            return true;
        }
    }

    public void remove(int pos) {
        if(arrseq[pos].getType().equals(SinglyLinkedList.Type.Null)) {
            System.out.println("No sequence to remove at specified position");
        }
        else {
            while(!arrseq[pos].isEmpty()) {
                arrseq[pos].removeFirst();
            }
            arrseq[pos].setType(SinglyLinkedList.Type.Null);
        }
    }

    public void print() {
        for(int i=0;i<arrseq.length;i++) {
            if(!arrseq[i].getType().equals(SinglyLinkedList.Type.Null)) {
                System.out.println(i+"\t"+arrseq[i].getType()+"\t"+arrseq[i].toString());
            }
            else
                continue;
        }
    }

    public void print(int pos) {
        if(arrseq[pos].getType().equals(SinglyLinkedList.Type.Null)) {
            System.out.println("No sequence to print at specified position");
        }
        else {
            System.out.println(arrseq[pos].getType()+"\t"+arrseq[pos]);
        }
    }


    public void clip(int pos, int start, int end) {
        String type = arrseq[pos].typeToString(arrseq[pos].getType());  //store current type
        if(arrseq[pos].getType().equals(SinglyLinkedList.Type.Null)) {
            System.out.println("No sequence to clip at sepcified position.");
        }else if(start>end){
            remove(pos);
            arrseq[pos].setType(arrseq[pos].stringToType(type));
        }else if(start > arrseq[pos].size()){
            System.out.println("Start index is out of bounds.");
        }else if(start<0) {
            System.out.println("Invalid start value.");
        }else if(end > arrseq[pos].size()) {
            System.out.println("End index is out of bounds.");
        }else {

            char[] list = new char[end-start+1]; // create a char array to store data
            for(int i=start;i<=end;i++) {
                char a = arrseq[pos].first();
                arrseq[pos].removeFirst();
                list[i]=a;
            }
            remove(pos);  // remove data and type
            arrseq[pos].setType(arrseq[pos].stringToType(type)); //set back its current type
            for(int i=list.length-1;i>=0;i--) {
                arrseq[pos].addFirst(list[i]);  // add back clipped elements
            }
        }

    }
    public void copy(int pos1,int pos2) {
        // set type in position pos2 to pos1
        String type = arrseq[pos1].typeToString(arrseq[pos1].getType()); // same with clip method
        if(arrseq[pos1].getType().equals(SinglyLinkedList.Type.Null)) {
            System.out.println("No sequence to copy at specified position");
        }
        else {
            // same with clip method
            char[] list = new char[arrseq[pos1].size()];
            int size = arrseq[pos1].size();
            for(int i=0;i<size;i++) {
                Character a=arrseq[pos1].first();
                arrseq[pos1].removeFirst();
                list[i]=a;
            }
            remove(pos2);
            arrseq[pos2].setType(arrseq[pos1].stringToType(type));

            for(int i=list.length-1;i>=0;i--) {
                arrseq[pos2].addFirst(list[i]);
                arrseq[pos1].addFirst(list[i]); // add sequence back to pos1.
            }
        }
    }

    public void transcribe(int pos) {
        if(arrseq[pos].getType().equals(SinglyLinkedList.Type.RNA)) { // check the type
            System.out.println("Cannot transcribe RNA");
        }else if(arrseq[pos].getType().equals(SinglyLinkedList.Type.Null)){
            System.out.println("No sequence to transcribe at specified position");
        }else {
            arrseq[pos].setType(SinglyLinkedList.Type.RNA); //set type to RNA
            char[] list = new char[arrseq[pos].size()];  // create a char array to store data
            int size = arrseq[pos].size();
            for(int i=0;i<size;i++) {
                Character a=arrseq[pos].first();
                arrseq[pos].removeFirst();
                if(a=='T') {  // if the character is "T", convert it to "U"
                    list[i]='U';
                }else {
                    list[i]=a;
                }
            }

            for(int j =0; j<size; j++) { // change "A", "U", "C", and "G"
                if(list[j] == 'A') {
                    list[j] = 'U';
                }else if(list[j] == 'U') {
                    list[j] = 'A';
                }else if(list[j] =='G') {
                    list[j] = 'C';
                }else if(list[j] == 'C') {
                    list[j] = 'G';
                }
            }

            for(int i=list.length-1;i>=0;i--) {
                arrseq[pos].addFirst(list[i]); // add sequence back to pos1.
            }

            arrseq[pos].reverse(); // reverse all the elements
        }
    }

}
