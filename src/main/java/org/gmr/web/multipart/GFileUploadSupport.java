package org.gmr.web.multipart;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public abstract class GFileUploadSupport
{
  protected final Log logger = LogFactory.getLog(getClass());
  private final GFileItemFactory fileItemFactory;
  private final FileUpload fileUpload;
  
  public GFileUploadSupport()
  {
    this.fileItemFactory = newFileItemFactory();
    this.fileUpload = newFileUpload(getFileItemFactory());
  }
  
  public GFileItemFactory getFileItemFactory()
  {
    return this.fileItemFactory;
  }
  
  public FileUpload getFileUpload()
  {
    return this.fileUpload;
  }
  
  public void setMaxUploadSize(int maxUploadSize)
  {
    this.fileUpload.setSizeMax(maxUploadSize);
    this.fileItemFactory.setSizeThreshold(maxUploadSize);
  }
  
  public void setDefaultEncoding(String defaultEncoding)
  {
    this.fileUpload.setHeaderEncoding(defaultEncoding);
  }
  
  protected String getDefaultEncoding()
  {
    String encoding = getFileUpload().getHeaderEncoding();
    if (encoding == null) {
      encoding = "ISO-8859-1";
    }
    return encoding;
  }
  
  protected GFileItemFactory newFileItemFactory()
  {
    return new GFileItemFactory();
  }
  
  protected abstract FileUpload newFileUpload(FileItemFactory paramFileItemFactory);
  
  protected FileUpload prepareFileUpload(String encoding)
  {
    FileUpload fileUpload = getFileUpload();
    FileUpload actualFileUpload = fileUpload;
    if ((encoding != null) && (!encoding.equals(fileUpload.getHeaderEncoding())))
    {
      actualFileUpload = newFileUpload(getFileItemFactory());
      actualFileUpload.setSizeMax(fileUpload.getSizeMax());
      actualFileUpload.setHeaderEncoding(encoding);
    }
    return actualFileUpload;
  }
  
  protected MultipartParsingResult parseFileItems(List<FileItem> fileItems, String encoding)
  {
    MultiValueMap<String, MultipartFile> multipartFiles = new LinkedMultiValueMap();
    Map<String, String[]> multipartParameters = new HashMap();
    Map<String, String> multipartParameterContentTypes = new HashMap();
    for (FileItem fileItem : fileItems) {
      if (fileItem.isFormField())
      {
        String value = null;
        if (encoding != null) {
          try
          {
            value = fileItem.getString(encoding);
          }
          catch (UnsupportedEncodingException ex)
          {
            if (this.logger.isWarnEnabled()) {
              this.logger.warn("Could not decode multipart item '" + fileItem.getFieldName() + "' with encoding '" + encoding + "': using platform default");
            }
            value = fileItem.getString();
          }
        } else {
          value = fileItem.getString();
        }
        String[] curParam = (String[])multipartParameters.get(fileItem.getFieldName());
        if (curParam == null)
        {
          multipartParameters.put(fileItem.getFieldName(), new String[] { value });
        }
        else
        {
          String[] newParam = StringUtils.addStringToArray(curParam, value);
          multipartParameters.put(fileItem.getFieldName(), newParam);
        }
        multipartParameterContentTypes.put(fileItem.getFieldName(), fileItem.getContentType());
      }
      else
      {
        GMultipartFile file = new GMultipartFile(fileItem);
        multipartFiles.add(file.getName(), file);
        if (this.logger.isDebugEnabled()) {
          this.logger.debug("Found multipart file [" + file.getName() + "] of size " + file.getSize() + 
            " bytes with original filename [" + file.getOriginalFilename() + "], stored " + 
            file.getStorageDescription());
        }
      }
    }
    return new MultipartParsingResult(multipartFiles, multipartParameters, multipartParameterContentTypes);
  }
  
  protected void cleanupFileItems(Collection<MultipartFile> multipartFiles)
  {
    for (MultipartFile file : multipartFiles) {
      if ((file instanceof GMultipartFile))
      {
        GMultipartFile cmf = (GMultipartFile)file;
        cmf.getFileItem().delete();
        if (this.logger.isDebugEnabled()) {
          this.logger.debug("Cleaning up multipart file [" + cmf.getName() + "] with original filename [" + cmf.getOriginalFilename() + "], stored " + cmf.getStorageDescription());
        }
      }
    }
  }
  
  protected static class MultipartParsingResult
  {
    private final MultiValueMap<String, MultipartFile> multipartFiles;
    private final Map<String, String[]> multipartParameters;
    private final Map<String, String> multipartParameterContentTypes;
    
    public MultipartParsingResult(MultiValueMap<String, MultipartFile> mpFiles, Map<String, String[]> mpParams, Map<String, String> mpParamContentTypes)
    {
      this.multipartFiles = mpFiles;
      this.multipartParameters = mpParams;
      this.multipartParameterContentTypes = mpParamContentTypes;
    }
    
    public MultiValueMap<String, MultipartFile> getMultipartFiles()
    {
      return this.multipartFiles;
    }
    
    public Map<String, String[]> getMultipartParameters()
    {
      return this.multipartParameters;
    }
    
    public Map<String, String> getMultipartParameterContentTypes()
    {
      return this.multipartParameterContentTypes;
    }
  }
}
