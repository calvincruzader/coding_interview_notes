class CodingPractice1 {
  public static void main(String[] args) {
    System.out.println(reverseString("hello world"));
  }
  
  // Reverse the characters in a string 
  public static String reverseString(String s) {
    
    char[] reversedString = new char[s.length()];
    
    for(int i = s.length() - 1; i >= 0; i--) {
      
      reversedString[(s.length()-1)- i] = s.charAt(i);
    }
    
    return new String(reversedString);
  }
}