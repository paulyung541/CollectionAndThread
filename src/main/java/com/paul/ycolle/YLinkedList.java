package com.paul.ycolle;

import java.io.Serializable;
import java.util.*;

public class YLinkedList<E> implements List<E>, Deque<E>, Serializable {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> pre;

        Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next, Node<E> pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (firstNode == null) {
            firstNode = lastNode = newNode;
        } else {
            Node<E> tmpNode = new Node<>(e);
            firstNode.pre = tmpNode;
            tmpNode.next = firstNode;
            firstNode = tmpNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> last = lastNode;
        Node<E> newNode = new Node<>(e);
        if (last == null)
            firstNode = lastNode = newNode;
        else {
            last.next = newNode;
            last.pre = lastNode;
            lastNode = newNode;
        }
    }

    public boolean offerFirst(E e) {
        return false;
    }

    public boolean offerLast(E e) {
        return false;
    }

    public E removeFirst() {
        if (isEmpty())
            throw new RuntimeException("the size is 0");
        Node<E> currentFirst = firstNode;
        if (currentFirst == lastNode) {
            firstNode = lastNode = null;
            return currentFirst.value;
        }

        firstNode = currentFirst.next;
        firstNode.pre = null;
        size--;
        return currentFirst.value;
    }

    public E removeLast() {
        if (isEmpty())
            throw new RuntimeException("the size is 0");
        Node<E> currentLast = lastNode;
        if (currentLast == firstNode) {//only one
            firstNode = lastNode = null;
            return currentLast.value;
        }

        lastNode = currentLast.pre;
        lastNode.next = null;
        size--;

        return currentLast.value;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public E getFirst() {
        return firstNode.value;
    }

    public E getLast() {
        return lastNode.value;
    }

    private Node<E> lastNode() {
        if (isEmpty())
            return null;
        Node<E> last = firstNode;
        while (last.next != null)
            last = last.next;
        return last;
    }

    public E peekFirst() {
        return null;
    }

    public E peekLast() {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public boolean offer(E e) {
        return false;
    }

    public E remove() {
        return removeLast();
    }

    public E poll() {
        return null;
    }

    public E element() {
        return null;
    }

    public E peek() {
        return null;
    }

    public void push(E e) {

    }

    public E pop() {
        return null;
    }

    public Iterator<E> descendingIterator() {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public boolean contains(Object o) {
        if (isEmpty())
            return false;
        boolean result = false;
        Node<E> last = firstNode;
        while (last.next != null) {
            if (last.value == o) {
                result = true;
                break;
            }
            last = last.next;
        }
        return result;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        addLast(e);
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        if (isEmpty())
            throw new RuntimeException("the size is 0");
        Node<E> last = firstNode;
        Node<E> tmp = last;

        while (last.next != null) {
            last = last.next;
            tmp.value = null;
            tmp.next = null;
            tmp.pre = null;
            tmp = last;
        }
        last.value = null;
        last.pre = null;
        firstNode = lastNode = null;
    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> last = firstNode;
        while (last.next != null) {
            builder.append(last.value).append(",");
            last = last.next;
        }
        builder.append(last.value).append("]");
        return builder.toString();
    }
}
