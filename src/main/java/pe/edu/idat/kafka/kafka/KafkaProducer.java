package pe.edu.idat.kafka.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.edu.idat.kafka.model.KafkaModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaProducer {

    private static final List<KafkaModel> lista = new ArrayList<>();

    @KafkaListener(topics ="logs_app", groupId = "group_idat")

    public void guardar(KafkaModel kafkaModel) {
        lista.add(kafkaModel);
    }

    public static List<KafkaModel> listar() {
        return lista;
    }
}
