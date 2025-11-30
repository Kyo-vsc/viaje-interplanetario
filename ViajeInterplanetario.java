import java.util.*;

public class ViajeInterplanetario {


    static class Planeta {
        String nombre;
        double distancia;

        Planeta(String nombre, double distancia) {
            this.nombre = nombre;
            this.distancia = distancia;
        }
    }

    static List<Planeta> planetas = new ArrayList<>();

    static {
        planetas.add(new Planeta("Mercurio", 91.7));
        planetas.add(new Planeta("Venus", 41.4));
        planetas.add(new Planeta("Tierra", 0.0));
        planetas.add(new Planeta("Marte", 78.3));
        planetas.add(new Planeta("Júpiter", 628.7));
        planetas.add(new Planeta("Saturno", 1200.0));
        planetas.add(new Planeta("Urano", 2600.0));
        planetas.add(new Planeta("Neptuno", 4300.0));
    }

    public static double calcularTiempo(double distanciaKm, double velocidadKmH) {
        return distanciaKm / velocidadKmH;
    }

    public static Planeta buscarPlaneta(String nombre) {
        for (Planeta planeta : planetas) {
            if (planeta.nombre.equalsIgnoreCase(nombre)) {
                return planeta;
            }
        }
        return null; 
    }

    public static void compararTiempos(Planeta p1, Planeta p2, double velocidad) {
        double distancia1 = p1.distancia * 1_000_000;
        double distancia2 = p2.distancia * 1_000_000;

        double tiempo1 = calcularTiempo(distancia1, velocidad);
        double tiempo2 = calcularTiempo(distancia2, velocidad);

        System.out.println("\n--- RESULTADOS DE COMPARACIÓN ---");
        System.out.println("Tiempo hacia " + p1.nombre + ": " + tiempo1 + " horas.");
        System.out.println("Tiempo hacia " + p2.nombre + ": " + tiempo2 + " horas.");

        if (tiempo1 < tiempo2) {
            System.out.println("El destino más rápido de alcanzar es: " + p1.nombre);
        } else if (tiempo2 < tiempo1) {
            System.out.println("El destino más rápido de alcanzar es: " + p2.nombre);
        } else {
            System.out.println("Ambos planetas tienen el mismo tiempo estimado de viaje.");
        }
    }
    // ------------------------------------------------------------

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de planificación de viaje interplanetario.\n");

        System.out.println("Planetas disponibles:");
        for (Planeta planeta : planetas) {
            System.out.println("- " + planeta.nombre);
        }

    
        System.out.print("\nSelecciona el planeta destino: ");
        String destino = scanner.nextLine();

        Planeta planetaSeleccionado = buscarPlaneta(destino);

        while (planetaSeleccionado == null) {
            System.out.println("Destino inválido. Intenta nuevamente.");
            destino = scanner.nextLine();
            planetaSeleccionado = buscarPlaneta(destino);
        }

        double distanciaKm = planetaSeleccionado.distancia * 1_000_000;
        System.out.println("Distancia a " + planetaSeleccionado.nombre + ": " + distanciaKm + " km");

    
        System.out.print("Ingresa la velocidad de la nave en km/h: ");
        double velocidad = scanner.nextDouble();
        scanner.nextLine(); 

        double tiempoViaje = calcularTiempo(distanciaKm, velocidad);
        System.out.println("Tiempo estimado de viaje: " + tiempoViaje + " horas.");

        System.out.println("\n¿Deseas comparar el tiempo con otro planeta? (si/no)");
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("si")) {

            System.out.println("\nSelecciona otro planeta para comparar:");

            String otro = scanner.nextLine();
            Planeta planeta2 = buscarPlaneta(otro);

            while (planeta2 == null || planeta2 == planetaSeleccionado) {
                System.out.println("Planeta no válido o ya seleccionado. Intenta de nuevo:");
                otro = scanner.nextLine();
                planeta2 = buscarPlaneta(otro);
            }

            compararTiempos(planetaSeleccionado, planeta2, velocidad);
        }

        // System.out.println("\nGracias por usar el simulador interplanetario.");
        scanner.close();
    }
}
