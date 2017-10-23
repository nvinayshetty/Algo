package com.company.ds.trie.stack;

import java.util.Scanner;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack stack = new Stack();
        int size = expression.length();
        if (size % 2 != 0)
            return false;
        for (int i = 0; i < expression.length(); i++) {
            Character c = expression.charAt(i);
            switch (c) {
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default: {
                    if (stack.isEmpty() || !c.equals(stack.peek()))
                        return false;
                    stack.pop();
                }

            }
        }


        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

    public static class Node {
        Character data;
        Node next;

        public Node(Character data) {
            this.data = data;
        }
    }

    public static class Stack {
        Node head;

        public void push(Character data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }

        public Character pop() {
            Character node = head.data;
            head = head.next;

            return node;
        }

        public Character peek() {
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}