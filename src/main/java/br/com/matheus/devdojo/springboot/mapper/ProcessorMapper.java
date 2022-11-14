package br.com.matheus.devdojo.springboot.mapper;

import br.com.matheus.devdojo.springboot.domain.Processor;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPostRequestBody;
import br.com.matheus.devdojo.springboot.request.processor.ProcessorPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProcessorMapper {
    public static final ProcessorMapper INSTANCE = Mappers.getMapper(ProcessorMapper.class);
    public abstract Processor toProcessor(ProcessorPostRequestBody processorPostRequestBody);
    public abstract Processor toProcessor(ProcessorPutRequestBody processorPutRequestBody);
}
