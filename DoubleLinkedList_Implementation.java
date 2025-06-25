public class DoubleLinkedList_Implementation {
    public static void main(String[] args) {
        // Setup a couple of test linked lists.
        nfs_DoubleLinkedList foo = new nfs_DoubleLinkedList();
        nfs_DoubleLinkedList bar = new nfs_DoubleLinkedList();
        foo.add("Hello World!");
        bar.add("Howard");
        bar.add("Jarvis");
        // Test add(String)
        if (foo.getSize() * bar.getSize() == 0) {
            System.out.println("Method add(String) is not working properly.");
            return;
        }
        // Test compareTo
        if ((foo.compareTo(bar) * bar.compareTo(foo) < 0 &&
                (foo.compareTo(foo) == 0))) {
            System.out.println("Method compareTo passes basic logic test");
        } else {
            System.out.println("Method compareTo fails basic logic test");
        }
    } // method main
}
