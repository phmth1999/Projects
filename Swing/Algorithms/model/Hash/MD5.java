package model.Hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

public class MD5 {
	public MD5(){
		
	}
	public static void main(String[] args) throws Exception {
	    String password = "stackjava.com";
	    String hashedText = getMD5Text(password);
	    System.out.println("Digest(in hex format): " + hashedText);
	  }
	  public static String getMD5Text(String input) {
	    try {
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      byte[] messageDigest = md.digest(input.getBytes());
	      return convertByteToHex(messageDigest);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	  }
	  public static String getMD5File(File file) {
	    MessageDigest md;
	    try {
	      md = MessageDigest.getInstance("MD5");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] dataBytes = new byte[1024];
	      int nread = 0;
	      while ((nread = fis.read(dataBytes)) != -1) {
	        md.update(dataBytes, 0, nread);
	      }
	      byte[] byteData = md.digest();
	      fis.close();
	      return convertByteToHex(byteData);
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
	    }
	  }
	  public static String convertByteToHex(byte[] data) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < data.length; i++) {
	      sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	  }

}
