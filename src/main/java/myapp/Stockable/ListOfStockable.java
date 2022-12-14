package myapp.Stockable;

public class ListOfStockable {
    ListElementOfStockable head = null;

    public void addFirst(Stockable stock)
    {
        ListElementOfStockable element = new ListElementOfStockable(stock);
        element.setNextElement(head);
        head = element;
    }

    public Stockable[] toArray()
    {
        // count number of elements
        int count = 0;
        ListElementOfStockable loopElement = head;
        while (loopElement != null)
        {
            count = count + 1;
            loopElement = loopElement.getNextElement();
        }
        // create array from list content
        Stockable[] array = new Stockable[count];
        int index = 0;
        loopElement = head;
        while (loopElement != null)
        {
            array[index] = loopElement.getData();
            index = index + 1;
            loopElement = loopElement.getNextElement();
        }
        return array;
    }

    public void add(Stockable stock)
    {
        ListElementOfStockable elementFin = new ListElementOfStockable(stock);
        if(head==null)
        {
            head = elementFin;
        }
        else
        {
            ListElementOfStockable findList = head;
            while(findList.getNextElement()!=null)
            {
                findList = findList.getNextElement();
            }
            findList.setNextElement(elementFin);
        }
    }

    public boolean contains(Stockable data)
    {
        ListElementOfStockable listElement = head;
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

    public Stockable findFirst(Stockable data) {

        ListElementOfStockable listElement = head;
        while (listElement != null) {
            if (listElement.getData().equals(data)) {
                return data;
            }
            listElement = listElement.getNextElement();

        }

        return null;
    }

    public void delete(Stockable data)
    {
        //cas o?? l'??lement ?? supprimer est la t??te de la liste.
        if (head.getData().equals(data)){
            if (head.getNextElement()!= null){
                ListElementOfStockable tmp = head.getNextElement();
                head = null;
                head = new ListElementOfStockable(tmp.getData());
                head.setNextElement(tmp.getNextElement());
            }
            else{
                head = null;
            }
        }

        //cas o?? l'??l??ment est au milieu de la liste.
        else{
            ListElementOfStockable currentElement = head;
            while(currentElement!= null){
                if((currentElement.getNextElement()!=null)&&
                        (currentElement.getNextElement().data.equals(data))){
                    if(currentElement.getNextElement().getNextElement()!=null){
                        ListElementOfStockable tmp = currentElement.getNextElement()
                                .getNextElement();
                        currentElement.getNextElement().setNextElement(null);
                        currentElement.setNextElement(tmp);
                        break;
                    }
                    //cas o?? l'??l??ment est le dernier de la liste;
                    else{
                        currentElement.setNextElement(null);
                        break;
                    }
                }
                currentElement = currentElement.getNextElement();
            }
        }
    }
    public ListElementOfStockable getHead() {
        return head;
    }

    public void setHead(ListElementOfStockable head) {
        this.head = head;
    }
}