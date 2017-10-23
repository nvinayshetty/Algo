package com.company.ds.trie;

public class TrieDriver {

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("a");
        trie.insert("an");
        trie.insert("ana");
        trie.insert("anna");
        trie.insert("aaane");
        trie.insert("aano");
        trie.insert("awesome");
        trie.insert("alll");
        trie.insert("als");
        trie.insert("also");
        trie.insert("alike");

        System.out.println("ana "+trie.search("ana"));
        System.out.println("amazing "+trie.search("amazing"));
        System.out.println("aano "+trie.search("aano"));
        System.out.println("app "+trie.search("app"));
        System.out.println("and "+trie.search("and"));
        System.out.println("---------------------------------------");



        System.out.println("ana "+trie.startsWith("ana"));
        System.out.println("amazing "+trie.startsWith("amazing"));
        System.out.println("aano "+trie.startsWith("aano"));
        System.out.println("app "+trie.startsWith("app"));
        System.out.println("and "+trie.startsWith("and"));


        System.out.println("---------------------------------------");
        System.out.println("a "+trie.countNode("aaa"));
    }
}
