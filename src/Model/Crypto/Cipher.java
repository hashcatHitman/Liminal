package Model.Crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * A Cipher is capable of encrypting cleartext and decrypting ciphertext, given
 * the cleartext/ciphertext and key.
 * </p>
 *
 * @author Sam K
 * @version 12/9/2024
 */
public interface Cipher {
// Methods

    /**
     * <p>
     * Takes a ciphertext and key and attempts to decrypt the ciphertext.
     * </p>
     *
     * @param ciphertext The ciphertext to decrypt, as an array of bytes.
     * @param key        The key to decrypt the ciphertext with, as an array of
     *                   bytes.
     *
     * @return The resulting cleartext, as an array of bytes.
     *
     * @throws NoSuchPaddingException             When a particular padding
     *                                            mechanism is requested but is
     *                                            not available in the
     *                                            environment.
     * @throws NoSuchAlgorithmException           When a particular
     *                                            cryptographic algorithm is
     *                                            requested but is not available
     *                                            in the environment.
     * @throws InvalidKeyException                When invalid keys are
     *                                            provided.
     * @throws IllegalBlockSizeException          When the length of data
     *                                            provided to a block cipher is
     *                                            incorrect, i. e., does not
     *                                            match the block size of the
     *                                            cipher.
     * @throws BadPaddingException                When a particular padding
     *                                            mechanism is expected for the
     *                                            input data but the data is not
     *                                            padded properly.
     * @throws InvalidAlgorithmParameterException When invalid or inappropriate
     *                                            algorithm parameters are
     *                                            provided.
     */
    byte[] decrypt(byte[] ciphertext, byte[] key)
    throws NoSuchPaddingException, NoSuchAlgorithmException,
           InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
           InvalidAlgorithmParameterException;

    /**
     * <p>
     * Takes a cleartext and key and attempts to encrypt the cleartext.
     * </p>
     *
     * @param cleartext The cleartext to encrypt, as an array of bytes.
     * @param key       The key to encrypt the cleartext with, as an array of
     *                  bytes.
     *
     * @return The resulting ciphertext, as an array of bytes.
     *
     * @throws NoSuchPaddingException             When a particular padding
     *                                            mechanism is requested but is
     *                                            not available in the
     *                                            environment.
     * @throws NoSuchAlgorithmException           When a particular
     *                                            cryptographic algorithm is
     *                                            requested but is not available
     *                                            in the environment.
     * @throws InvalidKeyException                When invalid keys are
     *                                            provided.
     * @throws IllegalBlockSizeException          When the length of data
     *                                            provided to a block cipher is
     *                                            incorrect, i. e., does not
     *                                            match the block size of the
     *                                            cipher.
     * @throws BadPaddingException                When a particular padding
     *                                            mechanism is expected for the
     *                                            input data but the data is not
     *                                            padded properly.
     * @throws InvalidAlgorithmParameterException When invalid or inappropriate
     *                                            algorithm parameters are
     *                                            provided.
     */
    byte[] encrypt(byte[] cleartext, byte[] key)
    throws NoSuchPaddingException, NoSuchAlgorithmException,
           InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
           InvalidAlgorithmParameterException;
}
