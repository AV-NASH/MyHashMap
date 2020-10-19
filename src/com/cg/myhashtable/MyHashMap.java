package com.cg.myhashtable;
public class MyHashMap<K,V> {
    MapNode head=null;

    public void add(K key, V value){
        MapNode node=new MapNode(key,value);

        if(head==null)
            head=node;
        else{
            if(getMapNode(key)==null) append(node);
            else getMapNode(key).value=value;
        }
    }

    public void append(MapNode node){
        MapNode tempNode=head;
        while(tempNode.next!=null)
            tempNode=tempNode.next;
        tempNode.next=node;
    }
    public MapNode getMapNode(K searchKey){
        MapNode searchNode=head;
        while(searchNode!=null){
            if(searchNode.key.equals(searchKey)){
                break;
            }
            searchNode=searchNode.next;
        }
        return (searchNode==null)?null:searchNode;
    }

    public void pop(){
        head=head.next;
    }
    public void popLast(){
        MapNode lastNode=head;
        while(lastNode.next.next!=null){
            lastNode=lastNode.next;
        }
        lastNode.next=null;

    }
    public MapNode getTail(){
        MapNode tailNode=head;
        while(tailNode.next!=null){
            tailNode=tailNode.next;
        }
        return  tailNode;
    }
    public void remove(K key){
        MapNode removedNode=getMapNode(key);
       MapNode beforeRemovedNode = head;
        if(key==head){pop();}
        else{
            if(removedNode==getTail()){popLast();}
            else {

                while (beforeRemovedNode != null) {
                    if (beforeRemovedNode.next.key.equals(key)) {

                        break;
                    }
                    beforeRemovedNode = beforeRemovedNode.next;
                }
            }
        }
        beforeRemovedNode.next=removedNode.next;
    }

    public V get(K searchKey){
        return getMapNode(searchKey)==null?null: (V) getMapNode(searchKey).value;
    }




    public void printMap(){
        if(head==null) System.out.println("HashMap empty");
        else{
            MapNode node=head;
            while(node!=null){
                System.out.println(node.key+"--"+node.value);
                node=node.next;
            }

        }
    }
}
