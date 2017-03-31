package br.com.houdini.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.SecurityUtils;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Calendar;
import java.util.Collections;

/**
 * Created by FBF0113 on 20/02/2017.
 */
public class BucketStorageUtils {

    private Log log = LogFactory.getLog(BucketStorageUtils.class);

    private Storage storageService;
    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String APPLICATION_NAME = "felipearaujo-houdini";
    private static final String BUCKET_NAME = "felipearaujo-houdini.appspot.com";
    private static final String SERVICE_ACCOUNT_EMAIL = "hudini-storage@felipearaujo-houdini.iam.gserviceaccount.com";
    private PrivateKey key;






    public BucketStorageUtils() {
        try {
            //Busca a chave de autenticacao na instanciação da classe
            key = loadKeyFromPkcs12("notasecret".toCharArray());
        } catch (Exception ex) {
            throw new RuntimeException("Erro - ", ex);
        }
    }





    /**
     * Servico de autenticacao para acesso ao bucket, em qualquer ambiente
     *
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public Storage getStorageService() throws IOException, GeneralSecurityException {

        log.info("[STORAGE] - Autenticacao");

        if (null == storageService) {
            // GoogleCredential credential =
            // GoogleCredential.getApplicationDefault();
            // Depending on the environment that provides the default
            // credentials (e.g. Compute Engine,
            // App Engine), the credentials may require us to specify the scopes
            // we need explicitly.
            // Check for this case, and inject the Cloud Storage scope if
            // required.
            PrivateKey serviceAccountPrivateKey = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), this.getClass().getClassLoader().getResourceAsStream("houdini-storage.p12"), "notasecret", "privatekey", "notasecret");

            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            // Build service account credential.

            GoogleCredential credential = new GoogleCredential.Builder()
                    .setTransport(httpTransport)
                    .setJsonFactory(JSON_FACTORY)
                    .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                    .setServiceAccountScopes(Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL))
                    .setServiceAccountPrivateKey(serviceAccountPrivateKey).build()

                    ;

            if (credential.createScopedRequired()) {
                credential = credential.createScoped(StorageScopes.all());
            }


            storageService = new Storage.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
        }

        return storageService;
    }


    /**
     * Assinatura digital de URL
     *
     * @param verb
     * @param objectName
     * @return
     * @throws Exception
     */
    public String getSigningURL(String verb, String objectName) throws Exception {

        String signed_url = "";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 10000);
        final long expiration = c.getTimeInMillis();

        String url_signature = this.signString(verb + "\n\n\n" + expiration + "\n" + "/" + BUCKET_NAME + "/" + objectName);
        signed_url = "https://storage.googleapis.com/" + BUCKET_NAME + "/" + objectName + "?GoogleAccessId="
                + SERVICE_ACCOUNT_EMAIL + "&Expires=" + expiration + "&Signature="
                + URLEncoder.encode(url_signature, "UTF-8");

        return signed_url;
    }


    /**
     * URL assinada
     *
     * @param stringToSign
     * @return
     * @throws Exception
     */
    private String signString(String stringToSign) throws Exception {

        if (key == null) {
            throw new Exception("PrivateKey error - chave privada nao inicializada");
        }
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(key);
        signer.update(stringToSign.getBytes("UTF-8"));
        byte[] rawSignature = signer.sign();
        return new String(Base64.encodeBase64(rawSignature, false), "UTF-8");
    }


    /**
     * Busca a chave de acesso P12
     *
     * @param password
     * @return
     * @throws Exception
     */
    private PrivateKey loadKeyFromPkcs12(char[] password) throws Exception {

        InputStream fis = this.getClass().getClassLoader().getResourceAsStream("houdini-storage.p12");
        log.info(String.format("Carregando p12 %s", fis));
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(fis, password);
        return (PrivateKey) ks.getKey("privatekey", password);
    }




}
