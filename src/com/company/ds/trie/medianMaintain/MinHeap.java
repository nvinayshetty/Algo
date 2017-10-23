package com.company.ds.trie.medianMaintain;

import java.util.Arrays;

public class MinHeap {
    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];


    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return (2 * index + 1) < size;
    }

    public boolean hasRightChild(int index) {
        return (2 * index + 2) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int leftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return items[getParentIndex(index)];
    }


    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;

    }

    public void ensureCapcity() {
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
        size--;
        heapifyDown();
        return data;
    }

    public void add(int element) {
        ensureCapcity();
        items[size] = element;
        size++;
        heapifyUp();

    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index,smallerChildIndex);
            }
            index=smallerChildIndex;
        }

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
