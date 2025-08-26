/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad4;

/**
 *
 * @author diana
 */
import java.util.Scanner;

public class Actividad4 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingreso a calculadora");
      
        boolean ejecutando = true;
        
        while (ejecutando) {
            mostrarMenu();
            
            // Obtener la opción del usuario
            System.out.print("\nIngresa tu opcin (en palabras): ");
            String opcion = scanner.nextLine().toLowerCase().trim();
            
            // Verificar si el usuario quiere salir
            if (opcion.equals("siete")) {
                System.out.println("Estas saliendo de la calculadora");
                ejecutando = false;
                continue;
            }
            
            // Validar que la opción sea válida
            if (!esOpcionValida(opcion)) {
                System.out.println("Invalido, verfica la opcion");
                continue;
            }
            
            // Obtener los números
            double a = obtenerNumero(scanner, "Ingresa el primer numero (a): ");
            double b = obtenerNumero(scanner, "Ingresa el segundo nuero (b): ");
            
            // Realizar la operación seleccionada
            realizarOperacion(opcion, a, b);
       
        }
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("        CALCULADORA CONSOLA");
        System.out.println("=".repeat(40));
        System.out.println("Operaciones disponibles:");
        System.out.println("1. Suma");
        System.out.println("2. Resta ");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division ");
        System.out.println("5. Potencia ");
        System.out.println("6. Raiz");
        System.out.println("7. Salir ");
        System.out.println("=".repeat(40));
    }
    
    private static boolean esOpcionValida(String opcion) {
        return opcion.equals("uno") || opcion.equals("dos") || opcion.equals("tres") ||
               opcion.equals("cuatro") || opcion.equals("cinco") || opcion.equals("seis");
    }
    
    private static double obtenerNumero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido");
            }
        }
    }
    
    private static void realizarOperacion(String opcion, double a, double b) {
        double resultado = 0;
        String operacion = "";
        String simbolo = "";
        
        switch (opcion) {
            case "uno":
                resultado = a + b;
                operacion = "Suma";
                simbolo = "+";
                break;
                
            case "dos":
                resultado = a - b;
                operacion = "Resta";
                simbolo = "-";
                break;
                
            case "tres":
                resultado = a * b;
                operacion = "Multiplicación";
                simbolo = "×";
                break;
                
            case "cuatro":
                if (b == 0) {
                    System.out.println("No se puede dividr entte cero");
                    return;
                }
                resultado = a / b;
                operacion = "División";
                simbolo = "÷";
                break;
                
            case "cinco":
                resultado = Math.pow(a, b);
                operacion = "Potencia";
                simbolo = "^";
                break;
                
            case "seis":
                if (a < 0 && b % 2 == 0) {
                    System.out.println("No se puede calcular la raíz par de un número negativo.");
                    return;
                }
                if (b == 0) {
                    System.out.println("El índice de la raíz no puede ser cero.");
                    return;
                }
                resultado = Math.pow(a, 1.0 / b);
                operacion = "Raíz";
                simbolo = "√";
                break;
        }
        
        // Mostrar el resultado con formato diferente para raíz
         if (opcion.equals("seis")) {
            System.out.printf("\n %s: %.0f√(%.0f) = %.4f%n", operacion, b, a, resultado);
        } else {
            System.out.printf("\n %s: %.2f %s %.2f = %.4f%n", operacion, a, simbolo, b, resultado);
        }
    }
}
