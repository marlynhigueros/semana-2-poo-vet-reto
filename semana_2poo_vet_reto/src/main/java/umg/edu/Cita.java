package umg.edu;

import java.time.LocalDateTime;

public class Cita {
    private long id;
    private LocalDateTime fechaHora;
    private Dueno dueno;
    private Paciente paciente;
    private EstadoCita estado;
    private String motivoCancelacion;

    public Cita(long id, LocalDateTime fechaHora, Dueno dueno, Paciente paciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.dueno = dueno;
        this.paciente = paciente;
        this.estado = EstadoCita.PROGRAMADA;
        this.motivoCancelacion = null;
    }

    // Getters
    public long getId() { return id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public Dueno getDueno() { return dueno; }
    public Paciente getPaciente() { return paciente; }
    public EstadoCita getEstado() { return estado; }
    public String getMotivoCancelacion() { return motivoCancelacion; }

    // Métodos para cambiar estado
    public void reagendar(LocalDateTime nuevaFecha) {
        this.fechaHora = nuevaFecha;
        this.estado = EstadoCita.REAGENDADA;
    }

    public void cancelar(String motivo) {
        this.estado = EstadoCita.CANCELADA;
        this.motivoCancelacion = motivo;
    }

    public void marcarAtendida() {
        this.estado = EstadoCita.ATENDIDA;
    }

    public String resumen() {
        return "Cita ID: " + id + ", Fecha: " + fechaHora +
                ", Dueño: " + dueno.getNombreComplete() +
                ", Mascota: " + paciente.getNombre();
    }
}