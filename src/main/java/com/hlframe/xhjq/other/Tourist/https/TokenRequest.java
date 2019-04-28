package com.hlframe.xhjq.other.Tourist.https;

import com.hlframe.xhjq.utils.EncodeUtils;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-08 20:14
 */

public class TokenRequest {
    private String userName ;
    private String passwordDigest ;
    private String nonce ;
    private String created ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return  userName+" Username='" + userName + '\'' +
                ", PasswordDigest='" + EncodeUtils.Base64AndShaEncoder(nonce+created+passwordDigest) + '\'' +
                ", Nonce='" + nonce + '\'' +
                ", Created='" + created + '\''
                ;
    }

}

