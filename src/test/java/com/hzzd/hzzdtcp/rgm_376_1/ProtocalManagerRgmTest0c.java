package com.hzzd.hzzdtcp.rgm_376_1;

import com.hzzd.protocol.protocal3761.BinPacket;
import com.hzzd.protocol.protocal3761.IProtocal;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.ProtocalManagerFactory;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.HashMap;

/**
 * Created by PETER on 2015/3/16.
 */
public class ProtocalManagerRgmTest0c {
    private IProtocal protocalManagerRgm;

    @Before
    public void load() throws Exception {
        protocalManagerRgm = ProtocalManagerFactory.getProtocalManager("rgm_376_1");
        protocalManagerRgm.getCodecConfig().setTerminalAddress("00010001");
    }

    @Test
    public void testDecodeTime() throws Exception {
        String packet = "684a004a0068cb91910400000c64000002000039071743151216";
        ByteBuffer buffor = ByteBuffer.wrap(Hex.decodeHex(packet.toCharArray()));
        Packet rgmPacket = new Packet();
        int result = protocalManagerRgm.decode(buffor, rgmPacket);
        System.out.print(rgmPacket);

    }

    @Test
    public void testEncodeGetMsIP() throws Exception {
        Packet rgmPacket = new Packet("getMsIp",new HashMap<String,Object>());
        BinPacket binPacket=new BinPacket();
        int re=protocalManagerRgm.encode(rgmPacket,binPacket);
        System.out.print(Hex.encodeHex(binPacket.getByteBuffer().array()));

    }

}
