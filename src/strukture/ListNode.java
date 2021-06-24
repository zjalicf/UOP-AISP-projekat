package strukture;

public class ListNode<T> {

    private ListNode<T> sledeci;
    private ListNode<T> prethodni;
    private T element;

    public ListNode(ListNode<T> sledeci, T element) {
        this.sledeci = sledeci;
        this.element = element;
    }

    public ListNode(T element) {
        this.element = element;
    }

    public ListNode() {}

    public ListNode(ListNode<T> sledeci, ListNode<T> prethodni, T element){
        this.prethodni = prethodni;
        this.element = element;
        this.sledeci = sledeci;
    }

    public ListNode<T> getSledeci() {
        return sledeci;
    }

    public void setSledeci(ListNode<T> sledeci) {
        this.sledeci = sledeci;
    }

    public T getElement() {
        return element;
    }

    public ListNode<T> getPrethodni() {
        return prethodni;
    }

    public void setPrethodni(ListNode<T> prethodni) {
        this.prethodni = prethodni;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
