package com.github.lihongjie.util.collection;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This class come from org.glassfish.hk2.classmodel.reflect.util.LinkedQueue
 *
 * Non locked based linked queue.
 *
 */
public class LinkedQueue<E> {

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(new Node<E>(null, null));

    private AtomicReference<Node<E>> tail = head;

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> residue = curTail.next.get();
            if (curTail == tail.get()) {
                if (residue == null) /* A */ {
                    if (curTail.next.compareAndSet(null, newNode)) /* C */ {
                        tail.compareAndSet(curTail, newNode) /* D */ ;
                        return true;
                    }
                } else {
                    tail.compareAndSet(curTail, residue) /* B */;
                }
            }
        }
    }

    public Iterator<E> elements() {

        return new Iterator<E>() {

            AtomicReference<Node<E>> current = head;

            @Override
            public boolean hasNext() {
                return current.get().next!=null;
            }

            @Override
            public E next() {
                E element = current.get().item;
                current = current.get().next;
                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("elements cannot be removed from list");
            }
        };
    }
}
