package org.labseq.service;

import java.math.BigInteger;

import org.labseq.repository.LabseqRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    private LabseqRepository labseqRepository = new LabseqRepository();

    public BigInteger getValue(String key) {
        return labseqRepository.getValue(key);
    }

}
