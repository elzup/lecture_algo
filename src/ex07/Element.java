package ex07;

public class Element <T>{
	private Element next;
	private Element previous;
	private T data;
	public Element (T data) {
		this.data = data;
	}

	public Element setNext(Element next) {
		this.next = next;
		return next;
	}

	public Element getNext() {
		return next;
	}

	public Element setPrevious(Element previous) {
		this.previous = previous;
		return previous;
	}
	public Element getPrevious() {
		return this.previous;
	}

	public T setData(T data) {
		this.data = data;
		return data;
	}

	public T getData() {
		return data;
	}

	public String toString() {
		return "[" + data + "]";
	}
}
