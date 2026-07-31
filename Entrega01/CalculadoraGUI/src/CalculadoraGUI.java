import javax.swing.JOptionPane;

public class CalculadoraGUI {
    public static void main(String[] args) {
        String[] operacoes = {"Somar", "Subtrair", "Multiplicar", "Dividir", "Sair"};
        boolean continuar = true;

        while (continuar) {
            int op = mostrarMenu(operacoes);

            if (op == 4 || op == JOptionPane.CLOSED_OPTION) {
                mostrarMensagem("Até a próxima! 👋");
                continuar = false;
                continue;
            }

            try {
                double a = lerNumero("Primeiro número:");
                double b = lerNumero("Segundo número:");
                double resultado = calcular(a, b, op);
                mostrarResultado(a, b, resultado, op);
            } catch (ArithmeticException e) {
                mostrarErro("Não é possível dividir por zero!");
            } catch (NumberFormatException e) {
                mostrarErro("Digite apenas números válidos!");
            }
        }
    }

    private static int mostrarMenu(String[] operacoes) {
        return JOptionPane.showOptionDialog(
            null,
            "Escolha a operação:",
            "Calculadora",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            operacoes,
            operacoes[0]
        );
    }

    private static double lerNumero(String mensagem) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, mensagem));
    }

    private static void mostrarResultado(double a, double b, double resultado, int op) {
        String simbolo = obterSimbolo(op);
        String html = String.format(
            "<html>Resultado de <b>%.2f %s %.2f</b> = " +
            "<font color='#2563eb'><b>%.2f</b></font></html>",
            a, simbolo, b, resultado
        );
        JOptionPane.showMessageDialog(null, html, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String obterSimbolo(int op) {
        switch (op) {
            case 0: return "+";
            case 1: return "-";
            case 2: return "×";
            case 3: return "÷";
            default: return "?";
        }
    }

    private static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    static double calcular(double a, double b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3:
                if (b == 0) throw new ArithmeticException("divisão por zero");
                return a / b;
            default: throw new IllegalArgumentException("operação inválida");
        }
    }
}