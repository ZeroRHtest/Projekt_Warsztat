import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.in;

public class Zadania_Warsztat {

    public static void Zadanie_1(){

        for(int i=0; i<7;i++){
            String tekst = LocalDate.of(2001,4,i+1).getDayOfWeek().name();
            System.out.printf("%-10.3s",tekst); System.out.println();
        }
       // LocalDate.of().getDayOfWeek().name();
        System.out.println();



        String[] S_array = new String[4];

        int PIENIONDZ = 12400;
        int x = 1;
        NumberFormat t_usd = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat t_ind = NumberFormat.getCurrencyInstance(new Locale("en","in"));
        NumberFormat t_chi = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat t_eur = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        S_array[0]  =  t_usd.format(PIENIONDZ);
        S_array[1]  =  t_ind.format(PIENIONDZ);
        S_array[2]  =  t_chi.format(PIENIONDZ);
        S_array[3]  =  t_eur.format(PIENIONDZ);

        for(int i=0;i<4;i++){
            System.out.printf("%010d%20.40s", x,S_array[i]);
            System.out.println();
            x *= 123;
        }

    }

    public static void Zadanie_2(){


        String smallest="";
        String largest="";

        String s = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs\n";
        int k = 30;
        largest = s.substring(0,k);
        smallest= s.substring(0,k);

    }

    public static void Zadanie_3(){


        Scanner sc = new Scanner("He is a very very good boy, isn't he?\n");
        String s =  sc.nextLine().trim();

        if(s.length()>0 && s.length()<400000){
            String[] tokens =  s.split("[!,?._'@\\s]+");
            System.out.println(tokens.length);
            for(String token : tokens){
                System.out.println(token);
            }
        }
        else System.out.print("0");

        sc.close();







    }

    public static void Zadanie_4(){


        String  IPV4_REGEX_PATTERN =
                        "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."  +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."  +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

                      //  case0[0-1 0-9 0-9]case1[2 0-4 0-9]case2-[]




        Scanner sc = new Scanner("000.12.12.034\n" +
                "121.234.112.112\n" +
                "23.45.12.56\n" +
                "00.12.123.123123.123\n" +
                "122.23\n" +
                "Hello.IP");



        Pattern pattern  = Pattern.compile(IPV4_REGEX_PATTERN);

        while(sc.hasNext()){
            String address = sc.nextLine().trim();
            Matcher matcher  = pattern.matcher(address);
            System.out.println(matcher.matches());
        }
    }

    public static void Zadanie_5(){ //Liczba pierwsza

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean bit = true;


        if(n<2) bit = false;
        for(int i = 2; i<n;i++){
            if(n%i==0) bit = false;
            break;
        }
        if(!bit) System.out.println("not prime");
        else System.out.println("prime");


            //Pattern pattern = Pattern.compile("^[A-ZA-z]\\w{7,29}$");



    }

    public static void Zadanie_6(){

        /*
        5
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB*/

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";


    }

    public static void Zadanie_7(){


        Scanner sc = new Scanner("5\n" +
                "12 0 1 78 12\n" +
                "2\n" +
                "Insert\n" +
                "5 23\n" +
                "Delete\n" +
                "0");

        int n = sc.nextInt();
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            ls.add(sc.nextInt());
        }

