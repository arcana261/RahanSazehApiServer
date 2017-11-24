package com.rahansazeh.apiserver.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rahansazeh.apiserver.model.ProjectLine;

import java.io.IOException;

public class ProjectLineIdSerializer extends JsonSerializer<ProjectLine> {
    @Override
    public void serialize(ProjectLine value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(value.getId());
    }
}
