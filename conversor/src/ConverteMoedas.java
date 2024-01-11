import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class ConverteMoedas extends Conversor {
    private static final Map<String, Double> COTACOES = new HashMap<>();

    //cotação do dia 11/01/24 - mude conforme o necessário
    static {
        COTACOES.put("BRL/USD", 4.87);
        COTACOES.put("BRL/EUR", 5.35);
        COTACOES.put("BRL/GBP", 6.22);
        COTACOES.put("BRL/ARS", 0.060);
        COTACOES.put("BRL/CLP", 0.0053);
    }

    private final EscolheMoedas.TipoConversaoMoeda opcaoSelecionada;

    public ConverteMoedas(EscolheMoedas.TipoConversaoMoeda opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    @Override
    public void converter(double valor) {
        if (validarOperacao()) {
            realizarConversao(valor);
            exibirResultado();
        } else {
            new TelaErro("Operação de conversão de moeda inválida.");
        }
    }

    private boolean validarOperacao() {
        return opcaoSelecionada.name().startsWith("BRL_PARA_");
    }

    private void realizarConversao(double valor) {
        String moedaDestino = opcaoSelecionada.name().replace("BRL_PARA_", "");
        super.simboloConversao = extrairSimbolo(moedaDestino);
        super.valorConvertido = calcularConversao(valor, "BRL/" + moedaDestino);
    }

    private double calcularConversao(double valor, String moedaOrigem) {
        return (moedaOrigem.startsWith("BRL/")) ? valor / COTACOES.get(moedaOrigem) : valor * COTACOES.get(moedaOrigem);
    }

    private String extrairSimbolo(String moedaDestino) {
        return moedaDestino.substring(moedaDestino.length() - 3);
    }

    private void exibirResultado() {
        String msg = String.format("O valor convertido é de %.2f %s", super.valorConvertido, super.simboloConversao);
        JOptionPane.showMessageDialog(null, msg);
    }
}
