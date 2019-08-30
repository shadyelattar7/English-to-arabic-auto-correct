
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
            result = "��";
        }if (in == 'Y'){
            result = "�";
        }if (in == 'U'){
            result ="�";
        }if (in == 'I'){
            result = "�";
        }if (in == 'O'){
            result = "�";
        }if (in == 'P'){
            result = "�";
        }if (in == 'D'){
            result = "]";
        }if (in == 'F'){
            result = "[";
        }if (in == 'G'){
            result = "��";
        }if (in == 'H'){
            result = "�";
        }if (in == 'K'){
            result = "�";
        }if (in == 'L'){
            result = "/";
        }if (in == 'C'){
            result = "}";
        }if (in == 'V'){
            result = "{";
        }if (in == 'B'){
            result = "��";
        }if (in == 'N'){
            result = "�";
        }if (in == 'M'){
            result = "�";
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
            all = "�";
        }
        if (c == 'b' || c == 'B') {
            all = "��";
        }
        if (c == 'c' || c == 'C') {
            all = "�";
        }
        if (c == 'd' || c == 'D') {
            all = "�";
        }
        if (c == 'e' || c == 'E') {
            all = "�";
        }
        if (c == 'f' || c == 'F') {
            all = "�";
        }
        if (c == 'g' || c == 'G') {
            all = "�";
        }
        if (c == 'h' || c == 'H') {
            all = "�";
        }
        if (c == 'i' || c == 'I') {
            all = "�";
        }
        if (c == 'j' || c == 'J') {
            all = "�";
        }
        if (c == 'k' || c == 'K') {
            all = "�";
        }
        if (c == 'l' || c == 'L') {
            all = "�";
        }
        if (c == 'm' || c == 'M') {
            all = "�";
        }
        if (c == 'n' || c == 'N') {
            all = "�";
        }
        if (c == 'o' || c == 'O') {
            all = "�";
        }
        if (c == 'p' || c == 'P') {
            all = "�";
        }
        if (c == 'q' || c == 'Q') {
            all = "�";
        }
        if (c == 'r' || c == 'R') {
            all = "�";
        }
        if (c == 's' || c == 'S') {
            all = "�";
        }
        if (c == 't' || c == 'T') {
            all = "�";
        }
        if (c == 'u' || c == 'U') {
            all = "�";
        }
        if (c == 'v' || c == 'V') {
            all = "�";
        }
        if (c == 'w' || c == 'W') {
            all = "�";
        }
        if (c == 'x' || c == 'X') {
            all = "�";
        }
        if (c == 'y' || c == 'Y') {
            all = "�";
        }
        if (c == 'z' || c == 'Z') {
            all = "�";
        }
        if (c == '[') {
            all = "�";
        }
        if (c == ']') {
            all = "�";
        }
        if (c == ';') {
            all = "�";
        }
        if (c == '\'') {
            all = "�";
        }
        if (c == '`') {
            all = "�";
        }
        if (c == ',') {   ////(Y)
            all = "�";
        }
        if (c == '.') {
            all = "�";
        }
        if (c == '/') {
            all = "�";
        }
        if (c == '<') {
            all = ",";
        }
        if (c == '>') {
            all = ".";
        }
        if (c == '?') {
            all = "�";
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
                    if (c == '�') {
                        all = "`";
                    }
                    if (c == '�') {
                        all = "q";
                    }
                    if (c == '�') {
                        all = "w";
                    }
                    if (c == '�') {
                        all = "e";
                    }
                    if (c == '�') {
                        all = "r";
                    }
                    if (c == '�') {
                        all = "t";
                    }
                    if (c == '�') {
                        all = "y";
                    }
                    if (c == '�') {
                        all = "u";
                    }
                    if (c == '�') {
                        all = "i";
                    }
                    if (c == '�') {
                        all = "o";
                    }
                    if (c == '�') {
                        all = "p";
                    }

                    if (c == '�') {
                        all = "a";
                    }
                    if (c == '�') {
                        all = "s";
                    }
                    if (c == '�') {
                        all = "d";
                    }
                    if (c == '�') {
                        all = "f";
                    }
                    if (c == '�') {
                        all = "g";
                    }
                    if (c == '�') {
                        all = "h";
                    }
                    if (c == '�') {
                        all = "j";
                    }
                    if (c == '�') {
                        all = "k";
                    }
                    if (c == '�') {
                        all = "l";
                    }

                    if (c == '�') {
                        all = "Z";
                    }
                    if (c == '�') {
                        all = "x";
                    }
                    if (c == '�') {
                        all = "c";
                    }
                    if (c == '�') {
                        all = "v";
                    }
                    if (ah.equals("��")) {
                        all = "b";
                    }
                    if (c == '�') {
                        all = "n";
                    }
                    if (c == '�') {
                        all = "m";
                    }
                    if (c == '�') { //  //////////////////////////////// 
                        all = ",";
                    }
                    if (c == '�') {
                        all = ".";
                    }
                    if (c == '�') {
                        all = "/";
                    }
                    if (c == '�') {
                        all = "[";
                    }
                    if (c == '�') {
                        all = "]";
                    }
                    if (c == '�') {
                        all = ";";
                    }
                    if (c == '�') {
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
                    if (c == '�') {
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
