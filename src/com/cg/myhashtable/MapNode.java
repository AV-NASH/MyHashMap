package com.cg.myhashtable;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode next;


    public MapNode(K key, V value) {
        this.key=key;
        this.value = value;
        this.next=null;
    }
}
