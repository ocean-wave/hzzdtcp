package com.hzzd.protocol.protocal3761.internal.validator;

import java.util.List;

/**
 * Created by PETER on 2015/2/5.
 */
public class Min implements IValidator {
    public boolean check(Object value, List<Double> target) {
        if(Double.parseDouble(value.toString())<target.get(0)){
            return false;
        }else{
            return true;
        }
    }
}
