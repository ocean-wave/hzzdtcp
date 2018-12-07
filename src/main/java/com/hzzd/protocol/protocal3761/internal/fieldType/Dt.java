package com.hzzd.protocol.protocal3761.internal.fieldType;


import com.hzzd.protocol.protocal3761.internal.ConfigParse.FieldTypeParam;

import java.nio.ByteBuffer;

/**
 * Created by PETER on 2015/2/5.
 */
public class Dt implements IFieldType {

    public byte[] encode(final Object value,final FieldTypeParam fieldTypeParam) throws Exception {
        byte[] out=new byte[2];
        int fn=Integer.parseInt(value.toString());
        out[0]=(byte)(1 << (fn-1) % 8);
        out[1]=(byte)((fn-1) / 8);
        return out;
    }


    public Integer decode(final ByteBuffer byteBuffer,final FieldTypeParam fieldTypeParam) throws Exception {
        byte[] value=new byte[2];
        byteBuffer.get(value);
        int fn=value[1]*8;

        for(int i=0;i<8;i++){
            if(((value[0]&0xff)>>i)==1){
                fn+=i+1;
            }
        }
        return fn;
    }


    public void reset() {

    }
}
