package cn.sunn.forensiclion.exception;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class FLException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2235899701287659281L;
	public FLException(){}
	public FLException(String msg)
	{
		super(msg);
	}
}