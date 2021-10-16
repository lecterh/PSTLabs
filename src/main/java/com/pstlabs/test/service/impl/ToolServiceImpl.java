package com.pstlabs.test.service.impl;

import com.pstlabs.test.entity.Profile;
import com.pstlabs.test.entity.Tool;
import com.pstlabs.test.repository.ToolRepository;
import com.pstlabs.test.service.ToolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public Tool create(Tool tool) {
        return toolRepository.save(tool);
    }

    @Override
    public Tool getById(Long id) {
        return toolRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tool> getAll() {
        return toolRepository.findAll();
    }

    @Override
    public Tool update(Tool tool) {
        Tool newTool;
        Optional<Tool> oldTool = toolRepository.findById(tool.getId());
        if (oldTool.isPresent()) {
            newTool = oldTool.get();
            newTool.setName(tool.getName());
            newTool.setDescription(tool.getDescription());
            newTool.setPrice(tool.getPrice());
            newTool.setDuration(tool.getDuration());
            toolRepository.save(newTool);
        } else {
            throw new RuntimeException("Can't find tool");
        }
        return newTool;
    }

    @Override
    public void delete(Tool tool) {
        toolRepository.delete(tool);
    }
}
