package org.labseq.repository;

import java.util.HashMap;
import java.util.Map;

public class LabseqRepository {
    private Map<String, Integer> labseqMemory = new HashMap<>() {{
        put("0", 0);
        put("1", 1);
        put("2", 0);
        put("3", 1);
    }};


    public Integer getValue(String key) {
        if (!labseqMemory.containsKey(key)) {
            labseqMemory.put(key, calculateValue(key));
        }
        return labseqMemory.get(key);
    }

    private Integer calculateValue(String key) {
        Integer nMinusFour = getValue(String.valueOf(Integer.parseInt(key)-4));
        Integer nMinusThree = getValue(String.valueOf(Integer.parseInt(key)-3));
        return nMinusFour + nMinusThree;
    }

}
