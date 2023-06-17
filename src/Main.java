import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        // Deque para almacenar los números únicos de cada conjunto de 3 números
        Deque<Integer> uniqueNumbersDeque = new ArrayDeque<>();

        // Conjunto para realizar un seguimiento de los números únicos
        Set<Integer> uniqueNumbersSet = new HashSet<>();

        // Pedir al usuario que ingrese los números
        System.out.println("Ingrese los números (ingrese 'q' para terminar):");

        String input;
        while (!(input = scanner.next()).equalsIgnoreCase("q")) {
            int number = Integer.parseInt(input);

            // Agregar el número al conjunto de números únicos
            uniqueNumbersSet.add(number);

            // Si estamos en un conjunto de 3 números completado, agregar el número único al Deque
            if (uniqueNumbersSet.size() % 3 == 0) {
                uniqueNumbersDeque.addLast(uniqueNumbersSet.size());

                // Si el Deque supera el tamaño de 3, eliminar el primer número
                if (uniqueNumbersDeque.size() > 3) {
                    uniqueNumbersDeque.removeFirst();
                }
            }
        }

        scanner.close();

        // Encontrar el número máximo en el Deque
        int maxNumber = Integer.MIN_VALUE;
        for (int number : uniqueNumbersDeque) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        System.out.println("El número máximo de los conjuntos de 3 números es: " + maxNumber);
    }
}
