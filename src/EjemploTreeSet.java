import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        List<String> registros = List.of("Java", "Python", "JavaScript", "Java", "SQL", "Python", "Git", "Java", "Docker", "SQL");
        Set<String> tecnologias = new TreeSet<>(registros);

        System.out.println("Intentos: " + registros.size());
        System.out.println("Sin duplicados: " + tecnologias.size());
        System.out.println("TreeSet ordenado:");
        tecnologias.forEach(System.out::println);
    }
}
