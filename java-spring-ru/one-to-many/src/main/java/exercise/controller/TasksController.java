package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping(path = "")
    public List<TaskDTO> index() {
        return taskRepository.findAll().stream()
                .map(model -> taskMapper.map(model))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public TaskDTO show(@PathVariable long id) {
        var model = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + " not found"));
        return taskMapper.map(model);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO dto) {
        var taskModel = taskMapper.map(dto);
        var userModel = userRepository.findById(dto.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + " not found"));
        userModel.addTask(taskModel);
        taskModel.setAssignee(userModel);
        taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }

    @PutMapping(path = "/{id}")
    public TaskDTO update(@PathVariable long id, @Valid @RequestBody TaskUpdateDTO dto) {
        var taskModel = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + " not found"));
        var userModel = userRepository.findById(dto.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + " not found"));
        userModel.removeTask(taskModel);
        taskMapper.update(dto, taskModel);
        userModel.addTask(taskModel);
        taskModel.setAssignee(userModel);
        taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        var taskModel = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + " not found"));
        taskRepository.delete(taskModel);
    }
    // END
}
