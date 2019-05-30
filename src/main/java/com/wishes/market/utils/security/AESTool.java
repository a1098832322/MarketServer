package com.wishes.market.utils.security;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Hex;

/**
 * AES encryption and decryption tool.
 *
 * @author Joshua zhong
 */
public class AESTool {

    private static byte[] initVector = {0x32, 0x37, 0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x38, 0x27, 0x36, 0x35, 0x33, 0x23, 0x32, 0x31};


    /**
     * Encrypt the content with a given key using aes algorithm.
     *
     * @param key must contain exactly 32 characters
     */
    public static String encrypt(String content, String key) throws Exception {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        String encrypted = null;
        byte[] keyBytes = key.getBytes();
        byte[] encryptedBytes = null;
        encryptedBytes = encrypt(content.getBytes("UTF-8"), keyBytes, initVector);
        encrypted = new String(Hex.encode(encryptedBytes));
        return encrypted;
    }

    /**
     * Decrypt the content with a given key using aes algorithm.
     *
     * @param key must contain exactly 32 characters
     */
    public static String decrypt(String content, String key) throws Exception {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        String decrypted = null;
        byte[] encryptedContent = Hex.decode(content);
        byte[] keyBytes = key.getBytes();
        byte[] decryptedBytes = null;
        decryptedBytes = decrypt(encryptedContent, keyBytes, initVector);
        decrypted = new String(decryptedBytes, "UTF-8");
        return decrypted;
    }

    /**
     * Encrypt data.
     */
    public static byte[] encrypt(byte[] plain, byte[] key, byte[] iv) throws Exception {
        PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(
                new CBCBlockCipher(new AESFastEngine()));
        CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key),
                iv);
        aes.init(true, ivAndKey);
        return cipherData(aes, plain);
    }

    /**
     * Decrypt data.
     */
    public static byte[] decrypt(byte[] cipher, byte[] key, byte[] iv)
            throws Exception {
        PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(
                new CBCBlockCipher(new AESFastEngine()));
        CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key),
                iv);
        aes.init(false, ivAndKey);
        return cipherData(aes, cipher);
    }

    /**
     * Encrypt or decrypt data.
     */
    private static byte[] cipherData(PaddedBufferedBlockCipher cipher, byte[] data) throws Exception {
        int minSize = cipher.getOutputSize(data.length);
        byte[] outBuf = new byte[minSize];
        int length1 = cipher.processBytes(data, 0, data.length, outBuf, 0);
        int length2 = cipher.doFinal(outBuf, length1);
        int actualLength = length1 + length2;
        byte[] result = new byte[actualLength];
        System.arraycopy(outBuf, 0, result, 0, result.length);
        return result;
    }

    public static void main(String[] args) throws Exception {
        AESTool aesTool = new AESTool();
        String key = "a368ec459659f4f4a4747cc674b94447";
        String json = "9b37df42f57f538014b4d40c4c2b263120d4a9c40040f66b98958df4418ab7d5fc2e010daeafc68353672a989dce84f6141392c5ce029e292bf8a46070d8b94e4b7fd91877e524f390492d1120cfb315e52aa4a3acc738dfbbe0849213d5ae3e8a8518ab14b730ce12f9975530c86bafd2ee912aa2543d43311af69b487b91017b487effc8d122b4cf37f2c4fd104c392f65d1b317cc47fb987d0dec86c4c8c992664ceb37d39f623bc9875c544f43fd75e34be3a0bfa9e705ca8c746ba969fd3ce7f0b979659fb4e3f1496a4d5bcfe8f1f4cc6874536fabeff6fd0d4440247116c41c721a18f840f8af22ab19d2052c";
        System.out.println(aesTool.decrypt(json, key));
    }
}  