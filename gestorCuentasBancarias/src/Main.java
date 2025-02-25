import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia de la clase CuentaBancaria
        CuentaBancaria cuenta = new CuentaBancaria("12345", 1000);

        boolean continuar = true;

        //while para mostrar el menú y permitir realizar operaciones
        while(continuar){

            System.out.println("\n****************** Menú ******************");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");

            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            //switch para realizar la operación seleccionada
            switch(opcion){
                case 1 :
                    System.out.println("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    cuenta.depositar(cantidadDeposito);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    try{
                        cuenta.retirar(cantidadRetiro);

                    }catch (SaldoInsuficienteException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("El saldo de la cuenta es: " + cuenta.getSaldo());
                    break;

                case 4:
                    continuar = false;
                    System.out.println("Saliendo...Gracias por utilizar el sistema");
                    break;

                default:
                    System.out.println("Opción no válida.Intenta de nuevo");
            }


        }

        scanner.close();

    }
}
