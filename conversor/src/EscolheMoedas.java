public class EscolheMoedas {

    public enum TipoConversaoMoeda {
        BRL_PARA_USD,
        BRL_PARA_EUR,
        BRL_PARA_GBP,
        BRL_PARA_ARS,
        BRL_PARA_CLP,
        USD_PARA_BRL,
        EUR_PARA_BRL,
        GBP_PARA_BRL,
        ARS_PARA_BRL,
        CLP_PARA_BRL
    }

    private final TipoConversaoMoeda opcaoSelecionada;

    public EscolheMoedas(TipoConversaoMoeda opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    public TipoConversaoMoeda getOpcaoSelecionada() {
        return this.opcaoSelecionada;
    }
}