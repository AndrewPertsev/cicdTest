package by.aston.intensive.aap.controller;

import by.aston.intensive.aap.model.Position;
import by.aston.intensive.aap.model.dto.PositionDto;
import by.aston.intensive.aap.service.PositionServiceable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(PositionController.REST_URL_POSITIONS)
@AllArgsConstructor
public class PositionController {
    public static final String REST_URL_POSITIONS = "/positions";
    private final PositionServiceable positionServiceable;


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Position position = positionServiceable.findById(id);
        model.addAttribute("position", position);
        return "positions";
    }


    @GetMapping
    public String findAll(Model model) {
        List<Position> positions = positionServiceable.findAll();
        model.addAttribute("positions", positions);
        return "positions";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(PositionDto dto, @PathVariable Long id) {
        positionServiceable.update(dto, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        positionServiceable.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(PositionDto position) {
        positionServiceable.save(position);
    }
}



