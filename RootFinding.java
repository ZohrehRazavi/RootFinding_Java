import java.util.Scanner;

public class RootFinding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the estimated interval (a, b)
        System.out.println("Please enter the first double number: ");
        double a = input.nextDouble();

        System.out.println("Please enter the second double number: ");
        double b = input.nextDouble();

        // Find the root using the Bisection method
        double rootByBisection = bisectionMethod(a, b);

        // Display the root or message based on the result
        if (Double.isNaN(rootByBisection)) {
            System.out.println("Root cannot be found by the Bisection Method. Trying the Secant Method.");
            double rootBySecant = secantMethod(a, b);
            System.out.printf("Root: %.3f (Secant Method)\n", rootBySecant);
        } else {
            System.out.printf("Root: %.3f (Bisection Method)\n", rootByBisection);
        }

        input.close();
    }

    // Function f(x) = 0.1 * x^3 + x^2 - 6
    private static double f(double x) {
        return 0.1 * Math.pow(x, 3) + Math.pow(x, 2) - 6;
    }

    // Bisection method to find root
    private static double bisectionMethod(double a, double b) {
        double epsilon = 1.0e-6; // Tolerance for convergence
        int maxIterations = 100; // Maximum iterations to prevent infinite loops

        do {
            double c = (a + b) / 2; // Calculating the midpoint (c)

            if (Math.abs(f(c)) < epsilon) {
                return c; // Found a root within tolerance
            }

            // Check the sign of f(c) and update the interval (a, b)
            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        } while (Math.abs(b - a) > epsilon && maxIterations-- > 0);

        return Double.NaN; // Root not found within tolerance or iterations
    }

    // Secant method to find root (corrected)
    private static double secantMethod(double a, double b) {
        double epsilon = 1.0e-6; // Tolerance for convergence
        int maxIterations = 100; // Maximum iterations to prevent infinite loops
        double c;

        for (int i = 0; i < maxIterations; i++) {
            // Check for division by zero before calculation
            if (Math.abs(f(b) - f(a)) < epsilon) {
                System.out.println("Error: Division by zero encountered.");
                return Double.NaN;
            }

            // Calculate the new approximation (c)
            c = b - f(b) * (b - a) / (f(b) - f(a));

            // Check for convergence (consider both absolute and relative difference)
            if (Math.abs(c - b) < epsilon || Math.abs((c - b) / c) < epsilon) {
                return c; // Root found within tolerance
            }

            // Update for the next iteration
            a = b;
            b = c;
        }

        //System.out.println("Root not found within specified iterations or tolerance.");
        return Double.NaN;
    }
}