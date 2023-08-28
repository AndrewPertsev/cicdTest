package by.aston.intensive.aap.service.impl;

import by.aston.intensive.aap.dao.PositionDao;
import by.aston.intensive.aap.model.Position;
import by.aston.intensive.aap.model.converter.ConverterDTO;
import by.aston.intensive.aap.model.dto.PositionDto;
import by.aston.intensive.aap.service.PositionServiceable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionServiceable {
   private final ConverterDTO<PositionDto, Position> positionConverterDto;
    private PositionDao positionDao;


    @Override
    public void save(PositionDto dto) {
        positionConverterDto.convertDtoToEntity(dto);
    }

    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public Position findById(Long id) {
        return positionDao.findById(id);
    }

    @Override
    public void update(PositionDto dto, Long id) {
        Position position = positionConverterDto.convertDtoToEntity(dto);
        positionDao.update(position, id);
    }

    @Override
    public void deleteById(Long id) {
        positionDao.deleteById(id);
    }


}
