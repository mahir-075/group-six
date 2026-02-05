
/**
 * Write a description of class wile here.
 *
 * @author (sule)
 * @version (a version number or a date)
 */
public class sules{
    


    public static void main(String[] args) {
         Scanner = new scanner(System.in);

        System.out.println("=== Array Operations ===\n");

        
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Your Numbers ---");
        System.out.print("[ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.length;

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }

        // results
        System.out.println("\n--- Statistics ---");
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        scanner.close();
    }
}
    