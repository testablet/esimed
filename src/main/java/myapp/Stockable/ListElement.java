package myapp.Stockable;

import java.util.LinkedList;

public class ListElement<T>{
    T data;
    ListElement<T> NextElement = null;
    ListElement<T> PreviousElement = null;

    public ListElement(T data) {
        this.data = data;
    }

    public ListElement<T> getNextElement()
    {
        return NextElement;
    }

    public void setNextElement(ListElement<T> NextElement)
    {
        this.NextElement = NextElement;
    }

    public ListElement<T> getPreviousElement() {
        return PreviousElement;
    }

    public void setPreviousElement(ListElement<T> previousElement) {
        PreviousElement = previousElement;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
