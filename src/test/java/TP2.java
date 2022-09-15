import myapp.Stockable.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TP2 {
    public static class StringData implements Stockable
    {
        final String message;
        StringData(String message)
        {
            this.message = message;
        }
        @Override
        public boolean equals(Object obj)
        {
            if (message == null) return false;
            return message.equals(((StringData)obj).message);
        }
    }
    @Test
    public void addFirst()
    {
        ListOfStockable list = new ListOfStockable();
        Assertions.assertArrayEquals(new StringData[] { },
                list.toArray());
        list.addFirst(new StringData("Hello"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("Hello")},
                list.toArray());
        list.addFirst(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("World"),
                        new StringData("Hello")},
                list.toArray());
        list.addFirst(new StringData("!"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("!"),
                        new StringData("World"),
                        new StringData("Hello")},
                list.toArray());
    }

    @Test
    public void add()
    {
        ListOfStockable list = new ListOfStockable();
        Assertions.assertArrayEquals(new StringData[] { },
                list.toArray());
        list.add(new StringData("Hello"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("Hello")},
                list.toArray());
        list.add(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("Hello"),
                        new StringData("World")},
                list.toArray());
        list.add(new StringData("!"));
        Assertions.assertArrayEquals(new StringData[] {
                        new StringData("Hello"),
                        new StringData("World"),
                        new StringData("!")},
                list.toArray());
    }
    @Test
    public void delete()
    {
        ListOfStockable list = new ListOfStockable();
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("Hello"));
        list.add(new StringData("!"));
        Assertions.assertEquals(true,list.contains(new StringData("!")));
        list.delete(new StringData("!"));
        Assertions.assertEquals(false,list.contains(new StringData("!")));
        list.delete(new StringData("Hello"));
        Assertions.assertEquals(true,list.contains(new StringData("Hello")));
        list.delete(new StringData("Hello"));
        Assertions.assertEquals(false,list.contains(new StringData("Hello")));
        list.delete(new StringData("World"));
        Assertions.assertEquals(false,list.contains(new StringData("World")));
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("!"));
        list.delete(new StringData("World"));
        Assertions.assertArrayEquals(new StringData[]
        {
                new StringData("Hello"),
                new StringData("!")
        },
        list.toArray());
    }

    @Test
    public void findFirst() {
        ListOfStockable list = new ListOfStockable();
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("Hello"));
        list.add(new StringData("!"));
        list.add(new StringData(" "));
        Assertions.assertEquals(new StringData("Hello"), list.findFirst(new StringData("Hello")));
        Assertions.assertEquals(new StringData("!"), list.findFirst(new StringData("!")));
        Assertions.assertEquals(new StringData(" "), list.findFirst(new StringData(" ")));
        Assertions.assertEquals(null, list.findFirst(new StringData("HELLO")));
        Assertions.assertEquals(null, list.findFirst(new StringData("helLO")));
    }

    @Test
    public void contains() {
        ListOfStockable list = new ListOfStockable();
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("!"));
        list.add(new StringData(" "));
        Assertions.assertEquals(true,list.contains(new StringData("Hello")));
        Assertions.assertEquals(false,list.contains(new StringData("Test")));
        Assertions.assertEquals(true,list.contains(new StringData("!")));
        Assertions.assertEquals(true,list.contains(new StringData(" ")));
        Assertions.assertEquals(false,list.contains(new StringData("HELLO")));
        Assertions.assertEquals(false,list.contains(new StringData("heLLO")));
        Assertions.assertEquals(false,list.contains(new StringData("")));
    }

    @Test
    public void exo1Part4() throws EndOfListException {
        ListOfStockable listOfStockable = new ListOfStockable();
        IteratorOfStockable iteratorOfStockable = new IteratorOfStockable(listOfStockable);

        listOfStockable.add(new StringData("Hello"));
        listOfStockable.add(new StringData("World"));
        listOfStockable.add(new StringData("!"));

        iteratorOfStockable.restart();
        Assertions.assertEquals(true, iteratorOfStockable.hasNext());
        Assertions.assertEquals(new StringData("Hello"), iteratorOfStockable.next());
        Assertions.assertEquals(true,iteratorOfStockable.hasNext());
        Assertions.assertEquals(new StringData("World"), iteratorOfStockable.next());
        Assertions.assertEquals(true,iteratorOfStockable.hasNext());
        Assertions.assertEquals(new StringData("!"), iteratorOfStockable.next());
        Assertions.assertEquals(false, iteratorOfStockable.hasNext());
        iteratorOfStockable.restart();
        Assertions.assertEquals(true, iteratorOfStockable.hasNext());
        Assertions.assertEquals(new StringData("Hello"), iteratorOfStockable.next());
    }

    @Test
    public void exo2() throws EndOfListException {
        List<String> list = new List<String>();
        Iterator<String> it = new Iterator<String>(list);
        Assertions.assertEquals(false, it.hasNext());
        it.restart();
        Assertions.assertEquals(false, it.hasNext());
        list.add("Hello");
        it.restart();
        Assertions.assertEquals(true, it.hasNext());
        String data = it.next();
        Assertions.assertEquals(false, it.hasNext());
        Assertions.assertEquals("Hello", data);
        list.add("World");
        list.add("!");
        it.restart();
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("Hello", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("World", it.next());
        Assertions.assertEquals(true, it.hasNext());
        Assertions.assertEquals("!", it.next());
        Assertions.assertEquals(false, it.hasNext());
    }
}