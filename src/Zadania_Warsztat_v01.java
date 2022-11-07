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
import java.util.concurrent.TimeUnit;

public class Zadania_Warsztat_v01 {


    public static void Zadanie_1() throws InterruptedException {
        int timeout_int = 10;
        double speed = 0.5;
        double z_down = 0.9;
        double pi_2 = Math.PI*2;
        boolean bit_cyk = true;

        while (true){

           /*x 2 on 1 off

            3on 2of*/


                for(double i=0; i<pi_2; i += speed) {

                    TimeUnit.MILLISECONDS.sleep(timeout_int);
                    double z = i;
                    while (z > 0){
                        System.out.print(" ");
                        z -= z_down;
                    }
                    System.out.printf("%1.3f\n",i);
                }
                for(double i=pi_2; i>0; i -= speed) {
                    TimeUnit.MILLISECONDS.sleep(timeout_int);

                    double z = i;
                    while (z > 0){
                        System.out.print(" ");
                        z -= z_down;
                    }
                    System.out.printf("%1.3f\n",i);

                }




        }
    }




}
