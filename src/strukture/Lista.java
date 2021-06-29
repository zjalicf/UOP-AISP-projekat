// remove po indexu, remove last, remove object
package strukture;

import java.util.Iterator;

public class Lista<T> implements Iterable<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int velicina;

    public Lista(int i) {}

    public Lista() {}

//    public void addFirst(T element) {
//        ListNode<T> node = new ListNode<T>(element);
//        if (head == null) {
//            head = node;
//        } else {
//            head.setPrethodni(node);
//            node.setSledeci(head);
//            head = node;
//        }
//        velicina++;
//    }
    public void add(T element) {
        ListNode<T> node = new ListNode<T>(element);
        if(head == null) {
            head = node;
        } else {
            ListNode<T> current = head;
            while (current.getSledeci() != null) {
                current = current.getSledeci();
            }
            current.setSledeci(node);
            node.setPrethodni(current);
        }
        velicina++;
    }

    public int indexOf(T element){
        int index = 0;
        ListNode<T> current = head;
        while(current != null){
            if (current.getElement().equals(element)){
                return index;
            }
            current = current.getSledeci();
            index ++;
        }
        return -1;
    }

    /**
     * Proverava da li element tipa T postoji u listi.
     *
     * @param element Element koji se proverava da li postoji.
     * @return Vraca true ako ima, false ako nema.
     */
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public T getElement(int index) {
        if(index < 0 || index >= velicina) {
            throw new IndexOutOfBoundsException("Indeks prevazilazi velicinu liste");
        }
        ListNode<T> currentNode = head;
        int i = 0;
        while (currentNode != null) {
            if(index == i) {
                return currentNode.getElement();
            }
            currentNode = currentNode.getSledeci();
            i++;
        }
        return null;
    }

    public int getSize() { return velicina;}
    
    public ListNode<T> getHead(){
        return head;
    }

    public ListNode<T> getTail(){
        return tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterator<T>(this);
    }

    public Object[] toArray () {
        Object[] retArray = new Object[velicina];
        for (int i = 0; i < velicina; i++) {
            retArray[i] = getElement(i);
        }
        return retArray;
    }
}

// Sta ako je index out of range
    // Sta ako je poslednji

