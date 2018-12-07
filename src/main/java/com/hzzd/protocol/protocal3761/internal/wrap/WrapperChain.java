package com.hzzd.protocol.protocal3761.internal.wrap;

import com.hzzd.protocol.protocal3761.CodecConfig;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.internal.ProtocalTemplate;
import com.hzzd.protocol.protocal3761.internal.packetSegment.PacketSegmentContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by PETER on 2015/3/24.
 */
public class WrapperChain {
    List<Wrapper> wrappers=new ArrayList<Wrapper>();

    public void add(Wrapper wrapper){
        if(wrappers.size()>0){
            Wrapper pre=wrappers.get(wrappers.size()-1);
            pre.setNext(wrapper);
        }
        wrappers.add(wrapper);
    }

    public void encode(Packet in,PacketSegmentContext packetSegmentContext,
                       ProtocalTemplate protocalTemplate,CodecConfig codecConfig) throws Exception{
        if(wrappers.size()>0){
            wrappers.get(0).encode(in,packetSegmentContext,protocalTemplate,codecConfig);
        }
    }
}
