public class Stack {
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public String peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }
}


