package product.domain;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * ��ʗp�̌v�Z���ʃI�u�W�F�N�g�ł��B<br/>
 * �ꗗ��ʂ̌v�Z���ʂ̍s��\�����܂��B
 * 
 * @author koujienami
 */
public class Result {

	/** ���t�v�Z�� */
	private DateFormula formula;
	/** �v�Z���� */
	private String calculated;

	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param formula ���t�v�Z��
	 */
	public Result(DateFormula formula) {
		this.formula = formula;
	}

	/** {@link DateFormula#getDateId()} */
	public String getDateId() {
		return formula.getDateId();
	}

	/** {@link DateFormula#getDateName()} */
	public String getDateName() {
		return formula.getDateName();
	}

	/**
	 * ���t�v�Z�����擾���܂��B
	 * 
	 * @return ���t�v�Z��
	 */
	public DateFormula getFormula() {
		return formula;
	}

	/**
	 * �v�Z���ʂ��擾���܂��B
	 * 
	 * @return �v�Z����
	 */
	public String getCalculated() {
		return calculated;
	}

	/**
	 * �v�Z���ʂ�ݒ肵�܂��B
	 * 
	 * @param calculated �v�Z����
	 */
	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}

	/**
	 * �N�������ɋ�؂�ꂽ�v�Z�����擾���܂��B<br/>
	 * ��ʗp�Ɂu / �v��؂�ŉ����l�����ꂼ��N�������ŕ\�����܂��B
	 * 
	 * @return �N�������ɋ�؂�ꂽ�v�Z��
	 */
	public String getYmdFormula() {
		int[] ymdFormula = {formula.getAdjustmentYear(), formula.getAdjustmentMonth(), formula.getAdjustmentDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymdFormula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
}
