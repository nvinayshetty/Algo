package com.company.ds.trie.medianMaintain;

import java.util.Scanner;

public class RunningMedian {
    MinHeap minHeap=new MinHeap();
    MaxHeap maxHeap=new MaxHeap();

    public  double getRunningMedian(int element){
        if(minHeap.isEmpty()&&maxHeap.isEmpty()) {
            maxHeap.add(element);
            return element;
        }
        if(element>maxHeap.peek())
            minHeap.add(element);
        else
            maxHeap.add(element);

        if(Math.abs(minHeap.size-maxHeap.size)>1){
            if(minHeap.size>maxHeap.size) {
                int minInMaxHeap = minHeap.poll();
                maxHeap.add(minInMaxHeap);
            }else{
                int maxInMinHeap = maxHeap.poll();
                minHeap.add(maxInMinHeap);
            }
        }



        if(minHeap.size==maxHeap.size){
            return ((double) minHeap.peek()+maxHeap.peek())/2;
        }
        if(minHeap.size>maxHeap.size)
            return minHeap.peek();
        else
          return   maxHeap.peek();
    }

    public static void main(String[] args) {
        RunningMedian runningMedian=new RunningMedian();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            double runningMedian1 = runningMedian.getRunningMedian(in.nextInt());
            System.out.println(runningMedian1);

        }
    }
}
