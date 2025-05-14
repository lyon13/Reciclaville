package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T20:06:32-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class DeclarationMapperImpl implements DeclarationMapper {

    @Override
    public DeclarationResponseDto toDto(DeclarationEntity declaration) {
        if ( declaration == null ) {
            return null;
        }

        DeclarationResponseDto.DeclarationResponseDtoBuilder declarationResponseDto = DeclarationResponseDto.builder();

        declarationResponseDto.id( declaration.getId() );
        declarationResponseDto.idCustomer( declaration.getIdCustomer() );
        declarationResponseDto.declarationDate( declaration.getDeclarationDate() );
        declarationResponseDto.initialPeriodDate( declaration.getInitialPeriodDate() );
        declarationResponseDto.finalPeriodDate( declaration.getFinalPeriodDate() );
        declarationResponseDto.totalMaterial( declaration.getTotalMaterial() );
        declarationResponseDto.totalCompensation( declaration.getTotalCompensation() );

        return declarationResponseDto.build();
    }

    @Override
    public DeclarationEntity toEntity(DeclarationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DeclarationEntity.DeclarationEntityBuilder declarationEntity = DeclarationEntity.builder();

        declarationEntity.idCustomer( dto.idCustomer() );
        declarationEntity.declarationDate( dto.declarationDate() );
        declarationEntity.initialPeriodDate( dto.initialPeriodDate() );
        declarationEntity.finalPeriodDate( dto.finalPeriodDate() );
        declarationEntity.totalMaterial( dto.totalMaterial() );
        declarationEntity.totalCompensation( dto.totalCompensation() );

        return declarationEntity.build();
    }
}
