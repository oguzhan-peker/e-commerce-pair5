package com.etiya.ecommercedemopair5;

import com.etiya.ecommercedemopair5.core.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.utils.result.ErrorDataResult;
import com.etiya.ecommercedemopair5.core.utils.result.ErrorResult;
import com.etiya.ecommercedemopair5.core.utils.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoPair5Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair5Application.class, args);
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		//İlgili dosyanın mesaj kaynağının neresi olacağını belirtiriz. API, Veritabanı, Dosya
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		//Clientten seçili dili hangi yöntemle almalıyım?
		//Header , QueryParam
		//Accept-language yöntemi kullanıyoruz.
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);

		return acceptHeaderLocaleResolver;
	}

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler({BusinessException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleBusinessException(BusinessException exception){
		return new ErrorResult(exception.getMessage());
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
		//Gelen validasyon hatalarını liste olarak dönmemizi sağlar.
		Map<String,String> errors = new HashMap<>();

		for (FieldError fieldError:exception.getBindingResult().getFieldErrors()){
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>(errors, "Validation error.");
	}

	@ExceptionHandler({DataIntegrityViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleDataIntegrityViolationException(DataIntegrityViolationException exception){
		return exception.getMessage();
	}

}
