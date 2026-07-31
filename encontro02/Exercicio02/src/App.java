public class App {
    static int z = 100; // campo estático da classe

    public static void testar(int x) {
        System.out.println("x no início: " + x);   // 8
        x = x + 10;
        System.out.println("x depois +10: " + x);  // 18

        if (x > 15) {
            int y = x * 2;
            System.out.println("y dentro do if: " + y); // 36
        }
        // System.out.println(y); // por que isso seria erro?

        System.out.println("z (campo): " + z); // 100
    }

    public static void main(String[] args) {
        testar(8);
    }
}