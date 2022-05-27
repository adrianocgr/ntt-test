package br.com.adriano.nttdatatest.business;

import java.util.List;

public interface LambdaFunctionsBO {
    void md5EncryptRandomStrings();
    List<String> decodePhones();
    List<String> encodePhonesParallel();
}
