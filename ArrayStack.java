/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Agu
 */
import java.util.EmptyStackException;

public class ArrayStack implements BKStack{
    
    // initalizes the pointer to the top of the stack and creates an array of size 20 that holds the stack
    private int top = 0;
    private double[] elements = new double[20];

    // checks to see if the stack is empty and returns true or false
    @Override
    public boolean isEmpty() {
        if (top == 0)
            return true;
        return false;
    }

    // pushes a given element into the top spot of the array 
    // if the array(stack) is full it creates a new array 5 times the size and copies the elements over
    @Override
    public void push(double d) {
        if (top == elements.length) {
            double[] newElements = new double[elements.length * 5];
            for (int i = 0; i < elements.length; i++) 
                newElements[i] = elements[i];
            elements = newElements;
        }
    
        elements[top] = d;
        top++;
    }

    // pops the top element from the stack and returns it if the stack is not empty 
    @Override
    public double pop() {
        if (isEmpty())
            throw new EmptyStackException();
        double poppedElement = peek();
        top--;
        return poppedElement;
    }

    // peeks to check the top element in the stack and returns it if the stack is not empty
    @Override
    public double peek() {
        if (isEmpty())
            throw new EmptyStackException();
        double topElement = elements[top - 1];
        return topElement;
    }
    
}
