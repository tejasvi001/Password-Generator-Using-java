import java.util.*;  
import java.util.stream.Collectors;  

public class GeneratePassword {  
      
    // main() method start  
    public static void main(String args[]) {  
          
        // call generateSecurePassword() method to generate random password using RandomStringUtils  
        String pass = generateSecurePassword();  
          
        // print RandomStringUtils password  
        System.out.println("Password generated is:"+pass);  
          
    }  
    public static String generateStr(int length, int asciiStart, int asciiEnd){
        String res = "";
        for(int i=0; i<length; i++){
            Random r = new Random();
            res+= (char)(r.nextInt(asciiEnd) + 'A');
        }
        return res;
    }
    public static int generateNumber(int length){
        int res = 0;
        for(int i=0; i<length; i++){
            res *= 10;
            res += Math.ceil((int)Math.random()*10);
        }
        return res;
    }
    // create generateSecurePassword() method that find the secure 10 digit password and returns it to the main() method  
    public static String generateSecurePassword() {  
          
        // generate a string of upper case letters having length 2  
        String upperCaseStr = generateStr(2, 65, 90);  
         
        // generate a string of lower case letters having length 2  
        String lowerCaseStr = generateStr(2, 97, 122);  
          
        // generate a string of numeric letters having length 2  
        String numbersStr = Integer.toString(generateNumber(2));  
          
        // generate a string of special chars having length 2  
        String specialCharStr = generateStr(2, 33, 47);  
          
        // generate a string of alphanumeric letters having length 2  
        String totalCharsStr = Integer.toString(generateNumber(2));  
          
        // concatenate all the strings into a single one  
        String demoPassword = upperCaseStr.concat(lowerCaseStr)  
          .concat(numbersStr)  
          .concat(specialCharStr)  
          .concat(totalCharsStr);  
          
        // create a list of Char that stores all the characters, numbers and special characters   
        List<Character> listOfChar = demoPassword.chars()  
                .mapToObj(data -> (char) data)  
                .collect(Collectors.toList());  
          
        // use shuffle() method of the Collections to shuffle the list elements   
        Collections.shuffle(listOfChar);  
          
        //generate a random string(secure password) by using list stream() method and collect() method  
        String password = listOfChar.stream()  
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)  
                .toString();  
                  
        // return RandomStringGenerator password to the main() method   
        return password;  
    }  
      
}  