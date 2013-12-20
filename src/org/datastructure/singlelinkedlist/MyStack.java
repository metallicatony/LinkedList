package org.datastructure.singlelinkedlist;

/**
 * A class that models stack data structure (LIFO)
 * @author skanniah
 *
 */

public class MyStack {
	private Element head;
	public MyStack(Element head) {
		this.head = head;
	}
	
	/**
	 * Returns true if stack is empty else returns false
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the method was able to push data to the stack. Else returns false.
	 * @param data Integer
	 * @return boolean
	 */
	public boolean push(Integer data) {
		if (data == null) {
			return false;
		}
		
		Element newElement = new Element(data);
		if (head == null) {
			head = newElement;
			return true;
		}
		
		if (head != null) {
			Element temp = head;
			head = newElement;
			head.setNext(temp);
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Pops and returns the last element that was pushed to the stack
	 * @return stackElement
	 */
	public Element pop() {
		Element element = null;
		if (head == null) {
			System.out.println("Stack is empty!! Cannot pop anything out of it!!");
			return element;
		}
		
		Element firstElement = head;
		Element secondElement = head.getNext();
		head = secondElement;
		firstElement.setNext(null);
		return firstElement;
	}
	
	
	/**
	 * Returns true if stack was cleared or if it was empty already
	 * @return boolean
	 */
	public boolean clear() {
		while (head != null) {
			Element element = head;
			head = head.getNext();
			element.setNext(null);
		}
		return true;
	}
	
	
	/**
	 * Iterates over the stack and prints all its elements
	 */
	public void printAll() {
		if (head == null) {
			System.out.println("Stack is empty currently!!");
			return;
		}
		
		Element currElement = head;
		while (currElement != null) {
			System.out.println(currElement);
			currElement = currElement.getNext(); 
		}
	}
	
	public static void main(String[] args) {
		Element element = new Element(10);
		MyStack myStack = new MyStack(element);
		
		System.out.println("## Stack created with element:" + element.toString());
		System.out.println("## Is Stack Empty? " + myStack.isEmpty());
		
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		myStack.push(22);
		System.out.println("## After pushing elements 20, 30, 40, 22:");
		myStack.printAll();
		
		Element poppedElement = myStack.pop();
		System.out.println("Popped one element: " + poppedElement);
		System.out.println("## Elements currently in stack:");
		myStack.printAll();
		
		poppedElement = myStack.pop();
		System.out.println("## Popped Element: " + poppedElement);
		System.out.println("## Elements currently in stack:");
		myStack.printAll();
		
		System.out.println("## Clearing Stack");
		myStack.clear();
		myStack.printAll();
	}
}
