import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EjemploHashSet {
    public static void main(String[] args) {
        List<String> registros = List.of("Java", "Python", "JavaScript", "Java", "SQL", "Python", "Git", "Java", "Docker", "SQL");
        Set<String> tecnologias = new HashSet<>();

        for (String tecnologia : registros) {
            tecnologias.add(tecnologia);
        }

        System.out.println("Intentos: " + registros.size());
        System.out.println("Sin duplicados: " + tecnologias.size());
        System.out.println("HashSet: " + tecnologias);
        System.out.println("Agregar Java: " + tecnologias.add("Java"));
        System.out.println("Agregar Kotlin: " + tecnologias.add("Kotlin"));
    }
}
