public class DynamicArray_Implementation {
public static void main(String[] args) {
        /*
         *  WE. GOT. TO. TALK. ABOUT. SERIOUS. TESTING. !!!
         */
        final String[] TEST = { "Washington", "Island", "is", "in", "Lake", "Michigan", "in", "Wisconsin" };
        final String TARGET = TEST[TEST.length - 1];
        final String NTARGET = TEST[0] + TEST[TEST.length - 1];
        final String CTARGET = "in";
        // Note to self: remember to remove nfs_ for release
        DynamicArray arr1 = new DynamicArray();
        DynamicArray arr2 = new DynamicArray(0);
        for (String T : TEST)
            arr1.add(T);
        final String PASS = "Pass", FAIL = "FAIL";
        final String TEST_INDEXOF_NEG = "\n       Testing indexOf for non existing target: %s";
        final String TEST_INDEXOF_POS = "\n           Testing indexOf for existing target: %s";
        final String TEST_CONTAINS_NEG = "\n      Testing contains for non existing target: %s";
        final String TEST_CONTAINS_POS = "\n          Testing contains for existing target: %s";
        final String TEST_REMOVEI_NEG = "\n   Testing remove(int) for non existing target: %s";
        final String TEST_REMOVEI_POS = "\n       Testing remove(int) for existing target: %s";
        final String TEST_REMOVES_NEG = "\nTesting remove(String) for non existing target: %s";
        final String TEST_REMOVES_POS = "\n    Testing remove(String) for existing target: %s";
        final String TEST_COUNTOF_NEG = "\n       Testing countOf for non existing target: %s";
        final String TEST_COUNTOF_POS = "\n           Testing countOf for existing target: %s";
        final String TEST_INDEXOF_EMPTY = "\n              Testing indexOf for empty object: %s";
        final String TEST_CONTAINS_EMPTY = "\n             Testing contains for empty object: %s";
        final String TEST_REMOVEI_EMPTY = "\n          Testing remove(int) for empty object: %s";
        final String TEST_REMOVES_EMPTY = "\n       Testing remove(String) for empty object: %s";
        System.out.println("\n\nTesting:");
        System.out.printf(TEST_INDEXOF_NEG, (arr1.indexOf(NTARGET) == -1 ? PASS : FAIL));
        System.out.printf(TEST_INDEXOF_POS, (arr1.indexOf(TARGET) == TEST.length - 1) ? PASS : FAIL);
        System.out.printf(TEST_CONTAINS_NEG, (arr1.contains(NTARGET)) ? FAIL : PASS);
        System.out.printf(TEST_CONTAINS_POS, (arr1.contains(TARGET)) ? PASS : FAIL);
        System.out.printf(TEST_REMOVEI_NEG, (arr1.remove(TEST.length + 1) == null) ? PASS : FAIL);
        System.out.printf(TEST_REMOVEI_POS, (arr1.remove(0).equals(TEST[0])) ? PASS : FAIL);
        System.out.printf(TEST_REMOVES_NEG, (arr1.remove(NTARGET) == null) ? PASS : FAIL);
        System.out.printf(TEST_REMOVES_POS, (arr1.remove(TARGET).equals(TARGET)) ? PASS : FAIL);
        System.out.printf(TEST_COUNTOF_NEG, (arr1.countOf(NTARGET) == 0) ? PASS : FAIL);
        System.out.printf(TEST_COUNTOF_POS, (arr1.countOf(CTARGET) == 2) ? PASS : FAIL);
        System.out.printf(TEST_INDEXOF_EMPTY, (arr2.indexOf(TARGET) == -1) ? PASS : FAIL);
        System.out.printf(TEST_CONTAINS_EMPTY, (arr2.contains(TARGET)) ? FAIL : PASS);
        System.out.printf(TEST_REMOVEI_EMPTY, (arr2.remove(0) == null) ? PASS : FAIL);
        System.out.printf(TEST_REMOVES_EMPTY, (arr2.remove(TARGET) == null) ? PASS : FAIL);
        System.out.println("\n\nTesting completed\n");
    } // method main
}