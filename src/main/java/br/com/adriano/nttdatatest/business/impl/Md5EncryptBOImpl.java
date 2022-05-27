package br.com.adriano.nttdatatest.business.impl;

import br.com.adriano.nttdatatest.business.Md5EncryptBO;
import br.com.adriano.nttdatatest.exception.Md5EncondeRuntimeException;

import java.security.MessageDigest;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Md5EncryptBOImpl implements Md5EncryptBO {

    private static final int DEFAULT_INT = 0xff;

    public String encrypt(String value){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(value.getBytes("UTF-8"));

            Stream<String> hex = IntStream.range(0, hash.length)
                    .map(e -> hash[e])
                    .mapToObj(h -> Integer.toHexString(DEFAULT_INT & h));

            return hex.map(h -> h.length() == 1 ? h + "0" : h).collect(Collectors.joining());

        } catch (Exception e) {
            throw new Md5EncondeRuntimeException("A failure occurred while encrypt. Reason: " + e.getMessage());
        }
    }
}
