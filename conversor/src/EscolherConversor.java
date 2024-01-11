import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EscolherConversor {
    public enum TipoConversor {
        MOEDAS
        // Adicione outros tipos de conversor conforme necessário
    }

    private final TipoConversor opcaoSelecionada;
    private final EscolheMoedas escolheMoedas;

    public EscolherConversor() {
        String[] opcoes = {
                "Conversor de Moedas",
                // Adicione outros tipos de conversor conforme necessário
        };

        int opcaoSelecionadaIndex = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de conversor desejado:",
                "Conversores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        this.opcaoSelecionada = mapearIndiceParaTipoConversor(opcaoSelecionadaIndex);

        if (this.opcaoSelecionada == TipoConversor.MOEDAS) {
            this.escolheMoedas = new EscolheMoedas(mostrarMenuMoedas());
        } else {
            throw new IllegalArgumentException("Opção de conversor inválida");
        }
    }

    public Conversor getConversorSelecionado() {
        switch (this.opcaoSelecionada) {
            case MOEDAS:
                return new ConverteMoedas(escolheMoedas.getOpcaoSelecionada());
            // Adicione outros casos de conversor conforme necessário
            default:
                throw new IllegalArgumentException("Opção de conversor inválida");
        }
    }

    private TipoConversor mapearIndiceParaTipoConversor(int indice) {
        switch (indice) {
            case 0:
                return TipoConversor.MOEDAS;
            // Adicione outros mapeamentos conforme necessário
            default:
                throw new IllegalArgumentException("Opção de conversor inválida");
        }
    }

    private EscolheMoedas.TipoConversaoMoeda mostrarMenuMoedas() {
        String[] opcoesMoedas = {
                "Real/BRL para Dolar/USD",
                "Real/BRL para Euro/EUR",
                "Real/BRL para Libra Esterlina/GBP",
                "Real/BRL para Peso Argentino/ARS",
                "Real/BRL para Peso Chileno/CLP",
                "Dólar/USD para Real/BRL",
                "Euro/EUR para Real/BRL",
                "Libra Esterlina/GBP para Real/BRL",
                "Peso Argentino/ARS para Real/BRL",
                "Peso Chileno para Real/BRL"
        };
        
        JComboBox<String> comboMoedas = new JComboBox<>(opcoesMoedas);
        JOptionPane.showMessageDialog(null, comboMoedas, "Escolha a moeda desejada:", JOptionPane.PLAIN_MESSAGE);

        int opcaoMoedaIndex = comboMoedas.getSelectedIndex();
        return mapearIndiceParaTipoConversao(opcaoMoedaIndex);
    }

    private EscolheMoedas.TipoConversaoMoeda mapearIndiceParaTipoConversao(int indice) {
        switch (indice) {
            case 0:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_USD;
            case 1:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_EUR;
            case 2:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_GBP;
            case 3:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_ARS;
            case 4:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_CLP;
            case 5:
                return EscolheMoedas.TipoConversaoMoeda.USD_PARA_BRL;
            case 6:
                return EscolheMoedas.TipoConversaoMoeda.EUR_PARA_BRL;
            case 7:
                return EscolheMoedas.TipoConversaoMoeda.GBP_PARA_BRL;
            case 8:
                return EscolheMoedas.TipoConversaoMoeda.ARS_PARA_BRL;
            case 9:
                return EscolheMoedas.TipoConversaoMoeda.CLP_PARA_BRL;
            default:
                throw new IllegalArgumentException("Opção de conversão de moeda inválida");
        }
    }
}