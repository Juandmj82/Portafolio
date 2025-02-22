// Clase auxiliar para representar y manejar fechas
public class Date  {
    int date;  // Día del mes (1-31)
    int month; // Mes del año (1-12)
    int year;  // Año (e.g., 2005)

    // Constructor que inicializa una fecha con día, mes y año
    Date(int d, int m, int y) {
        this.date = d;
        this.month = m;
        this.year = y;
    }

    // Método que devuelve la fecha como una cadena en formato "día-mes-año"
    String getDate() {
        return this.date + "-" + this.month + "-" + this.year;
    }
}