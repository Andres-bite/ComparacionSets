import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class BenchmarkSets {
    private static final int N = 1_000_000;
    private static final int REPETICIONES = 3;

    public static void main(String[] args) {
        probar("HashSet", HashSet::new);
        probar("TreeSet", TreeSet::new);
    }

    private static void probar(String nombre, Supplier<Set<Integer>> fabrica) {
        double insercionTotal = 0;
        double busquedaTotal = 0;
        double eliminacionTotal = 0;

        for (int ejecucion = 1; ejecucion <= REPETICIONES; ejecucion++) {
            Set<Integer> conjunto = fabrica.get();
            long inicioInsercion = System.nanoTime();
            for (int i = 0; i < N; i++) {
                conjunto.add(i);
            }
            long finInsercion = System.nanoTime();

            long inicioBusqueda = System.nanoTime();
            int encontrados = 0;
            for (int i = 0; i < N; i++) {
                if (conjunto.contains(i)) {
                    encontrados++;
                }
            }
            long finBusqueda = System.nanoTime();

            long inicioEliminacion = System.nanoTime();
            for (int i = 0; i < N; i++) {
                conjunto.remove(i);
            }
            long finEliminacion = System.nanoTime();

            double insercion = milisegundos(finInsercion - inicioInsercion);
            double busqueda = milisegundos(finBusqueda - inicioBusqueda);
            double eliminacion = milisegundos(finEliminacion - inicioEliminacion);
            insercionTotal += insercion;
            busquedaTotal += busqueda;
            eliminacionTotal += eliminacion;
            System.out.printf("%s %d: inserción %.3f ms, búsqueda %.3f ms, eliminación %.3f ms, encontrados %d%n", nombre, ejecucion, insercion, busqueda, eliminacion, encontrados);
        }

        System.out.printf("%s promedio: inserción %.3f ms, búsqueda %.3f ms, eliminación %.3f ms%n%n", nombre, insercionTotal / REPETICIONES, busquedaTotal / REPETICIONES, eliminacionTotal / REPETICIONES);
    }

    private static double milisegundos(long nanosegundos) {
        return nanosegundos / 1_000_000.0;
    }
}
