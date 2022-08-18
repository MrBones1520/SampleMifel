package org.example.api.controllers;

import org.example.api.request.CipherRequest;
import org.example.api.response.CipherResponse;
import org.example.api.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api/crypto")
public class CipherController {

    final EncryptService encryptService;

    @Autowired
    public CipherController(EncryptService encryptService) {
        this.encryptService = encryptService;
    }

    @PostMapping("/encrypt")
    @ResponseStatus(HttpStatus.OK)
    public CipherResponse encrypt(@RequestBody CipherRequest request)
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        return encryptService.encrypt(request);
    }

    @PostMapping("/decrypt")
    @ResponseStatus(HttpStatus.OK)
    public CipherResponse decrypt(@RequestBody CipherRequest request)
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        return encryptService.decrypt(request);
    }


}
