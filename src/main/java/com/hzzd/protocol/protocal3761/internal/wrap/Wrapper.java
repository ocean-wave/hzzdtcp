package com.hzzd.protocol.protocal3761.internal.wrap;

import com.hzzd.protocol.protocal3761.CodecConfig;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.internal.ProtocalTemplate;
import com.hzzd.protocol.protocal3761.internal.packetSegment.PacketSegmentContext;

/**
 * Created by PETER on 2015/3/24.
 */
public abstract class Wrapper {
    protected Wrapper next;
    abstract void encode(Packet in,PacketSegmentContext packetSegmentContext,
                ProtocalTemplate protocalTemplate,CodecConfig codecConfig) throws Exception;

    public void setNext(Wrapper next) {
        this.next = next;
    }
}
