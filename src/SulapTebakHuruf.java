import java.io.Console;
import java.util.*;
public class SulapTebakHuruf {
    public static void SulapTebakHuruf(){
        System.out.println("Pikirkan angka 2 digit\n" +
                "Kemudian pisahkan angka tersebut lalu jumlahkan\n" +
                "kurangi angka yang kamu pilih sebelumnya dengan hasil penjumlahan\n" +
                "cek hasilnya huruf apa\n" +
                "Contoh: angka dipilih = 39, maka 3+9=12, 39-12=27, Lihat 27 adalah huruf apa");
        char[] symbols = new char[100];
        char[] alphabets = {'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X',
                'Y', 'Z'};
        int multiplier = 9;
        Random rand = new Random();

        char chosenSymbol = alphabets[rand.nextInt(26)];
        for(int i = 0;i< symbols.length;i++){
            if(i % 9 == 0 && i != 0){
                symbols[i] = chosenSymbol;
            }else{
                symbols[i] = alphabets[rand.nextInt(26)];
            }
        }
        String result = "";
        for(int i = 0; i < 100; i++){
            if(i % 6 == 0){
                result += "\n";
            }
            result += (i) + " = " + symbols[i] + "   ";
        }
        result += "100" + " = " + alphabets[rand.nextInt(26)] + "   ";

        System.out.println(result + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");


        System.out.println("Huruf anda adalah: " + chosenSymbol);
    }

    public static void main (String[] args){

        SulapTebakHuruf();
    }
}
