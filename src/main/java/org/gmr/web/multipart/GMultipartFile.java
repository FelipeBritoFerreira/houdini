package org.gmr.web.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

public class GMultipartFile
  implements MultipartFile, Serializable
{
  private static final long serialVersionUID = -2270490133870606L;
  protected static final Log logger = LogFactory.getLog(GMultipartFile.class);
  private final FileItem fileItem;
  private final long size;
  
  public GMultipartFile(FileItem fileItem)
  {
    this.fileItem = fileItem;
    this.size = this.fileItem.getSize();
  }
  
  public final FileItem getFileItem()
  {
    return this.fileItem;
  }
  
  public String getName()
  {
    return this.fileItem.getFieldName();
  }
  
  public String getOriginalFilename()
  {
    String filename = this.fileItem.getName();
    if (filename == null) {
      return "";
    }
    int pos = filename.lastIndexOf("/");
    if (pos == -1) {
      pos = filename.lastIndexOf("\\");
    }
    if (pos != -1) {
      return filename.substring(pos + 1);
    }
    return filename;
  }
  
  public String getContentType()
  {
    return this.fileItem.getContentType();
  }
  
  public boolean isEmpty()
  {
    return this.size == 0L;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public byte[] getBytes()
  {
    byte[] bytes = this.fileItem.get();
    return bytes != null ? bytes : new byte[0];
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    InputStream inputStream = this.fileItem.getInputStream();
    return inputStream != null ? inputStream : new ByteArrayInputStream(new byte[0]);
  }
  
  public void transferTo(File dest)
    throws IOException, IllegalStateException
  {
    throw new UnsupportedOperationException("not possible.");
  }
  
  protected boolean isAvailable()
  {
    return true;
  }
  
  public String getStorageDescription()
  {
    return "in memory";
  }
}
