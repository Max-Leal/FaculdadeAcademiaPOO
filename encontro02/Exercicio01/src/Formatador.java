public class Formatador {

    public static String formatar(int numero) {
        return "#" + numero;
    }

    public static String formatar(double valor) {
        return String.format("R$ %.2f", valor);
    }

    public static String formatar(String texto) {
        return texto.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(formatar(42));       // #42
        System.out.println(formatar(42.5));     // R$ 42,50
        System.out.println(formatar("java"));   // [JAVA]
    }
}