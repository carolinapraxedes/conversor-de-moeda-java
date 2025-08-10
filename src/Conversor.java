import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Conversor {

    private JsonObject conversionRates;
    private static final String API_KEY = "2354d04afbd85f877e88cccb";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public Conversor() throws IOException, InterruptedException {
        try{

            // Cria o client
            HttpClient client = HttpClient.newHttpClient();

            // Realiza a request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .timeout(Duration.ofMinutes(2))
                    .header("Content-Type", "application/json")
                    .build();

            // Guarda o response da request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro na API: código " + response.statusCode());
            }

            // Transforma o json em JsonObject
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            // Acessa a propriedade "conversion_rates"
            this.conversionRates = jsonObject.getAsJsonObject("conversion_rates");


        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar taxas de câmbio: ",e);
        }

    }

    public double getValueSomeCoin(String someCoin) {
        someCoin = someCoin.toUpperCase();
        try{
            if (conversionRates == null) {
                throw new IllegalStateException("As taxas ainda não foram carregadas.");
            }
            if (!conversionRates.has(someCoin)) {
                throw new IllegalArgumentException("Moeda inválida ou não suportada: " + someCoin);
            }
            return conversionRates.get(someCoin).getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public double someCoinToUsdCoin(String someCoin, double qtdSomeCoin) {
        try {
            return qtdSomeCoin / getValueSomeCoin(someCoin);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public double usdCoinToSomeCoin(String someCoin, double qtdUsd) {
        try {
            return qtdUsd * getValueSomeCoin(someCoin);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // BRL -> USD
    public double brlToUsd(double qtdBrl) {
        try {
            return someCoinToUsdCoin("BRL", qtdBrl);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // USD -> BRL
    public double usdToBrl(double qtdUsd) {
        try {
            return usdCoinToSomeCoin("BRL", qtdUsd);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // ARS -> USD
    public double arsToUsd(double qtdArs) {
        try {
            return someCoinToUsdCoin("ARS", qtdArs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // USD -> ARS
    public double usdToArs(double qtdArs) {
        try {
            return usdCoinToSomeCoin("ARS", qtdArs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // COP -> USD
    public double copToUsd(double qtdCop) {
        try {
            return someCoinToUsdCoin("COP", qtdCop);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // USD -> ARS
    public double usdToCop(double qtdCop) {
        try {
            return usdCoinToSomeCoin("COP", qtdCop);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
