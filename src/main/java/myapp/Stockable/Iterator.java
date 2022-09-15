package myapp.Stockable;

public class Iterator<T>{
    ListElement<T> listElement;
    List<T> list;


    public Iterator(List<T> list) {
        this.list = list;
        restart();
    }

    public void restart()
    {
        listElement = new ListElement<T>(null);
        listElement.setNextElement(list.getHead());
    }

    public T next() throws EndOfListException
    {
        if (listElement.getNextElement() == null) {
            throw new EndOfListException();

        }
        listElement = listElement.getNextElement();
        return listElement.getData();
    }

    public boolean hasNext()
    {
        return (listElement.getNextElement() != null && listElement != null);
    }

}
