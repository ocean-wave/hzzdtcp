package com.hzzd.protocol.protocal3761;

import com.hzzd.protocol.protocal3761.internal.ProtocalImpl;
import com.hzzd.protocol.protocal3761.internal.ProtocalTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by peter on 2015-1-13.
 */
public class ProtocalManagerFactory {
    //private static final Map<String,ProtocalTemplate> templateCache=new ConcurrentHashMap<>();
    private static final Map<String,ProtocalTemplate> templateCache=new ConcurrentHashMap<String, ProtocalTemplate>();

    public static IProtocal getProtocalManager(String protocalName,CodecConfig codecConfig) throws Exception{
    	return new ProtocalImpl(getProtocalTemplate(protocalName),codecConfig);
    }

    public static IProtocal getProtocalManager(String protocalName) throws Exception{
        return new ProtocalImpl(getProtocalTemplate(protocalName));
    }

    private static ProtocalTemplate getProtocalTemplate(String protocalName) throws Exception{
        ProtocalTemplate protocalTemplate=templateCache.get(protocalName);
        if(protocalTemplate==null){
            protocalTemplate=new ProtocalTemplate();
            protocalTemplate.loadConfig(protocalName);
        }
        return protocalTemplate;
    }



}
