package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateFormula;
import product.service.CalculationService;

/**
 * ���t�v�Z�����X�V�����ʂɕR�Â��R���g���[���[�ł��B
 * 
 * @author koujienami
 */
@Controller
public class UpdateController {

	/** ���t�v�Z�T�[�r�X */
	@Autowired
	private CalculationService service;

	/**
	 * �����\���������s���܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @param model ���f��
	 * @return �\������e���v���[�g
	 */
	@RequestMapping("/update/{dateId}")
	public String index(@PathVariable String dateId, Model model) {
		model.addAttribute("dateFormula", service.search(dateId));
		return "update";
	}

	/**
	 * ���t�v�Z�����X�V���܂��B<br/>
	 * �X�V������͈ꗗ��ʂ֖߂�܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @param model ���f��
	 * @return �\������e���v���[�g
	 */
	@RequestMapping(value = "/update/{dateId}", params = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute DateFormula form) {
		service.update(form);
		return "forward:/";
	}
}
