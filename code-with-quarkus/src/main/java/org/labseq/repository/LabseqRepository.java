package org.labseq.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LabseqRepository {

    /*
     * The implementation removes temporal complexity and adds spatial complexity,
     * being necessary to save several values to reduce the logical tree of the recursion.
    */

    // HashMap memory
    private Map<String, BigInteger> labseqMemory = new HashMap<>() {{
        put("0", BigInteger.valueOf(0));
        put("1", BigInteger.valueOf(1));
        put("2", BigInteger.valueOf(0));
        put("3", BigInteger.valueOf(1));
    }};

    // Constructor
    public LabseqRepository() {
    }

    // Return value from HashMap memory
    public String returnValue (String key) {
        String result = String.valueOf(getValue(key));
        //System.out.println(labseqMemory);
        return result;
    }

    // Get value from HashMap memory and save it if it doesn't exist
    public BigInteger getValue(String key) {
        while (!labseqMemory.containsKey(key)) {
            labseqMemory.put(key, calculateValue(key));
        }
        return labseqMemory.get(key);
    }

    // Calculate a new value from HashMap memory
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

    // Reset HashMap memory
    public void restartMemory() {
        labseqMemory = new HashMap<>() {{
            put("0", BigInteger.valueOf(0));
            put("1", BigInteger.valueOf(1));
            put("2", BigInteger.valueOf(0));
            put("3", BigInteger.valueOf(1));
        }};
    }

    // Delete a value from HashMap memory
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
