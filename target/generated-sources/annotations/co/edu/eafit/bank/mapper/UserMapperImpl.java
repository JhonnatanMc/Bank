package co.edu.eafit.bank.mapper;

import co.edu.eafit.bank.domain.UserType;
import co.edu.eafit.bank.domain.Users;
import co.edu.eafit.bank.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUstyId( userUserTypeUstyId( user ) );
        userDTO.setEnable( user.getEnable() );
        userDTO.setName( user.getName() );
        userDTO.setToken( user.getToken() );
        userDTO.setUserEmail( user.getUserEmail() );

        return userDTO;
    }

    @Override
    public Users userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserType( userDTOToUserType( userDTO ) );
        users.setEnable( userDTO.getEnable() );
        users.setName( userDTO.getName() );
        users.setToken( userDTO.getToken() );
        users.setUserEmail( userDTO.getUserEmail() );

        return users;
    }

    @Override
    public List<UserDTO> usersToUsersDTOs(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( Users users1 : users ) {
            list.add( userToUserDTO( users1 ) );
        }

        return list;
    }

    @Override
    public List<Users> usersDTOsToUsers(List<UserDTO> usersDTOs) {
        if ( usersDTOs == null ) {
            return null;
        }

        List<Users> list = new ArrayList<Users>( usersDTOs.size() );
        for ( UserDTO userDTO : usersDTOs ) {
            list.add( userDTOToUser( userDTO ) );
        }

        return list;
    }

    private Integer userUserTypeUstyId(Users users) {
        if ( users == null ) {
            return null;
        }
        UserType userType = users.getUserType();
        if ( userType == null ) {
            return null;
        }
        Integer ustyId = userType.getUstyId();
        if ( ustyId == null ) {
            return null;
        }
        return ustyId;
    }

    protected UserType userDTOToUserType(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setUstyId( userDTO.getUstyId() );

        return userType;
    }
}
