import java.util.*;

public class ViajeInterplanetario {

    // representacion de clases y distancias
    static class Planeta {
        String nombre;
        double distancia;

        Planeta(String nombre, double distancia) {
            this.nombre = nombre;
            this.distancia = distancia;
        }
    }

    // Lista de planetas
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

    public static double calcularTiempo(double distancia, double velocidad) {
        return distancia / velocidad;
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

        // Detectar si el usuario seleccionó la Tierra
        if (planetaSeleccionado.nombre.equalsIgnoreCase("Tierra")) {
            System.out.println("\nTe encuentras en la Tierra, punto de partida del viaje. No hay distancia ni tiempo de desplazamiento que calcular.");
            scanner.close();
            return; // Terminar el programa sin hacer cálculos
        }

        // Si no es Tierra, continuar con el flujo normal
        double distancia = planetaSeleccionado.distancia * 1_000_000; // Convertir a kilómetros
        System.out.println("Distancia a " + planetaSeleccionado.nombre + ": " + distancia + " km");

        System.out.print("Ingresa la velocidad de la nave en km/h: ");
        double velocidad = scanner.nextDouble();

        double tiempo = calcularTiempo(distancia, velocidad);
        System.out.println("El tiempo estimado de viaje es: " + tiempo + " horas.");

        scanner.close();
    }
}
