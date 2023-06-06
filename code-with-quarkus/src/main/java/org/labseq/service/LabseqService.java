package org.labseq.service;

import java.math.BigInteger;

import org.labseq.repository.LabseqRepository;

public class LabseqService {

    private LabseqRepository labseqRepository = new LabseqRepository();

    public String getValue(String key) {
        return labseqRepository.returnValue(key);
    }

    public void deleteValue(String key) {
        labseqRepository.deleteValue(key);
    }

    public void restartMemory() {
        labseqRepository.restartMemory();
    }

}
