package pe.edu.idat.kafka.kafka;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.edu.idat.kafka.model.KafkaModel;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "logs_app";

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensaje(String mensaje){
        kafkaTemplate.send(TOPIC, mensaje);
    }
    public void enviarMensaje(KafkaModel log) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String logJson = mapper.writeValueAsString(log);
            kafkaTemplate.send(TOPIC, logJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
