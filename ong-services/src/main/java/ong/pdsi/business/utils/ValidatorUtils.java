package ong.pdsi.business.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidatorUtils {
	
	private ValidatorUtils() {}

	public static boolean isValidCnpj(String cnpj) {
		return StringUtils.isNotBlank(cnpj) && cnpj.matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
	}
}