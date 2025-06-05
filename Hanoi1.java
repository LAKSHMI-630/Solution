public class Hanoi1 {

    // Recursive function to solve Towers of Hanoi
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        solveHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    // Main method
    public static void main(String[] args) {
        int numDisks = 4; // You can change this value
        System.out.println("Towers of Hanoi solution for " + numDisks + " disks:");
        solveHanoi(numDisks, 'A', 'B', 'C');
    }
}