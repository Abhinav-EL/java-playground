import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Testing out Sorted implementations. 
 */
public class SortedTest {
    public static void main(String args[]){
        SortedTest test = new SortedTest();
        test.testSortedSet();
        test.testSortedMap();
        test.testSortedList();
    }
    
    /**
     * TreeMap sorts the map based on natural ordering of elements.
     * Duplicate Key has it's value replaced.
     */
    private void testSortedMap(){
        SortedMap<String, Integer> map = new TreeMap<String, Integer>();
        map.put("b", 10);
        map.put("a", 30);
        map.put("d", 40);
        map.put("d", 50); // Duplicate key updated
        map.put("z", 0);

        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println("TreeMap Value - " +e);
        }
    }

    /**
     * TreeSet sorts the map based on natural ordering of elements.
     * Duplicate key (that was used for Comparator) is ignored.
     */
    private void testSortedSet(){
        SortedSet<OrderedClass> set = new TreeSet<OrderedClass>();
        set.add(new OrderedClass("b", 10));
        set.add(new OrderedClass("a", 30));
        set.add(new OrderedClass("d", 40));
        set.add(new OrderedClass("d", 50)); // Duplicate key not picked up
        set.add(new OrderedClass("z", 0));

        for(OrderedClass e: set){
            System.out.println("TreeSet Value - " +e);
        }
    }

    /** 
     * List is not sorted and allows duplicates.
     * Collections.sort can be used to sort.
     */
    private void testSortedList(){
        List<OrderedClass> list = new ArrayList<OrderedClass>();
        list.add(new OrderedClass("b", 10));
        list.add(new OrderedClass("a", 30));
        list.add(new OrderedClass("d", 40));
        list.add(new OrderedClass("d", 50)); 
        list.add(new OrderedClass("z", 0));

        Collections.sort(list);
        for(OrderedClass e: list){
            System.out.println("List Value - " +e);
        }
    }

    private class OrderedClass implements Comparable<OrderedClass>{
        String key;
        Integer val;

        OrderedClass(String key, Integer val){
            this.key = key;
            this.val = val;
        }

        public int compareTo(OrderedClass otherObj){
            // Confirm that o is type of OrderedClas
            return this.key.compareTo(otherObj.key);
        }

        public String toString(){
            return this.key +" - " + this.val;
        }
    }
}
