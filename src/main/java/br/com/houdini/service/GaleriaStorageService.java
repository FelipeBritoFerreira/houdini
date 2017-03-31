package br.com.houdini.service;

import br.com.houdini.beans.Galeria;
import br.com.houdini.beans.ImagemGaleria;
import br.com.houdini.beans.TipoImagem;
import br.com.houdini.beans.TipoPosicaoTextoThumbnail;
import br.com.houdini.utils.BucketStorageUtils;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import org.apache.commons.fileupload.FileItem;
import org.gmr.web.multipart.GMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FBF0113 on 16/02/2017.
 */
@Component
public class GaleriaStorageService {


    @Value("${bucket.name}")
    private String BUCKET_NAME;

    @Value("${bucket.diretorio.galeria}")
    private String DIRETORIO_GALERIA;

    private Storage storageService;
    private BucketStorageUtils storageUtils;


    public GaleriaStorageService() {

        storageUtils = new BucketStorageUtils();

        try {
            storageService = storageUtils.getStorageService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }


    }


    /**
     * Busca a url de uma determinada imagem pelo nome completo do objeto
     * @param nomeObjeto
     * @return
     * @throws Exception
     */
    public String buscarUrlImagem(String nomeObjeto) throws Exception {

        Storage.Objects.Get objetoGaleria = storageService.objects().get(BUCKET_NAME, nomeObjeto);
        StorageObject object = objetoGaleria.execute();
        String urlArquivo = storageUtils.getSigningURL("GET", object.getName());
        return urlArquivo;

    }


    /**
     * Lista as imagens de uma determinada galeria
     * @param galeria
     * @return
     * @throws Exception
     */
    public Galeria listarImagensGaleria(Galeria galeria) throws Exception {

        Storage.Objects.List objetos = storageService.objects().list(BUCKET_NAME).setPrefix(DIRETORIO_GALERIA+"/"+galeria.getNomeGaleria()+"/");
        Objects objects;

        List<ImagemGaleria> imagens = new ArrayList<>();
        do {
            objects = objetos.execute();
            for (StorageObject object : objects.getItems()) {

                if (object.getName().endsWith(".xml")) {
                    continue;
                }

                ImagemGaleria imagemGaleria = new ImagemGaleria();
                imagemGaleria.setUrl(storageUtils.getSigningURL("GET",object.getName()));
                imagemGaleria.setNomeArquivo(object.getName());

                imagemGaleria.setTipoImagem(  object.getName().endsWith("capa.jpg") || object.getName().endsWith("thumbnail.jpg") ? TipoImagem.CAPA : TipoImagem.COMUM   );
                if (imagemGaleria.getTipoImagem() == TipoImagem.CAPA) {
                    galeria.setImagemThumbnail(imagemGaleria);
                }

                imagens.add(imagemGaleria);
            }
            objetos.setPageToken(objects.getNextPageToken());
        } while (null != objects.getNextPageToken());

        galeria.setImagens(imagens);

        return galeria;
    }


    /**
     * Lista o nome de todas as galerias do storage
     * @return
     * @throws Exception
     */
    public List<String> listarNomesGalerias() throws Exception {


        Storage.Objects.List objetos = storageService.objects().list(BUCKET_NAME).setPrefix(DIRETORIO_GALERIA+"/").setDelimiter("/");

        Objects objects;
        List<String> nomesGalerias = new ArrayList<String>();
        do {
            objects = objetos.execute();
            for (String prefixo : objects.getPrefixes()) {
                nomesGalerias.add( prefixo.replaceFirst(DIRETORIO_GALERIA,"").replaceAll("/","") );
            }
            objetos.setPageToken(objects.getNextPageToken());
        } while (null != objects.getNextPageToken());

        return nomesGalerias;


    }


