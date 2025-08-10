import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        try {
            Conversor conversor = new Conversor();
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("***********************************************************");
                System.out.println("Seja bem-vindo(a) ao conversor de moeda! Análise as seguintes opções:");
                System.out.println("1) Dolar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dolar");

                System.out.println("3) Dolar =>> Real brasileiro");
                System.out.println("4) Real brasileiro => Dolar");

                System.out.println("5) Dolar =>> Peso colombiano");
                System.out.println("6) Peso colombiano => Dolar");

                System.out.println("7) Moeda escolhida =>> Dolar");
                System.out.println("8) Sair");

                System.out.println("***********************************************************");
                System.out.println("Escolha uma opção válida: ");

                int option = sc.nextInt();

                if (option == 8) {
                    System.out.println("Até mais!");
                    break; // Sai do while
                }

                System.out.println("Informe a quantidade desejada para conversão das moedas:");
                int qtdValue = sc.nextInt();
                switch (option) {
                    case 1:
                        double resultUsdArs = conversor.usdToArs(qtdValue);
                        System.out.println("Conversão do dollar para o ARS: "+ resultUsdArs );
                        break;
                    case 2:
                        double resultArsDollar = conversor.arsToUsd(qtdValue);
                        System.out.println("Conversão do ARS para o dollar: "+ resultArsDollar );
                        break;
                    case 3:
                        double resultUsdBrl = conversor.usdToBrl(qtdValue);
                        System.out.println("Conversão do dollar para o BRL: "+ resultUsdBrl );
                        break;
                    case 4:
                        double resultBrlDollar = conversor.brlToUsd(qtdValue);
                        System.out.println("Conversão do BRL para o dollar: "+ resultBrlDollar );
                        break;
                    case 5:
                        double resultUsdCop = conversor.usdToCop(qtdValue);
                        System.out.println("Conversão do dollar para o COP: "+ resultUsdCop );
                        break;
                    case 6:
                        double resultCopDollar = conversor.copToUsd(qtdValue);
                        System.out.println("Conversão do BRL para o dollar: "+ resultCopDollar );
                        break;
                    case 7:
                        System.out.println("Informe a primeira moeda:");
                        String coin = sc.nextLine();
                        coin.toUpperCase();
                        System.out.println("Informe a quantidade da primeira moeda:");
                        int qtdCoin = sc.nextInt();

                        double result = conversor.someCoinToUsdCoin(coin, qtdCoin);
                        System.out.println("A conversão da moeda "+coin+ "para dolar: "+ result );
                        break;
                    default:
                        System.out.println("Até mais!");
                        break;
                }
            }
            sc.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao criar Conversor: " + e.getMessage());
        }




        /*System.out.println("10 BRL em USD: " + conversor.brlToUsd(10));
        System.out.println("10 USD em BRL: " + conversor.usdToBrl(10));

        System.out.println("10 ARS em USD: " + conversor.arsToUsd(10));
        System.out.println("10 USD em ARS: " + conversor.usdToArs(10));*/


    }

}