package com.eshop.common.utils;


import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.jce.provider.JCEBlockCipher;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;

public class Z3DESCipher extends JCEBlockCipher {
    public Z3DESCipher() {
        super(new DESedeEngine());
    }

    public void init(int mode, Key key) {
        try {
            this.engineInit(mode, key, new SecureRandom());
        } catch (InvalidKeyException arg3) {
            arg3.printStackTrace();
        }

    }

    public byte[] doFinal(byte[] str) throws Exception {
        return this.engineDoFinal(str, 0, str.length);
    }
}
