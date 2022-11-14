package br.com.matheus.devdojo.springboot.service;

import br.com.matheus.devdojo.springboot.domain.Processor;
import br.com.matheus.devdojo.springboot.mapper.ProcessorMapper;
import br.com.matheus.devdojo.springboot.repository.ProcessorRepository;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPostRequestBody;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorService {
    public final ProcessorRepository processorRepository;
    public List<Processor> listAll() {
        return processorRepository.findAll();
    }

    public Processor findByIdOrThrowBadRequestException(Long id) {
        return processorRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Processor Not Found"));
    }

    public Processor save(ProcessorPostRequestBody processorPostRequestBody) {
        Processor processor = ProcessorMapper.INSTANCE.toProcessor(processorPostRequestBody);
        return processorRepository.save(processor);
    }

    public void delete(Long id) {
        processorRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ProcessorPutRequestBody processorPutRequestBody) {
        findByIdOrThrowBadRequestException(processorPutRequestBody.getId());
        Processor processor = ProcessorMapper.INSTANCE.toProcessor(processorPutRequestBody);
        processorRepository.save(processor);
    }
}
