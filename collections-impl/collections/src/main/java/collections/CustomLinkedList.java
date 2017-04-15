package collections;

import java.util.*;

public class CustomLinkedList<T> implements List<T> {
    private Node<T> head = new Node<>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    @Override
    public boolean contains(Object o) {
        Node<T> node = head;
        while (node.hasNext()) {
            node = node.next;
            if (node.value == null) {
                if (o == null) {
                    return true;
                }
            } else if (node.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> iterator = head;
        while (iterator.hasNext()) {
            iterator = iterator.next;
        }
        iterator.next = new Node<>(t);
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head.next;
        Node<T> prev = head;
        while (current != null) {
            if (o.equals(current.value)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNodeByIndex(index);
        current.value = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        Node<T> current = getNodeByIndex(index-1);
        Node<T> newNode = new Node<>(element);
        newNode.next = current.next;
        current.next = newNode;
    }

    @Override
    public T remove(int index) {
        Node<T> current = getNodeByIndex(index - 1);
        size--;
        T value = current.next.value;
        current.next = current.next.next;
        return value;
    }

    @Override
    public int indexOf(Object o) throws NoSuchElementException {
        Node<T> current = head.next;
        int counter = 0;
        while (current != null) {
            if (o.equals(current.value)) {
                return counter;
            }
            counter++;
            current = current.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int lastIndexOf(Object o) throws NoSuchElementException {
        Node<T> current = head.next;
        int counter = 0;
        int lastIndex = -1;
        while (current != null) {
            if (o.equals(current.value)) {
                lastIndex = counter;
            }
            counter++;
            current = current.next;
        }
        if(lastIndex >= 0){
            return lastIndex;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if(fromIndex > 0 && toIndex > 0){
            if(fromIndex <= size && toIndex <= size){
                if(fromIndex < toIndex){
                    List<T> newList = new CustomLinkedList<>();
                    for(int i = fromIndex; i <= toIndex; i++){
                        newList.add(getNodeByIndex(i).value);
                    }
                    return newList;
                }
                throw new IllegalArgumentException();
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node<T> getNodeByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class Node<T> {

        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

    }
}
