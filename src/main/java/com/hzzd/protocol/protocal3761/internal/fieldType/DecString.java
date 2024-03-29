package com.hzzd.protocol.protocal3761.internal.fieldType;

import com.hzzd.protocol.protocal3761.internal.ConfigParse.FieldTypeParam;

import java.nio.ByteBuffer;

/**
 * Created by PETER on 2015/2/5.
 */
public class DecString implements IFieldType {


    public byte[] encode(final Object value,final FieldTypeParam fieldTypeParam) throws Exception {
        long integerValue=Long.parseLong(value.toString());
        int length=fieldTypeParam.getLength();
        byte[] result=new byte[length];
        for(int i=0;i<length;i++){
            result[i]=(byte)(integerValue>>i*8);
        }
        return result;
    }


    public String decode(final ByteBuffer byteBuffer,final FieldTypeParam fieldTypeParam) throws Exception {
        int length=fieldTypeParam.getLength();
        byte[] value=new byte[length];
        byteBuffer.get(value);
        long integerValue=0;
        for(int i=0;i<length;i++){
            integerValue=integerValue+((value[i]&0xff)<<i*8);
        }
        return String.valueOf(integerValue);
    }


    public void reset() {

    }
}
