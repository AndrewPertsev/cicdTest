package by.aston.intensive.aap.model.converter;

import by.aston.intensive.aap.model.Position;
import by.aston.intensive.aap.model.dto.PositionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PositionConverterDto implements ConverterDTO<PositionDto, Position> {

    @Override
    public PositionDto convertEntityToDto(Position entity) {
        log.info("Convert Entity To Dto");
        return PositionDto.builder()
                .positionId(entity.getPositionId())
                .name((entity.getName()))
                .build();
    }

    @Override
    public Position convertDtoToEntity(PositionDto dto) {
        log.info("Convert Dto to Entity");
        return Position.builder()
                .name(dto.getName())
                .build();
    }
}
