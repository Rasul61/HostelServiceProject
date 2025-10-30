package org.example.hostelserviceproject.service.abstraction;

import org.example.hostelserviceproject.dto.request.HostelRequest;
import org.example.hostelserviceproject.dto.response.HostelResponse;
import org.example.hostelserviceproject.entity.Hostel;

import java.util.List;

public interface HostelService {
    Hostel addHostel(HostelRequest hostelRequest);

    List<Hostel> getAllHostels();

    HostelResponse getHostelById(Long id);

    Hostel updateHostelBy(Long id, HostelRequest hostelRequest);

    void deleteHostel(Long id);

}
