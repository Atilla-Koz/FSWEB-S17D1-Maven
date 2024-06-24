package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullName;

    @GetMapping("/animal")
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/animal/{id}")
    public void updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (!animals.containsKey(id)) {

        }
        animal.setId(id);
        animals.put(id, animal);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }
}
