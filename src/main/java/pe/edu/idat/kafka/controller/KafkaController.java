package pe.edu.idat.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.kafka.kafka.KafkaProducer;
import pe.edu.idat.kafka.model.KafkaModel;

@RestController
@RequestMapping("/api")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/log")
    public String enviarLog(@RequestBody KafkaModel log) {
        kafkaProducer.enviarMensaje(log);
        return "Log enviado al tópico logs_app correctamente.";
    }
}
