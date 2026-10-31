# Comparación de Sets

`HashSet` elimina duplicados y privilegia rapidez promedio. `TreeSet` también elimina duplicados, pero conserva orden natural y permite navegación y rangos.

## Ejecución

```bash
javac -d out src/*.java
java -cp out EjemploHashSet
java -cp out EjemploTreeSet
java -cp out OperacionesSet
java -cp out BenchmarkSets
java -cp out RegistroParticipantes
java -cp out RegistroParticipantes tree
```

## Evidencia

Los 10 registros de tecnologías dejan 6 únicos. Agregar `Java` devuelve `false`; agregar `Kotlin`, `true`. `TreeSet` presenta: `[Docker, Git, Java, JavaScript, Python, SQL]`.

Unión: `addAll()`. Intersección: `retainAll()`. Diferencia: `removeAll()`.

## Resultados

Equipo: Java 25, 1 000 000 enteros, tres repeticiones.

| Colección | Inserción | Búsqueda | Eliminación |
| --- | ---: | ---: | ---: |
| HashSet | 59.539 ms | 12.892 ms | 25.759 ms |
| TreeSet | 113.922 ms | 66.983 ms | 64.863 ms |

| Característica | HashSet | TreeSet |
| --- | --- | --- |
| Duplicados | No | No |
| Orden de inserción | No | No |
| Orden natural | No | Sí |
| Estructura | Tabla hash | Árbol ordenado |
| `add`, `contains`, `remove` | O(1) promedio | O(log n) |
| Mínimo, máximo, navegación, rangos | No directo | Sí |
| Orden personalizado | No | Sí, con `Comparator` |

## Respuestas

| # | Respuesta |
| ---: | --- |
| 1 | Unicidad de elementos. |
| 2 | No. |
| 3 | No. |
| 4 | `false`. |
| 5 | Prioriza hashing, no posiciones. |
| 6 | Natural o del `Comparator`. |
| 7 | O(1) promedio. |
| 8 | O(log n). |
| 9 | Mantiene un árbol ordenado. |
| 10 | Obtiene el menor elemento. |
| 11 | `lower` es menor estricto; `floor` permite igualdad. |
| 12 | `higher` es mayor estricto; `ceiling` permite igualdad. |
| 13 | Obtiene una vista de un intervalo ordenado. |
| 14 | Define el criterio de comparación. |
| 15 | Copiar un set y usar `addAll`. |
| 16 | Copiar un set y usar `retainAll`. |
| 17 | Copiar un set y usar `removeAll`. |
| 18 | Pertenencia rápida sin orden. |
| 19 | Unicidad con orden, navegación o rangos. |
| 20 | Permite cambiar implementación sin cambiar el uso. |

## Conclusión

Usa `HashSet` para unicidad y pertenencia rápida. Usa `TreeSet` cuando el orden, mínimo/máximo o el rango `A0020` a `A0080` sea un requisito funcional.
