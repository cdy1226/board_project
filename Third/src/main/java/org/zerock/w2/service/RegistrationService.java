package org.zerock.w2.service;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.RegistrationDAO;
import org.zerock.w2.domain.Registration;
import org.zerock.w2.dto.RegistrationDTO;
import org.zerock.w2.util.MapperUtil;
import java.util.List;
import java.util.stream.Collectors;

public enum RegistrationService {
    INSTANCE;
    private RegistrationDAO dao;
    private ModelMapper modelMapper;

    RegistrationService(){
        dao = new RegistrationDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(RegistrationDTO registrationDTO) throws Exception{
        Registration registration = modelMapper.map(registrationDTO, Registration.class);
        System.out.println("Registration: "+ registration);
        dao.insert(registration);
    }
    public List<RegistrationDTO> listAll() throws Exception{
        List<Registration> voList = dao.selectAll();
        List<RegistrationDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,RegistrationDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

}
