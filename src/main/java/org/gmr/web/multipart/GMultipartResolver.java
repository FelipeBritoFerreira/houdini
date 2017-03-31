package org.gmr.web.multipart;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class GMultipartResolver
  extends GFileUploadSupport
  implements MultipartResolver
{
  private boolean resolveLazily = false;
  
  public void setResolveLazily(boolean resolveLazily)
  {
    this.resolveLazily = resolveLazily;
  }
  
  protected FileUpload newFileUpload(FileItemFactory fileItemFactory)
  {
    return new ServletFileUpload(fileItemFactory);
  }
  
  public boolean isMultipart(HttpServletRequest request)
  {
    return (request != null) && (ServletFileUpload.isMultipartContent(request));
  }
  
  public MultipartHttpServletRequest resolveMultipart(final HttpServletRequest request)
    throws MultipartException
  {
    if (this.resolveLazily) {
      new DefaultMultipartHttpServletRequest(request)
      {
        protected void initializeMultipart()
        {
          GFileUploadSupport.MultipartParsingResult parsingResult = GMultipartResolver.this.parseRequest(request);
          setMultipartFiles(parsingResult.getMultipartFiles());
          setMultipartParameters(parsingResult.getMultipartParameters());
        }
      };
    }
    GFileUploadSupport.MultipartParsingResult parsingResult = parseRequest(request);
    
    return new DefaultMultipartHttpServletRequest(request, 
      parsingResult.getMultipartFiles(), 
      parsingResult.getMultipartParameters(), parsingResult.getMultipartParameterContentTypes());
  }
  
  protected GFileUploadSupport.MultipartParsingResult parseRequest(HttpServletRequest request)
    throws MultipartException
  {
    String encoding = determineEncoding(request);
    FileUpload fileUpload = prepareFileUpload(encoding);
    try
    {
      List<FileItem> fileItems = ((ServletFileUpload)fileUpload).parseRequest(request);
      return parseFileItems(fileItems, encoding);
    }
    catch (FileUploadBase.SizeLimitExceededException ex)
    {
      throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
    }
    catch (FileUploadException ex)
    {
      throw new MultipartException("Could not parse multipart servlet request", ex);
    }
  }
  
  protected String determineEncoding(HttpServletRequest request)
  {
    String encoding = request.getCharacterEncoding();
    if (encoding == null) {
      encoding = getDefaultEncoding();
    }
    return encoding;
  }
  
  public void cleanupMultipart(MultipartHttpServletRequest request)
  {
    if (request != null) {
      try
      {
        cleanupFileItems(request.getFileMap().values());
      }
      catch (Throwable ex)
      {
        this.logger.warn("Failed to perform multipart cleanup for servlet request", ex);
      }
    }
  }
}