    /**
     * Download do arquivo xml que contém os dados da galeria
     *
     * @param galeria
     * @return
     * @throws Exception
     */
    public Galeria buscarInformacoesGaleria(Galeria galeria) throws Exception {

        Storage.Objects.Get objetoGaleria = storageService.objects().get(BUCKET_NAME, "galeria/"+galeria.getNomeGaleria()+"/dados.xml");

        StorageObject object;

        try {
            object = objetoGaleria.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        String urlArquivo = storageUtils.getSigningURL("GET", object.getName());

        URL url = new URL(urlArquivo);

        InputStream inputStream = url.openStream();

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();


            //Inicia a leitura do XML - Pega o elemento raiz
            String elementoRaiz = doc.getDocumentElement().getNodeName();

            //Pega a lista de elementos que estão dentro do elemento raiz
            NodeList listaDeNos = doc.getElementsByTagName(elementoRaiz);

            for (int i = 0; i < listaDeNos.getLength(); i++) {

                Node nNode = listaDeNos.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    galeria.setTituloThumbnail(eElement.getElementsByTagName("tituloThumbnail").item(0).getTextContent());
                    galeria.setTituloModal(eElement.getElementsByTagName("tituloModal").item(0).getTextContent());

                    if (eElement.getElementsByTagName("textoDesafio").getLength() > 0) {
                        galeria.setSubtituloModal(eElement.getElementsByTagName("textoDesafio").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("tipoPosicaoTextoThumbnail").getLength() > 0 ) {
                        galeria.setTipoPosicaoTextoThumbnail(eElement.getElementsByTagName("tipoPosicaoTextoThumbnail").item(0).getTextContent().equals("1") ? TipoPosicaoTextoThumbnail.UMA_LINHA : TipoPosicaoTextoThumbnail.DUAS_LINHAS);
                    }


                    if (eElement.getElementsByTagName("texto").getLength() > 0) {
                        //Percorre os paragrafos
                        List<String> paragrafos = new ArrayList<>();
                        for (int j = 0 ; j < eElement.getElementsByTagName("texto").getLength(); j++) {
                            paragrafos.add(eElement.getElementsByTagName("texto").item(j).getTextContent());
                        }
                        galeria.setTextoModal(paragrafos);
                    }


                    if (eElement.getElementsByTagName("video").getLength() > 0) {
                        //Lista os videos
                        List<String> videos = new ArrayList<>();
                        for (int v = 0 ; v < eElement.getElementsByTagName("video").getLength(); v++) {
                            videos.add(eElement.getElementsByTagName("video").item(v).getTextContent());
                        }
                        galeria.setVideos(videos);
                    }

                }
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return galeria;

    }


    /**
     * Lista todas as galerias do storage
     *
     * @return
     * @throws Exception
     */
    public List<Galeria> listarGalerias() throws Exception {

        List<String> nomesGalerias = listarNomesGalerias();

        List<Galeria> galerias = new ArrayList<>();

        for (String nomeGaleria : nomesGalerias) {

            Galeria galeria = new Galeria();
            galeria.setNomeGaleria(nomeGaleria);

            buscarInformacoesGaleria(galeria);
            listarImagensGaleria(galeria);

            galerias.add(galeria);

        }

        return galerias;

    }





    /**
     * Faz o upload de todas as imagens para uma galeria no bucket
     * @param multipartFile
     * @param nomeGaleria
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void upload(MultipartFile[] multipartFile, String nomeGaleria) throws IOException, GeneralSecurityException {

        for (MultipartFile file : multipartFile) {
            upload(file, nomeGaleria);
        }

    }


    /**
     * Faz o upload de uma imagem para uma galeria no bucket
     * @param multipartFile
     * @param nomeGaleria
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void upload(MultipartFile multipartFile, String nomeGaleria) throws IOException, GeneralSecurityException {

        //Prepara o arquivo para ser enviado inputsream
        InputStream stream = new ByteArrayInputStream(multipartFile.getBytes());
        InputStreamContent contentStream = new InputStreamContent(multipartFile.getContentType(), stream);

        FileItem fileItem = ((GMultipartFile) multipartFile).getFileItem();

        //Onde será gravado o arquivo
        StorageObject objectMetaData = new StorageObject().setName(DIRETORIO_GALERIA+"/"+nomeGaleria+"/"+fileItem.getName());

        //Chama o serviço do Storage para fazer o upload
        Storage.Objects.Insert inserRequest = storageService.objects().insert(BUCKET_NAME, objectMetaData, contentStream);
        inserRequest.execute();

    }




}
