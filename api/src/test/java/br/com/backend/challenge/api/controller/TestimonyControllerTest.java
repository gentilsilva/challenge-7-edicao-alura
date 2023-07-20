package br.com.backend.challenge.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.backend.challenge.api.domain.testimony.TestimonyDTO;
import br.com.backend.challenge.api.domain.testimony.TestimonyFormDTO;
import lombok.var;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TestimonyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<TestimonyFormDTO> jacksonTesterTestimonyForm;

    @Autowired
    private JacksonTester<TestimonyDTO> jacksonTesterTestimonyDTO;

    @Test
    @DisplayName("Deveria devolver codigo http 400 - Se falhar a criação")
    void testimonyTestOne() throws Exception {
        var response = mockMvc.perform(post("/depoimentos"))
            .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 - Se item criado")
    void testimonyTestTwo() throws IOException, Exception {

        String picture = "linkTest";
        String testimony = "testimonyTest";
        String name = "nameTest";

        var response = mockMvc.perform(post("/depoimentos")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(jacksonTesterTestimonyForm.write(
                                            new TestimonyFormDTO(picture, testimony, name)
                                        ).getJson()))
                                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
    
}
