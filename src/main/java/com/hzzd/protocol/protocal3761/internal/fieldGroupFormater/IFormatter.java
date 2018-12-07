package com.hzzd.protocol.protocal3761.internal.fieldGroupFormater;

import java.util.Map;

/**
 * Created by PETER on 2015/3/24.
 */
public interface IFormatter {
    String union(String pattern,Map<String,Object> value);
    Map<String,Object> division(String pattern,String value);
}
