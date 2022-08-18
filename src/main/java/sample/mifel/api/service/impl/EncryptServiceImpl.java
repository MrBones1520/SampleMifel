package sample.mifel.api.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import sample.mifel.api.request.CipherRequest;
import sample.mifel.api.response.CipherResponse;
import sample.mifel.api.service.EncryptService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Service
public class EncryptServiceImpl implements EncryptService {

    @Value("${cipher_transformation}")
    String cipherTransformation;
    @Value("${key_salt}")
    String salt;

    @Value("${key_algorithm}")
    String keyAlgorithm;

    @Value("${cipher_separator:;}")
    String separator;

    final IvParameterSpec ivParameter = generateIv();

    @Override
    public CipherResponse encrypt(String txt, String publicSecretKey, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException {
       Cipher cipher = Cipher.getInstance(cipherTransformation);
       SecretKey secretKey = getKeyFromPassword(publicSecretKey);

       cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
       byte[] crypt = cipher.doFinal(txt.getBytes(StandardCharsets.UTF_8));

       CipherResponse response = CipherResponse.createInstance();
       response.setCipherMessage(Base64.encodeBase64String(crypt) + separator + Base64.encodeBase64String(iv.getIV()));
       response.setPublicKey(publicSecretKey);
       return response;
    }

    @Override
    public CipherResponse encrypt(CipherRequest request)
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        return encrypt(request.getOriginalMessage(), request.getPublicKey(), ivParameter);
    }

    @Override
    public CipherResponse decrypt(CipherRequest request)
            throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        IvParameterSpec iv = request.getCipherMessage().contains(separator) ?
                new IvParameterSpec(Base64.decodeBase64(request.getCipherMessage().split(separator)[1])) :
                ivParameter;
        return decrypt(request.getCipherMessage(), request.getPublicKey(), iv);
    }

    @Override
    public CipherResponse decrypt(String encryptMessage, String publicSecrectKey, IvParameterSpec iv)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKey secretKey = getKeyFromPassword(publicSecrectKey);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] decrypt = cipher.doFinal(Base64.decodeBase64(encryptMessage));

        CipherResponse response = CipherResponse.createInstance();
        response.setOriginalMessage(new String(decrypt));
        response.setPublicKey(publicSecrectKey);

        return response;
    }

    /* Encryption Method */

    final IvParameterSpec generateIv(){
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    final SecretKey getKeyFromPassword(String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(keyAlgorithm);
        KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt.getBytes(), 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }


}
