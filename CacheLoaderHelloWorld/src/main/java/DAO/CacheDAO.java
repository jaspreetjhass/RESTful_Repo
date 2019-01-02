package DAO;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CacheDAO {

	@Select("SELECT CHANGE_BUSINESS_DATE FROM BRANCH_PROPERTY_MST WHERE BRANCH_CODE = #{branchCode}")
	Date getBusinessDate(@Param("branchCode")String branchCode);
	
}
