import java.util.Scanner;

class CeaserCypher {
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String EncryptData(String inputStr, int key){
        inputStr = inputStr.toLowerCase();

        String encryptStr = "";

        for(int i=0 ; i<inputStr.length(); i++){
            int pos  = alphabet.indexOf(inputStr.charAt(i));
            int encryptPos = (key + pos) % 26;
            char encryptChar = alphabet.charAt(encryptPos);
            encryptStr += encryptChar;
        }
        return encryptStr;
    }

    public static String decryptData(String inputStr, int shiftKey)
    {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();

        // decryptStr to store decrypted data
        String decryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++)
        {

            // get position of each character of inputStr in ALPHABET
            int pos = alphabet.indexOf(inputStr.charAt(i));

            // get decrypted char for each char of inputStr
            int decryptPos = (pos - shiftKey) % 26;

            // if decryptPos is negative
            if (decryptPos < 0){
                decryptPos = alphabet.length() + decryptPos;
            }
            char decryptChar = alphabet.charAt(decryptPos);

            // add decrypted char to decrypted string
            decryptStr += decryptChar;
        }
        // return decrypted string
        return decryptStr;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        System.out.println("> Enter plain text :  ");
        String inputStr = scn.nextLine();

        System.out.println("> Enter the value of key : ");
        int inputKey = scn.nextInt();

        System.out.println("> The Encrypted data is : "+EncryptData(inputStr,inputKey));
        System.out.println("> The Encrypted data is : "+decryptData(EncryptData(inputStr,inputKey),inputKey));
    }

}
