package umg.edu;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA VETERINARIO ===");

        // Parte B: Crear dueños y mascotas automáticamente
        Dueno[] duenos = new Dueno[500];
        Paciente[] pacientes = new Paciente[1000];

        System.out.println("Creando 500 dueños...");
        for (int i = 0; i < 500; i++) {
            long id = i + 1;
            String nombre = "Dueño " + id;
            String telefono = "502-" + (10000000 + i);
            duenos[i] = new Dueno(id, nombre, telefono);
        }

        System.out.println("Creando 1000 mascotas...");
        for (int i = 0; i < 1000; i++) {
            long id = i + 1;
            String nombre = "Mascota " + id;
            String especie = (i % 2 == 0) ? "perro" : "gato";
            int edad = (i % 120) + 1;
            double peso = 1.0 + (i % 30);

            pacientes[i] = new Paciente(id, nombre, especie, "mesitzo", edad, peso);
        }

        // Verificación
        System.out.println("\n=== PRIMEROS 3 DUEÑOS ===");
        for (int i = 0; i < 3; i++) {
            System.out.println(duenos[i].resumen());
        }

        System.out.println("\n=== PRIMERAS 6 MASCOTAS ===");
        for (int i = 0; i < 6; i++) {
            System.out.println(pacientes[i].resumen());
        }

        // Parte C: Reportes
        System.out.println("\n=== REPORTES ===");

        // 1. Conteo de cachorros
        int cachorros = 0;
        for (Paciente p : pacientes) {
            if (p.esCachorro()) {
                cachorros++;
            }
        }
        System.out.println("Total cachorros: " + cachorros);

        // 2. Distribución por especie
        int perros = 0, gatos = 0;
        for (Paciente p : pacientes) {
            if (p.getEspecie().equals("perro")) {
                perros++;
            } else {
                gatos++;
            }
        }
        System.out.println("Perros: " + perros + ", Gatos: " + gatos);

        // 3. Peso promedio
        double pesoPerros = 0, pesoGatos = 0;
        for (Paciente p : pacientes) {
            if (p.getEspecie().equals("perro")) {
                pesoPerros += p.getPesoKg();
            } else {
                pesoGatos += p.getPesoKg();
            }
        }
        System.out.printf("Peso promedio perros: %.2f kg\n", pesoPerros / perros);
        System.out.printf("Peso promedio gatos: %.2f kg\n", pesoGatos / gatos);

        // 4. Top 5 más longevos
        System.out.println("\nTop 5 mascotas más viejas:");
        Paciente[] masViejos = new Paciente[5];

        for (Paciente p : pacientes) {
            for (int i = 0; i < 5; i++) {
                if (masViejos[i] == null || p.getEdadMeses() > masViejos[i].getEdadMeses()) {
                    for (int j = 4; j > i; j--) {
                        masViejos[j] = masViejos[j-1];
                    }
                    masViejos[i] = p;
                    break;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (masViejos[i] != null) {
                System.out.println((i+1) + ". " + masViejos[i].resumen());
            }
        }

        // Parte D: Citas
        System.out.println("\n=== CITAS ===");
        Cita[] citas = new Cita[40];
        LocalDateTime ahora = LocalDateTime.now();

        // Crear 40 citas para los primeros 20 dueños (2 por dueño)
        for (int i = 0; i < 40; i++) {
            int indiceDueno = i / 2;
            LocalDateTime fecha = ahora.plusDays(1).withHour(10).withMinute(0).plusHours(i % 2);
            citas[i] = new Cita(i + 1, fecha, duenos[indiceDueno], pacientes[i]);
        }

        // Aplicar reglas de estado
        for (Cita cita : citas) {
            if (cita.getId() % 2 == 0) {
                cita.reagendar(cita.getFechaHora().plusDays(1));
            } else if (cita.getId() % 3 == 0) {
                cita.cancelar("no puede asistir");
            } else {
                cita.marcarAtendida();
            }
        }

        // Mostrar resumen de citas
        System.out.println("Resumen de citas:");
        for (Cita cita : citas) {
            System.out.println(cita.resumen() + " - Estado: " + cita.getEstado());
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}