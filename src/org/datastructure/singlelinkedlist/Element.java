package org.datastructure.singlelinkedlist;

public class Element {
	private Integer data;
	private Element next;
	
	public Element(Integer data) {
		this.data = data;
		this.next = null;
	}

	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Element [data=" + data + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || this.getClass() != object.getClass()) {
			return false;
		}
		
		final Element anotherElement = (Element)object;
		return this.data.equals(anotherElement.getData());
	}
		
}
