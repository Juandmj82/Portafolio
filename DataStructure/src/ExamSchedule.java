/**
 * Clase que maneja la programación de exámenes usando una lista doblemente enlazada.
 */
public class ExamSchedule {
    private ExamNode head; // Primer nodo de la lista de exámenes
    private ExamNode current; // Nodo actual en la navegación
    private ExamNode tail; // Último nodo de la lista

    public ExamSchedule() {
        this.head = null;
        this.current = null;
        this.tail = null;
    }

    /**
     * Agrega un examen a la lista de exámenes.
     * @param examDetails Detalles del examen (fecha, ubicación, etc.).
     */
    public void addExam(String examDetails) {
        ExamNode newExam = new ExamNode(examDetails);
        if (head == null) { // Si la lista está vacía, el nuevo nodo es cabeza y cola
            head = newExam;
            tail = newExam;
            current = newExam;
        } else { // Si ya hay exámenes, se agrega al final
            tail.next = newExam;
            newExam.prev = tail;
            tail = newExam;
        }
        System.out.println("Exam added: " + examDetails);
    }

    /**
     * Muestra el siguiente examen en la lista.
     */
    public void viewNextExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else {
            System.out.println("Next Exam: " + current.examDetails);
            if (current.next != null) {
                current = current.next;
            } else {
                System.out.println("You have reached the last exam.");
            }
        }
    }

    /**
     * Muestra el examen anterior en la lista.
     */
    public void viewPreviousExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else if (current.prev != null) {
            current = current.prev;
            System.out.println("Previous Exam: " + current.examDetails);
        } else {
            System.out.println("You are at the first exam.");
        }
    }

    /**
     * Muestra todos los exámenes programados.
     */
    public void viewAllExamSchedule() {
        ExamNode temp = head;
        if (temp == null) {
            System.out.println("No exams scheduled.");
        } else {
            System.out.println("Exam Schedule:");
            while (temp != null) {
                System.out.println(temp.examDetails);
                temp = temp.next;
            }
        }
    }
}
