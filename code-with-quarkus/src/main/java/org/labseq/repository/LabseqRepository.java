package org.labseq.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LabseqRepository {
    private Map<String, BigInteger> labseqMemory = new HashMap<>() {{
        put("0", BigInteger.valueOf(0));
        put("1", BigInteger.valueOf(1));
        put("2", BigInteger.valueOf(0));
        put("3", BigInteger.valueOf(1));
    }};


    public LabseqRepository() {
    }


    public BigInteger getValue(String key) {
        while (!labseqMemory.containsKey(key)) {
            labseqMemory.put(key, calculateValue(key));
            //System.out.println("labseqMemory: " + labseqMemory);
        }
        return labseqMemory.get(key);
    }

    private BigInteger calculateValue(String key) {
        BigInteger nMinusFour = getValue(String.valueOf(Long.parseLong(key)-4));
        BigInteger nMinusThree = getValue(String.valueOf(Long.parseLong(key)-3));
        return nMinusFour.add(nMinusThree);
    }

}
