package pe.edu.idat.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "logs_app", groupId = "group_idat")
    public void obtenerMensaje(String mensaje)
    {
        System.out.println("Mensaje recibido, listo para procesar"+mensaje);
    }
}
