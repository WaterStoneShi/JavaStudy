
package org.mine.StringMethods;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String source = "0123456789ABCDEFGHIJKLMNOPQRSTUVWYZ";
		
		// 返回对应字符的ASCII码
		System.out.println("source.codePointAt(0) = " + source.codePointAt(0));
		
		// 返回指定索引前一个字符的ASCII码
		System.out.println("source.codePointBefore(11) = " + source.codePointBefore(11));
		
		// 返回指定索引之前的字符（Unicode 代码点）
		System.out.println("source.codePointCount(0, 13) = " + source.codePointCount(0, 13));
		
		// 返回最后一个字符的索引+1
		System.out.println("source.offsetByCodePoints(11, 2) = " + source.offsetByCodePoints(11, 2));
		
		// 赋值字符
		char[] dst = new char[10];
		source.getChars(0, 2, dst, 0);
		System.out.println("source.getChars(0, 2, dst, 3) = " + new String(dst));
		
		// 转换为字节
		String tempSource="我";
		byte[] bytes = tempSource.getBytes();
		System.out.println(bytes.length);
		bytes = tempSource.getBytes("UTF-8");
		System.out.println(bytes.length);
		bytes = tempSource.getBytes(Charset.defaultCharset());
		System.out.println(bytes.length);
		bytes = tempSource.getBytes(Charset.forName("GBK"));
		System.out.println(bytes.length);
		
		System.out.println(source.contentEquals(new StringBuffer(source)));
		
		System.out.println("source.intern() = " + source.intern());
		
		// 测试两个字符串区域是否相等
		System.out.println("source.regionMatches(true,0,source,0,3) = " + source.regionMatches(true,0,source,0,3));
		
		// source.format()
	}

}
