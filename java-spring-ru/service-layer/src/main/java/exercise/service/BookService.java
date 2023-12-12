package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> findAll() {
        var models = bookRepository.findAll();
        return models.stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO create(BookCreateDTO dto) {
        var model = bookMapper.map(dto);
        bookRepository.save(model);
        return bookMapper.map(model);
    }

    public BookDTO findById(Long id) {
        var model = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        return bookMapper.map(model);
    }

    public BookDTO update(BookUpdateDTO dto, Long id) {
        var model = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookMapper.update(dto, model);
        bookRepository.save(model);
        return bookMapper.map(model);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
