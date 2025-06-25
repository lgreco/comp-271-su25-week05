public class DynamicArray_Implementation {
    public static void main(String[] args) {
        DynamicArray <String> dynamicArray1 = new DynamicArray<>();
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        dynamicArray1.add("Hello");
        dynamicArray1.add("world");
        System.out.println(dynamicArray1);
        System.out.println(dynamicArray2);
    }
}