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

    // code_problem7 - Find a missing number in a list
    public static int findMissingNumber(int[] arr) {

        Set < Integer > nums = new HashSet < Integer > ();

        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            nums.remove(arr[i]);
        }

        int val = -1;
        for (Integer numberino: nums) {
            val = (int) numberino;
        }
        return val;
    }
    // code_problem8 - Reverse a string in Java
    public static String reverseString(String str) {
        String inputString = str;
        String outputString = null;

        if (str == null) return null;

        char[] outStringChar = new char[str.length()];

        for (int i = 0; i < inputString.length(); i++) {
            outStringChar[i] = inputString.charAt(inputString.length() - 1 - i);
        }
        outputString = new String(outStringChar);
        return outputString;
    }
    // code_problem9 - Find the first Non duplicate character in a string 
    public static Character firstNonRepeatedCharacter(String str) {

        if (str == null) {
            return null;
        } else if (str.length() == 1) {
            return str.charAt(0);
        }

        HashMap < Character, Integer > hmap = new HashMap < Character, Integer > ();

        for (int i = 0; i < str.length(); i++) {
            if (hmap.get(str.charAt(i)) == null) hmap.put(str.charAt(i), 1);
            else hmap.put(str.charAt(i), hmap.get(str.charAt(i)) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hmap.get(c) == 1) {
                return c;
            }
        }
        return null;
    }
    // code_problem10 - replace every space with a given string 
    public static String replace(String a, String b) {

        if (a == null || b == null) {
            return null;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                a = replaceChar(a, i, b);
            }
        }

        return a;
    }

    public static String replaceChar(String str, int n, String replacer) {

        String front = str.substring(0, n);
        String back = str.substring(n + 1, str.length());
        return front + replacer + back;

    }


    // code_problem11 - replace every space with a given string TAKE 2 STRINGBUILDER
    public static String replace(String a, String b) {

        if (a == null) {
            return null;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {

            char c = a.charAt(i);
            if (c == ' ') str.append(b);
            else str.append(c);
        }

        return str.toString();
    }

    // code_problem12 - palindrome checker; return true if palindrome else false;
    public static boolean isStringPalindrome(String str) {

        if (str == null || str.length() == 0 || str.length() == 1) {
            return true;
        }

        char[] reversedArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            reversedArr[str.length() - 1 - i] = c;
        }

        String reversed = new String(reversedArr);

        if (str.equals(reversed)) {
            return true;
        }
        return false;
    }
}