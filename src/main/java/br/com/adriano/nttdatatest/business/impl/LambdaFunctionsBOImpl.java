package br.com.adriano.nttdatatest.business.impl;

import br.com.adriano.nttdatatest.business.LambdaFunctionsBO;
import br.com.adriano.nttdatatest.business.Md5EncryptBO;
import br.com.adriano.nttdatatest.business.PhoneDecoderBO;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaFunctionsBOImpl implements LambdaFunctionsBO {

    public void md5EncryptRandomStrings(){
        Md5EncryptBO md5EncryptBO = new Md5EncryptBOImpl();
        Stream<String> random = IntStream.range(0,10).mapToObj(value -> generateRandomString());
        random.map(value -> md5EncryptBO.encrypt(value)).forEach(System.out::println);
    }

    public List<String> decodePhones(){
        PhoneDecoderBO phoneDecoderBO = new PhoneDecoderBOImpl();
        List<String> phonesCoded = Arrays.asList("OTkyMzc4NTc4", "OTMyMzc4NTcy", "ODg0MjMwMDIw");

        return phonesCoded.stream().map(phone -> phoneDecoderBO.decode(phone)).collect(Collectors.toList());
    }

    public List<String> encodePhonesParallel(){
        PhoneDecoderBO phoneDecoderBO = new PhoneDecoderBOImpl();
        List<String> phonesDecoded = Arrays.asList("984230020", "98423000", "101111158", "101111168");

        return phonesDecoded.stream().parallel().map(phone -> phoneDecoderBO.encode(phone)).collect(Collectors.toList());
    }



    private String generateRandomString(){
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}
