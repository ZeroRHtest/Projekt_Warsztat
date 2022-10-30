import org.w3c.dom.ls.LSInput;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

}










