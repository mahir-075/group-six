
/**
 * Write a description of class Exercise8_MultiplicationTable here.
 *
 * @author (Hassan Juma Said)
 * @version ()
 */
public class Exercise8_MultiplicationTable {
        public static void main(String[] args) {
        System.out.println("=== 10x10 Multiplication Grid ===\n");
        
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n--------------------------------------------");

        for (int row = 1; row <= 10; row++) {
            System.out.printf("%2d |", row); 
            // Print side header
            for (int col = 1; col <= 10; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }
    }
}
