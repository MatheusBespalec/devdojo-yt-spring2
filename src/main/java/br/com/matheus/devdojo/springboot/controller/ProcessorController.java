package br.com.matheus.devdojo.springboot.controller;

import br.com.matheus.devdojo.springboot.domain.Processor;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPostRequestBody;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPutRequestBody;
import br.com.matheus.devdojo.springboot.service.ProcessorService;
import br.com.matheus.devdojo.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("processors")
@Log4j2
@RequiredArgsConstructor
public class ProcessorController {
    private final DateUtil dateUtil;
    private final ProcessorService processorService;

    @GetMapping
    public ResponseEntity<List<Processor>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(processorService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Processor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(processorService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Processor> save(@RequestBody ProcessorPostRequestBody processor) {
        return new ResponseEntity<Processor>(processorService.save(processor), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        processorService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProcessorPutRequestBody processor) {
        processorService.replace(processor);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
