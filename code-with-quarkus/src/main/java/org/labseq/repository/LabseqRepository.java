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

    public String returnValue (String key) {
        String result = String.valueOf(getValue(key));
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

    public void restartMemory() {
        labseqMemory = new HashMap<>() {{
            put("0", BigInteger.valueOf(0));
            put("1", BigInteger.valueOf(1));
            put("2", BigInteger.valueOf(0));
            put("3", BigInteger.valueOf(1));
        }};
    }

    public void deleteValue(String key) {
        if (labseqMemory.containsKey(key)){
            if (Integer.parseInt(key) < 4 ){
                throw new IllegalArgumentException("Cannot delete the first 4 values");
            }
            labseqMemory.remove(key);
        } else {
            throw new IllegalArgumentException("Key not found");
        }
    }
}
