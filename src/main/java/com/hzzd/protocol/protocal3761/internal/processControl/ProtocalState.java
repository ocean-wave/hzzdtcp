package com.hzzd.protocol.protocal3761.internal.processControl;

/**
 * Created by PETER on 2015/3/27.
 */
public interface ProtocalState {
    String START="start";
    String WAIT_NEXT_DECODE="waitNextDecode";
    String WAIT_RESPONSE="waitResponse";
    String IDLE="idle";
}
