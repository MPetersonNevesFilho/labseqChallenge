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
    private Integer requestN = 0;



    public LabseqRepository() {
    }

    public BigInteger returnValue (String key) {
        requestN = Integer.parseInt(key);
        BigInteger result = getValue(key);
        //System.out.println(labseqMemory);
        return result;
    }

    public BigInteger getValue(String key) {
        while (!labseqMemory.containsKey(key)) {
            labseqMemory.put(key, calculateValue(key));
        }
        return labseqMemory.get(key);
    }

    private BigInteger calculateValue(String key) {
        return getValue(
            String.valueOf(
                Long.parseLong(key)-4
                )
            ).add(
                getValue(
                    String.valueOf(
                        Long.parseLong(key)-3
                        )
                    )
                );
    }

}
