package by.prokopovich.switter.security.maper;

import by.prokopovich.switter.security.model.UserAccount;
import by.prokopovich.switter.security.web.dto.RegisterRequestDto;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequestDto> {

}
