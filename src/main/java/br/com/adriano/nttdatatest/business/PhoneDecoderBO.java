package br.com.adriano.nttdatatest.business;

public interface PhoneDecoderBO {

    String decode(String codedPhone);

    String encode(String phoneNumber);
}
