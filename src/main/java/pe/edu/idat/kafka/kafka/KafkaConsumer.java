package pe.edu.idat.kafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.edu.idat.kafka.kafka.KafkaConsumer;
import pe.edu.idat.kafka.model.KafkaModel;

@Service
public class KafkaConsumer {
    private final KafkaTemplate<String, KafkaModel> kafkaTemplate;

    private static final String TOPIC = "logs_app";

    public KafkaConsumer(KafkaTemplate<String, KafkaModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensaje(KafkaModel kafkaModel){
        kafkaTemplate.send(TOPIC, kafkaModel);
    }

}