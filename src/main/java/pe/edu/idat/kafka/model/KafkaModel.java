package pe.edu.idat.kafka.model;

public class KafkaModel {
    private String origen;
    private String mensaje;
    private String nivel;

    public KafkaModel() {
    }

    public KafkaModel(String nivel, String mensaje, String origen) {
        this.nivel = nivel;
        this.mensaje = mensaje;
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}