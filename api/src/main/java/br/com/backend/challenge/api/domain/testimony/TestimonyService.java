package br.com.backend.challenge.api.domain.testimony;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;


@Service
public class TestimonyService {

    private final TestimonyRepository testimonyRepository;

    public TestimonyService(TestimonyRepository testimonyRepository) {
        this.testimonyRepository = testimonyRepository;
    }

    @Transactional
    public TestimonyDTO postTestimony(TestimonyFormDTO testimonyFormDto) {
        return new TestimonyDTO(testimonyRepository.save(new Testimony(testimonyFormDto)));
    }

    @Transactional(readOnly = true)
    public List<TestimonyDTO> readAllTestimonys() {
        return testimonyRepository.findAllByIsActiveTrue().stream().map(TestimonyDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public TestimonyDTO readTestimonyById(Long id) {
        return new TestimonyDTO(testimonyRepository.getReferenceByIdAndIsActiveTrue(id));
    }

    @Transactional(readOnly = true)
    public List<TestimonyDTO> readRandomTestimonys() {
        return testimonyRepository.listRandomTestimonysAndActiveTrue().stream().map(TestimonyDTO::new).toList();
    }

    @Transactional
    public TestimonyDTO updateTestimony(@Valid TestimonyUpdateFormDTO testimonyUpdateFormDTO) {
        Testimony testimony = testimonyRepository.getReferenceByIdAndIsActiveTrue(testimonyUpdateFormDTO.id());
        if (testimony == null) {
            return null;
        }
        testimony.update(testimonyUpdateFormDTO);
        return new TestimonyDTO(testimony);
    }

    @Transactional
    public Boolean removeTestimonyById(Long id) {
        Testimony testimony = testimonyRepository.getReferenceByIdAndIsActiveTrue(id);
        if (testimony == null) {
            return false;
        }
        testimony.inactivate();
        return true;
    }

}
