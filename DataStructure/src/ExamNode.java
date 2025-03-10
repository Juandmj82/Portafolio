/**
 * Nodo que representa un examen dentro de una lista doblemente enlazada.
 */
public class ExamNode {
    String examDetails; // Información del examen (fecha, ubicación, etc.)
    ExamNode next; // Referencia al siguiente examen en la lista
    ExamNode prev; // Referencia al examen anterior en la lista

    /**
     * Constructor que inicializa un nodo de examen con detalles específicos.
     * @param examDetails Información del examen (fecha, lugar, etc.).
     */
    public ExamNode(String examDetails) {
        this.examDetails = examDetails;
        this.next = null;
        this.prev = null;
    }
}
