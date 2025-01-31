import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String word2 = new String("");
  for(int i = 0; i < word.length(); i++){
    if(Character.isLetter(word.charAt(i)) == true){
    word2 = word2 + word.substring(i, i+1);
  }
  }
  if(word2.equalsIgnoreCase(reverse(word))) return true;
  return false;
}

public String reverse(String str)
{
    String sNew1 = new String();
  for(int i = 0; i < str.length(); i++){
    if(Character.isLetter(str.charAt(i)) == true){
      sNew1 = sNew1 + str.substring(i, i+1);
    }
  }
  String sNew = new String();
   for(int i = 0; i < sNew1.length(); i++){
    sNew = sNew + sNew1.substring(sNew1.length()-i-1, sNew1.length()-i);
  }
  sNew.toLowerCase();
    return sNew;
}
}
