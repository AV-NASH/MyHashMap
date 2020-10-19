package com.cg.myhashtable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void whenGivenSentence_storeFrequencyofWords_inKeyValuePair(){
        MyLinkedHashMap<String,Integer> myLinkedHashMap=new MyLinkedHashMap<String, Integer>();
        String sampleString="Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] wordArray=sampleString.toLowerCase().split(" ");
        for(String word:wordArray){
            Integer frequency=1;
            if(myLinkedHashMap.get(word)==null){
                myLinkedHashMap.add(word,frequency);
            }
            else{
                frequency= myLinkedHashMap.get(word)+frequency;
                myLinkedHashMap.add(word,frequency);
            }
        }
        Integer expected=3;
        Assert.assertEquals(expected,myLinkedHashMap.get("paranoid"));

    }
}