package com.hzzd.hzzdtcp.fieldType.base;

import com.hzzd.protocol.protocal3761.internal.ConfigParse.FieldTypeParam;
import com.hzzd.protocol.protocal3761.internal.fieldType.Dt;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by PETER on 2015/3/4.
 */
public class DtTest {
    Dt dt=new Dt();
    @Test
    public void testEncode() throws Exception {


    }
    @Test
    public void testDecode() throws Exception {
        byte[] a=new byte[]{(byte) 01,0};
        ByteBuffer byteBuffer=ByteBuffer.wrap(a);
        System.out.print(dt.decode(byteBuffer, new FieldTypeParam()));

    }
}
