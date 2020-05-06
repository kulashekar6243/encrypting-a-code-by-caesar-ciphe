import javax.swing.*;
import java.util.Scanner;

public class encrypted {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("write code to encrypt");
        String encry=input.next();
        String x=normalize(encry);
        System.out.println("write shift");
        int v=input.nextInt();
        String y=caesify(v,x);
        String c=obify(y);
        System.out.println("groupify number");
        int s=input.nextInt();
        String g=groupify(c,s);
        System.out.println(g);



    }
    public static String normalize(String text){
        String next=text.toUpperCase().trim().replaceAll("\\p{Punct}","");
        return next;
    }
    private static String obify (String input) {
        String obifiledInput = "";
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
                obifiledInput += "OB" + temp;
            } else {
                obifiledInput += "" + temp;
            }
        }
        return obifiledInput;
    }
    public static String caesify(int shift,String text3){
        String ciphe="";
        for (int i=0;i<text3.length();i=i+1){
            int c=text3.charAt(i)+shift;
            if (c<65){
                c=c+26;

            }
            if (c>90){
                c=c-26;

            }
            ciphe += (char) c;

        }
        return ciphe;
    }
    public static String groupify(String p,int f){
        int newy = p.length();
        String segmented = "";
        int bigLength = newy % f;

        for (int chop = 0; chop < newy; chop += f) {
            if (chop + f > newy) {
                segmented = segmented + p.substring(chop, newy);
                for (int x = 0; x < bigLength; x++) {
                    segmented = segmented + "x";
                }
            }
            else { segmented = segmented + p.substring(chop, chop + f) + " "; }
        }


        if (bigLength == 0) { segmented = segmented.substring(0,segmented.length() - 1); }


        return segmented;
    }



}
