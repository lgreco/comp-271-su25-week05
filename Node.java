/**
 * Standard node class for single and double-linked lists. The node here is
 * written for String contents. Eventually it should be generalized for any kind
 * of contents.
 */
public class Node implements BasicGoodBehavior, Comparable<Node> {

    public int compareTo(Node node) {
        return this.value.length() - node.value.length();
    }

    /** Default value for new nodes */
    private static final String DEFAULT_VALUE = "EDON";
    /** Contents of node */
    private String value;
    /** Pointer to next node */
    private Node next;
    /** Pointer to previous node */
    private Node previous;

    /** Basic constructor assigns a value to the node and two null pointers */
    public Node(String value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    } // Basic constructor

    /** Default constructor */
    public Node() {
        this(DEFAULT_VALUE);
    } // default constructor

    /** Accessor for value */
    public String getValue() {
        return value;
    } // method getValue

    public boolean hasNext() {
        return this.next != null;
    }

    public Node getNext() {
        return this.next;
    }

    /** Mutator for next */
    public void setNext(Node next) {
        this.next = next;
    } // method setNext

    /** Mutator for previous */
    public void setPrevious(Node previous) {
        this.previous = previous;
    } // method setPrevious

    /**
     * Overrides the default Object.toString() method. Variables next and previous
     * below will resolve thanks to their instances of Node.toString() method.
     */
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    } // method toString

    public boolean isEmpty() {
        return this.value == null;
    }

    /** Simple testing */
    public static void main(String[] args) {
        Node a = new Node("our first real node");
        Node b = new Node("our second real node");
        a.setNext(b);
        System.out.println(a);
    }
} // class Node
