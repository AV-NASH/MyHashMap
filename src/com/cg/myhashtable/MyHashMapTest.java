package com.cg.myhashtable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void whenGivenSentence_storeFrequencyofWords_inKeyValuePair(){
        MyHashMap<String,Integer> myHashMap=new MyHashMap<String, Integer>();
        String sampleString="To be or not to be";
        String[] wordArray=sampleString.toLowerCase().split(" ");
        for(String word:wordArray){
            Integer frequency=1;
            if(myHashMap.get(word)==null){
                myHashMap.add(word,frequency);
            }
            else{
                frequency= myHashMap.get(word)+frequency;
                myHashMap.add(word,frequency);
            }
        }
        Integer expected=2;
        Assert.assertEquals(expected,myHashMap.get("to"));

    }
}