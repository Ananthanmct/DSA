package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.OrgDetailDto;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrgService {

    @Autowired
    DbApiIntgeration dbapiIntg;

    public Object createOrganization(OrgDetailDto orgDetailDto){
        // OrgDetailDTO
        // We need to map these details to actual organization model object.

        Organization organization = new Organization();
        organization.setName(orgDetailDto.getName());
        organization.setRegisteredName(orgDetailDto.getRegisteredName());
        organization.setAdminEmail(orgDetailDto.getAdminEmail());
        organization.setAdminName(orgDetailDto.getAdminName());
        organization.setPassword(orgDetailDto.getPassword());
        organization.setWebsiteUrl(orgDetailDto.getWebsiteUrl());
        organization.setAddress(orgDetailDto.getAddress());
        organization.setCompanySize(organization.getCompanySize());
        organization.setCreatedAt(LocalDateTime.now());
        organization.setUpdatedAt(LocalDateTime.now());
        // We need to call database-api create organization endpoint
        // That endpoint will save organization details in database.
        return dbapiIntg.callCreateOrganizationEndpoint(organization);
    }
}
