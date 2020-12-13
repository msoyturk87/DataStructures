public class HeapMainApp {
    public static void main(String[] args) {
        MyHeap myheap=new MyHeap();
        myheap.insert(23);
        myheap.print();
        System.out.println();
        myheap.insert(32);
        myheap.print();
        System.out.println();

        myheap.insert(91);
        myheap.insert(100);
        myheap.insert(2);
        myheap.insert(600);
        myheap.print();
        System.out.println();
        myheap.insert(1010);
        myheap.print();
    }
}
