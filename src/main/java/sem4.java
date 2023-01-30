import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class sem4 {
    public static void main(String[] args) {
        String str= "";
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        try {
//            FileWriter writer = new FileWriter("newfile.txt");
//            writer.append("привет дорогой друг ");
//            writer.flush();
            FileReader reader = new FileReader("newfile.txt");
            while(reader.ready()){
                str += (char)reader.read();
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        System.out.println(str);
        String[] text= str.split("\r\n");
        for (int i = 0; i < text.length ; i++) {
            String[] sb= text[i].split(" ");
            family.add(sb[0]);
            name.add(sb[1].charAt(0)+" . ");
            soname.add(sb[2].charAt(0)+" . ");
            age.add(Integer.valueOf(sb[3]));
            gender.add(" "+ sb[4]);
            index.add(i);
        }
        index.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < index.size() ; i++) {
            System.out.printf(family.get(index.get(i)));
            System.out.printf(name.get(index.get(i)));
            System.out.printf(soname.get(index.get(i)));
            System.out.printf(String.valueOf(age.get(index.get(i))));
            System.out.printf(String.valueOf(gender.get(index.get(i))));
            System.out.println();

        }
//        System.out.println(age);
        ArrayList <Integer> tmp = new ArrayList<>(age);
        Collections.sort(tmp);

        for (int i = 0; i <tmp.size(); i++) {
            int j= age.indexOf(tmp.get(i));
            index.set(i,j);
        }
        System.out.println("сортировка по возрасту от младшего к старшему ");
        for (int i = 0; i <index.size() ; i++) {
            System.out.println((family.get(index.get(i)))+" "+name.get((index.get(i)))+soname.get(index.get(i))+ gender.get((index.get(i))));
        }

    }

}
