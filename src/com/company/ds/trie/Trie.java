package com.company.ds.trie;

import java.util.HashMap;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.chidren;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode trieNode = children.get(c);
            if (trieNode == null) {
                trieNode = new TrieNode(c);
                children.put(c, trieNode);

            }
            trieNode.wordSize++;
            children = trieNode.chidren;
            if (i == word.length() - 1) {
                trieNode.isCompleteWord = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode trieNode = searchNode(word);
        if (trieNode != null && trieNode.isCompleteWord)
            return true;
        return false;
    }

    public boolean startsWith(String word) {
        if (searchNode(word) == null)
            return false;
        else
            return true;
    }

    public int countNode(String word) {
        TrieNode trieNode = searchNode(word);
        if (trieNode == null)
            return -1;
        else return trieNode.wordSize;
    }


    private TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> children = root.chidren;
        TrieNode trieNode = null;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (children.containsKey(c)) {
                trieNode = children.get(c);
                children = trieNode.chidren;
            } else {
                return null;
            }
        }
        return trieNode;
    }

    public class TrieNode {
        Character c;
        boolean isCompleteWord;
        HashMap<Character, TrieNode> chidren = new HashMap<>();
        int wordSize;

        public TrieNode() {
            wordSize=0;
        }

        public TrieNode(Character c) {
            this.c = c;
        }
    }
}
