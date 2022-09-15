package myapp.Stockable;

public class ListElementOfStockable {
    Stockable data;
    ListElementOfStockable NextElement = null;

    public ListElementOfStockable(Stockable data) {
        this.data = data;
    }

    public ListElementOfStockable getNextElement() {
        return NextElement;
    }

    public void setNextElement(ListElementOfStockable NextElement) {
        this.NextElement = NextElement;
    }

    public Stockable getData() {
        return data;
    }

    public void setData(Stockable data) {
        this.data = data;
    }
}