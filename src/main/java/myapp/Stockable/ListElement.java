package myapp.Stockable;

public class ListElement<T>{
    T data;
    ListElement<T> NextElement = null;

    public ListElement(T data) {
        this.data = data;
    }

    public ListElement<T> getNextElement() {
        return NextElement;
    }

    public void setNextElement(ListElement<T> NextElement) {
        this.NextElement = NextElement;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
