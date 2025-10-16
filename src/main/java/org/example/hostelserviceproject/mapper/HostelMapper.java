package org.example.hostelserviceproject.mapper;

import org.example.hostelserviceproject.dto.request.HostelRequest;
import org.example.hostelserviceproject.dto.response.HostelResponse;
import org.example.hostelserviceproject.entity.Hostel;
import org.springframework.stereotype.Component;

@Component
public class HostelMapper {
    public Hostel requestToEntity(HostelRequest hostelRequest) {
        return Hostel.builder()
                .name(hostelRequest.getName())
                .address(hostelRequest.getAddress())
                .stars(hostelRequest.getStars())
                .build();
    }

    public HostelResponse entityToResponse(Hostel hostel) {
        return HostelResponse.builder()
                .name(hostel.getName())
                .address(hostel.getAddress())
                .stars(hostel.getStars())
                .build();
    }
}
