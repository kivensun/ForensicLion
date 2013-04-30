package cn.sunn.forensiclion.service;

import java.io.File;
import java.util.List;

import cn.sunn.forensiclion.domain.MFile;


public interface IFileManager {
	public static final int SUCCESS = 1;
	public static final int FAIT = 0;
	// 从file转为byte[]
	public byte[] getBytesFromFile(File f);
	// 从byte[]转file
	public File getFileFromBytes(byte[] b, String outputFile);
	/**
	 * 保存为文档模版
	 * @return 
	 */
	public int saveasDocTemplete (MFile file);
	
	/**
	 * 保持案件图片
	 * @param file
	 * @return
	 */
	public int saveasCasePic(MFile file);
	
	/**
	 * 保持案件文档
	 * @param file
	 * @return
	 */
	public int saveasCaseDoc(MFile file);
	
	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	public int delFile(Long id);
	
	/**
	 * 编辑文件名
	 * @param file
	 * @return
	 */
	public int editFileName(MFile file);
	
	/**
	 * 显示所有文档模版
	 * @return
	 */
	public List listDoctempletes();
	
	
	/**
	 * 根据ID查找文档模版
	 * @param id
	 * @return
	 */
	public MFile listFile(Long id);
	
	/**
	 * 显示所有案件图片
	 * @return
	 */
	public List listCasepics();
	
	/**
	 * 显示所有案件文档
	 * @return
	 */
	public List listCasedocs();
	
	/**
	 * 获得分页数据
	 * @param offset 第一条记录索引
	 * @param pageSize 一页多少大
	 * @return
	 */
	public List findByPage(int offset, int pageSize,String Type);
	

}
