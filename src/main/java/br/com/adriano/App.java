package br.com.adriano;

import br.com.adriano.nttdatatest.business.LambdaFunctionsBO;
import br.com.adriano.nttdatatest.business.Md5EncryptBO;
import br.com.adriano.nttdatatest.business.PhoneDecoderBO;
import br.com.adriano.nttdatatest.business.impl.LambdaFunctionsBOImpl;
import br.com.adriano.nttdatatest.business.impl.Md5EncryptBOImpl;
import br.com.adriano.nttdatatest.business.impl.PhoneDecoderBOImpl;

public class App {

    public static void main(String[] args) {
        System.out.println("1 - Write a Java program that returns an MD5 hash");
        execMd5Encrypt();

        System.out.println("2 - Write three Java lambda expressions");
        execLambdaFunctions();

        System.out.println("3 - Write a phone number word decoder");
        execDecodePhoneNumber();
    }

    private static void execMd5Encrypt(){
        Md5EncryptBO md5EncryptBO = new Md5EncryptBOImpl();
        System.out.println(md5EncryptBO.encrypt("NTTDATA-TEST-ADRIANO"));
    }

    private static void execLambdaFunctions(){
        LambdaFunctionsBO lambdaFunctionsBO = new LambdaFunctionsBOImpl();

        System.out.println("Using IntStream");
        lambdaFunctionsBO.md5EncryptRandomStrings();

        System.out.println("Using Stream");
        lambdaFunctionsBO.decodePhones().stream().forEach(System.out::println);

        System.out.println("Using Stream with parallel");
        lambdaFunctionsBO.encodePhonesParallel().stream().forEach(System.out::println);

    }

    private static void execDecodePhoneNumber(){
        PhoneDecoderBO phoneDecoderBO = new PhoneDecoderBOImpl();
        String myPhone = "67-98423-0020";
        String result = String.format("Phone %s encoded is %s", myPhone, phoneDecoderBO.encode(myPhone));
        System.out.println(result);

    }

}
