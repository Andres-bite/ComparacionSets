import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class OperacionesSet {
    public static void main(String[] args) {
        Set<String> grupoA = Set.of("Java", "Python", "SQL", "Git");
        Set<String> grupoB = Set.of("Python", "Docker", "SQL", "Kotlin");

        Set<String> union = new HashSet<>(grupoA);
        union.addAll(grupoB);
        Set<String> interseccion = new HashSet<>(grupoA);
        interseccion.retainAll(grupoB);
        Set<String> diferencia = new HashSet<>(grupoA);
        diferencia.removeAll(grupoB);

        System.out.println("Unión: " + union);
        System.out.println("Intersección: " + interseccion);
        System.out.println("Diferencia A-B: " + diferencia);

        TreeSet<Integer> calificaciones = new TreeSet<>(Set.of(65, 70, 75, 80, 85, 90, 95));
        System.out.println("Mínimo: " + calificaciones.first());
        System.out.println("Máximo: " + calificaciones.last());
        System.out.println("lower(80): " + calificaciones.lower(80));
        System.out.println("higher(80): " + calificaciones.higher(80));
        System.out.println("floor(82): " + calificaciones.floor(82));
        System.out.println("ceiling(82): " + calificaciones.ceiling(82));
        System.out.println("70 a 90: " + calificaciones.subSet(70, true, 90, true));
        System.out.println("headSet(80): " + calificaciones.headSet(80));
        System.out.println("tailSet(80): " + calificaciones.tailSet(80));

        TreeSet<String> sinMayusculas = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        sinMayusculas.addAll(Set.of("Java", "python", "SQL"));
        TreeSet<String> inverso = new TreeSet<>(Comparator.reverseOrder());
        inverso.addAll(sinMayusculas);
        System.out.println("Sin distinguir mayúsculas: " + sinMayusculas);
        System.out.println("Orden inverso: " + inverso);
    }
}
