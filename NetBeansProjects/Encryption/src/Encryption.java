
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        
        while(true){
            String input = scanner.next();
            System.out.println(encrypt(input.toLowerCase()));
            System.out.println(decrypt(input));
        }
    }
    
    public static String encrypt(String input) {
        String character = "";
        for (int i = 0; i < input.length(); i++) {
            switch(input.charAt(i)) {
                case 'a':
                    character += "3458";
                    break;
                case 'b':
                    character += "8423";
                    break;
                case 'c':
                    character += "3793";
                    break;
                case 'd':
                    character += "9269";
                    break;
                case 'e':
                    character += "3720";
                    break;
                case 'f':
                    character += "3820";
                    break;
                case 'g':
                    character += "8397";
                    break;
                case 'h':
                    character += "2937";
                    break;
                case 'i':
                    character += "3840";
                    break;
                case 'j':
                    character += "3867";
                    break;
                case 'k':
                    character += "0693";
                    break;
                case 'l':
                    character += "1269";
                    break;
                case 'm':
                    character += "1272";
                    break;
                case 'n':
                    character += "2729";
                    break;
                case 'o':
                    character += "1733";
                    break;
                case 'p':
                    character += "2928";
                    break;
                case 'q':
                    character += "2294";
                    break;
                case 'r':
                    character += "2839";
                    break;
                case 's':
                    character += "2829";
                    break;
                case 't':
                    character += "2834";
                    break;    
                case 'u':
                    character += "2193";
                    break;
                case 'v':
                    character += "2453";
                    break;
                case 'w':
                    character += "2383";
                    break;
                case 'x':
                    character += "3202";
                    break;
                case 'y':
                    character += "3938";
                    break;
                case 'z':
                    character += "2730";
                    break;
                case '.':
                   character += "34";
                   break;
                case ',':
                    character += "02";
                    break;
                case '\'':
                    character += "83";
                    break;
                    
                     
            }
        }
        return character;
    }
    public static String decrypt(String input){
        String code= "";
        for (int i= 0; i < input.length() - 3; i += 4){
            switch(input.substring(i, i+4)){
                case "3458":
                    code+='a';
                    break;
                case "8423":
                    code += 'b';
                    break;
                case "3793":
                    code += 'c';
                    break;
                case "9269":
                    code += 'd';
                    break;
                case "3720":
                    code += 'e';
                    break;
                case "3820":
                    code += 'f';
                    break;
                case "8397":
                    code += 'g';
                    break;
                case "2937":
                    code += 'h';
                    break;
                case "3840":
                    code += 'i';
                    break;
                case "3867":
                    code += 'j';
                    break;
                case "0693":
                    code += 'k';
                    break;
                case "1269":
                    code += 'l';
                    break;
                case "1272":
                    code += 'm';
                    break;
                case "2729":
                    code += 'n';
                    break;
                case "1733":
                    code += 'o';
                    break;
                case "2928":
                    code += 'p';
                    break;
                case "2294":
                    code += 'q';
                    break;
                case "2839":
                    code += 'r';
                    break;
                case "2829":
                    code += 's';
                    break;
                case "2834":
                    code += 't';
                    break;    
                case "2193":
                    code += 'u';
                    break;
                case "2453":
                    code += 'v';
                    break;
                case "2383":
                    code += 'w';
                    break;
                case "3202":
                    code += 'x';
                    break;
                case "3938":
                    code += 'y';
                    break;
                case "2730":
                    code += 'z';
                    break;
                case "34":
                   code += '.';
                   break;
                case "02":
                    code += ',';
                    break;
                case "83":
                    code += '\'';
                    break;
            }
        }
        return code;
    }

}