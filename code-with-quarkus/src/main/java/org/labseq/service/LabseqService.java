package org.labseq.service;

import org.labseq.repository.LabseqRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    private LabseqRepository labseqRepository = new LabseqRepository();

    public Long getValue(String key) {
        return labseqRepository.getValue(key);
    }

}
