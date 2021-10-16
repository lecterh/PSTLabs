package com.pstlabs.test.controller;

import com.pstlabs.test.entity.Tool;
import com.pstlabs.test.entity.User;
import com.pstlabs.test.service.ToolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping("/add")
    public Tool add(@RequestBody Tool tool) {
        return toolService.create(tool);
    }

    @GetMapping("/{id}")
    public Tool getById(@PathVariable Long id) {
        return toolService.getById(id);
    }

    @GetMapping
    public List<Tool> getAll() {
        return toolService.getAll();
    }

    @PatchMapping
    public Tool update(@RequestBody Tool tool) {
        return toolService.update(tool);
    }

    @DeleteMapping
    public void delete(@RequestBody Tool tool) {
        toolService.delete(tool);
    }
}
