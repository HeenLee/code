package com.sinosun.aes;

import org.junit.Test;

public class AESTest {
	@Test
	public void testAes(){
		 String content = "hello";
	        String password = "123";
	        System.out.println("加密之前：" + content);

	        // 加密
	        byte[] encrypt = AESEncrypt.encrypt(content, password);
	        System.out.println("加密后的内容：" + new String(encrypt));
	        
	        // 解密
	        byte[] decrypt = AESDecrypt.decrypt(encrypt, password);
	        System.out.println("解密后的内容：" + new String(decrypt));
	        
	}

}
