public class CuentaBancaria {
    // Atributos
    private final String numeroCuenta;
    private double saldo;

    // Constructor
    public  CuentaBancaria(String numeroCuenta, double saldo){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Métodos

    // Método para depositar dinero

    public void depositar(double cantidad){
        saldo +=cantidad;
        System.out.println("Se ha depositado " + cantidad + " en la cuenta " + numeroCuenta +
                " El nuevo saldo es: " + saldo);
    }

    // Método para retirar dinero
    // Se lanza una excepción si el saldo es insuficiente
    public void retirar(double cantidad) throws  SaldoInsuficienteException{
        if(cantidad > saldo ){
            // Lanzar una excepción
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo);
        }
        saldo -= cantidad;
        System.out.println("Se ha retirado " + cantidad + " El nuevo saldo es: " + saldo);
    }
// Método para consultar el saldo
    public double getSaldo() {
        return saldo;
    }
}
