package com.hzzd.protocol.protocal3761.internal.wrap;

import com.hzzd.protocol.protocal3761.CodecConfig;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.internal.ProtocalTemplate;
import com.hzzd.protocol.protocal3761.internal.packetSegment.Control;
import com.hzzd.protocol.protocal3761.internal.packetSegment.Data;
import com.hzzd.protocol.protocal3761.internal.packetSegment.PacketSegmentContext;
import com.hzzd.protocol.protocal3761.internal.packetSegment.SegmentEnum;

import java.util.List;

/**
 * Created by PETER on 2015/5/5.
 */
public class CipherWrapper extends Wrapper{

    @Override
    void encode(Packet in, PacketSegmentContext packetSegmentContext, ProtocalTemplate protocalTemplate, CodecConfig codecConfig) throws Exception {
        Control control=(Control)packetSegmentContext.getSegment(SegmentEnum.control);
        Data dataSeg=(Data)packetSegmentContext.getSegment(SegmentEnum.data);
        int afn=control.getAfn();

        if(afn==0x04 || afn==0x05){
            List<byte[]> body=dataSeg.getBuffer();
            //加密
            List<byte[]> crypted=body;
            dataSeg.getBuffer().clear();
            dataSeg.getBuffer().addAll(crypted);
        }
        if(next!=null){
            next.encode(in,packetSegmentContext,protocalTemplate,codecConfig);
        }
    }
}
