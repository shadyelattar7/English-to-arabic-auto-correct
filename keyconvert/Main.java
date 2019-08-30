
import com.sahil.TrayClass;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.script.ScriptEngine.FILENAME;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import sun.awt.im.InputMethodManager;

public class Main implements NativeKeyListener {

    Connection c;
    Statement s;
    ResultSet r;
    public int sz = 4814;
    TrayClass t = new TrayClass();
    String[] wordFile = new String[4814];

    public void read_file() { // to read file
        int c = 0;
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
                wordFile[c++] = sCurrentLine; // couter to add to arr
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

    public boolean found(String in) {//to found or not found 
        for (int i = 0; i < sz; i++) {
            if (in.equals(wordFile[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean ghfound(String in) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == 'g' && i + 1 < in.length() && in.charAt(i + 1) == 'h') {
                return true;
            }
        }
        return false;
    }

    public String replacer(String in) {
        String res = "";
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == 'g' && i + 1 < in.length() && in.charAt(i + 1) == 'h') {
                i++;
                res += "b";
            } else {
                res += in.charAt(i);
            }
        }
        return res;
    }

    public String Head(String in) {
        String res = "";
        String[] words = in.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (ghfound(words[i]) && found(words[i]) == false) {
                words[i] = replacer(words[i]);
            }
            res += words[i];
            if (i != words.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    public boolean wrongcaps(String in) {

        int counter = 0;
        char c;
        for (int i = 0; i < in.length(); i++) {

             c = in.charAt(i);

            if (Character.isUpperCase(c)) {
                counter++;
            }

        }
        if (counter > 0.7*in.length() ){
            return true ;
        }
        return false;
    }
    public String zbt (String in ){
        String result ="";
        
        if (wrongcaps(in)){
            for (int i = 0; i < in.length(); i++) {
                char c =in.charAt(i);
                if (Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                    
                }else {
                  c = Character.toUpperCase(c);
                }
            result = result + c ;
            
            }
        }
        
        
        return result ;
        
    }
    public String uppereng (char in){
        
        String result ="" + in ;
        
        if (in == 'T'){
            result = "áÅ";
        }if (in == 'Y'){
            result = "Å";
        }if (in == 'U'){
            result ="‘";
        }if (in == 'I'){
            result = "÷";
        }if (in == 'O'){
            result = "×";
        }if (in == 'P'){
            result = "º";
        }if (in == 'D'){
            result = "]";
        }if (in == 'F'){
            result = "[";
        }if (in == 'G'){
            result = "áÃ";
        }if (in == 'H'){
            result = "Ã";
        }if (in == 'K'){
            result = "¡";
        }if (in == 'L'){
            result = "/";
        }if (in == 'C'){
            result = "}";
        }if (in == 'V'){
            result = "{";
        }if (in == 'B'){
            result = "áÂ";
        }if (in == 'N'){
            result = "Â";
        }if (in == 'M'){
            result = "’";
        }      
        
        
        
        return result ;
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

    public char spe(char in) {
        char ret = 0;

        if (in == '!') {
            ret = '!';
        }
        if (in == '@') {
            ret = '@';
        }
        if (in == '#') {
            ret = '#';
        }
        if (in == '$') {
            ret = '$';
        }
        if (in == '%') {
            ret = '%';
        }
        if (in == '^') {
            ret = '^';
        }
        if (in == '&') {
            ret = '&';
        }
        if (in == '*') {
            ret = '*';
        }
        if (in == '(') {
            ret = ')';
        }
        if (in == ')') {
            ret = '(';
        }
        if (in == '_') {
            ret = '_';
        }
        if (in == '+') {
            ret = '+';
        }
        if (in == '-') {
            ret = '-';
        }
        if (in == '=') {
            ret = '=';
        }

        return ret;

    }

    public Main(String key) {
        initComponents();

        datafromframe = key;
        System.out.println(datafromframe);

    }

    public String engtoara(char c) {
        String all = "";

        //   Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
        if (c == 'a' || c == 'A') {
            all = "Ô";
        }
        if (c == 'b' || c == 'B') {
            all = "áÇ";
        }
        if (c == 'c' || c == 'C') {
            all = "Ä";
        }
        if (c == 'd' || c == 'D') {
            all = "í";
        }
        if (c == 'e' || c == 'E') {
            all = "Ë";
        }
        if (c == 'f' || c == 'F') {
            all = "È";
        }
        if (c == 'g' || c == 'G') {
            all = "á";
        }
        if (c == 'h' || c == 'H') {
            all = "Ç";
        }
        if (c == 'i' || c == 'I') {
            all = "å";
        }
        if (c == 'j' || c == 'J') {
            all = "Ê";
        }
        if (c == 'k' || c == 'K') {
            all = "ä";
        }
        if (c == 'l' || c == 'L') {
            all = "ã";
        }
        if (c == 'm' || c == 'M') {
            all = "É";
        }
        if (c == 'n' || c == 'N') {
            all = "ì";
        }
        if (c == 'o' || c == 'O') {
            all = "Î";
        }
        if (c == 'p' || c == 'P') {
            all = "Í";
        }
        if (c == 'q' || c == 'Q') {
            all = "Ö";
        }
        if (c == 'r' || c == 'R') {
            all = "Þ";
        }
        if (c == 's' || c == 'S') {
            all = "Ó";
        }
        if (c == 't' || c == 'T') {
            all = "Ý";
        }
        if (c == 'u' || c == 'U') {
            all = "Ú";
        }
        if (c == 'v' || c == 'V') {
            all = "Ñ";
        }
        if (c == 'w' || c == 'W') {
            all = "Õ";
        }
        if (c == 'x' || c == 'X') {
            all = "Á";
        }
        if (c == 'y' || c == 'Y') {
            all = "Û";
        }
        if (c == 'z' || c == 'Z') {
            all = "Æ";
        }
        if (c == '[') {
            all = "Ì";
        }
        if (c == ']') {
            all = "Ï";
        }
        if (c == ';') {
            all = "ß";
        }
        if (c == '\'') {
            all = "Ø";
        }
        if (c == '`') {
            all = "Ð";
        }
        if (c == ',') {   ////(Y)
            all = "æ";
        }
        if (c == '.') {
            all = "Ò";
        }
        if (c == '/') {
            all = "Ù";
        }
        if (c == '<') {
            all = ",";
        }
        if (c == '>') {
            all = ".";
        }
        if (c == '?') {
            all = "¿";
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
        String keytab = "Tab";
        String Escape = "Escape";
        String keyshift = "shift";
        String keyComma = "Comma";

        if (datakey.equals(keyshift + keyComma)) {

            System.out.println("shady");
        }

        if (datakey.equals(Escape)) {
            new Settingsframe().setVisible(true);

        }

        if (datakey.equals(keytab)) {

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
                System.out.println("bf " + all);
                all = "";
                System.out.println("af " + all);
                if ((isdig(c)) || (i > 0 && i + 1 < lin && isdig(conv.charAt(i - 1)) && isdig(conv.charAt(i + 1)))) {
                    total = total + c;
                    continue;
                }
                if (is_english(conv)) {
                    conv = zbt(conv);
                    c=conv.charAt(i);
                    if (Character.isUpperCase(c)) {
                       conv = uppereng(c);
                    }
                    else{
                    all = engtoara(c);
                    }
                } else {
                    if (c == 'Ð') {
                        all = "`";
                    }
                    if (c == 'Ö') {
                        all = "q";
                    }
                    if (c == 'Õ') {
                        all = "w";
                    }
                    if (c == 'Ë') {
                        all = "e";
                    }
                    if (c == 'Þ') {
                        all = "r";
                    }
                    if (c == 'Ý') {
                        all = "t";
                    }
                    if (c == 'Û') {
                        all = "y";
                    }
                    if (c == 'Ú') {
                        all = "u";
                    }
                    if (c == 'å') {
                        all = "i";
                    }
                    if (c == 'Î') {
                        all = "o";
                    }
                    if (c == 'Í') {
                        all = "p";
                    }

                    if (c == 'Ô') {
                        all = "a";
                    }
                    if (c == 'Ó') {
                        all = "s";
                    }
                    if (c == 'í') {
                        all = "d";
                    }
                    if (c == 'È') {
                        all = "f";
                    }
                    if (c == 'á') {
                        all = "g";
                    }
                    if (c == 'Ç') {
                        all = "h";
                    }
                    if (c == 'Ê') {
                        all = "j";
                    }
                    if (c == 'ä') {
                        all = "k";
                    }
                    if (c == 'ã') {
                        all = "l";
                    }

                    if (c == 'Æ') {
                        all = "Z";
                    }
                    if (c == 'Á') {
                        all = "x";
                    }
                    if (c == 'Ä') {
                        all = "c";
                    }
                    if (c == 'Ñ') {
                        all = "v";
                    }
                    if (ah.equals("áÇ")) {
                        all = "b";
                    }
                    if (c == 'ì') {
                        all = "n";
                    }
                    if (c == 'É') {
                        all = "m";
                    }
                    if (c == 'æ') { //  //////////////////////////////// 
                        all = ",";
                    }
                    if (c == 'Ò') {
                        all = ".";
                    }
                    if (c == 'Ù') {
                        all = "/";
                    }
                    if (c == 'Ì') {
                        all = "[";
                    }
                    if (c == 'Ï') {
                        all = "]";
                    }
                    if (c == 'ß') {
                        all = ";";
                    }
                    if (c == 'Ø') {
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
                    if (c == '¿') {
                        all = "?";
                    }
                    if (c == ' ') {
                        all = " ";
                    }

                }
                if (spe(c) != 0) {
                    all += spe(c);
                }
                total = total + all;
                System.out.println(total);
            }

            // total = total + all;
            total = Head(total);
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
