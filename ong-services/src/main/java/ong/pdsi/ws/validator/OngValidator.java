package ong.pdsi.ws.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import ong.pdsi.business.utils.ValidatorUtils;
import ong.pdsi.domain.ong.Ong;
import ong.pdsi.ws.error.MessagesMap;
import ong.pdsi.ws.error.exception.BadRequestException;

public class OngValidator {
	
	private OngValidator() {}

	public static void validateCreateOng(Ong ong) {
		List<MessagesMap> errorKeys = new ArrayList<>();
		if (ong == null) {
			throw new BadRequestException(MessagesMap.ONG_NULL);
		}
		if (StringUtils.isBlank(ong.getName())) {
			errorKeys.add(MessagesMap.EMPTY_NAME);
		}
		if (StringUtils.isBlank(ong.getDescription())) {
			errorKeys.add(MessagesMap.EMPTY_DESCRIPTION);
		}
		if (StringUtils.isBlank(ong.getCnpj())) {
			errorKeys.add(MessagesMap.EMPTY_CNPJ);
		} else if (ValidatorUtils.isValidCnpj(ong.getCnpj())) {
			errorKeys.add(MessagesMap.INVALID_CNPJ);
		}
		if (!CollectionUtils.isEmpty(errorKeys)) {
			throw new BadRequestException(errorKeys);
		}
	}
	
	public static void validateDeleteOng(Ong ong) {
		if (ong == null) {
			throw new BadRequestException(MessagesMap.ONG_NULL);
		}
		if (ong.getId() == null) {
			throw new BadRequestException(MessagesMap.ONG_ID_NULL);
		}
	}
	
	public static void validateUpdateOng(Ong ong) {
		if (ong == null) {
			throw new BadRequestException(MessagesMap.ONG_NULL);
		}
		if (ong.getId() == null) {
			throw new BadRequestException(MessagesMap.ONG_ID_NULL);
		}
	}
}