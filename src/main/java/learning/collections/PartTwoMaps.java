package learning.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartTwoMaps {
    public static void main(String[] args) {
//        Map<Integer,Integer> map=new HashMap<>();
//        map.put(1,100);
//        map.put(2,200);
//        map.put(3,300);
//        map.put(4,400);
//        map.put(5,200);
//        Map.Entry<Integer,Integer> eentry=Map.entry(2,200);
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//            //System.out.println(entry.getKey()+" - "+entry.getValue());
//        }
//        Map<Integer,Integer> copyMap=Map.copyOf(map);
////        copyMap.put(4,500);
//        System.out.println("*******Views**********");
//        Set<Integer> keys=map.keySet();
//        keys.remove(1);
//        System.out.println(keys);
//        System.out.println(map);
//        Collection<Integer> mapVals=map.values();
//        mapVals.remove(200);
//        System.out.println(mapVals);
//        System.out.println(map);
//        Set<Map.Entry<Integer,Integer>> entries=map.entrySet();
//        for(Map.Entry<Integer,Integer> entry: entries) {
//            entry.setValue(entry.getValue()+100);
//        }
//        map.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });
        mapStuff();
    }
    public static void mapStuff(){
        Map<String,Integer> originalMap=new HashMap<>();
        originalMap.put("BLR", 562125);
        originalMap.put("RTK", 124001);
        // Two maps
        Map<String,Integer> unmodifiable=Collections.unmodifiableMap(originalMap);
        Map<String,Integer> copied=Map.copyOf(originalMap);

        originalMap.put("MDN", 124111);
        System.out.println("originalMap = " + originalMap);
        System.out.println("unmodifiable = " + unmodifiable);
        System.out.println("copied = " + copied);
    }
    public static void primitiveStream(){
        List<String> strings=List.of("Ashish","Swati","Harshi","Laavya");
        int x=strings.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(x);
    }
    public static void basic(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        int[] keys={0,2,4,8};
        for(int i=0;i<keys.length;i++){
            if(map.containsKey(keys[i])){
                int freq=map.get(keys[i]);
                freq++;
                map.put(keys[i],freq);
            }
            else {
                map.put(keys[i],1);
            }
        }
        for(int i=0;i<keys.length;i++){
            map.put(keys[i], map.getOrDefault(keys[i],0)+1);
        }
        System.out.println(map);
    }
    public static void mapVFlatMap(){
        List<String> names=new ArrayList<>();
        names.add("Ashish");
        names.add("Harshi");
        List<String> upper=names.stream()
                .map(a->a.toUpperCase())
                .toList();
        System.out.println(upper);

    }
    public static void streamBasic(){
        List<Integer> nums=new ArrayList<>();
        for(int i=0; i<20;i++){
            int random=(int)(Math.random()*10)+1;
            nums.add(random);
        }
        System.out.println(nums);
        List<Integer> result=nums.stream()
                .filter((num)->num%2==0)
                .sorted(Integer::compare)
                .distinct()
                .map(Integer -> Integer)
                .toList();
        System.out.println(result);
    }
    public static void flatMapExample(){
        Book chemistry=new Book("chemistry");
        Book physics=new Book("physics");
        Book mathematics=new Book("mathematics");
        List<Book> bookSetOne=new ArrayList<>();
        bookSetOne.add(chemistry);
        bookSetOne.add(physics);
        bookSetOne.add(mathematics);

        Book english=new Book("english");
        Book hindi=new Book("physics");
        Book science=new Book("science");
        List<Book> bookSetTwo=new ArrayList<>();
        bookSetTwo.add(english);
        bookSetTwo.add(hindi);
        bookSetTwo.add(science);
        List<Box> boxes=new ArrayList<>();
        Box boxOne=new Box(10,bookSetOne);
        Box boxTwo=new Box(20,bookSetTwo);
        boxes.add(boxOne);
        boxes.add(boxTwo);
        List<Box> boxWithMap=boxes.stream()
                .map(box -> box)
                .toList();
//        System.out.println(boxWithMap);
//        List<Book> allBooks=boxes.stream()
//                .flatMap(box -> box.books.stream())
//                .toList();
//        Object[] arr=boxes.stream()
//                .flatMap(box -> box.books.stream())
//                .toArray();
//        System.out.println(arr);
//        System.out.println("s");
        Stream.of(english,hindi).map(book -> book.author).reduce("",(acc, book)->acc+book);
        var result=boxes.stream()
                .flatMap(box -> box.books.stream())
                .collect(Collectors.groupingBy(book -> book.author));
        System.out.println(result);
    }
}
class Book{
    String author;
    Book(String author){
        this.author=author;
    }
    String getAuthor(){
        return this.author;
    }
    @Override
    public String toString(){
        return "Book has author: "+this.author;
    }
}
class Box{
    int height;
    List<Book> books;
    Box(int height, List<Book> books){
        this.books=books;
        this.height=height;
    }
    @Override
    public String toString(){
        return "Box has height: "+this.height+" Box has books: "+this.books;
    }
}
