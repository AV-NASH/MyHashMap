package com.cg.myhashtable;

import java.util.ArrayList;

public class MyLinkedHashMap<K,V>  {
private final int numBucket;
ArrayList<MyHashMap<K,V>> bucketArray;

    public MyLinkedHashMap() {
        this.numBucket = 10;
        bucketArray=new ArrayList<MyHashMap<K,V>>(numBucket);
        for(int index=0;index<numBucket;index++){
            bucketArray.add(null);
        }
    }
    public int getIndex(K key){
        int hashCode=Math.abs(key.hashCode());
        return (int)hashCode%numBucket;
    }

    public void add(K key,V value){
        int index=getIndex(key);
        MyHashMap<K,V> myHashMap=new MyHashMap<K,V>();
        if(bucketArray.get(index)==null){
            myHashMap.add(key,value);
            bucketArray.set(index,myHashMap);
        }
        else{
            bucketArray.get(index).add(key,value);
        }

    }

    public V get(K key){
        int index=getIndex(key);
        if(bucketArray.get(index)==null) return null;
        else {
            if(bucketArray.get(index).get(key)==null) return  null;
            else return bucketArray.get(index).get(key);
        }

    }
    public void remove(K key){
        int index=getIndex(key);
        if(bucketArray.get(index)==null) System.out.println("key does not exist");
        else {
            if(bucketArray.get(index).get(key)==null) System.out.println("key does not exist");
            else  bucketArray.get(index).remove(key);
        }
    }


    public void printMap(){
        for(int index=0;index<numBucket;index++){
           if(bucketArray.get(index)!=null) bucketArray.get(index).printMap();
        }
    }

}
