package Seminar_Task;

import java.util.*;

/**
 * Task_01
 */
public class Task_01 {

    public static void main(String[] args) {
        newSet set = new newSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        System.out.println(set.toString());  // [1, 2, 3, 4]

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        set1.size();
        if (!set.isEmpty()) {
            Iterator<Integer> it = set.iter();
            while (it.hasNext()) {
                System.out.println(it.next());  // 1 2 3 4
            }
        }

        Iterator<Integer> it = set.iter();
        ArrayList<Integer> ar = new ArrayList();
        while (it.hasNext()) {
            ar.add(it.next());
        }
        Collections.sort(ar);
        for (int i = 0; i < ar.size(); i++) {
            set1.add(ar.get(i));
        }
        System.out.println(set1);  // [1, 2, 3, 4]

        TreeSet<String> set2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {return 0;}
                if (o1.compareTo(o2)>0) {return 1;}
                else return -1;
            }
        });

        set2.add("Один");
        set2.add("Два");
        set2.add("Два+один");
        set2.add("Два");
        set2.add("Два+один+один");
        System.out.println(set2);  // [Два, Два+один, Два+один+один, Один]
    }
}

class newSet {

    private static final Object NF = new Object();

    private HashMap<Integer, Object> map;

    public boolean add(Integer value) {
        if (map.containsKey(value)) {
            return false;
        } else {       
            map.put(value, NF);
            return true;
        }
    }

    public newSet() {
        map = new HashMap<>();
    }

    @Override
    public String toString() {
        Set<Integer> keys = map.keySet();
        String tmp = "";
        for (int i = 0; i < keys.size(); i++) {
            tmp += keys.toArray()[i] + ", " ;
        }
        tmp ="["+ tmp.substring(0, tmp.length()-2)+ "]";
        return tmp;
    }

    public void remove(Integer key) {
        map.remove(key);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        if(map.size()>0) {return false;}
        return true;
    }

    // public String[] get() {
    //     return (String[]) map.keySet().toArray();
    // }

    public Iterator iter() {
        return map.keySet().iterator();
    }
}
