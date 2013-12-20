package org.datastructure.singlelinkedlist;

/**
 * A class that models single linked list data structure
 * @author skanniah
 *
 */
public class MyLinkedList {
	private Element head;
	
	public MyLinkedList(Element head) {
		this.head = head;
	}
	
	
	/**
	 * Prints all elements in the linked list to out stream
	 * @param void
	 * @return void
	 */
	public void print() {
		Element currElement = head;
		while (currElement != null) {
			System.out.println(currElement);
			currElement = currElement.getNext();
		}
	}
	
	/**
	 * Adds the provided Integer object data to the end of linked list
	 * @param data Integer
	 * @return boolean
	 */
	public boolean add(Integer data) {
		Element newElement = new Element(data);
		if (head == null) {
			head = newElement;
			return true;
		} else {
			Element prevElement = head;
			Element currElement = head.getNext();
			while (currElement != null) {
				prevElement = currElement;
				currElement = currElement.getNext();
			}
			if (prevElement != null) {
				prevElement.setNext(newElement);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Inserts the provided Integer object data at the requested position of linked list.
	 * If insert was successful it returns true else returns false
	 * 
	 * 
	 * Implementation Details:
	 * Though the iteration variable tracks the position of current Element pointer, if a position
	 * is found where the new element needs to be inserted, it is implicit that the position is going to be
	 * in between the prevElement and curreElement. Idea is to visualize the position (input) to be in between 
	 * prevElement and currElement
	 * 
	 * Say if the position is after the last element then it means you have to insert after the prevElement(pointing last element)
	 * but before the curreElement (which is pointing a virtual non-existent element - beyond last element). So its imperative that 
	 * the while loop runs until the prevElement is pointing the last element
	 * 
	 * @param data Integer
	 * @param position Long
	 * @return boolean
	 * 
	 */
	public boolean add(Integer data, Long position) {
		
		if (position == null || position.intValue() < 1) {
			return false;
		}
		
		if (head != null) {
			Element newElement = new Element(data);
			if (position.intValue() == 1) {
				newElement.setNext(head);
				head = newElement;
			} else {
				Element prevElement = head;
				Element currElement = head.getNext();
				int iteration = 2;
				while (prevElement != null) {
					if (iteration == position.intValue()) {
						newElement.setNext(currElement);
						prevElement.setNext(newElement);
						return true;
					} else {
						prevElement = currElement;
						currElement = currElement.getNext();
						iteration++;
					}
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * This method deletes all elements in the linked list that have the provided Integer data. 
	 * If one or many elements are deleted, this method returns true else it returns false
	 * @param data Integer
	 * @return boolean
	 */
	public boolean delete(Integer data) {
		Element givenElement = new Element(data);
		boolean deleted = false;
		
		// Special case if the head element needs to be deleted
		if (head.equals(givenElement)) {
			Element temp = head;
			head = head.getNext();
			temp.setNext(null);
			deleted = true; 
		}
		
		if (head != null) {
			Element prevElement = head;
			Element currElement = head.getNext();
			while (currElement != null) {
				if (currElement.equals(givenElement)) {
					prevElement.setNext(currElement.getNext());
					currElement = currElement.getNext();
					deleted = true;
				}
				prevElement = currElement;
				currElement = currElement.getNext();
			}
		}
		return deleted;
	}
	
	/**
	 * This method deletes the element at requested position of the linked list. 
	 * If deletion happens, this method returns true else it returns false
	 * @param position Long
	 * @return boolean
	 */
	public boolean delete(Long position) {
		if (position == null || position.intValue() < 1) {
			return false;
		}

		if (head != null) {
			if (position.intValue() == 1) {
				Element temp = head;
				head = head.getNext();
				temp.setNext(null);
				return true;
			} else {
				int iteration = 2;
				Element prevElement = head;
				Element currElement = head.getNext();
				while (currElement != null) {
					if (iteration == position.intValue()) {
						prevElement.setNext(currElement.getNext());
						currElement.setNext(null);
						return true;
					}
					prevElement = currElement;
					currElement = currElement.getNext();
					iteration++;
				}
			}
		}

		return false;
	}
	
	/**
	 * Deletes all elements in the linked list. 
	 * If all elements are deleted, this method returns true else it returns false
	 * @param void
	 * @return boolean
	 */
	public boolean clear() {
		if (head == null) {
			return false;
		}
		
		while (head != null) {
			Element element = head;
			head = head.getNext();
			element.setNext(null);
		}
		return true;
	}
	
	
	/**
	 * Returns the element at requested position of the linked list. 
	 * The position is counted from the head element.
	 * @param position Long
	 * @return Element
	 */
	public Element getElementAt(Long position) {
		
		if (position == null || head == null || position.intValue() < 1) {
			return null;
		}
		
		int iteration = 1;
		Element currElement = head;
		while (currElement != null) {
			if (position.intValue() == iteration) {
				return currElement;
			}
			currElement = currElement.getNext();
			iteration++;
		}

		return null;
	}
	
	
	/**
	 * Returns the element at requested position of the linked list. 
	 * The position is counted from the tail or last element of the linked list.
	 * @param position Long
	 * @return Element
	 */
	public Element getNthFromLastElement(Long position) {
		
		if (position == null || head == null || position.intValue() < 1) {
			return null;
		}
		
		Element currElement = head;
		Element nthBehindElement = head;
		int iteration = 1;
		
		while (currElement != null && iteration <= position.intValue()) {
			if (iteration++ == position.intValue()) {
				break;	
			}
			currElement = currElement.getNext();
		}
		
		if (currElement == null) {
			System.out.println("** Error: Current Element is past tail element");
			return null;
		}
		
		while (currElement.getNext() != null) {
			currElement = currElement.getNext();
			nthBehindElement = nthBehindElement.getNext();
		}
		
		return nthBehindElement;
	}
	
	
	public static void main(String[] args) {
		Element element1 = new Element(10);
		MyLinkedList linkedList = new MyLinkedList(element1);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(30);
		
		System.out.println("## Linked List Elements:");
		linkedList.print();
		
		System.out.println("## Add element with value 99 at 6th position: ");
		linkedList.add(99, Long.valueOf(6));
		linkedList.print();
		
		System.out.println("## Delete element with value: 30");
		linkedList.delete(Integer.valueOf(30));
		linkedList.print();
		
		System.out.println("## Delete element at position: 5");
		linkedList.delete(Long.valueOf(5));
		linkedList.print();
		
		System.out.println("## Get Element at position 4: " + linkedList.getElementAt(Long.valueOf(4)));
		System.out.println("## 5th Element from last: " + linkedList.getNthFromLastElement(Long.valueOf(5)));
		System.out.println("## 4th Element from last: " + linkedList.getNthFromLastElement(Long.valueOf(4)));
		System.out.println("## Clear Linked List");
		linkedList.clear();
		linkedList.print();
		
	}
}
