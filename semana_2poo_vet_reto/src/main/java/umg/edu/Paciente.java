package umg.edu;

public class Paciente {
    private long id;
    private String nombre;
    private String especie;
    private String raza;
    private int edadMeses;
    private double pesoKg;

    // Constructor completo
    public Paciente(long id, String nombre, String especie, String raza, int edadMeses, double pesoKg) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edadMeses = edadMeses;
        this.pesoKg = pesoKg;
    }

    // Constructor corto
    public Paciente(long id, String nombre, String especie) {
        this(id, nombre, especie, "mesitzo", 1, 1.0);
    }

    // Getters y setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdadMeses() { return edadMeses; }
    public void setEdadMeses(int edadMeses) { this.edadMeses = edadMeses; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public boolean esCachorro() {
        return edadMeses <= 24;
    }

    public String resumen() {
        return "Mascota ID: " + id + ", Nombre: " + nombre + ", Especie: " + especie +
                ", Edad: " + edadMeses + " meses, Peso: " + pesoKg + " kg";
    }
}
