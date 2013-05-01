package cn.sunn.forensiclion.service;

import cn.sunn.forensiclion.domain.CaseInfor;

public interface ICaseInforManager {
		public static final int SUCCESS = 1;
		public static final int ERROR = 0;
		
		public int saveCase(CaseInfor caseinfor);
}
