package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.mappers.ItemDeclarationMapper;
import Leonardo.Ribeiro.Project.java.repositories.ItemDeclarationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemDeclarationServiceImpl implements ItemDeclarationService{
    private ItemDeclarationRepository repository;
    private ItemDeclarationMapper mapper;




    public List<ItemDeclarationResponseDto> findAll() {
        List<ItemDeclarationEntity> itemDeclarations = repository.findAll();
        return itemDeclarations.stream().map(mapper::toDto).toList();
    }

    public ItemDeclarationResponseDto findById(Long id) {
        ItemDeclarationEntity itemDeclaration = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item Declaration not found with id: " + id));
        return mapper.toDto(itemDeclaration);
    }

    public ItemDeclarationResponseDto create(ItemDeclarationRequestDto dto) {
        ItemDeclarationEntity itemDeclaration = mapper.toEntity(dto);

        itemDeclaration = repository.save(itemDeclaration);
        return mapper.toDto(itemDeclaration);
    }



}
