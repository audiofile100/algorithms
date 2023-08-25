package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class Node {
        public Map<Character, Node> children;
        public Node() {
            children = new HashMap<>();
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String key) {
        Node node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
    }

    public boolean search(String key) {
        Node node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    private void print() {
        Map<Integer, StringBuilder> map = new HashMap<>();
        print(root, 0, map);
        for (Map.Entry<Integer, StringBuilder> ent : map.entrySet()) {
            System.out.println(ent.getKey() + " = " + ent.getValue());
        }
    }

    private void print(Node node, int level, Map<Integer, StringBuilder> map) {
        if (node == null) return;
        for (Map.Entry<Character, Node> ent : node.children.entrySet()) {
            map.put(level, map.getOrDefault(level, new StringBuilder()).append(ent.getKey()).append(" "));
            print(ent.getValue(), level+1, map);
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("batter");
        trie.insert("apple");
        System.out.println(trie.search("bytter"));
        System.out.println(trie.search("app"));

        trie.print();
    }
}
