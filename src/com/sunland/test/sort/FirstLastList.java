package sort;

public class FirstLastList {
    private Link last;
    private Link first;

    public boolean isEmity(){
        return first == null;
    }

    public void insertFirst(int id,double d){
        Link link = new Link(id,d);
        if (isEmity())
            last = link;
        link.next = first;
        first = link;
    }

    public void insertLast(int id,double d){
        Link link = new Link(id,d);
        if (isEmity())
            first = link;
        else
            last.next = link;
        last = link;
    }
}
