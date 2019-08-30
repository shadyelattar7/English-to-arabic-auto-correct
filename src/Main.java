
import com.sahil.Settingsframe;
import com.sahil.TrayClass;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.script.ScriptEngine.FILENAME;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import sun.awt.im.InputMethodManager;

public class Main implements NativeKeyListener {
   
    public boolean mo3zamcaps(String in){
        int c=0;
        for (int i = 0; i < in.length(); i++) if(Character.isUpperCase(in.charAt(i)))c++;
        return c>in.length()*0.5;
    }
    public String zabat(String in){
        String res="";
        if (mo3zamcaps(in)) {
            char c;
            for (int i = 0; i < in.length(); i++) {
                c=in.charAt(i);
                if (Character.isUpperCase(c)) {
                    c=Character.toLowerCase(c);
                }
                else  if (Character.isLowerCase(c)){
                    c=Character.toUpperCase(c);
                }
                res+=c;
            }
        }
        else{
            res=in;
        }
        return res;
    }
    Connection c;
    Statement s;
    ResultSet r;
    public  int sz  = 4814;
    TrayClass t = new TrayClass();
    String [] wordFile = new String[4814];
    public void read_file(){ // to read file
         int c=0;
        String FILENAME = "ghwords.txt";
	BufferedReader br = null;
		FileReader fr = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
                                wordFile[c++]=sCurrentLine; // couter to add to arr
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
                }
    

    } 
    public boolean found(String in){//to found or not found 
        for (int i = 0; i < sz; i++) if (in.equals(wordFile[i])) return true;
        return false;
    }
    public boolean ghfound(String in){
        for (int i = 0; i < in.length(); i++) if(in.charAt(i)=='g'&&i+1<in.length()&&in.charAt(i+1)=='h') return true;
        return false;
    }
    public String replacer(String in){
        String res="";
        for (int i = 0; i < in.length(); i++) {
            if(in.charAt(i)=='g'&&i+1<in.length()&&in.charAt(i+1)=='h') {
                i++;
                res+="b";
            }
            else res+=in.charAt(i);
        }
        return res;
    }
    public String Head(String in){
        String res="";
        String []words = in.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (ghfound(words[i])&&found(words[i])==false) words[i]=replacer(words[i]);
            res+=words[i];
            if (i!=words.length-1) res+=" ";
        }
        return res;
    }
    public Main() {
        read_file();
        initComponents();
    }
    
    String datafromframe = "";
    String bast = "";
    String yarap = "";
    String datakey;
    String totalgetkey;

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.getInstance().addNativeKeyListener(new Main());

    }
