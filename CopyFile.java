package wgm.cn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyFile {
public static void main(String[] args) throws IOException {
  String srcFile="C:\\Users\\华硕\\Desktop\\11";
  String detFile="D:\\";
copyFolder(srcFile,detFile);
}
private static void copyFolder(String src, String det) throws IOException {
	// TODO Auto-generated method stub
	File srcFile=new File(src);
	File detFile=new File(det);
	//判断srcFile是否是文件夹
if(srcFile.isDirectory()) {
//在目的地创建一个文件夹
	String srcFileName=srcFile.getName();
	detFile=new File(detFile,srcFileName);
	if(!detFile.exists()) {
		detFile.mkdir();
	}
	File[] FileArray=srcFile.listFiles();
	System.out.println(FileArray.length);
	for(File file:FileArray) {
		copyFolder(file.toString(),detFile.toString());
	}
	
}else {
	copyFile(src, det);
}
}
public static void copyFile(String src,String det) throws IOException {
	//创建文件对象
	File srcFile=new File(src);
	File detFile=new File(det);
	//获取数据源文件的名称
	String srcname=srcFile.getName();
	detFile=new File(detFile,srcname);
	copyFileDemo(srcFile,detFile);
}
private static void copyFileDemo(File file, File detFile) throws IOException {
	// TODO Auto-generated method stub
//	BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
//	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(detFile));
//	byte[] byt=new byte[1024];
//	while(!((bis.read(byt))==-1)) {
//		bos.write(byt);
//	}
//	FileReader fid=new FileReader(file);
//	FileWriter fod=new FileWriter(detFile);
//	char[] cha=new char[1024];
//	while(fid.read(cha)!=-1) {
//		fod.write(cha);
//	}
	InputStreamReader isr=new InputStreamReader(new FileInputStream(file), "utf-8");
	OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(detFile),"utf-8");
	char[] cha=new char[1024];
	while(isr.read(cha)!=-1) {
		osw.write(cha);
		}
	
}

}
