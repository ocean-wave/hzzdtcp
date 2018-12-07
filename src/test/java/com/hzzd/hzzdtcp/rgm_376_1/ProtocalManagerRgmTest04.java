package com.hzzd.hzzdtcp.rgm_376_1;

import com.hzzd.protocol.protocal3761.BinPacket;
import com.hzzd.protocol.protocal3761.IProtocal;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.ProtocalManagerFactory;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2015-04-14.
 */
public class ProtocalManagerRgmTest04 {
    private IProtocal protocalManagerRgm;
    @Before
    public void load() throws Exception{
        protocalManagerRgm= ProtocalManagerFactory.getProtocalManager("rgm_376_1");
    }
    @Test
    public void testp1() throws Exception {
        Packet rgmPacket=new Packet();
        Map<String,Object> dMap = new HashMap<String,Object>();
        dMap.put("reSwitchOn", "1");
        dMap.put("gearReturn", "1");
        dMap.put("timingSwitch", "1");
        dMap.put("alertSound", "1");
        dMap.put("alertLight", "1");
        dMap.put("dataAlert", "1");
        rgmPacket.setLine(2);
        rgmPacket.setCommand("setControlParam1");
        rgmPacket.setTerminalAddress("00010001");
        rgmPacket.setData(dMap);
        BinPacket binPacket=new BinPacket();
        protocalManagerRgm.encode(rgmPacket,binPacket);
        System.out.print(Hex.encodeHex(binPacket.getByteBuffer().array()));
    }
}
