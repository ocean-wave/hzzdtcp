package com.hzzd.hzzdtcp;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;

import com.google.gson.Gson;
import com.hzzd.protocol.protocal3761.BinPacket;
import com.hzzd.protocol.protocal3761.IProtocal;
import com.hzzd.protocol.protocal3761.Packet;
import com.hzzd.protocol.protocal3761.ProtocalManagerFactory;

public class TestProtocal {
	public static void main(String[] args) throws Exception {
		IProtocal protocalManagerRgm = ProtocalManagerFactory
				.getProtocalManager("rgm_376_1");

		Packet packet = new Packet();
		packet.setTerminalAddress("91910004");
		Map<String, Object> data = new HashMap<String, Object>();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		Map<String, Object> timeData = new HashMap<String, Object>();
		timeData.put("second", calendar.get(Calendar.SECOND));
		timeData.put("minute", calendar.get(Calendar.MINUTE));
		timeData.put("hour", calendar.get(Calendar.HOUR_OF_DAY));
		timeData.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		timeData.put("month", calendar.get(Calendar.MONTH) + 1);
		timeData.put("week", calendar.get(Calendar.DAY_OF_WEEK));
		timeData.put("year", calendar.get(Calendar.YEAR));

		System.out.println(new Gson().toJson(timeData));
		data.put("time", timeData);
		packet.setData(data);
		packet.setCommand("setControlParam3");
		// packet.setCommand("synchronizeTime");
		packet.setLine(1);

		BinPacket outPacket = new BinPacket();
		if (protocalManagerRgm.encode(packet, outPacket) >0)
			System.out.print(Hex.encodeHex(outPacket.getByteBuffer().array()));
		else
			System.out.println("Error");
	}
}