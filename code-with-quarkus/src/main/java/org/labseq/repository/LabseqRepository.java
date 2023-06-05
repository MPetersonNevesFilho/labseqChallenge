package org.labseq.repository;

import java.util.HashMap;
import java.util.Map;

public class LabseqRepository {
    private Map<String, Long> labseqMemory = new HashMap<>() {{
        put("0", (long) 0);
        put("1", (long) 1);
        put("2", (long) 0);
        put("3", (long) 1);
    }};

    public LabseqRepository() {
    }


    public Long getValue(String key) {
        if (!labseqMemory.containsKey(key)) {
            labseqMemory.put(key, calculateValue(key));
        }
        return labseqMemory.get(key);
    }

    private Long calculateValue(String key) {
        Long nMinusFour = getValue(String.valueOf(Long.parseLong(key)-4));
        Long nMinusThree = getValue(String.valueOf(Long.parseLong(key)-3));
        return nMinusFour + nMinusThree;
    }

}
