package product.domain;

/**
 * ���t�v�Z����\������I�u�W�F�N�g�ł��B
 * 
 * @author koujienami
 */
public class DateFormula {

	/** ���tID */
	private String dateId;
	/** ���t�� */
	private String dateName;
	/** �����l(�N) */
	private int adjustmentYear;
	/** �����l(��) */
	private int adjustmentMonth;
	/** �����l(��) */
	private int adjustmentDay;

	/**
	 * ���tID���擾���܂��B
	 * 
	 * @return ���tID
	 */
	public String getDateId() {
		return dateId;
	}

	/**
	 * ���tID��ݒ肵�܂��B
	 * 
	 * @param dateId ���tID
	 */
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	/**
	 * ���t�����擾���܂��B
	 * 
	 * @return ���t��
	 */
	public String getDateName() {
		return dateName;
	}

	/**
	 * ���t����ݒ肵�܂��B
	 * 
	 * @param dateName ���t��
	 */
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	/**
	 * �����l(�N)���擾���܂��B
	 * 
	 * @return �����l(�N)
	 */
	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	/**
	 * �����l(�N)��ݒ肵�܂��B
	 * 
	 * @param adjustmentYear �����l(�N)
	 */
	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	/**
	 * �����l(��)���擾���܂��B
	 * 
	 * @return �����l(��)
	 */
	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	/**
	 * �����l(��)��ݒ肵�܂��B
	 * 
	 * @param adjustmentMonth �����l(��)
	 */
	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	/**
	 * �����l(��)���擾���܂��B
	 * 
	 * @return �����l(��)
	 */
	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	/**
	 * �����l(��)��ݒ肵�܂��B
	 * 
	 * @param adjustmentDay �����l(��)
	 */
	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

}
