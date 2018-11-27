package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateFormula;
import product.service.CalculationService;

/**
 * ���t�v�Z������V�K�o�^�����ʂɕR�Â��R���g���[���[�ł��B
 * 
 * @author koujienami
 */
@Controller
public class RegisterController {

	/** ���t�v�Z�T�[�r�X */
	@Autowired
	private CalculationService service;

	/**
	 * �����\���������s���܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @return �\������e���v���[�g
	 */
	@RequestMapping("/register")
	public String index(DateFormula form) {
		return "register";
	}

	/**
	 * ���t�v�Z����V�K�o�^���܂��B<br/>
	 * �o�^������͈ꗗ��ʂ֖߂�܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @param model ���f��
	 * @return �\������e���v���[�g
	 */
	@RequestMapping(value = "/register", params = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute DateFormula form) {
		service.register(form);
		return "forward:/";
	}
}
