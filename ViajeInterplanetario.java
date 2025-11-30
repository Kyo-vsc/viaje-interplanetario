import java.util.*;

public class ViajeInterplanetario {

    // representacion de clases y distancias
    static class Planeta {
        String nombre;
        double distancia;
        String composicionQuimica;
        String atmosfera;
        String tamano; // Pequeño, Mediano, Grande, Gigante

        Planeta(String nombre, double distancia, String composicionQuimica, String atmosfera, String tamano) {
            this.nombre = nombre;
            this.distancia = distancia;
            this.composicionQuimica = composicionQuimica;
            this.atmosfera = atmosfera;
            this.tamano = tamano;
        }
    }

    // Lista de planetas
    static List<Planeta> planetas = new ArrayList<>();
    static {
        planetas.add(new Planeta("Mercurio", 91.7, 
            "Hierro, Silicatos", 
            "Muy delgada (exosfera), principalmente helio y sodio", 
            "Pequeño"));
        planetas.add(new Planeta("Venus", 41.4, 
            "Silicatos, Núcleo de hierro", 
            "Densa: 96% CO2, 3% nitrógeno", 
            "Mediano"));
        planetas.add(new Planeta("Tierra", 0.0, 
            "Hierro, Silicatos, Núcleo externo líquido", 
            "78% nitrógeno, 21% oxígeno", 
            "Mediano"));
        planetas.add(new Planeta("Marte", 78.3, 
            "Silicatos, Óxidos de hierro", 
            "Delgada: 95% CO2, 2.6% nitrógeno", 
            "Pequeño"));
        planetas.add(new Planeta("Júpiter", 628.7, 
            "Hidrógeno, Helio, Metano, Amoníaco", 
            "Hidrógeno y helio, con nubes de amoníaco", 
            "Gigante"));
        planetas.add(new Planeta("Saturno", 1200.0, 
            "Hidrógeno, Helio, Metano", 
            "Hidrógeno y helio, con nubes de amoníaco", 
            "Gigante"));
        planetas.add(new Planeta("Urano", 2600.0, 
            "Hielo, Hidrógeno, Helio, Metano", 
            "Hidrógeno, helio y metano (color azul-verde)", 
            "Grande"));
        planetas.add(new Planeta("Neptuno", 4300.0, 
            "Hielo, Hidrógeno, Helio, Metano", 
            "Hidrógeno, helio y metano (color azul intenso)", 
            "Grande"));
    }

    public static double calcularTiempo(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    public static int calcularPosicionRelativa(Planeta planeta) {
        int posicion = 1; // Empieza en 1 (el más cercano)
        for (Planeta p : planetas) {
            if (p.distancia < planeta.distancia && !p.nombre.equals(planeta.nombre)) {
                posicion++;
            }
        }
        return posicion;
    }

    public static int obtenerIndicePlaneta(Planeta planeta) {
        for (int i = 0; i < planetas.size(); i++) {
            if (planetas.get(i).nombre.equals(planeta.nombre)) {
                return i + 1; // Posición en la lista (1-indexado)
            }
        }
        return -1;
    }

    public static void mostrarInformacionPlaneta(Planeta planeta) {
        int posicionLista = obtenerIndicePlaneta(planeta);
        int posicionRelativa = calcularPosicionRelativa(planeta);
        
        System.out.println("\n=== INFORMACIÓN DEL PLANETA ===");
        System.out.println("Nombre: " + planeta.nombre);
        System.out.println("Posición en la lista: #" + posicionLista);
        
        if (planeta.distancia == 0.0) {
            System.out.println("Posición relativa: Planeta de origen (Tierra)");
        } else {
            System.out.println("Posición relativa: " + posicionRelativa + "º planeta más cercano a la Tierra");
        }
        
        System.out.println("Tamaño: " + planeta.tamano);
        System.out.println("Composición química: " + planeta.composicionQuimica);
        System.out.println("Atmósfera: " + planeta.atmosfera);
        System.out.println("===============================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de planificación de viaje interplanetario.");
        System.out.println("Selecciona un destino:");
        
        // muestra planetas
        for (Planeta planeta : planetas) {
            System.out.println(planeta.nombre);
        }

        String destino = scanner.nextLine();

        // Aqui se valida el destino
        Planeta planetaSeleccionado = null;
        for (Planeta planeta : planetas) {
            if (planeta.nombre.equalsIgnoreCase(destino)) {
                planetaSeleccionado = planeta;
                break;
            }
        }

        while (planetaSeleccionado == null) {
            System.out.println("Destino inválido. Por favor, selecciona un planeta válido.");
            destino = scanner.nextLine();
            for (Planeta planeta : planetas) {
                if (planeta.nombre.equalsIgnoreCase(destino)) {
                    planetaSeleccionado = planeta;
                    break;
                }
            }
        }

        // Mostrar información detallada del planeta seleccionado
        mostrarInformacionPlaneta(planetaSeleccionado);

        double distancia = planetaSeleccionado.distancia * 1_000_000; // Convertir a kilómetros
        System.out.println("Distancia a " + planetaSeleccionado.nombre + ": " + distancia + " km");

        System.out.print("Ingresa la velocidad de la nave en km/h: ");
        double velocidad = scanner.nextDouble();

        double tiempo = calcularTiempo(distancia, velocidad);
        System.out.println("El tiempo estimado de viaje es: " + tiempo + " horas.");

        scanner.close();
    }
}
