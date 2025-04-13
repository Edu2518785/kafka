package pe.edu.idat.kafka.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.idat.kafka.model.KafkaModel;
import pe.edu.idat.kafka.kafka.KafkaProducer;
import pe.edu.idat.kafka.kafka.KafkaConsumer;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KafkaController {

    public final KafkaConsumer kafkaConsumer;


    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    @PostMapping("/log")
    public String enviarMensaje(@RequestBody KafkaModel kafkaModel) {
        kafkaProducer.guardar(kafkaModel);
        return "Mensaje enviado a Kafka";
    }

    @GetMapping("/logs")
    public List<KafkaModel> listar() {
        return KafkaProducer.listar();
    }

}