class CodingPractice1 {
    public static void main(String[] args) {
        System.out.println(reverseString("hello world"));
    }

    // code_problem1 - Reverse the characters in a string
    public static String reverseString(String s) {

        char[] reversedString = new char[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {

            reversedString[(s.length() - 1) - i] = s.charAt(i);
        }

        return new String(reversedString);
    }

    // code_problem2 - flip a matrix along its vertical axis 
    public static void flipItVerticalAxis(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length / 2; j++) {

                int temp = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }

        }
    }

    // code_problem3 - Given a singly-linked list, write a method to delete its last node and return the head.
    public ListNode deleteAtTail(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode previousNode = head;
        ListNode runningNode = head.next;

        if (runningNode == null) {
            head = null;
            return null;
        }

        while (runningNode.next != null) {
            previousNode = runningNode;
            runningNode = runningNode.next;
        }

        previousNode.next = null;

        return head;
    }

    //code_problem4 - Take 1 of finding duplicates
    public static String duplicate(int[] numbers) {

        HashMap < Integer, Integer > existingKeys = new HashMap < Integer, Integer > ();
        Set < Integer > duplicates = new HashSet < Integer > ();

        for (int i = 0; i < numbers.length; i++) {
            if (existingKeys.get(numbers[i]) == null) {
                existingKeys.put(numbers[i], 1);
            } else {
                duplicates.add(numbers[i]);
            }
        }

        Iterator < Integer > dupsIter = duplicates.iterator();

        int[] dupes = new int[duplicates.size()];
        int counter = 0;
        while (dupsIter.hasNext()) {
            Integer dupVal = dupsIter.next();
            dupes[counter] = (int) dupVal;
            counter++;
        }

        Arrays.sort(dupes);

        return Arrays.toString(dupes);
    }

    // code_problem5 - Take2 finding dupes
    public static String duplicate(int[] numbers) {

        Set < Integer > nums = new HashSet < Integer > ();
        Set < Integer > uniques = new HashSet < Integer > ();

        for (int i = 0; i < numbers.length; i++) {
            if (!nums.contains(numbers[i])) nums.add(numbers[i]);
            else uniques.add(numbers[i]);
        }
        Iterator < Integer > iter = uniques.iterator();
        int[] uniqueNums = new int[uniques.size()];

        int idx = 0;
        while (iter.hasNext()) {
            Integer num = iter.next();
            uniqueNums[idx] = (int) num;
            idx++;
        }
        Arrays.sort(uniqueNums);
        return Arrays.toString(uniqueNums);
    }

    // code_problem6 - Implement binarySearch in Java
    public static Boolean binarySearch(int[] arr, int n) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (int)(Math.floor(low + high) / 2.0);

            int val = arr[mid];
            if (val == n) {
                return true;
            } else if (val < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}