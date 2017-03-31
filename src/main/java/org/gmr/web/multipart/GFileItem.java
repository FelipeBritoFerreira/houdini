package org.gmr.web.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.FileItemHeadersSupport;
import org.apache.commons.fileupload.ParameterParser;

public class GFileItem
  implements FileItem, FileItemHeadersSupport
{
  private static final long serialVersionUID = -8090661404150222661L;
  public static final String DEFAULT_CHARSET = "ISO-8859-1";
  private String fieldName;
  private final String contentType;
  private boolean isFormField;
  private final String fileName;
  private byte[] cachedContent;
  private transient GOutputStream dfos;
  private int sizeThreshold;
  private FileItemHeaders headers;
  
  public GFileItem(String fieldName, String contentType, boolean isFormField, String fileName, int sizeThreshold)
  {
    this.fieldName = fieldName;
    this.contentType = contentType;
    this.isFormField = isFormField;
    this.fileName = fileName;
    this.sizeThreshold = sizeThreshold;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    if (this.cachedContent == null) {
      this.cachedContent = this.dfos.getData();
    }
    return new ByteArrayInputStream(this.cachedContent);
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public String getCharSet()
  {
    ParameterParser parser = new ParameterParser();
    parser.setLowerCaseNames(true);
    
    Map<String, String> params = parser.parse(getContentType(), ';');
    return (String)params.get("charset");
  }
  
  public String getName()
  {
    return this.fileName;
  }
  
  public boolean isInMemory()
  {
    return true;
  }
  
  public long getSize()
  {
    if (this.cachedContent != null) {
      return this.cachedContent.length;
    }
    return this.dfos.getData().length;
  }
  
  public byte[] get()
  {
    if (this.cachedContent == null) {
      this.cachedContent = this.dfos.getData();
    }
    return this.cachedContent;
  }
  
  public String getString(String charset)
    throws UnsupportedEncodingException
  {
    return new String(get(), charset);
  }
  
  public String getString()
  {
    byte[] rawdata = get();
    String charset = getCharSet();
    if (charset == null) {
      charset = "ISO-8859-1";
    }
    try
    {
      return new String(rawdata, charset);
    }
    catch (UnsupportedEncodingException e) {}
    return new String(rawdata);
  }
  
  public void write(File file)
  {
    throw new UnsupportedOperationException("Not possible in GAE.");
  }
  
  public void delete() {}
  
  public String getFieldName()
  {
    return this.fieldName;
  }
  
  public void setFieldName(String fieldName)
  {
    this.fieldName = fieldName;
  }
  
  public boolean isFormField()
  {
    return this.isFormField;
  }
  
  public void setFormField(boolean state)
  {
    this.isFormField = state;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    if (this.dfos == null) {
      this.dfos = new GOutputStream(this.sizeThreshold);
    }
    return this.dfos;
  }
  
  public String toString()
  {
    return "name=" + getName() + ", size=" + getSize() + "bytes, " + "isFormField=" + isFormField() + ", FieldName=" + getFieldName();
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    this.cachedContent = get();
    
    out.defaultWriteObject();
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
    
    OutputStream output = getOutputStream();
    if (this.cachedContent != null) {
      output.write(this.cachedContent);
    }
    output.close();
    
    this.cachedContent = null;
  }
  
  public FileItemHeaders getHeaders()
  {
    return this.headers;
  }
  
  public void setHeaders(FileItemHeaders pHeaders)
  {
    this.headers = pHeaders;
  }
}
