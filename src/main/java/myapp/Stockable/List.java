package myapp.Stockable;

public class List<T>{
    ListElement<T> head = null;

    public void addFirst(T stock)
    {
        ListElement<T> element = new ListElement(stock);
        element.setNextElement(head);
        head = element;
    }

    public void add(T stock)
    {
        ListElement<T> elementFin = new ListElement<T>(stock);
        if(head==null)
        {
            head = elementFin;
        }
        else
        {
            ListElement<T> findList = head;
            while(findList.getNextElement()!=null)
            {
                findList = findList.getNextElement();
            }
            findList.setNextElement(elementFin);
        }
    }

    public boolean contains(T data)
    {
        ListElement<T> listElement = head;
        while((listElement!=null))
        {
            if(listElement.getData().equals(data))
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

    public void delete(T data)
    {
        //cas où l'élement à supprimer est la tête de la liste.
        if (head.getData().equals(data)){
            if (head.getNextElement()!= null){
                ListElement<T> tmp = head.getNextElement();
                head = null;
                head = new ListElement<T>(tmp.getData());
                head.setNextElement(tmp.getNextElement());
            }
            else{
                head = null;
            }
        }

        //cas où l'élément est au milieu de la liste.
        else{
            ListElement<T> currentElement = head;
            while(currentElement!= null){
                if((currentElement.getNextElement()!=null)&&
                        (currentElement.getNextElement().data.equals(data))){
                    if(currentElement.getNextElement().getNextElement()!=null){
                        ListElement<T> tmp = currentElement.getNextElement()
                                .getNextElement();
                        currentElement.getNextElement().setNextElement(null);
                        currentElement.setNextElement(tmp);
                        break;
                    }
                    //cas où l'élément est le dernier de la liste;
                    else{
                        currentElement.setNextElement(null);
                        break;
                    }
                }
                currentElement = currentElement.getNextElement();
            }
        }
    }
    public ListElement<T> getHead() {
        return head;
    }

    public void setHead(ListElement<T> head) {
        this.head = head;
    }
}
