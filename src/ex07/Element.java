package ex07;

public class Element <T>{
	private Element<T> next;
	private Element<T> previous;
	private T data;
	public Element (T data) {
		this.data = data;
	}

	public Element<T> setNext(Element<T> next) {
		this.next = next;
		return next;
	}

	public Element<T> getNext() {
		return next;
	}

	public Element<T> setPrevious(Element<T> previous) {
		this.previous = previous;
		return previous;
	}
	public Element<T> getPrevious() {
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
