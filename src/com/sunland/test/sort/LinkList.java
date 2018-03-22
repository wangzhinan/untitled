package sort;

public class LinkList {
    private Link first;
    public boolean isEmity(){
        return first == null;
    }

    public void insertFirst(int id,double d){
        Link link = new Link(id,d);
        link.next = first;
        first = link;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = temp.next;
        return temp;
    }

    public Link find(int key){
        Link current = first;
        while (current.iData != key){
            if (current.next == null){
                return null;
            }else {
                current = current.next;
            }
        }
        return current;
    }

    public void insertAfter(int key ,Link link){
        Link current = first;
        while (current.iData != key){
            if (current.next == null){
                current.next = link;
                return;
            }else {
                current = current.next;
            }
        }
        Link next = current.next;
        current.next = link;
        link.next = next;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.iData != key){
            if (current.next == null){
                return null;
            }else {
                previous = current;
                current = current.next;
            }

        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }

    public void displayList(){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }
}
