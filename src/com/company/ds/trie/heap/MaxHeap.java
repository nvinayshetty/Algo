package com.company.ds.trie.heap;

import java.util.Arrays;

public class MaxHeap {
    int size = 0;
    int capacity = 10;
    int[] items = new int[capacity];

    public int getleftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getrightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return getleftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getrightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int getParent(int index) {
        return items[getParentIndex(index)];
    }

    public int getLeftChild(int index) {
        return items[getleftChildIndex(index)];
    }

    public int getRightChild(int index) {
        return items[getrightChildIndex(index)];
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int data = items[0];
        items[0] = items[size - 1];
        heapifyDown();
        size--;
        return data;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int highestChildIndex = getleftChildIndex(index);
            if(hasRightChild(index)&&getRightChild(index)>items[highestChildIndex])
                highestChildIndex=getrightChildIndex(index);
            if(items[index]>items[highestChildIndex]){
                break;
            }else {
                swap(index,highestChildIndex);

            }
            index=highestChildIndex;
        }

    }

    public void add(int element) {
        ensureCapacity();
        items[size] = element;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap=new MaxHeap();
        maxHeap.add(50);
        maxHeap.add(150);
        maxHeap.add(250);
        maxHeap.add(-50);
        maxHeap.add(-100);
        maxHeap.add(123);
        System.out.println("output"+maxHeap.peek());
        maxHeap.poll();
        System.out.println("output"+maxHeap.peek());
        maxHeap.poll();
        System.out.println("output"+maxHeap.peek());
    }

}
