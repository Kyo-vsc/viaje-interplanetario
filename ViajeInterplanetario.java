import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Programa de planificación de viaje interplanetario.
 * Permite seleccionar un planeta destino y calcular el tiempo estimado
 * de viaje en función de la distancia y la velocidad ingresada.
 * 
 * Mantenimiento preventivo realizado:
 * - Se agregó una constante FACTOR_KM para evitar valores mágicos.
 * - Se creó un enum NombrePlaneta para centralizar los nombres válidos.
 * - Se encapsularon atributos de Planeta con modificadores 'private' y getters.
 * - Se extrajo la lógica de búsqueda de planeta a un método separado.
 * - Se agregó validación de entrada numérica para la velocidad.
 * - Se añadieron comentarios de bloque para mejorar comprensión.
 * 
 * Ninguno de estos cambios modifica la funcionalidad original del programa.
 */

public class ViajeInterplanetario {

    /* 
     * FACTOR_KM:
     * Convierte la distancia de millones de kilómetros a kilómetros.
     * Se utiliza para evitar repetir el literal 1_000_000.0 en el código.
     */
    private static final double FACTOR_KM = 1_000_000.0;

    /*
     * NombrePlaneta:
     * Enum que representa los nombres válidos de los planetas.
     * Ayuda a evitar errores tipográficos y el uso de cadenas mágicas.
     */
    private enum NombrePlaneta {
        MERCURIO("Mercurio"),
        VENUS("Venus"),
        TIERRA("Tierra"),
        MARTE("Marte"),
        JUPITER("Júpiter"),
        SATURNO("Saturno"),
        URANO("Urano"),
        NEPTUNO("Neptuno");

        private final String nombre;

        NombrePlaneta(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

    /*
     * Clase Planeta:
     * Representa un planeta con su nombre y distancia a la Tierra
     * medida en millones de kilómetros.
     */
    static class Planeta {
        private final String nombre;
        private final double distancia; // en millones de km

        Planeta(String nombre, double distancia) {
            this.nombre = nombre;
            this.distancia = distancia;
        }

        public String getNombre() {
            return nombre;
        }

        public double getDistancia() {
            return distancia;
        }
    }

    /*
     * Lista estática de planetas disponibles como destinos.
     * Se inicializa en un bloque estático para cargarse una sola vez.
     */
    private static final List<Planeta> planetas = new ArrayList<>();

    static {
        planetas.add(new Planeta(NombrePlaneta.MERCURIO.getNombre(), 91.7));
        planetas.add(new Planeta(NombrePlaneta.VENUS.getNombre(), 41.4));
        planetas.add(new Planeta(NombrePlaneta.TIERRA.getNombre(), 0.0));
        planetas.add(new Planeta(NombrePlaneta.MARTE.getNombre(), 78.3));
        planetas.add(new Planeta(NombrePlaneta.JUPITER.getNombre(), 628.7));
        planetas.add(new Planeta(NombrePlaneta.SATURNO.getNombre(), 1200.0));
        planetas.add(new Planeta(NombrePlaneta.URANO.getNombre(), 2600.0));
        planetas.add(new Planeta(NombrePlaneta.NEPTUNO.getNombre(), 4300.0));
    }

    /*
     * calcularTiempo:
     * Calcula el tiempo estimado de viaje.
     * @param distanciaKm Distancia total en kilómetros.
     * @param velocidadKmH Velocidad de la nave en km/h.
     * @return Tiempo estimado de viaje en horas.
     */
    public static double calcularTiempo(double distanciaKm, double velocidadKmH) {
        return distanciaKm / velocidadKmH;
    }

    /*
     * buscarPlanetaPorNombre:
     * Recorre la lista de planetas y devuelve el que coincide con el nombre
     * (ignorando mayúsculas/minúsculas). Si no existe, retorna null.
     */
    private static Planeta buscarPlanetaPorNombre(String nombre) {
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().equalsIgnoreCase(nombre)) {
                return planeta;
            }
        }
        return null;
    }

    /*
     * mostrarPlanetas:
     * Imprime en consola los nombres de todos los planetas disponibles
     * para que el usuario pueda seleccionar un destino.
     */
    private static void mostrarPlanetas() {
        for (Planeta planeta : planetas) {
            System.out.println(planeta.getNombre());
        }
    }

    /*
     * main:
     * Punto de entrada del programa.
     * Gestiona la interacción con el usuario:
     *  - Muestra los planetas disponibles.
     *  - Solicita y valida el destino.
     *  - Maneja el caso especial cuando el destino es la Tierra.
     *  - Solicita y valida la velocidad de la nave.
     *  - Muestra el tiempo estimado de viaje.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bienvenido al programa de planificación de viaje interplanetario.");
            System.out.println("Selecciona un destino:");
            mostrarPlanetas();

            /*
             * Bucle de validación del destino:
             * Continúa pidiendo un planeta hasta que el usuario
             * ingrese uno válido presente en la lista.
             */
            Planeta planetaSeleccionado = null;
            while (planetaSeleccionado == null) {
                String destino = scanner.nextLine();
                planetaSeleccionado = buscarPlanetaPorNombre(destino);

                if (planetaSeleccionado == null) {
                    System.out.println("Destino inválido. Por favor, selecciona un planeta válido.");
                }
            }

            /*
             * Caso especial: si el usuario selecciona la Tierra,
             * no se realiza ningún cálculo de distancia ni tiempo,
             * ya que se considera el punto de partida.
             */
            if (planetaSeleccionado.getNombre().equalsIgnoreCase(NombrePlaneta.TIERRA.getNombre())) {
                System.out.println(
                    "\nTe encuentras en la Tierra, punto de partida del viaje. " +
                    "No hay distancia ni tiempo de desplazamiento que calcular."
                );
                return;
            }

            /*
             * Cálculo de distancia:
             * Se convierte de millones de kilómetros a kilómetros usando FACTOR_KM.
             */
            double distanciaKm = planetaSeleccionado.getDistancia() * FACTOR_KM;
            System.out.println("Distancia a " + planetaSeleccionado.getNombre() + ": " + distanciaKm + " km");

            /*
             * Lectura y validación de la velocidad:
             * Se asegura que el usuario ingrese un valor numérico (double).
             */
            System.out.print("Ingresa la velocidad de la nave en km/h: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Velocidad inválida. Ingresa un valor numérico en km/h:");
                scanner.next(); // descarta la entrada inválida
            }
            double velocidad = scanner.nextDouble();

            /*
             * Cálculo y presentación del tiempo estimado de viaje.
             */
            double tiempo = calcularTiempo(distanciaKm, velocidad);
            System.out.println("El tiempo estimado de viaje es: " + tiempo + " horas.");
        } finally {
            /*
             * Cierre del Scanner:
             * Se realiza en el bloque finally para asegurar que el recurso
             * se libere siempre, incluso si ocurre una excepción.
             */
            scanner.close();
        }
    }
}
