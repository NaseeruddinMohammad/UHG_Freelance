public class AlphaNumeric {

    public static void main(String [] s){
        String String = "qwerty324$*&";
        System.out.println(String.matches("[A-Za-z0-9]+"));

        String str = "madam";
        String rev="";
        char[] value=str.toCharArray();
        for(int i=value.length-1;i>=0;i--) {
            rev = rev + value[i];
            System.out.println(rev);
        }
        if(str.equals(rev)) {
            System.out.print("is a palindrome");
        }else{
            System.out.print("is not a palindrome");
        }
    }
}