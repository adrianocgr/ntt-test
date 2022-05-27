package br.com.adriano.nttdatatest.business.impl;

import br.com.adriano.nttdatatest.business.PhoneDecoderBO;
import br.com.adriano.nttdatatest.exception.StringNullRuntimeException;
import org.codehaus.plexus.util.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class PhoneDecoderBOImpl implements PhoneDecoderBO {

    public String decode(String codedPhone){
        byte[] encodedBytes = getBytes(Optional.ofNullable(codedPhone));
        return new String(Base64.decodeBase64(encodedBytes));
    }

    public String encode(String phoneNumber){
        byte[] phoneBytes = getBytes(Optional.of(phoneNumber));
        return new String(Base64.encodeBase64(phoneBytes));
    }

    private byte[] getBytes(Optional<String> value){
        if(!value.isPresent())
            throw new StringNullRuntimeException("Value is null.");

        return value.get().getBytes(StandardCharsets.UTF_8);
    }
}


