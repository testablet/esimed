package myapp.Stockable;

public class IteratorOfStockable {
    ListElementOfStockable listElementOfStockable;
    ListOfStockable listOfStockable;


    public IteratorOfStockable(ListOfStockable listOfStockable) {
        this.listOfStockable = listOfStockable;
        restart();
    }

    public void restart()
    {
        listElementOfStockable = new ListElementOfStockable(null);
        listElementOfStockable.setNextElement(listOfStockable.getHead());
    }

    public Stockable next() throws EndOfListException
    {
        if (listElementOfStockable.getNextElement() == null) {
            throw new EndOfListException();

        }
        listElementOfStockable = listElementOfStockable.getNextElement();
        return listElementOfStockable.getData();
    }

    public boolean hasNext()
    {
        return (listElementOfStockable.getNextElement() != null && listElementOfStockable != null);
    }
}
