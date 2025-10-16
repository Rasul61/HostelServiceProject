package org.example.hostelserviceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.HostelRequest;
import org.example.hostelserviceproject.dto.response.HostelResponse;
import org.example.hostelserviceproject.entity.Hostel;
import org.example.hostelserviceproject.sevice.abstraction.HostelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hostel")

public class HostelController {
    private final HostelService hostelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Hostel createHostel(@RequestBody HostelRequest hostelRequest) {
        return hostelService.addHostel(hostelRequest);
    }

    @GetMapping
    List<Hostel> findAllHostels() {
        return hostelService.getAllHostels();
    }

    @GetMapping("/id/{id}")
    HostelResponse findHostelById(@PathVariable Long id) {
        return hostelService.getHostelById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    Hostel updateHostelBy(@PathVariable Long id, @RequestBody HostelRequest hostelRequest) {
        return hostelService.updateHostelBy(id, hostelRequest);
    }

    @DeleteMapping
    void deleteHostel(@PathVariable Long id) {
        hostelService.deleteHostel(id);
    }


}
