package by.training.webapplication.util;

import by.training.webapplication.service.exception.LogicException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;
/**
 * Created by Tanya on 24.07.2016.
 */
public class MD5 {

    public String getHash(String str) throws LogicException {
        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();
        try{
            md5 = MessageDigest.getInstance("md5");
            md5.reset();
            md5.update(str.getBytes());
            byte messageDigest[] = md5.digest();
            for(int i = 0; i < messageDigest.length; i++){
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        }catch (NoSuchAlgorithmException e){
            LOGGER.error(e);
            throw new LogicException(e);
        }
        return hexString.toString();
    }
}
