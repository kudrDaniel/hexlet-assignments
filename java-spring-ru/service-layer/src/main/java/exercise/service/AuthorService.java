package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var models = authorRepository.findAll();
        return models.stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO dto) {
        var model = authorMapper.map(dto);
        authorRepository.save(model);
        return authorMapper.map(model);
    }

    public AuthorDTO findById(Long id) {
        var model = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        return authorMapper.map(model);
    }

    public AuthorDTO update(AuthorUpdateDTO dto, Long id) {
        var model = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        authorMapper.update(dto, model);
        authorRepository.save(model);
        return authorMapper.map(model);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
