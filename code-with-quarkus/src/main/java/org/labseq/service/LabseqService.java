package org.labseq.service;

import java.math.BigInteger;

import org.labseq.repository.LabseqRepository;

public class LabseqService {

    private LabseqRepository labseqRepository = new LabseqRepository();

    public BigInteger getValue(String key) {
        return labseqRepository.returnValue(key);
    }

}
