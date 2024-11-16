import java.util.*;

public class ViajeInterplanetario {

    // Lista de planetas y distancias
    static Map<String, Double> planetas = new HashMap<>();
    static {
        planetas.put("Mercurio", 91.7);
        planetas.put("Venus", 41.4);
        planetas.put("Tierra", 0.0);
        planetas.put("Marte", 78.3);
        planetas.put("Júpiter", 628.7);
        planetas.put("Saturno", 1200.0);
        planetas.put("Urano", 2600.0);
        planetas.put("Neptuno", 4300.0);
    }

    // con este codigo calculas el tiempo de horas
    public static double calcularTiempo(double distancia, double velocidad) {
        return distancia / velocidad; // Tiempo en horas
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Este codigo sirve para seleccionar el destino
        System.out.println("Bienvenido al programa de planificación de viaje interplanetario.");
        System.out.println("Selecciona un destino:");
        for (String planeta : planetas.keySet()) {
            System.out.println(planeta);
        }
        String destino = scanner.nextLine();
        
        // aqui es por si alguien ingresa un planeta invalido
        while (!planetas.containsKey(destino)) {
            System.out.println("Destino inválido. Por favor, selecciona un planeta válido.");
            destino = scanner.nextLine();
        }

        // Este codigo es para calcular la distancia y tiempo del viaje
        double distancia = planetas.get(destino) * 1_000_000; // este codigo es para convertir en kilometros
        System.out.println("Distancia a " + destino + ": " + distancia + " km");

        System.out.print("Ingresa la velocidad de la nave en km/h: ");
        double velocidad = scanner.nextDouble();

        double tiempo = calcularTiempo(distancia, velocidad);
        System.out.println("El tiempo estimado de viaje es: " + tiempo + " horas.");

        scanner.close();
    }
}
