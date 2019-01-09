package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.DateFormula;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * ���t�v�Z����V�K�o�^�����ʂɕR�Â��R���g���[���[�ł��B
 * 
 * @author koujienami
 */
@Controller
@RequestMapping("/register")
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
	@GetMapping
	public String index(@ModelAttribute DateFormula form) {
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
	@PostMapping
	public String register(@ModelAttribute @Validated DateFormula form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register";
		}

		service.register(form);
		model.addAttribute("simulationForm", new SimulationForm());
		return "simulation";
	}
}
