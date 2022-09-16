package myapp.Stockable;

import java.util.Comparator;

public class List<T>{
    ListElement<T> head = null;

    public void addFirst(T stock)
    {
        ListElement<T> newElement = new ListElement<T>(stock);
        if (head == null) { // empty list
            head = newElement;
        } else {
            // add new elemement at the start of the list (replace 'head')
            ListElement<T> nextElement = head;
            head = newElement;
            newElement.setNextElement(nextElement);
            nextElement.setPreviousElement(newElement);
        }
    }

    public void add(T stock)
    {
        ListElement<T> newElement = new ListElement<T>(stock);
        if (head == null) { // empty list
            head = newElement;
        } else {
            // search for the end of the list
            ListElement<T> loopElement = head;
            while (loopElement.getNextElement() != null) {
                loopElement = loopElement.getNextElement();
            }
            // add new element at the end of the list
            loopElement.setNextElement(newElement);
            newElement.setPreviousElement(loopElement);
        }
    }

    public boolean contains(T stock)
    {
        ListElement<T> listElement = head;
        while((listElement!=null))
        {
            if(listElement.getData().equals(stock))
            {
                return true;
            }
            listElement = listElement.getNextElement();
        }
        return false;
    }

    public T findFirst(T data) {

        ListElement<T> listElement = head;
        while (listElement != null) {
            if (listElement.getData().equals(data)) {
                return data;
            }
            listElement = listElement.getNextElement();

        }

        return null;
    }

    public void delete(T stock)
    {
        //cas où l'élement à supprimer est la tête de la liste.
        ListElement<T> loopElement = head;
        ListElement<T> previousElement = null;
        while (loopElement != null) {
            if (loopElement.getData().equals(stock)) {
                if (previousElement == null) { // element to delete is the first element (head)
                    head = head.getNextElement();
                    head.setPreviousElement(null);
                } else { // remove element by dropping it from the chain
                    previousElement.setNextElement(loopElement.getNextElement());
                    loopElement.getNextElement().setPreviousElement(previousElement);
                }
                return;
            }
            previousElement = loopElement;
            loopElement = loopElement.getNextElement();
        }
        }
    public ListElement<T> getHead() {
        return head;
    }

    public void setHead(ListElement<T> head) {
        this.head = head;
    }

    public void sort(Comparator<? super T> comparator) {
        ListElement<T> loopElement = head;
        while (loopElement.getNextElement() != null) {
            ListElement<T> min = loopElement;
            ListElement<T> innerLoopElement = loopElement.getNextElement();
            while (innerLoopElement != null) {
                if (comparator.compare(innerLoopElement.getData(), min.getData()) < 0) {
                    min = innerLoopElement;
                }
                innerLoopElement = innerLoopElement.getNextElement();
            }
            if (min != loopElement) {
                ListElement<T> prevCurrent = loopElement.getPreviousElement();
                ListElement<T> nextMin = min.getNextElement();
                ListElement<T> prevMin = min.getPreviousElement();
                min.setNextElement(loopElement);
                min.setPreviousElement(prevCurrent);
                loopElement.setPreviousElement(min);
                prevMin.setNextElement(nextMin);
                if (nextMin != null) nextMin.setPreviousElement(prevMin);
                if (prevCurrent == null) {
                    head = min;
                } else {
                    prevCurrent.setNextElement(min);
                    loopElement.setPreviousElement(min);
                }

            } else {
                loopElement = loopElement.getNextElement();
            }
        }
    }
}
