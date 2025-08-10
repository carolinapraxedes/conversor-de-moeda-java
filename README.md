# Conversor de Moedas em Java 💱

## 📌 Sobre o projeto
Este é um projeto simples desenvolvido para **praticar consumo de APIs** e **tratamento de exceções** em Java.  
Ele utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter taxas de câmbio em tempo real e permite converter valores entre diversas moedas.

O usuário interage por meio de um **menu no console**, podendo realizar conversões entre pares de moedas.

---

## 🚀 Funcionalidades
- Menu interativo no console.
- Conversão entre o Dolar Americano e o Peso Argentino ou vice-versa.
- Conversão entre o Dolar Americano e o Real Brasileiro ou vice-versa.
- Conversão entre o Dolar Americano e o Peso Colombiano ou vice-versa.
- Conversão entre o Dolar Americano e qualquer moedas suportadas pela API.
- Tratamento de exceções para entradas inválidas ou falhas de conexão.
- Validação de códigos de moedas informados pelo usuário.

---

## 🛠 Tecnologias utilizadas
- **Java 17+**
- **HTTP Client** (`java.net.http`)
- **Gson** para manipulação de JSON
- **ExchangeRate-API** para as taxas de câmbio

---

## 🔧 Como executar
1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas-java.git
   cd conversor-moedas-java

### 2. Adicionar a biblioteca Gson
Este projeto usa o Gson para manipulação de JSON.

Para adicionar o Gson no IntelliJ via arquivo `.jar`:

1. Baixe o gson-2.10.jar em: [Maven Reposity Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
2. No IntelliJ IDEA, vá em:
3. Adicione a biblioteca Gson
   `File > Project Structure > Modules > Dependencies`  
4. Clique no botão **`+`** e escolha **JARs or directories**.
5. Selecione o arquivo `gson-2.10.jar` baixado.
6. Clique em **OK** para salvar.

