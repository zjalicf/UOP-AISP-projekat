package strukture;

import java.util.Iterator;

public class ListaIterator<T> implements Iterator<T> {

    private ListNode<T> currentNode;

    public ListaIterator(Lista<T> lista){
        currentNode = lista.getHead();
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T element = currentNode.getElement();
        currentNode = currentNode.getSledeci();
        return element;
    }
}