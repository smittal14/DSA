import java.util.*;

class URLShortenerBase62 {

    //testing function
    public static void main(String[] args) {
        URLShortenerBase62 mc = new URLShortenerBase62();

        System.out.println((mc.encode("kuchkuch.com/1"))); //tinyurl.com/a
        System.out.println((mc.encode("kuchkuch.com/2"))); //tinyurl.com/b
        System.out.println((mc.encode("kuchkuch.com/3"))); //tinyurl.com/c
        System.out.println((mc.encode("kuchkuch.com/4"))); //tinyurl.com/d

        System.out.println((mc.decode("tinyurl.com/d"))); //kuchkuch.com/4
        System.out.println((mc.decode("tinyurl.com/a"))); //kuchkuch.com/1
        System.out.println((mc.decode("tinyurl.com/b"))); //kuchkuch.com/2
        System.out.println((mc.decode("tinyurl.com/c"))); //kuchkuch.com/3
    }
    
    //database
    private class Database{
        private Map<Integer,String> database;
        private int serialNumber;

        public Database(){
            this.database  = new HashMap<>();
            this.serialNumber = 1;
        }

        public String getLongUrlFromDataBase(int serial){
            return database.getOrDefault(serial,"");
        }

        public int putLongUrlIntoDatabaseAndReturnSerial(String longUrl){
            database.put(serialNumber++,longUrl);
            return serialNumber-1;
        }
    }

    //class variables
    Database database = new Database();
    String hostname = "tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int serial = database.putLongUrlIntoDatabaseAndReturnSerial(longUrl);
        String path = getBase62ForBase10(serial);
        return hostname+path;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String path = shortUrl.substring(hostname.length(),shortUrl.length());
        int serial = getBase10ForBase62(path);
        return database.getLongUrlFromDataBase(serial);
    }

    //input is 1 to 62
    //output is b/w a-z A-Z 0-9
    private char getCharForNumber(int n){
        if(n<=26) return (char)('a'+n-1);
        else if(n<=52) return (char)('A'+n-27);
        else return (char)('0'+n-53);
    }

    private int getNumberForChar(char c){
        if(c>='a' && c<='z') return (int)(c-'a')+1;
        else if(c>='A' && c<='Z') return (int)(c-'A')+27;
        else return (int)(c-'0')+53;
    }

    private String getBase62ForBase10(int number){
        StringBuilder code = new StringBuilder();
        while(number>0){
            code.append(getCharForNumber(number%62));
            number = number/62;
        }
        return code.reverse().toString();
    }

    private int getBase10ForBase62(String s){
        int result = 0;
        for(int i=s.length()-1;i>=0;i--){
            int n = getNumberForChar(s.charAt(i));
            result+= n*(int)(Math.pow(62,i));
        }
        return result;
    }

}
