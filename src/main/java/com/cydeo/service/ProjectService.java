package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String code);

    void complete(String projectcode);

    List<ProjectDTO> listAllProjectDetails();


}
