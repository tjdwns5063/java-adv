package charsets;

import java.nio.charset.Charset;
import java.util.Map;

public class AvailableCharsets {
    public static void main(String[] args) {
        Map<String, Charset> charsets = Charset.availableCharsets();

        System.out.println(charsets);
        String s = new String(new byte[] {Integer.valueOf(65).byteValue()}, charsets.get("UTF-8"));

        System.out.println(s);
        System.out.println(Charset.defaultCharset());
    }
}
