package org.example.hostelserviceproject.sevice.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.HostelRequest;
import org.example.hostelserviceproject.dto.response.HostelResponse;
import org.example.hostelserviceproject.entity.Hostel;
import org.example.hostelserviceproject.mapper.HostelMapper;
import org.example.hostelserviceproject.repository.HostelRepository;
import org.example.hostelserviceproject.sevice.abstraction.HostelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostelServiceHandle implements HostelService {
    private final HostelRepository hostelRepository;
    private final HostelMapper hostelMapper;


    @Override
    public Hostel addHostel(HostelRequest hostelRequest) {
        Hostel hostel = hostelMapper.requestToEntity(hostelRequest);

        return hostelRepository.save(hostel);
    }

    @Override
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    @Override
    public HostelResponse getHostelById(Long id) {
        Hostel hostel = hostelRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found hostel!"));

        return hostelMapper.entityToResponse(hostel);
    }

    @Override
    public Hostel updateHostelBy(Long id, HostelRequest hostelRequest) {
        Hostel hostel = hostelRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found payment!"));

        hostel.setName(hostelRequest.getName());
        hostel.setAddress(hostelRequest.getAddress());
        hostel.setStars(hostelRequest.getStars());

        return hostelRepository.save(hostel);
    }

    @Override
    public void deleteHostel(Long id) {
        hostelRepository.deleteById(id);

    }
}
