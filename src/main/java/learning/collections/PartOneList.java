package learning.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PartOneList {
    public static void main(String[] args) {
        Integer[] array={1,2,3,4,5};
        List<Integer> list=new ArrayList<>(List.of(array));
        list.replaceAll(value -> value%2==0?-value:value);
        System.out.println(list);
        list.sort(BY_ASHISH);
        System.out.println(list);
        Iterator<Integer> iterator= list.iterator();
        while(iterator.hasNext()){
            Integer x=iterator.next();
            System.out.println(x);
        }
    }
    public static final Comparator<Integer> BY_ASHISH=Comparator.comparingInt(Integer::intValue);
}
