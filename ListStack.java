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

public class ListStack implements BKStack{
    
    // stack node class for nodes used in the ListStack
    private class StackNode {
        double nodeValue;
        StackNode prevNode;
        
        // default constructor for a node that accepts the value and the prev node in the stack
        public StackNode(double a, StackNode k) {
            nodeValue = a;
            prevNode = k;
        }
        
        // get methods for the node
        public double getValue() {
            return nodeValue;
        }
        
        public StackNode getPrevNode() {
            return prevNode;
        }
        
        // set methods for the node
        public void setValue(double a) {
            nodeValue = a;
        }
        
        public void setPrevNode (StackNode k) {
            prevNode = k;
        }
    }
    
    // variable pointing to the top of the stack
    private StackNode top;

    // checks to see if the stack is empty and returns true or false
    @Override
    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }

    // pushes a given element into a new node which is then inserted at the top of the stack
    @Override
    public void push(double d) {
        StackNode topReplace = new StackNode(d, top);
        top = topReplace;
    }

    // pops the top node from the stack and returns it if the stack is not empty 
    @Override
    public double pop() {
        if (isEmpty())
            throw new EmptyStackException();
        double poppedElement = peek();
        top = top.getPrevNode();
        return poppedElement;
    }

    // peeks to check the top element in the stack and returns it if the stack is not empty
    @Override
    public double peek() {
        if (isEmpty())
            throw new EmptyStackException();
        double topElement = top.getValue();
        return topElement;
    }
    
}
