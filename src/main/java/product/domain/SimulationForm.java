package product.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * ���t�v�Z�������V�~�����[�g�����ʂ�\������t�H�[���r�[���ł��B
 * 
 * @author koujienami
 */
public class SimulationForm {

	/** �v�Z��� */
	private String baseDate;
	/** �v�Z���� */
	private List<Result> results;

	/**
	 * �f�t�H���g�R���X�g���N�^�B
	 * 
	 * @deprecated Thymeleaf�ɂ�鐶���p�B����ȊO�ł̎g�p�֎~�B
	 */
	@Deprecated
	public SimulationForm() {
	}

	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param baseDate �v�Z���
	 * @param results ���t�v�Z���ꗗ
	 */
	public SimulationForm(String baseDate, List<DateFormula> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}

	/**
	 * �v�Z������擾���܂��B
	 * 
	 * @return �v�Z���
	 */
	public String getBaseDate() {
		return baseDate;
	}

	/**
	 * �v�Z�����ݒ肵�܂��B
	 * 
	 * @param baseDate �v�Z���
	 */
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	/**
	 * �v�Z���ʂ��擾���܂��B
	 * 
	 * @return �v�Z����
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * ���t�v�Z���̓��e����ʗp�̌v�Z���ʃI�u�W�F�N�g�ɕϊ����܂��B
	 * 
	 * @param formula ���t�v�Z��
	 * @return ��ʗp�v�Z���ʃI�u�W�F�N�g
	 */
	public Result convertToResult(DateFormula formula) {
		return new Result(formula);
	}
}
