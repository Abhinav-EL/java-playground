import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
   
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(7);
        list.add(3);
        list.add(6);
        list.add(3);
        list.add(4);

        Set<Integer> set = new HashSet<>();
        for(Integer val : list){
            set.add(val);
        }

        for(Integer val : set){
            System.out.println(val);
        }
    }
}
