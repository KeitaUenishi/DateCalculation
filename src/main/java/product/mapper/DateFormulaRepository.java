package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import product.domain.DateFormula;

/**
 * ���t�v�Z�����������|�W�g���ł��B<br/>
 * ���̂�{@link DateFormula}��DB�e�[�u��(dateformula)��R�Â���ׂ�ORM�N���X�ł��B
 * 
 * @author koujienami
 */
@Mapper
public interface DateFormulaRepository {

	/**
	 * ���t�v�Z���̈ꗗ���擾���܂��B
	 * 
	 * @return ���t�v�Z���̈ꗗ
	 */
	@Select("SELECT * FROM dateformula ORDER BY dateId ASC")
	List<DateFormula> select();

	/**
	 * ���t�v�Z����V�K�o�^���܂��B
	 * 
	 * @param dateMaster �o�^������t�v�Z��
	 */
	@Insert("INSERT INTO dateformula VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void insert(DateFormula dateMaster);
}
