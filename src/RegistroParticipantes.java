import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RegistroParticipantes {
    private final Set<String> estudiantes;
    private final boolean ordenado;

    public RegistroParticipantes(boolean ordenado) {
        this.ordenado = ordenado;
        estudiantes = ordenado ? new TreeSet<>() : new HashSet<>();
        List.of("A0032", "A0015", "A0081", "A0032", "A0021", "A0015", "A0105", "A0007", "A0081", "A0044").forEach(estudiantes::add);
    }

    public static void main(String[] args) {
        boolean usarTreeSet = args.length > 0 && args[0].equalsIgnoreCase("tree");
        new RegistroParticipantes(usarTreeSet).ejecutar();
    }

    private void ejecutar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Implementación: " + (ordenado ? "TreeSet" : "HashSet"));

        int opcion;
        do {
            menu();
            opcion = leerEntero(entrada);
            switch (opcion) {
                case 1 -> registrar(entrada);
                case 2 -> buscar(entrada);
                case 3 -> eliminar(entrada);
                case 4 -> mostrar();
                case 5 -> System.out.println("Número de estudiantes: " + estudiantes.size());
                case 6 -> System.out.println("Fin del sistema.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void menu() {
        System.out.println("\n1. Registrar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Eliminar estudiante");
        System.out.println("4. Mostrar estudiantes");
        System.out.println("5. Mostrar número de estudiantes");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }

    private int leerEntero(Scanner entrada) {
        String valor = entrada.nextLine().trim();
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void registrar(Scanner entrada) {
        String identificador = leerIdentificador(entrada);
        if (identificador == null) {
            return;
        }
        System.out.println(estudiantes.add(identificador) ? "Estudiante registrado." : "El estudiante ya existe.");
    }

    private void buscar(Scanner entrada) {
        String identificador = leerIdentificador(entrada);
        if (identificador != null) {
            System.out.println(estudiantes.contains(identificador) ? "Estudiante encontrado." : "Estudiante no encontrado.");
        }
    }

    private void eliminar(Scanner entrada) {
        String identificador = leerIdentificador(entrada);
        if (identificador != null) {
            System.out.println(estudiantes.remove(identificador) ? "Estudiante eliminado." : "Estudiante no encontrado.");
        }
    }

    private String leerIdentificador(Scanner entrada) {
        System.out.print("Identificador (A0000): ");
        String identificador = entrada.nextLine().trim().toUpperCase();
        if (!identificador.matches("A\\d{4}")) {
            System.out.println("Formato inválido.");
            return null;
        }
        return identificador;
    }

    private void mostrar() {
        System.out.println("Estudiantes: " + estudiantes);
        if (ordenado) {
            System.out.println("Rango A0020-A0080: " + new TreeSet<>(estudiantes).subSet("A0020", true, "A0080", true));
        }
    }
}