       // System.out.printf(ls.toString());
        int querry = sc.nextInt();
        while (querry-- > 0){
            sc.nextLine();
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("Insert")) {
                int index = sc.nextInt();
                int number = sc.nextInt();
                ls.add(index, number);
            }
            else if(command.equalsIgnoreCase("Delete")){
                ls.remove(sc.nextInt());
            }
        }
    }

    public static void Zadanie_8(){

        Scanner sc = new Scanner("3\n" +
                "uncle sam\n" +
                "99912222\n" +
                "tom\n" +
                "11122222\n" +
                "harry\n" +
                "12299933\n" +
                "uncle sam\n" +
                "uncle tom\n" +
                "harry");

        int n = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> adr_num = new HashMap<String, Integer>();

        for(int i=0; i<n; i++){
            String  name = sc.nextLine();
            int     number = sc.nextInt();

            adr_num.put(name, number);
            sc.nextLine();
        }

        while (sc.hasNext()){
            String s = sc.nextLine();
            if(adr_num.get(s)!=null){
                System.out.println(s +"="+ adr_num.get(s));

            }
            else {
                System.out.println("Not found");
            }
        }


    }

    public static void Zadanie_9(){

        Scanner sc = new Scanner("""
                5
                5 41 77 74 22 44
                1 12
                4 37 34 36 52
                0
                3 20 22 33
                5
                1 3
                3 4
                3 1
                4 3
                5 5""");

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int n = sc.nextInt();

        while (n-- > 0){
            int m = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for(int i=0; i<m;i++){
                line.add(sc.nextInt());
            }
            arr.add(line);

        }

        int t = sc.nextInt();
        for(int i=0; i<t; i++){

            try {
                System.out.println(arr.get(sc.nextInt()-1).get(sc.nextInt()-1));
            } catch (Exception e){
                System.out.println("ERROR!");
            }

        }


    }


    public static  boolean canWin(int leap, int[] game){

        return true;
    }
    public  static void Zadanie_10(){ //

        Scanner scan = new Scanner("");
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

    public static void Zadanie_11(int...a){
       try {
           String s = "";
           int r = 0;
           for(int i : a){
               r+=i;
               s+=String.valueOf(i)+"+";
           }
           System.out.println(s.substring(0,s.length()-1)+"="+r);
       } catch (Exception e){
           System.out.println(e);
       }

    }
    public static void Zadanie_12(){

        Class c = Student.class;
        Method[] m = c.getDeclaredMethods();
        for(int i=0; i<m.length;i++){
            System.out.println(m[i].getName().toString());
        }

    }

    public static void Dodatkowe(){
        Scanner sc = new Scanner("ahqym\n" +
                "amftc\n" +
                "anotherfunction\n" +
                "atcks\n" +
                "bwkbd\n" +
                "cfwyc\n" +
                "cmkxa\n" +
                "dnpym\n" +
                "dnqvo\n" +
                "dvvwq\n" +
                "ehjdm\n" +
                "elyed\n" +
                "fmyce\n" +
                "getEmail\n" +
                "getId\n" +
                "getName\n" +
                "ghtlj\n" +
                "hluvb\n" +
                "isqdf\n" +
                "iwhtf\n" +
                "jmopy\n" +
                "jnskt\n" +
                "kbjlt\n" +
                "kgwku\n" +
                "khuag\n" +
                "levtp\n" +
                "mcgme\n" +
                "migyc\n" +
                "moebl\n" +
                "nixhb\n" +
                "odyqp\n" +
                "ogvdl\n" +
                "ormim\n" +
                "piwro\n" +
                "plaob\n" +
                "pnruo\n" +
                "pqfct\n" +
                "ptrup\n" +
                "pvgyp\n" +
                "qthde\n" +
                "rmjig\n" +
                "setEmail\n" +
                "setId\n" +
                "setName\n" +
                "sumvl\n" +
                "tkbpp\n" +
                "tntpj\n" +
                "toxdp\n" +
                "twyfa\n" +
                "uccfq\n" +
                "ujxei\n" +
                "vhxoi\n" +
                "viwuu\n" +
                "viyog\n" +
                "whjtj\n" +
                "ytijy");
        while (sc.hasNext()){

            System.out.println("public void "+ sc.nextLine() + "(){}");
        }
    }




    public static void Zadanie_13() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Zadanie_14(){

        Scanner sc = new Scanner("11");



    }
    // Szkolny rodzaj sprawdzania liczb pierwszych
    // Sprawdzanie pierwiastków w kolejnych iteracjach
    // A naive solution is to iterate through all numbers from 2 to sqrt(n) and for every number check if it divides n. If we find any number that divides, we return false.
    boolean prime_metoda_1(int n){
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
    void prime_metoda_2(int...n){


        for(int i = 0; i<n.length; i++){
            BigInteger bi = new BigInteger(String.valueOf(n[i]));

            if(bi.isProbablePrime(1));
            System.out.print(bi);


        }
        System.out.println();
    }   //
    boolean prime_metoda_3(int n){
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }







}


final class Prime {

    public static void checkPrime(int... a) {

        for (int i = 0; i < a.length; i++) {
            BigInteger bi = new BigInteger(String.valueOf(a[i]));

            if (bi.isProbablePrime(1)){
                System.out.printf("%s ", bi);
            }
        }
        System.out.println();
    }
}


class Student{
    public static void metoda_1(){}
    public static void metoda_2(){}
    public static void metoda_3(){}
    public static void metoda_4(){}
    public static void metoda_5(){}
}











