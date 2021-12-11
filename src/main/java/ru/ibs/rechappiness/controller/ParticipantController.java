package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.ParticipantDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Participant;
import ru.ibs.rechappiness.service.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participant/read")
    public List<ParticipantDto> showAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/participant/read/{id}")
    public ParticipantDto getParticipant(@PathVariable Long id) {
        return participantService.getParticipant(id);
    }

    @PostMapping("/participant/create")
    public void addNewParticipant(@RequestBody ParticipantDto participantDto) {
        participantService.saveParticipant(participantDto);
    }

    @PostMapping("/participant/update/{id}")
    public void updateParticipant(@RequestBody ParticipantDto participantDto, @PathVariable Long id) {
        participantService.updateParticipant(participantDto, id);
    }

    @PostMapping("/participant/update/")
    public Participant updateParticipant() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/participant/delete/{id}")
    public String deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return "Participant with ID = " + id + " was deleted";
    }

    @PostMapping("/participant/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
