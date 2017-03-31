package br.com.houdini.service;

import br.com.houdini.beans.Galeria;
import br.com.houdini.beans.ImagemGaleria;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.SecurityUtils;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import com.google.appengine.tools.cloudstorage.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gmr.web.multipart.GMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.*;

/**
 * Created by FBF0113 on 14/02/2017.
 */
public class StorageService {

    private Log log = LogFactory.getLog(StorageService.class);

    private Storage storageService;

    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String APPLICATION_NAME = "felipearaujo-houdini";
    private static final String BUCKET_NAME = "felipearaujo-houdini.appspot.com";
    private static final String SERVICE_ACCOUNT_EMAIL = "hudini-storage@felipearaujo-houdini.iam.gserviceaccount.com";

    private static List<StorageObject> OBJETOS = new ArrayList<>();
    private static final String FOTO_CAPA = "capa.jpg";


    private PrivateKey key;


//    public StorageService() {
//        try {
//
//            //Busca a chave de autenticacao
//            key = loadKeyFromPkcs12("notasecret".toCharArray());
//
//            //Já busca todos os objetos do storage na construcao da classe
//            OBJETOS = listarObjetosStorage();
//
//        } catch (Exception ex) {
//            throw new RuntimeException("Erro - ", ex);
//        }
//    }
//
//
//    /**
//     * Lista todos os objetos do storage
//     *
//     * @return
//     * @throws Exception
//     */
//    private List<StorageObject> listarObjetosStorage() throws Exception {
//        List<StorageObject> objetos = new ArrayList<>();
//        Storage.Objects.List listObjects = getStorageService().objects().list(BUCKET_NAME );
//        Objects objects;
//        do {
//            objects = listObjects.execute();
//            for (StorageObject object : objects.getItems()) {
//                objetos.add(object);
//            }
//            listObjects.setPageToken(objects.getNextPageToken());
//        } while (null != objects.getNextPageToken());
//        return objetos;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    /**
//     * Lista as galerias com as fotos
//     *
//     * @return
//     * @throws Exception
//     */
//    public List<Galeria> listarGalerias() throws Exception {
//
//        List<Galeria> galerias = new ArrayList<>();
//
//        List<String> pastasStorage = listarPastas();
//
//        for (  String pasta : pastasStorage  ) {
//
//            Galeria galeria = new Galeria();
//            galeria.setNomeGaleria(pasta);
//
//            List<ImagemGaleria> fotos = popularGaleria(galeria);
//            List<ImagemGaleria> fotosRemover = new ArrayList<>();
//
//            for (ImagemGaleria foto : fotos) {
//
//                if (  foto.getNomeArquivo().equals(FOTO_CAPA)   ) {
//                    galeria.setImagemThumbnail(foto);
//                    fotosRemover.add(foto);
//                    break;
//                }
//
//            }
//
//            fotos.removeAll(fotosRemover);
//            galeria.setImagens(fotos);
//            galerias.add(galeria);
//        }
//
//        return galerias;
//    }
//
//
//
//
//
//
//    /**
//     * Lista toda as fotos de uma determinada galeria
//     *
//     * @param
//     * @return
//     * @throws Exception
//     */
//    private List<ImagemGaleria> popularGaleria(Galeria galeria) throws Exception {
//
//        List<ImagemGaleria> fotos = new ArrayList<>();
//
//        List<StorageObject> objetos  = OBJETOS;
//
//        for (  StorageObject obj : objetos  ) {
//
//            if (  ! obj.getName().contains("galeria/"+galeria.getNomeGaleria()+"/")  ) {
//                continue;
//            }
//
//
//            //Pega a parte "texto" do arquivo
//            if ( obj.getContentType().equals("text/plain") ) {
//
//                System.out.print("é texto!");
//
//                String line;
//
//                try {
//                    String urlArquivo = getSigningURL("GET", obj.getName());
//
//                    URL url = new URL(urlArquivo);
//                    InputStream fis = url.openStream();
//                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
//                    BufferedReader br = new BufferedReader(isr);
//
//
//                    List<String> linhas = new ArrayList<>();
//
//                    while ((line = br.readLine()) != null) {
//                        linhas.add(line);
//                    }
//
//                    galeria.setTituloThumbnail(linhas.get(0));
//                    galeria.setTituloModal(linhas.get(1));
//                    galeria.setSubtituloModal(linhas.get(2));
//
//                    StringBuilder textoModal = new StringBuilder();
//
//                    for ( int i = 3; i < linhas.size(); i++ ) {
//                        textoModal.append(linhas.get(i));
//                    }
//
//                    galeria.setTextoModal(textoModal.toString());
//
//                } catch(Exception e) {
//                    throw new RuntimeException(e);
//                }
//
//                continue;//volta ao loop do for, para não setar o texto na galeria de fotos
//            }
//
//
//            ImagemGaleria foto = new ImagemGaleria();
//            String nomeFoto = obj.getName().substring( obj.getName().lastIndexOf("/") + 1 , obj.getName().length());
//            foto.setNomeArquivo(nomeFoto);
//            foto.setUrl(  getSigningURL("GET", obj.getName())  );
//
//            fotos.add(foto);
//
//        }
//
//        return fotos;
//
//    }
//
//
//
//
//
//    /**
//     * Lista todas as pastas da galeria
//     *
//     * @return
//     * @throws Exception
//     */
//    private List<String> listarPastas() throws Exception {
//
//        Set<String> pastas = new LinkedHashSet<>();
//        List<StorageObject> objetos  = OBJETOS;
//        for (  StorageObject obj : objetos  ) {
//            String pasta = obj.getName();
//            if (  ! obj.getName().equals("galeria/") && obj.getName().startsWith("galeria/") ) {
//                pasta = pasta.substring( pasta.indexOf("/") + 1 ,  pasta.lastIndexOf("/") );
//                pastas.add(pasta);
//            }
//        }
//        List<String> retorno = new ArrayList<>();
//        retorno.addAll(pastas);
//        return retorno;
//    }
//
//
//
//
//
//
//    /************************
//     *
//     * 		UPLOAD
//     *
//     * **********************
//     */
//    public void upload(MultipartFile multipartFile) throws IOException, GeneralSecurityException {
//
//        //Prepara o arquivo para ser enviado inputsream
//        InputStream stream = new ByteArrayInputStream(multipartFile.getBytes());
//        InputStreamContent contentStream = new InputStreamContent(multipartFile.getContentType(), stream);
//
//        FileItem fileItem = ((GMultipartFile) multipartFile).getFileItem();
//
//        //Onde será gravado o arquivo
//        StorageObject objectMetaData = new StorageObject().setName("teste/"+fileItem.getName());
//
//        //Chama o serviço do Storage para fazer o upload
//        Storage client = getStorageService();
//        Storage.Objects.Insert inserRequest = client.objects().insert(BUCKET_NAME, objectMetaData, contentStream);
//        inserRequest.execute();
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    /************************
//     *
//     * 		AUTENTICACAO
//     *
//     * **********************
//     */
//
//
//    /**
//     * Servico de autenticacao para acesso ao bucket, em qualquer ambiente
//     *
//     * @return
//     * @throws IOException
//     * @throws GeneralSecurityException
//     */
//    private Storage getStorageService() throws IOException, GeneralSecurityException {
//
//        log.info("[STORAGE] - Autenticacao");
//
//        if (null == storageService) {
//            // GoogleCredential credential =
//            // GoogleCredential.getApplicationDefault();
//            // Depending on the environment that provides the default
//            // credentials (e.g. Compute Engine,
//            // App Engine), the credentials may require us to specify the scopes
//            // we need explicitly.
//            // Check for this case, and inject the Cloud Storage scope if
//            // required.
//            PrivateKey serviceAccountPrivateKey = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), this.getClass().getClassLoader().getResourceAsStream("houdini-storage.p12"), "notasecret", "privatekey", "notasecret");
//
//            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//            // Build service account credential.
//
//            GoogleCredential credential = new GoogleCredential.Builder()
//                    .setTransport(httpTransport)
//                    .setJsonFactory(JSON_FACTORY)
//                    .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
//                    .setServiceAccountScopes(Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL))
//                    .setServiceAccountPrivateKey(serviceAccountPrivateKey).build()
//
//                    ;
//
//            if (credential.createScopedRequired()) {
//                credential = credential.createScoped(StorageScopes.all());
//            }
//
//
//            storageService = new Storage.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
//        }
//
//        return storageService;
//    }
//
//
//    /**
//     * Assinatura digital de URL
//     *
//     * @param verb
//     * @param objectName
//     * @return
//     * @throws Exception
//     */
//    private String getSigningURL(String verb, String objectName) throws Exception {
//
//        String signed_url = "";
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.YEAR, 10000);
//        final long expiration = c.getTimeInMillis();
//
//        String url_signature = this.signString(verb + "\n\n\n" + expiration + "\n" + "/" + BUCKET_NAME + "/" + objectName);
//        signed_url = "https://storage.googleapis.com/" + BUCKET_NAME + "/" + objectName + "?GoogleAccessId="
//                + SERVICE_ACCOUNT_EMAIL + "&Expires=" + expiration + "&Signature="
//                + URLEncoder.encode(url_signature, "UTF-8");
//
//        return signed_url;
//    }
//
//
//    /**
//     * URL assinada
//     *
//     * @param stringToSign
//     * @return
//     * @throws Exception
//     */
//    private String signString(String stringToSign) throws Exception {
//
//        if (key == null) {
//            throw new Exception("PrivateKey error - chave privada nao inicializada");
//        }
//        Signature signer = Signature.getInstance("SHA256withRSA");
//        signer.initSign(key);
//        signer.update(stringToSign.getBytes("UTF-8"));
//        byte[] rawSignature = signer.sign();
//        return new String(Base64.encodeBase64(rawSignature, false), "UTF-8");
//    }
//
//
//    /**
//     * Busca a chave de acesso P12
//     *
//     * @param password
//     * @return
//     * @throws Exception
//     */
//    private PrivateKey loadKeyFromPkcs12(char[] password) throws Exception {
//
//        InputStream fis = this.getClass().getClassLoader().getResourceAsStream("houdini-storage.p12");
//        log.info(String.format("Carregando p12 %s", fis));
//        KeyStore ks = KeyStore.getInstance("PKCS12");
//        ks.load(fis, password);
//        return (PrivateKey) ks.getKey("privatekey", password);
//    }
//
//



}
