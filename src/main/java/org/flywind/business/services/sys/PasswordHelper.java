package org.flywind.business.services.sys;

import org.flywind.business.entities.sys.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordHelper {


    @Value("md5")
    private String algorithmName = "md5";
    
    @Value("2")
    private int hashIterations = 2;

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

        //user.setSalt(randomNumberGenerator.nextBytes().toHex());

        /*String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();*/

        //user.setPassword(newPassword);
    }
}
