import java.util.Scanner;
public class sum {
    public static int findPairs(int[] numbers, int target) {
        int count = 0;
     
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        int[] numbers = new int[size];

        System.out.println("Enter the number for the list:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the target : ");
        int target = scanner.nextInt();

        int result = findPairs(numbers, target);
        System.out.println("Number of pairs: " + result);
        scanner.close();

        }
}
