package br.com.backend.challenge.api.domain.testimony;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TestimonyService {

    @Autowired
    private TestimonyRepository testimonyRepository;

    @Transactional(readOnly = true)
    public List<TestimonyDTO> getTestimonys() {
        return testimonyRepository.findAll().stream().map(TestimonyDTO::new).toList();
    }

}
