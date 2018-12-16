package jxau.vip.until.exception;
//用户注册违法规则时，用异常传递错误信息

public class RuleException extends RuntimeException{
	public RuleException(String message){
		super(message);
	}

}
