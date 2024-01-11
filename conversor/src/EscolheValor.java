import javax.swing.JOptionPane;

public class EscolheValor {
    public double getValor() {
        try {
            String valorStr = JOptionPane.showInputDialog("Digite o valor:");
            return Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("O valor informado é inválido!");
        }
    }
}