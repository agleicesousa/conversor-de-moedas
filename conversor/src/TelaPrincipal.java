import javax.swing.JOptionPane;

public class TelaPrincipal {
    public static void main(String[] args) {
        do {
            try {
                EscolherConversor escolherConversor = new EscolherConversor();
                EscolheValor escolheValor = new EscolheValor();

                double valorSelecionado = escolheValor.getValor();
                Conversor conversor = escolherConversor.getConversorSelecionado();

                conversor.converter(valorSelecionado);

            } catch (NumberFormatException exception) {
                new TelaErro("O valor informado é inválido!");
            } catch (IllegalArgumentException exception) {
                new TelaErro(exception.getMessage());
            } catch (Exception exception) {
                new TelaErro("Erro... Digite um valor válido!");
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Continuar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");
        System.exit(0);
    }
}