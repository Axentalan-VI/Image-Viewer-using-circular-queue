package com.example.imageview;

public class CQueue {



    // Structure of a Node

    // Function to create Circular queue
    static void enQueue(Queue q, String value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.next = temp;
        temp.back=q.rear;


        q.rear = temp;
        q.rear.next = q.front;
        q.front.back=q.rear;
    }

    // Function to delete element from Circular Queue
    static String deQueue(Queue q) {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return String.valueOf(Integer.MIN_VALUE);
        }

        // If this is the last node to be deleted
        String value; // Value to be dequeued
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else // There are more than one nodes
        {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.next;
            q.front.back=q.rear;
            q.rear.next = q.front;
        }

        return value;
    }

    // Function displaying the elements of Circular Queue
    static int size(Queue q) {
        if(q==null){
            return -1;
        }
        Node temp=q.front;
        int x=0;
        while(temp!=q.rear){
            temp=temp.next;
            x++;
        }
        return x;


    }

    /* Driver of the program */
    public static void main(String args[]) {
        // Create a queue and initialize front and rear
        Queue q = new Queue();
        q.front = q.rear = null;

        // Inserting elements in Circular Queue
        enQueue(q, "14");
        enQueue(q, "22");
        enQueue(q, "6");




    }
}

// This code is contributed
// by Arnab Kundu
