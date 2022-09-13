import myapp.Stockable.ListOfStockable;
import myapp.Stockable.Stockable;
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
        Assertions.assertArrayEquals(new StringData[] { },
                list.toArray());
        list.add(new StringData("Hello"));
        list.add(new StringData("World"));
        list.add(new StringData("!"));
        list.delete(new StringData("World"));
        Assertions.assertEquals(true,
                list.contains(new StringData("!")));
        Assertions.assertEquals(false,
                list.contains(new StringData("World")));
        Assertions.assertEquals(true,
                list.contains(new StringData("Hello")));
    }

    @Test
    public void contains()
    {
        ListOfStockable list = new ListOfStockable();
        
    }

}