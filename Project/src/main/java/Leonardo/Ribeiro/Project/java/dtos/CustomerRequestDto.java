package Leonardo.Ribeiro.Project.java.dtos;

import lombok.*;



public record CustomerRequestDto(
        String name,
        String cnpj,
        String economicActivity,
        String ownerName) {

}
