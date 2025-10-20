package umg.edu;

public class Dueno {
    private long id;
    private String nombreComplete;
    private String telefono;
    private String email;
    private String direccion;

    // Constructor completo
    public Dueno(long id, String nombreComplete, String telefono, String email, String direccion) {
        this.id = id;
        this.nombreComplete = nombreComplete;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    // Constructor corto
    public Dueno(long id, String nombreComplete, String telefono) {
        this(id, nombreComplete, telefono, null, "sin dirección");
    }

    // Getters y setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNombreComplete() { return nombreComplete; }
    public void setNombreComplete(String nombreComplete) { this.nombreComplete = nombreComplete; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String resumen() {
        return "Dueño ID: " + id + ", Nombre: " + nombreComplete + ", Tel: " + telefono;
    }

}