public char spe (char in){
     char ret = 0 ;
      
     if (in == '!') ret = '!' ;
     if (in == '@') ret = '@' ;
     if (in == '#') ret = '#' ;
     if (in == '$') ret = '$' ;
     if (in == '%') ret = '%' ;
     if (in == '^') ret = '^' ;
     if (in == '&') ret = '&' ;
     if (in == '*') ret = '*' ;
     if (in == '(') ret = ')' ;
     if (in == ')') ret = '(' ;
     if (in == '_') ret = '_' ;
     if (in == '+') ret = '+' ;
     if (in == '-') ret = '-' ;
     if (in == '=') ret = '=' ;
     
     return ret ;
     
}
    public Main(String key) {
        initComponents();

        datafromframe = key;
        System.out.println(datafromframe);

    }

    public String engtoara(char c) {
        String all = "";
        if (c == 'a' || c == 'A') {
            all = "ش";
        }
        if (c == 'b' ) {
            all = "لا";
        }if (c == 'B'){
            all = "لآ";
            return all ;
        }
        if (c == 'c' ) {
            all = "ؤ";
        }if (c == 'C'){
            all = "}";
            return all ;
        }
        if (c == 'd' ) {
            all = "ي";
        }if ( c == 'D'){
            all = "]";
            return all ;
        }
        if (c == 'e' || c == 'E') {
            all = "ث";
        }
        if (c == 'f' ) {
            all = "ب";
        }if (c == 'F'){
            all = "[";
            return all ;
        }
        if (c == 'g' ) {
            all = "ل";
        }if (c == 'G'){
            all = "لأ";
            return all ;
        }
        if (c == 'h' ) {
            all = "ا";
        }if (c == 'H'){
            all = "أ";
            return all ;
        }
        if (c == 'i' ) {
            all = "ه";
        }if (c == 'I'){
            all = "÷";
            return all ;
        }
        if (c == 'j' || c == 'J') {
            all = "ت";
        }
        if (c == 'k' ) {
            all = "ن";
        }if (c == 'K'){
            all = "،";
            return all ;
        }
        if (c == 'l' ) {
            all = "م";
        }if (c == 'L'){
            all = "/";
            return all ;
        }
        if (c == 'm' ) {
            all = "ة";
        }if (c == 'M'){
            all = "’";
            return all ;
        }
        if (c == 'n' ) {
            all = "ى";
        }if (c == 'N'){
            all = "آ";
            return all ;
        }
        if (c == 'o' ) {
            all = "خ";
        }if (c == 'O'){
            all = "×";
            return all ;
        }
        if (c == 'p' ) {
            all = "ح";
        }if (c == 'P'){
            all = "؛";
            return all ;
        }
        if (c == 'q' || c == 'Q') {
            all = "ض";
        }
        if (c == 'r' || c == 'R') {
            all = "ق";
        }
        if (c == 's' || c == 'S') {
            all = "س";
        }
        if (c == 't' ) {
            all = "ف";
        }if (c == 'T'){
            all = "لإ";
            return all ;
        }
        if (c == 'u' ) {
            all = "ع";
        }if (c == 'U'){
            all = "‘";
            return all ;
        }
        if (c == 'v' ) {
            all = "ر";
        }if (c == 'V'){
            all = "{";
            return all ;
        }
        if (c == 'w' || c == 'W') {
            all = "ص";
        }
        if (c == 'x' || c == 'X') {
            all = "ء";
        }
        if (c == 'y' ) {
            all = "غ";
        }if (c == 'Y'){
            all = "إ";
            return all ;
        }
        if (c == 'z' || c == 'Z') {
            all = "ئ";
        }
        if (c == '[') {
            all = "ج";
        }
        if (c == ']') {
            all = "د";
        }
        if (c == ';') {
            all = "ك";
        }
        if (c == '\'') {
            all = "ط";
        }
        if (c == '`') {
            all = "ذ";
        }
        if (c == ',') {   ////(Y)
            all = "و";
        }
        if (c == '.') {
            all = "ز";
        }
        if (c == '/') {
            all = "ظ";
        }
        if (c == '<') {
            all = ",";
        }
        if (c == '>') {
            all = ".";
        }
        if (c == '?') {
            all = "؟";
        }
        if (c == ':') {
            all = ":";
        }
        if (c == '"') {      ////// "
            all = "!!";
        }
        if (c == '{') {
            all = "<";
        }
        if (c == '}') {
            all = ">";
        }
        if (c == ' ') {
            all = " ";
        }
        return all;
    }

    public boolean isdig(char c) {
        return c >= '0' && c <= '9';
    } // for numbers

    public boolean is_english(String conv) {
        int c = 0;
        String ret = "";
        for (int i = 0; i < conv.length(); i++) {
            ret = engtoara(conv.charAt(i));
            if (ret.length() == 0) {
                continue;
            }
            if ((ret.length() != 1) || (ret.charAt(0) != conv.charAt(i))) {
                c++;
            }
        }
        return c >= conv.length() / 3;
    } // for english to arabic

 
    @Override
    public void nativeKeyPressed(NativeKeyEvent n) {

        boolean isShiftPressed = (n.getModifiers() & NativeKeyEvent.SHIFT_MASK) > 0;

        if (n.getKeyCode() == NativeKeyEvent.VK_COMMA && isShiftPressed) {

            System.out.println("short key work");

        }

        System.out.println(NativeKeyEvent.getKeyText(n.getKeyCode()));
        datakey = (NativeKeyEvent.getKeyText(n.getKeyCode()));
        String shortkey = "Backspace";
        String Escape = "Escape";
        String keyshift = "shift";
        String keyComma = "Comma";

        if (datakey.equals(keyshift + keyComma)) {

            System.out.println("shady");
        }

        if (datakey.equals(Escape)) {
            new Settingsframe().setVisible(true);

        }

        if (datakey.equals(shortkey)) {

            String clp = "";
            Clipboard cl = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable o = cl.getContents(this);
            if (o == null) {
                return;
            }
            try {
                clp = (String) o.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!clp.isEmpty()) {
                System.out.println("not em");
            }

            if (clp.isEmpty()) {
                System.out.println("is em");
            }

            String conv = clp;
            String all = "";
            String total = "";
            int lin = conv.length();

            for (int i = 0; i < lin; i++) {
                int state = 0;
                char c = conv.charAt(i);

                char ch = conv.charAt(i);
                String th = Character.toString(c);
                String ah = Character.toString(c);
                System.out.println("bf "+all);
                 all="";
              System.out.println("af "+all);
                if ((isdig(c)) || (i > 0 && i + 1 < lin && isdig(conv.charAt(i - 1)) && isdig(conv.charAt(i + 1)))) {
                    total = total + c;
                    continue;
                }
                if (is_english(conv)) {
                    String tmp =zabat(conv);
                    c = tmp.charAt(i);
                    all = engtoara(c);
                } else {
                    if (c == 'ذ') {
                        all = "`";
                    }
                    if (c == 'ض') {
                        all = "q";
                    }
                    if (c == 'ص') {
                        all = "w";
                    }
                    if (c == 'ث') {
                        all = "e";
                    }
                    if (c == 'ق') {
                        all = "r";
                    }
                    if (c == 'ف') {
                        all = "t";
                    }
                    if (c == 'غ') {
                        all = "y";
                    }
                    if (c == 'ع') {
                        all = "u";
                    }
                    if (c == 'ه') {
                        all = "i";
                    }
                    if (c == 'خ') {
                        all = "o";
                    }
                    if (c == 'ح') {
                        all = "p";
                    }

                    if (c == 'ش') {
                        all = "a";
                    }
                    if (c == 'س') {
                        all = "s";
                    }
                    if (c == 'ي') {
                        all = "d";
                    }
                    if (c == 'ب') {
                        all = "f";
                    }
                    if (c == 'ل') {
                        all = "g";
                    }
                    if (c == 'ا') {
                        all = "h";
                    }
                    if (c == 'ت') {
                        all = "j";
                    }
                    if (c == 'ن') {
                        all = "k";
                    }
                    if (c == 'م') {
                        all = "l";
                    }

                    if (c == 'ئ') {
                        all = "Z";
                    }
                    if (c == 'ء') {
                        all = "x";
                    }
                    if (c == 'ؤ') {
                        all = "c";
                    }
                    if (c == 'ر') {
                        all = "v";
                    }
                    if (ah.equals("لا")) {
                        all = "b";
                    }
                    if (c == 'ى') {
                        all = "n";
                    }
                    if (c == 'ة') {
                        all = "m";
                    }
                    if (c == 'و') { // علامه االتنصيص ////////////////////////////////
                        all = ",";
                    }
                    if (c == 'ز') {
                        all = ".";
                    }
                    if (c == 'ظ') {
                        all = "/";
                    }
                    if (c == 'ج') {
                        all = "[";
                    }
                    if (c == 'د') {
                        all = "]";
                    }
                    if (c == 'ك') {
                        all = ";";
                    }
                    if (c == 'ط') {
                        all = "'";
                    }
                    if (c == '<') {
                        all = "{";
                    }
                    if (c == '>') {
                        all = "}";
                    }
                    if (c == ':') {
                        all = ":";
                    }
                    if (c == '"') {  ////////// "
                        all = "!!";
                    }
                    if (c == ',') {
                        all = "<";
                    }
                    if (c == '.') {
                        all = ">";
                    }
                    if (c == '؟') {
                        all = "?";
                    }if ( c == ' '){
                        all =" ";
                    }

                }
                if(spe(c)!=0)all+=spe(c);
                total = total + all;
                System.out.println(total);
            }

            // total = total + all;
            total=Head(total);
            System.out.println(total);
            //   return;

            String myString = total;
            StringSelection stringSelection = new StringSelection(total);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);

        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke
    ) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke
    ) {

    }

    private void initComponents() {

    }
}
