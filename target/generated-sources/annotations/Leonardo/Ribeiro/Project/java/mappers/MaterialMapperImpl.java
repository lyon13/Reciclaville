package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T20:06:32-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class MaterialMapperImpl implements MaterialMapper {

    @Override
    public MaterialResponseDto toDto(MaterialEntity materialEntity) {
        if ( materialEntity == null ) {
            return null;
        }

        MaterialResponseDto.MaterialResponseDtoBuilder materialResponseDto = MaterialResponseDto.builder();

        materialResponseDto.id( materialEntity.getId() );
        materialResponseDto.name( materialEntity.getName() );
        materialResponseDto.compensationPercentage( materialEntity.getCompensationPercentage() );

        return materialResponseDto.build();
    }

    @Override
    public MaterialEntity toEntity(MaterialRequestDto Dto) {
        if ( Dto == null ) {
            return null;
        }

        MaterialEntity materialEntity = new MaterialEntity();

        materialEntity.setName( Dto.name() );
        materialEntity.setCompensationPercentage( Dto.compensationPercentage() );

        return materialEntity;
    }
}
